import * as net from "net";
import { Socket } from "net";
import * as Long from "long";
import IsaacCipher from "./packets/IsaacCipher";
import { ParseIncomingPackets } from "./packets/incoming";
import { EventEmitter } from "events";
import { LoadMapZone73, UpdateLocalPlayer81 } from "./packets/outgoing";
import GameIds from "./GameIds";

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
    private _inStreamCacheBuffer: Buffer[] = [];

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

                    /**
                     * Opcode buffer cache testing:
                     */
                    // game tick, prob need better place to put this honestly
                    setInterval(() => {
                        this._gameLoopEventEmitter.emit("tick");
                    }, 600);

                    /**
                     * So I need to read opcode, parse packet, and repeat.
                     * not cache opcodes lol
                     * so take all data, store it in one big array
                     * then once 600ms is up, pass this big array to the parser
                     * for now we'll have it identify and return the opcode and the packet size
                     *
                     * also checkout buf.equals ->, may help me detmermine copies and stuff
                     *
                     * change of plan, we parse the opcodes here and then send them to the packet parser
                     *
                     */
                    this._gameLoopEventEmitter.on("tick", () => {
                        const decryptedList = this._inStreamCacheBuffer.map(buffer => {
                            buffer[0] = ((buffer[0] & 0xff) - this._inStreamDecryption.nextKey() & 0xff);
                            console.log(buffer.toJSON());
                            return buffer;
                        });
                        console.log("_");
                        this._inStreamCacheBuffer = [];

                        // we need to send packets here too actually
                        // so uhm i send one now, in real situation packet parser would
                        // come back and send them for us  or some kind of other eventemitter
                        // for now hardcode

                        // 81 Update; our; player (eventually will update others...);
                        // socket.write(
                        //     UpdateLocalPlayer81(
                        //         this._outStreamEncryption.nextKey(),
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

                    });
                    let b: Buffer;
                    /**
                     * Base packets needing to be sent only once after login
                     */

                    // 34: Update an item into the players inventory...
                    // Wouldn't this rely on the inv stack packet...?
                    // Pretty sure this doesn't update items, or if it does
                    // it something to do with skills llike fletching maybe

                    // 53: Inv stack size
                    // I think this actually sets the items in the inventory,
                    // not set the stack size...

                    // 72: Clears a shop inventory I think? I don't get the client code

                    // 248: Inventory background maybe? Like trading?

                    // 71: Set sidebar interface (fixed 4 bytes)
                    GameIds.SIDEBAR_IDS.forEach((sideBarIconId, sideBarLocationId) => {
                        const b = Buffer.alloc(4);
                        b[0] = 71 + this._outStreamEncryption.nextKey();
                        b.writeInt16BE(sideBarIconId, 1);
                        b[3] = sideBarLocationId + 128;
                        socket.write(b);
                    });


                    // 73: Load the map zone (fixed)
                    socket.write(
                        LoadMapZone73(
                            this._outStreamEncryption.nextKey(),
                            406, // higher = east, lower = west  // x
                            406 // higher = north, lower = south // y coord
                        )
                    );

                    // 109: Logout, gonna try attach this to the packet received from the client
                    // for initial packet parsing

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


                    // 176: Opens welcome screen - doesn't appear to work...?
                    b = Buffer.alloc(11);
                    b[0] = 176 + this._outStreamEncryption.nextKey();
                    socket.write(b);

                    // 221: Update friends list status
                    b = Buffer.alloc(2);
                    b[0] = 221 + this._outStreamEncryption.nextKey();
                    b[1] = 2; // 1 doesn't work, idk why, but 2 loads them
                    socket.write(b);

                    // 253: Write message to chat
                    // needa check why my string no render
                    const bytes: number[] = [10];
                    "Testing".split("").forEach(char => {
                        const c: number = char.charCodeAt(0);
                        bytes.push(c >>> 8);
                        bytes.push(c & 0xff);
                    });
                    console.log(bytes);
                    b = Buffer.alloc((bytes.length + 2));
                    b[0] = 253 + this._outStreamEncryption.nextKey();
                    b[1] = bytes.length;
                    socket.write(b);

                    /**
                     * Begin game loop once everything setup (i.e., accept shit from client)
                     */
                } else if (this._loginState === LoginState.LoggedIn) {
                    // the game event callback above should be somewhere down here eventually!

                    // now we're logged in, we are willing to push incoming packets
                    // to our buffer
                    this._inStreamCacheBuffer.push(data);

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

