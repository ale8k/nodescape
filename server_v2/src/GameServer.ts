import LoginHandler from "./handlers/LoginHandler";
import Client from "./game/entities/Client";
import Player from "./game/entities/game/Player";
import WriteShort from "./utils/write-data/WriteShort";
import RSString from "./utils/RSString";
import { Server } from "net";
import { EventEmitter } from "events";
import { Subject, of, merge, forkJoin, Observable } from "rxjs";
import { map } from "rxjs/operators";
import SyncPlayers81 from "./game/packets/outgoing/81/SyncPlayers81";
import { once } from "cluster";

/**
 * Entry point
 * @author ale8k
 */
export default class GameServer {
    /**
     * The server instance reference
     */
    private readonly SERVER = new Server();
    /**
     * Game tick rate
     */
    private readonly GAME_CYCLE_RATE = 600;
    /**
     * Contains an index for each connection that comes in
     */
    private readonly PLAYER_INDEX: Set<number> = new Set<number>();
    /**
     * The player store, corresponding it's index to the PLAYER_INDEX value.
     */
    private readonly PLAYER_LIST: Player[] = new Array<Player>(2047);
    /**
     * Game cycle subject
     * I think async subject be more appropriate, test it Alex
     */
    private readonly _gameCycle$: Subject<string> = new Subject<string>();
    /**
     * DEBUG
     */
    public maskData = [0, 0, 1183, 1127, 0, 1059, 1079, 4131, 10, 0, 0, 0, 0, 1163, 7, 4, 9, 5, 0,
        0x328, 0x337, 0x333, 0x334, 0x335, 0x336, 0x338, ...RSString.writeStringToLongBytes37("DEBUG"), 10, 0];

    /**
     * Please note:
     *  All variables created within a connection even call back persist
     *  for the length of that connection
     */
    constructor() {
        // TURN GAME CYCLE ON
        this.startGameCycle(this.GAME_CYCLE_RATE, this._gameCycle$);

        // CONNECTION
        this.SERVER.on("connection", (socket) => {
            console.log("A client is attempting to connect...");
            const clientEmitter$: EventEmitter = new EventEmitter();
            const client: Client = new Client(socket);
            new LoginHandler(client, clientEmitter$);

            // LOGGED IN
            clientEmitter$.on("successful-login", (player: Player) => {
                player.needMaskUpdate = true; // debug, forces a mask update everytime for everyone
                player.planeUpdated = true;
                player.playedTeleported = true;
                player.updateLocalPlayer = true;
                this.updatePlayerIndex(player); // Adds our local players index to the index list
                this.collectGamePackets(player); // Pushes all incoming data for our local players socket into their buffer
                this.sendRegionPacket(player); // Sends P73 to load a region
                this.PLAYER_LIST[player.localPlayerIndex] = player; // Adds our local player inst object to the servers player list

                // GAME CYCLE
                const playerSub = this._gameCycle$.subscribe(() => {
                    const otherPlayerList: number[] = this.getConnectedIndexes(this.PLAYER_INDEX, player);
                    console.log("Player at index: ", player.localPlayerIndex, "has other players (indexes) connected: ", otherPlayerList);
                    player.packetBuffer = [];

                    // Pretends packets have been read here

                    // Imagine we read packet164, and now we have a bunch of co-ordinates to go to,
                    // our player.x/y will definitely change by a single increment each time.
                    // So we'd happily set player.movementUpdated to true?
                    // We would also calculate the direction prior too...
                    // So that would be send as a param to p81.
                    //
                    // As for the planes, we have a separate flag which determines if it's changed
                    // And this would be used to check if movement type 3 should be declared in syncLocalPlayerMovement

                    // Create the initial P81 for this local player
                    const direction = 0, direction2 = 0; // Just an example
                    new SyncPlayers81(player)
                        .syncLocalPlayerMovement(direction, direction2)
                        .syncOtherPlayerMovement(this.PLAYER_LIST)
                        .updatePlayerList(this.PLAYER_INDEX, this.PLAYER_LIST)
                        .writePlayerSyncMasks()
                        .flushPacket81();
                });

                // LOGGED OUT
                player.socket.on("close", () => {
                    playerSub.unsubscribe();
                    this.PLAYER_INDEX.delete(player.localPlayerIndex);
                    console.log("Client disconnected and unsubscribed to gamecycle....");
                });
            });

        });
        // CLOSE
        this.SERVER.on("close", () => {
            console.log("Server closed...");
        });
    }

    /**
     * Start method for the server
     */
    public startServer(): void {
        this.SERVER.listen(43594, () => {
            console.log("Server listening on port 43594");
        });
    }

    /**
     * Set _gameCycle$ to emit 'tick' every 600ms
     * This represents our game loop, and allows sockets to subscribe briefly.
     */
    private startGameCycle(cycleRate: number, cycleSubject: Subject<string>): void {
        setInterval(() => {
            cycleSubject.next("tick");
        }, cycleRate);
    }

    /**
     * Updates the PLAYER_INDEX with this local players index
     * @param player the local player
     */
    private updatePlayerIndex(player: Player): void {
        player.localPlayerIndex = this.getNextConnectionIndex();
        this.PLAYER_INDEX.add(player.localPlayerIndex);
    }

    /**
     * Adds the next index to the PLAYER_INDEX
     * It checks if there's any gaps between 0-2047 and fills them
     * This would be a usecase for when a player logsout.
     */
    private getNextConnectionIndex(): number {
        const maxPlayers = 2046;
        if (this.PLAYER_INDEX.size === 0) {
            return 0;
        } else {
            for (let i = 0; i < maxPlayers; i++) {
                if (!this.PLAYER_INDEX.has(i)) {
                    return i;
                }
            }
        }
        return 2047;
    }

    /**
     * Sets up the listener which listens for incoming packets
     * and stores them in the players packetBuffer (it's actually an array lol)
     */
    private collectGamePackets(player: Player): void {
        player.socket.on("data", (data) => {
            //console.log("ENCRYPTED OPCODE: ", data[0]);
            player.packetBuffer.push(...data.toJSON().data);
        });
    }

    /**
     * Gets the other indexes currently connected, i.e., it skips our local players
     */
    private getConnectedIndexes(playerIndexList: Set<number>, player: Player): number[] {
        const otherPlayerList: number[] = [];
        playerIndexList.forEach((v, v2, s) => {
            if (v !== player.localPlayerIndex) {
                otherPlayerList.push(v);
            }
        });
        return otherPlayerList;
    }

    /**
     * DEBUG
     */
    public sendRegionPacket(player: Player): void {
        // sending region packet for testing
        const bb = Buffer.alloc(5);
        bb[0] = 73 + player.outStreamEncryptor.nextKey();
        WriteShort.BES(((3200 / 8) + 6), bb, 1);
        WriteShort.BE(((3200 / 8) + 6), bb, 3);
        player.socket.write(bb);
    }

}

new GameServer().startServer();
