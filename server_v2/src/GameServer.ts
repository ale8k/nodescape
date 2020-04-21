import LoginHandler from "./handlers/LoginHandler";
import Client from "./entities/Client";
import Player from "./entities/game/Player";
import { Server, Socket } from "net";
import { EventEmitter } from "events";
import { Subject } from "rxjs";

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
        this._gameCycle$.subscribe(console.log);

        // CONNECTION
        this.SERVER.on("connection", (socket) => {
            console.log("A client is attempting to connect...");
            const clientEmitter$: EventEmitter = new EventEmitter();
            const client: Client = new Client(socket);
            new LoginHandler(client, clientEmitter$);
            let player: Player;

            /**
             * We can instantiate all server response procedures inside of this callback now,
             * as we're positive they've successfully logged in. I.e., we can parse the incoming packets
             * safely.
             */
            clientEmitter$.on("successful-login", (loggedInClient: Client) => {
                // Cast into player object
                player = loggedInClient as Player;
                // Setup the local players packetBuffer
                player.packetBuffer = [];
                // Begin storing packets into the buffer as they come in
                this.collectGamePackets(socket, player);
                // Add the local players index to the PLAYER_INDEX
                this.updatePlayerIndex(player);
                // Wipe game packets every 600MS and some how respond,
                // in rhythme with the game cycle itself...
                // All players must respond in rhythme too.
                // Upon disconnect, destroy this listener.

                // closing stuff
                player.socket.on("close", () => {
                    console.log("Socket closed bro");
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
    private collectGamePackets(socket: Socket, player: Player): void {
        socket.on("data", (data) => {
            player.packetBuffer.push(...data.toJSON().data);
            console.log(player.packetBuffer);
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
