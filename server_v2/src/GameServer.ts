import LoginHandler from "./handlers/LoginHandler";
import Client from "./game/entities/Client";
import Player from "./game/entities/game/Player";
import { Server } from "net";
import { EventEmitter } from "events";
import { Subject } from "rxjs";
import WriteShort from "./utils/write-data/WriteShort";
import SyncPlayers81 from "./game/packets/outgoing/SyncPlayers81";

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
     * Game cycle subject
     * I think async subject be more appropriate, test it Alex
     */
    private readonly _gameCycle$: Subject<string> = new Subject<string>();

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

            /**
             * We can instantiate all server response procedures inside of this callback now,
             * as we're positive they've successfully logged in. I.e., we can parse the incoming packets
             * safely.
             */
            clientEmitter$.on("successful-login", (player: Player) => {
                // Begin storing packets into the buffer as they come in
                this.collectGamePackets(player);

                // sending region packet for testing
                const bb = Buffer.alloc(5);
                bb[0] = 73 + player.outStreamEncryptor.nextKey();
                WriteShort.BES(((3200 / 8) + 6), bb, 1);
                WriteShort.BE(((3200 / 8) + 6), bb, 3);
                console.log(bb.toJSON().data);
                socket.write(bb);

                // initial p81
                new SyncPlayers81()
                .updateLocalPlayer(1)
                .setMovementType(3)
                .setPlane(0)
                .setTeleport(1)
                .updateRequired(0)
                .setLocalPlayerXY(20)
                .setLocalPlayerXY(20)
                .setAmountOfOthersForUpdates(0)
                .setNextUpdateListIndex(2047)
                .flushPacket81(player);

                // The subscription for this player on the game cycle
                // i.e., every 600ms this will run for each individual player
                const playerSub = this._gameCycle$.subscribe(() => {
                    /**
                     * GAME CODE ---------------------------------------------------------------------------------------------------------------
                     */
                    // Decryption will fail after P81 because we not handled sizes, that's all
                    if (player.packetBuffer[0] !== undefined) {
                        console.log("DECRYPTED OPCODE: ", player.packetBuffer[0] - player.inStreamDecryptor.nextKey() & 0xff);
                    }
                    player.packetBuffer = [];
                    // cant send move 0 unless we got a mask
                    new SyncPlayers81()
                    .updateLocalPlayer(1)
                    .setMovementType(3)
                    .setPlane(0)
                    .setTeleport(1)
                    .updateRequired(0)
                    .setLocalPlayerXY(20)
                    .setLocalPlayerXY(20)
                    .setAmountOfOthersForUpdates(0)
                    .setNextUpdateListIndex(2047)
                    .flushPacket81(player);
                    /**
                     * /GAME CODE ---------------------------------------------------------------------------------------------------------------
                     */
                });

                // Add the local players index to the PLAYER_INDEX
                this.updatePlayerIndex(player);

                // closing stuff
                player.socket.on("close", () => {
                    playerSub.unsubscribe();
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
            console.log("ENCRYPTED OPCODE: ", data[0]);
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


}


new GameServer().startServer();
