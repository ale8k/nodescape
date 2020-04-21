import { Server } from "net";
import LoginHandler from "./handlers/LoginHandler";
import Client from "./Client";
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
        // CONNECTION
        this.SERVER.on("connection", (socket) => {
            console.log("A client is attempting to connect...");

            const clientEmitter$ = new EventEmitter();
            const client = new Client(socket);
            new LoginHandler(client, clientEmitter$);
            clientEmitter$.on("successful-login", (data: Client) => {
                console.log("booming");
                console.log(data.username);
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
