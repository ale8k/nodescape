import * as net from "net";
import { Socket } from "net";
import * as Long from "long";
import IsaacCipher from "./packets/IsaacCipher";
import { ParseIncomingPackets } from "./packets/incoming";
import LoginHandler from "./login/LoginHandler";
import PacketHandler from "./packets/PacketHandler";
import { EventEmitter } from "events";

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
    /**
     * A single observable emitting on a tick system,
     * also handles the transition between LoginHandler events and
     * PacketHandler events
     */
    private _gameEmitter: EventEmitter = new EventEmitter();


    constructor() {
        this.startServer();
    }

    private startServer(): void {
        let inStreamDecryption: IsaacCipher;
        let outStreamEncryption: IsaacCipher;
        let loginProtocolStage = 0;
        net.createServer((socket: Socket) => {
            console.log("A Client is attempting to establish a connection...");
            /**
             * Entry point
             * Almost works, the packet decryption doesn't though!
             */
            socket.on("data", (data) => console.log("Server byte[0]: " + data[0]));
            // new LoginHandler(socket, this._gameEmitter);
            // new PacketHandler(socket, this._gameEmitter);


            socket.on("data", (data) => {
                if (loginProtocolStage === 0) {

                    console.log("Server 1st response:");
                    loginProtocolStage = 1;
                    const b = Buffer.alloc(17);
                    // server key is 0, 0, 0, 69
                    b[15] = 0;
                    b[16] = 69;
                    socket.write(b);

                } else if (loginProtocolStage === 1) {

                    console.log("Server 2nd response:");
                    loginProtocolStage = 2;
                    const rsaBlock = data.toJSON().data.slice(43);
                    // try fromBytesBE if any issues
                    const clientSessionKey = Long.fromBytes(rsaBlock.slice(1, 9));
                    console.log("Client session key:", clientSessionKey.toBytes());

                    const serverSessionKey = Long.fromBytes(rsaBlock.slice(9, 17));
                    console.log("Server session key:", serverSessionKey.toBytes());

                    console.log("Username: TODO");
                    console.log("Password: TODO");

                    const inSessionKey = [
                        (clientSessionKey.shiftRight(32).toInt()),
                        (clientSessionKey.toInt()),
                        (serverSessionKey.shiftRight(32).toInt()),
                        (serverSessionKey.toInt())
                    ];
                    console.log("In session key = " + inSessionKey);
                    const sessionKey = [
                        (clientSessionKey.shiftRight(32).toInt()) + 50,
                        (clientSessionKey.toInt()) + 50,
                        (serverSessionKey.shiftRight(32).toInt()) + 50,
                        (serverSessionKey.toInt()) + 50
                    ];
                    console.log("Out session key = " + sessionKey);
                    inStreamDecryption = new IsaacCipher(inSessionKey);
                    outStreamEncryption = new IsaacCipher(sessionKey);
                    socket.write(Buffer.from([2, 0, 0]));

                } else if (loginProtocolStage === 2) {
                    /**
                     * Incoming packet parsing
                     */
                    ParseIncomingPackets(data, inStreamDecryption, socket, outStreamEncryption);
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

new Server();

