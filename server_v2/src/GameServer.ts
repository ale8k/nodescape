import LoginHandler from "./handlers/LoginHandler";
import Client from "./entities/Client";
import Player from "./entities/game/Player";
import { Server, Socket } from "net";
import { EventEmitter } from "events";

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
     * Game event emitter (tick handler)
     */
    private _gameEmitter$: EventEmitter = new EventEmitter();
    /**
     * Contains an index for each connection that comes in
     */
    private readonly PLAYER_INDEX: Set<number> = new Set<number>();

    /**
     * The SERVER uses the constructor to apply all of
     * our events specific to the server
     *
     * Please note:
     *  All variables created within a connection even call back persist
     *  for the length of that connection
     */
    constructor() {
        // START GAME TICK CYCLE
        this.startGameCycle(this._gameEmitter$);
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
                // Setup the game packet listener
                player.packetBuffer = [];
                this.collectGamePackets(socket, player);
                // Add their index to the player index, as they're in now
                this.updatePlayerIndex(player);
                // we got packets here, lets do something with them
                this.respondToCollectedGamePackets(socket, player);
            });

        });
        // CLOSE
        this.SERVER.on("close", () => {
            console.log("A client disconnected...");
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
     * Emits a value to the gameEvent on a specified tick cycle
     * @param gameEmitter the emitter to emit to
     */
    private startGameCycle(gameEmitter: EventEmitter): void {
        setInterval(() => {
            gameEmitter.emit("tick");
        }, this.GAME_CYCLE_RATE);
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
        });
    }
    /**
     * Just some bullshit I'm tryingout
     * @param socket the local player's socket
     * @param player the local player
     */
    private respondToCollectedGamePackets(socket: Socket, player: Player): void {
        this._gameEmitter$.on("tick", () => {
            console.log("PACKET:");
            console.log(player?.packetBuffer);
            player.packetBuffer = [];
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
