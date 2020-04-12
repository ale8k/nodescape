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
    private _loginState: LoginState = LoginState.FirstResponse;
    private _inStreamDecryption: IsaacCipher;
    private _outStreamEncryption: IsaacCipher;

    /**
     * The emitter which handles directing incoming and outgoing packets
     */
    private _gameLoopEventEmitter: EventEmitter = new EventEmitter();
    /**
     * The game loop emitter emits to this, such that
     * it can parse the packets and return timely
     */
    private _packetParserEventEmitter: EventEmitter = new EventEmitter();
    /**
     * Only used during login completion, sends a bunch of packets
     * required on login, i.e., region, sidebars etc.
     */
    private _loginSetUpEventEmitter: EventEmitter = new EventEmitter();
    /**
     * A place for us to store the incoming data outside of our
     * 600ms cycle
     */
    private _inStreamCacheBuffer: number[] = [];
    /**
     * The player's id. Eventually this will be an array,
     * for multiplayer and handling each socket connection
     */
    private _playerId: number;

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
                    this._playerId = rsaBlock[17];
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
                    socket.write(Buffer.from([2, 0, 0]));
                    this._loginState = LoginState.LoggedIn;
                    console.log("Second client request received and second server response sent");

                    /**
                     * Opcode buffer cache testing:
                     */
                    // game tick, prob need better place to put this honestly
                    setInterval(() => {
                        this._gameLoopEventEmitter.emit("tick");
                    }, 600);

                    /**
                     * Game loop
                     */
                    this._gameLoopEventEmitter.on("tick", () => {

                        // reset cache buffer every 600ms

                        // the client doesnt send the idle packet on 600ms btw!
                        // check if the length is greater than 0 due to this!
                        if (this._inStreamCacheBuffer.length > 0) {
                            /**
                             * Read an op code,
                             * check packet size
                             * print opcode
                             * remove packet size from array
                             * repeat until inStreamCacheBuffer empty
                             */
                            const testBuffer = [241, 0, 0, 0, 0, 36, 0, 0, 0, 0, 202, 152, 0]; // two packets
                            console.log("TEST BUFFER: SHOULD SHOW 241, 36");
                            while (testBuffer.length > 0) {
                                const opcode = testBuffer[0];
                                console.log("OPCODE: ", opcode);
                                //let parsedOpcode = ParsePacketOpcode(opcode, this._inStreamDecryption);
                                const packetLength = GetPacketLength(opcode);
                                // 241 = 4, so we got length 4 and opcode
                                for (let i = 0; i < (packetLength + 1); i++) {
                                    testBuffer.shift();
                                }
                            }

                            //console.log(ParsePacketOpcode(this._inStreamCacheBuffer[index], this._inStreamDecryption));
                        }
                        // reset it regardless
                        this._inStreamCacheBuffer = [];
                        console.log("_");


                        //buffer[0] = ((buffer[0] & 0xff) - this._inStreamDecryption.nextKey() & 0xff);

                    });

                    let b: Buffer;

                    /**
                     * Base packets needing to be sent only once after login
                     */

                    // 71: Set sidebar interface (fixed 4 bytes)
                    GameIds.SIDEBAR_IDS.forEach((sideBarIconId, sideBarLocationId) => {
                        const b = Buffer.alloc(4);
                        b[0] = 71 + this._outStreamEncryption.nextKey();
                        b.writeInt16BE(sideBarIconId, 1);
                        b[3] = sideBarLocationId + 128;
                        socket.write(b);
                    });

                    // 249: Sends mem status and player's index in servers playerlist to client
                    b = Buffer.alloc(4);
                    b[0] = 249 + this._outStreamEncryption.nextKey();
                    b[1] = 1 + 128; // one of them -128 removes on client end
                    // rest of it is a short accepting our id, but its also got that -128 on client side
                    // again. Really frustrating
                    b[2] = (this._playerId + 128);
                    b[3] = (this._playerId >> 8);
                    socket.write(b);
                    console.log("Player index sent to client");

                    // 73: Load the map zone (fixed)
                    socket.write(
                        LoadMapZone73(
                            this._outStreamEncryption.nextKey(),
                            406, // higher = east, lower = west  // x
                            406 // higher = north, lower = south // y coord
                        )
                    );

                    // 107: Reset camera position
                    b = Buffer.alloc(1);
                    b[0] = 107 + this._outStreamEncryption.nextKey();
                    socket.write(b);

                    // 134: Set/Update(?) skill level // sets them all for some reason... :D
                    // need to play with this more... (i.e., update just 1)
                    b = Buffer.alloc(7);
                    new Array(10).fill(0).forEach((zero, i) => {
                        b[0] = 134 + this._outStreamEncryption.nextKey();
                        b[1] = i;
                        // the client reads skill xp updates like this
                        b[2] = (0 >> 8);
                        b[3] = (0);
                        b[4] = (0 >> 24);
                        b[5] = (0 >> 16);
                        // skill level?
                        b[6] = 5;
                        socket.write(b);
                    });

                    // 221: Update friends list status
                    b = Buffer.alloc(2);
                    b[0] = 221 + this._outStreamEncryption.nextKey();
                    b[1] = 2; // 1 doesn't work, idk why, but 2 loads them
                    socket.write(b);

                    // 81: Update our player
                    // socket.write(
                    //     UpdateLocalPlayer81(
                    //         this._outStreamEncryption.nextKey(),
                    //         1, // update our player
                    //         3, // move type
                    //         0, // planelevel
                    //         1, // clear await queuee
                    //         1, // update required - declares whether or not a bitmask should be read, good shit
                    //         21, // ycoord
                    //         21,  // xcoord
                    //         0, // updateNPlayers movements - always skip this
                    //         2047, // player list updating bit - always skip this
                    //         // bit masks now because update required = 1
                    //         // the bit masks are only read if that is 11
                    //     )
                    // );

                /**
                 * Begin game loop once everything setup (i.e., accept shit from client)
                 */
                } else if (this._loginState === LoginState.LoggedIn) {
                    /**
                     * First step, concat all data into one big buffer
                     *
                     * 2nd step, read this giant buffer in a burst
                     * Reading works by -> read opcode, compare opcode to packet length,
                     * skip that amount of packets, read next opcode
                     *
                     * Then we'll work on responding afterwards
                     */
                    //console.log(((data[0] & 0xff) - this._inStreamDecryption.nextKey() & 0xff));
                    //console.log(data.toJSON().data);
                    // for now we don't clear it, we just track opcode indexes and keep going
                    this._inStreamCacheBuffer.push(...data.toJSON().data);

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

