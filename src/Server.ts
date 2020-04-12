import * as net from "net";
import { Socket } from "net";
import { EventEmitter } from "events";
import * as Long from "long";
import IsaacCipher from "./packets/IsaacCipher";
import { LoadMapZone73, UpdateLocalPlayer81 } from "./packets/outgoing";
import GameIds from "./GameIds";
import { ParsePacketOpcode, GetPacketLength } from "./packets/incoming";

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
 * Entry point for the server
 * @author ale8k
 */
class Server {
    /**
     * Handles the current state of our login procedure
     */
    private _loginState: LoginState = LoginState.FirstResponse;
    /**
     * In stream opcode isaac cipher
     */
    private _inStreamDecryption: IsaacCipher;
    /**
     * Out stream opcode isaac cipher
     */
    private _outStreamEncryption: IsaacCipher;
    /**
     * The emitter which handles directing incoming and outgoing packets
     */
    private _gameLoopEventEmitter: EventEmitter = new EventEmitter();
    /**
     * A place for us to store the incoming data outside of our
     * 600ms cycle
     */
    private _inStreamCacheBuffer: number[] = [];
    /**
     * Some kind of flag to ensure that our emitter call back is added once
     * and our initial packets are sent once...
     */
    private _gameInitialSetupComplete = false;

    public startServer(): void {
        net.createServer((socket: Socket) => {
            console.log("A Client is attempting to establish a connection...");

            /**
             * Single primary data event
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
                    // set player id
                    //this._playerId = rsaBlock[17];
                    console.log("USERID: ", rsaBlock[17]);

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
                    /**
                     * We're happy with logging the user in, so setup game tick
                     * and send A-OK response
                     */
                    setInterval(() => {
                        this._gameLoopEventEmitter.emit("tick");
                    }, 600);
                    socket.write(Buffer.from([2, 0, 0]));
                    this._loginState = LoginState.LoggedIn;
                    console.log("Second client request received and second server response sent");

                } else if (this._loginState === LoginState.LoggedIn) {
                    /**
                     * Set up the initial game tick callback and send initial packets once
                     * otherwise just push all incoming data into the instream cache
                     * // We're done here now
                     */
                    if (this._gameInitialSetupComplete === false) {
                        console.log("Setting up initial game stage!");
                        // Push the very first game packet to our cache buffer
                        this._inStreamCacheBuffer.push(...data.toJSON().data);
                        // setup event listener and send initial packets
                        this.setupGame(socket);
                    } else {
                        this._inStreamCacheBuffer.push(...data.toJSON().data);
                    }

                }
            });

            /**
             * Close
             */
            socket.on("close", (e) => {
                console.log("A client was disconnected...");
            });

        }).listen(43594, () => {
            console.log("Server running");
        });
    }

    /**
     * Sends initial packets and adds our gameloop
     * event listener callback
     * The inStreamBuffer cache increments based on all incoming data
     * @param socket the primary socket
     */
    private setupGame(socket: Socket): void {
        this._gameLoopEventEmitter.on("tick", () => {
            console.log("Current cache buffer state: ", this._inStreamCacheBuffer);
            // so, we got the buffer full of packets...
            // let's ensure its actually got stuff in
            while (this._inStreamCacheBuffer.length > 0) {
                // Grab the first index of our cache buffer
                // (which will always be the opcode! See below as to why)
                const eOpcode = this._inStreamCacheBuffer[0];
                // Parse the opcode
                const dOpcode = ParsePacketOpcode(eOpcode, this._inStreamDecryption);
                // Get the packet length for this opcode
                const pLength = GetPacketLength(dOpcode);
                console.log("Opcode for this packet: ", dOpcode, "Packet length: ", pLength);
                // Remove this packet from the in stream buffer,
                // eventually we'll put it into another buffer that'll respond based
                // on the packet
                // Also this obviously only works for fixed size packets
                // P.s. the + 1 is for the opcode lol.
                for (let i = 0; i < (pLength + 1); i++) {
                    this._inStreamCacheBuffer.shift();
                }

            }
        });

        // 73: Load the map zone (fixed)
        socket.write(
            LoadMapZone73(
                this._outStreamEncryption.nextKey(),
                406, // higher = east, lower = west  // x
                406 // higher = north, lower = south // y coord
            )
        );
        console.log("Callback attached and initial packets sent");
        this._gameInitialSetupComplete = true;
    }

}

new Server().startServer();

