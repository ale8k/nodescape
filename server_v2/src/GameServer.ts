import LoginHandler from "./handlers/LoginHandler";
import Client from "./game/entities/Client";
import Player from "./game/entities/game/Player";
import { Server } from "net";
import { EventEmitter } from "events";
import { Subject } from "rxjs";
import WriteShort from "./utils/write-data/WriteShort";
import RSString from "./utils/RSString";

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
     * The player store, corresponding it's index to the PLAYER_INDEX value. I.e.,
     * PLAYER at INDEX 12 would be PLAYER_ARR[12], and it'll have all their player details etc.
     * @todo create the class which we'll cast the player object into (i.e., remove the socket and client specific details)
     */
    private readonly PLAYER_LIST: number[] = new Array<number>(2047).fill(0);
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
                this.updatePlayerIndex(player);
                this.collectGamePackets(player);
                const otherPlayerList: number[] = this.getConnectedIndexes(this.PLAYER_INDEX, player);
                this.sendRegionPacket(player);


                const playerSub = this._gameCycle$.subscribe(() => {
                    // Decryption will fail after P81 because we not handled sizes, that'ss al
                    // if (player.packetBuffer[0] !== undefined) {
                    // console.log("DECRYPTED OPCODE: ", player.packetBuffer[0] - player.inStreamDecryptor.nextKey() & 0xff);
                    // }
                    player.packetBuffer = [];
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
