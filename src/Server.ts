import * as net from "net";
import * as Long from "long";
import IsaacCipher from "./IsaacCipher";
import { LoadMapZone73, UpdateLocalPlayer81 } from "./packets/outgoing";
import { ParseIncomingPackets } from "./packets/incoming";
import * as utils from "./utils";

/**
 * Entry point for the server
 * @author ale8k
 */
class Server {
    // TODO: Implement code 16 for reconnection
    private loginProtocolStage: number = 0;
    private outStreamEncryption: IsaacCipher;
    private inStreamDecryption: IsaacCipher;
    private isTheInitialLoad: boolean = true;
    // When reading the packets, please note it goes data -> frame header
    // Can flip the array but idk if it matters

    constructor() {
        this.startServer();
    }

    private startServer(): void {

        const test = true;

        net.createServer((socket: net.Socket) => {
            console.log("Client attempting to establish connection...");

            socket.on("data", (data) => {

                console.log("_");

                if (this.loginProtocolStage === 0) {

                    console.log("Server 1st response:");
                    this.loginProtocolStage = 1;
                    const b = Buffer.alloc(17);
                    // server key is 0, 0, 0, 69
                    b[15] = 0;
                    b[16] = 69;
                    socket.write(b);

                } else if (this.loginProtocolStage === 1) {

                    console.log("Server 2nd response:");
                    this.loginProtocolStage = 2;
                    const rsaBlock = data.toJSON().data.slice(43);
                    // try fromBytesBE if any issues
                    const clientSessionKey = Long.fromBytes(rsaBlock.slice(1, 9));
                    console.log("Client session key:", clientSessionKey.toBytes());

                    const serverSessionKey = Long.fromBytes(rsaBlock.slice(9, 17));
                    console.log("Server session key:", serverSessionKey.toBytes());

                    console.log("Username: TODO");
                    console.log("Password: TODO");

                    // shift to integer and ISAAC seed with +=50
                    // really not a fan of us using the long package again, surely
                    // we can extend the 53bit cap another way?
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
                    // Our key gen for the in stream
                    this.inStreamDecryption = new IsaacCipher(inSessionKey);
                    // Our key gen for the out stream
                    this.outStreamEncryption = new IsaacCipher(sessionKey);

                    // Write out our response, player status and whether to log or not
                    socket.write(Buffer.from([2, 0, 0]));

                } else if (this.loginProtocolStage === 2) {
                    /**
                     * Incoming packet parsing
                     */
                    ParseIncomingPackets(data, this.inStreamDecryption);

                    /**
                     * Outgoing packet sending & encrypting
                     */
                    // Send our initial 73 & 81 packets once upon load
                    if (this.isTheInitialLoad === true) {
                            //setInterval(() => {
                            // 73: Load the map zone
                            socket.write(
                                LoadMapZone73(
                                    this.outStreamEncryption.nextKey(),
                                    406, // higher = east, lower = west  // x
                                    406 // higher = north, lower = south // y coord
                                )
                            );

                            // 83: Update our player (eventually will update others...)
                            socket.write(
                                UpdateLocalPlayer81(
                                    this.outStreamEncryption.nextKey(),
                                    1, // update our player
                                    3, // move type
                                    0, // planelevel
                                    1, // clear await queuee
                                    1, // update required
                                    21, // ycoord
                                    21,  // xcoord
                                    0, // updateNPlayers movements
                                    2047, // player list updating bit
                                )
                            );
                        //}, 600);
                        //this.isTheInitialLoad = false;
                    }


                }
            });

            socket.on("close", (err) => {
                this.loginProtocolStage = 0;
                this.isTheInitialLoad = true;
                console.log("Ended");
            });

        }).listen(43594, () => {
            console.log("Server running");
        });
    }

}

new Server();

