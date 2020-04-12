import * as net from "net";
import { Socket } from "net";
import { EventEmitter } from "events";
import * as Long from "long";
import IsaacCipher from "./packets/IsaacCipher";
import { LoadMapZone73, UpdateLocalPlayer81 } from "./packets/outgoing";
import GameIds from "./GameIds";
import { ParsePacketOpcode, GetFixedPacketLength } from "./packets/incoming";

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
    /**
     * Sets the game cycle rate (600 default)
     */
    private _gameCycleRate = 1000;

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
                    }, this._gameCycleRate);
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
            /**
             * This works by removing the packet from the start
             * of the inStreamBuffer[], and then continues to read until the
             * buffer is empty.
             */
            // so, we got the buffer full of packets...
            // let's ensure its actually got stuff in
            while (this._inStreamCacheBuffer.length > 0) {
                /**
                 * Packet 210 expects data? Apparently?
                 */
                // Grab the first index of our cache buffer
                // (which will always be the opcode! See below as to why)
                const eOpcode = this._inStreamCacheBuffer[0];
                // Parse the opcode
                const dOpcode = ParsePacketOpcode(eOpcode, this._inStreamDecryption);
                let pLength;
                // check if its variable length packet, if not just set the fixed length
                switch (dOpcode) {
                    // Sent when a player enters a chat message
                    case 4:
                    // Walk on command: Sent when player walks due to clicking a door or something
                    case 98:
                    // Command in chatbox, i.e., ::something
                    case 103:
                    // Sent when dude sends private message
                    case 126:
                    // Sent when player clicks a tile to walk normally
                    case 164:
                    // Sent when player walks using map (note, it has 14 additional bytes on the end
                    // presumed to be anticheat that are ignored)
                    case 248:
                        pLength = 69999;
                    default:
                        pLength = GetFixedPacketLength(dOpcode);
                }
                console.log("Opcode for this packet: ", dOpcode, "Packet length: ", pLength);
                // Remove this packet from the in stream buffer,
                // eventually we'll put it into another buffer that'll respond based
                // on the packet
                for (let i = 0; i < (pLength); i++) {
                    this._inStreamCacheBuffer.shift();
                }

            }
            // General packet cycle
            // 81: Update our player
            socket.write(
                UpdateLocalPlayer81(
                    this._outStreamEncryption.nextKey(),
                    1, // update our player
                    3, // move type
                    0, // planelevel
                    1, // clear await queuee
                    0, // update required - declares whether or not a bitmask should be read, good shit
                    21, // ycoord
                    21,  // xcoord
                    0, // updateNPlayers movements - always skip this
                    2047, // player list updating bit - always skip this
                    // bit masks now because update required = 1
                    // the bit masks are only read if that is 11
                )
            );
        });

        // 73: Load the map zone (fixed)
        socket.write(
            LoadMapZone73(
                this._outStreamEncryption.nextKey(),
                406, // higher = east, lower = west  // x
                406 // higher = north, lower = south // y coord
            )
        );

        // 81: Update our player
        socket.write(
            UpdateLocalPlayer81(
                this._outStreamEncryption.nextKey(),
                1, // update our player
                3, // move type
                0, // planelevel
                1, // clear await queuee
                1, // update required - declares whether or not a bitmask should be read, good shit
                21, // ycoord
                21,  // xcoord
                0, // updateNPlayers movements - always skip this
                2047, // player list updating bit - always skip this
                // bit masks now because update required = 1
                // the bit masks are only read if that is 11
            )
        );
        console.log("Callback attached and initial packets sent");
        this._gameInitialSetupComplete = true;
    }

}

new Server().startServer();

