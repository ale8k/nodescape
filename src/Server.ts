import * as net from "net";
import { Socket } from "net";
import * as Long from "long";
import IsaacCipher from "./packets/IsaacCipher";
import { ParseIncomingPackets } from "./packets/incoming";
import { EventEmitter } from "events";
import { LoadMapZone73 } from "./packets/outgoing";

enum LoginState {
    FirstResponse,
    SecondResponse,
    LoggedIn
}

enum ConnectionStatus {
    NewSession = 14,
    Reconnecting = 16
}

enum ResponseCode {
    TryAgainFailure = -1,
    NewSession = 0,
    TryAgainFailure2 = 1,
    SuccessfulLogin = 2,
    InvalidUserOrPass = 3,
    AccountBanned = 4,
    AccountStillLoggedIn = 5,
    RuneScapeUpdated = 6,
    WorldFull = 7,
    ServerDown = 8,
    LoginLimit = 9,
    BadSessionID = 10,
    LoginRejected = 11,
    Memembers = 12,
    LoginFailure = 13,
    ServerUpdated = 14,
}

/**
 * After some good research,
 * I'm gonna have to listen to the data separately to my emitting.
 * They've got to be out of sync, the client expects data on 600ms turnover,
 * yet can emit multiple to us within 600ms. So...
 * We gotta concat each new piece of data and only emit it via emitter after 600ms is up.
 * After the 600ms is up, we obviously clear our cached buffer and prepare it to
 * stock up on the next 10billion clicks people do.
 *
 * SO:
 * socket.on("data") -> emits "queue-data", this will performs a Buffer.concat and store it in a field
 * called 'cachedBuffer'. That's all for the socket data event, on the flip side:
 *
 * we'll ghave an event emitter run every 600ms, it'll read the cachedBuffer and respond to each packet
 * appropriately (ideally).
 *
 * This should clear up my asynchronous / quick emit issues.
 */

/**
 * Entry point for the server
 * @author ale8k
 */
class Server {
    private readonly _server: net.Server;
    private _loginState: LoginState = LoginState.FirstResponse;
    private _inStreamDecryption: IsaacCipher;
    private _outStreamEncryption: IsaacCipher;
    private _gameLoopEventEmitter: EventEmitter = new EventEmitter();
    private inStreamCacheBuffer: Buffer;

    public startServer(): void {


        const loginProtocolStage = 0;
        net.createServer((socket: Socket) => {
            console.log("A Client is attempting to establish a connection...");

            /**
             * Login data event
             */
            socket.on("data", (data) => {
                if (this._loginState === LoginState.FirstResponse) {
                    const b = Buffer.alloc(17);
                    b[16] = 69;
                    socket.write(b);
                    this._loginState = LoginState.SecondResponse;
                    console.log("First client request received and first server response sent");
                } else if (this._loginState === LoginState.SecondResponse) {
                    const rsaBlock = data.toJSON().data.slice(43);
                    const clientSessionKey = Long.fromBytes(rsaBlock.slice(1, 9));
                    const serverSessionKey = Long.fromBytes(rsaBlock.slice(9, 17));

                    const inSessionKey = [
                        (clientSessionKey.shiftRight(32).toInt()),
                        (clientSessionKey.toInt()),
                        (serverSessionKey.shiftRight(32).toInt()),
                        (serverSessionKey.toInt())
                    ];

                    const sessionKey = [
                        (clientSessionKey.shiftRight(32).toInt()) + 50,
                        (clientSessionKey.toInt()) + 50,
                        (serverSessionKey.shiftRight(32).toInt()) + 50,
                        (serverSessionKey.toInt()) + 50
                    ];

                    this._inStreamDecryption = new IsaacCipher(inSessionKey);
                    this._outStreamEncryption = new IsaacCipher(sessionKey);
                    socket.write(Buffer.from([2, 0, 0]));
                    this._loginState = LoginState.LoggedIn;
                    console.log("Second client request received and second server response sent");
                } else if (this._loginState === LoginState.LoggedIn) {
                    /**
                     * Incoming packet parsing
                     */
                    //ParseIncomingPackets(data, this._inStreamDecryption);
                    console.log((data[0] & 0xff) - this._inStreamDecryption.nextKey() & 0xff);






                    // Just some testing for rendering player packet
                    // //73: Load the map zone
                    // socket.write(
                    //     LoadMapZone73(
                    //         this._outStreamEncryption.nextKey(),
                    //         406, // higher = east, lower = west  // x
                    //         406 // higher = north, lower = south // y coord
                    //     )
                    // );

                    // //83;: Update; our; player (eventually will update others...);
                    // socket.write(
                    //     UpdateLocalPlayer81(
                    //         outStreamEncryption.nextKey(),
                    //         1, // update our player
                    //         3, // move type
                    //         0, // planelevel
                    //         1, // clear await queuee
                    //         1, // update required
                    //         21, // ycoord
                    //         21,  // xcoord
                    //         0, // updateNPlayers movements
                    //         2047, // player list updating bit
                    //     )
                    // );

                }
            });

            /**
             * Close
             */
            socket.on("close", (err) => {
                console.log("A client was disconnected...");
            });

        }).listen(43594, () => {
            console.log("Server running");
        });
    }

}

new Server().startServer();

