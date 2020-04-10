import * as net from "net";
import * as Long from "long";
import Cryption from "./IsaacCipher";
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
    private outStreamEncryption: Cryption;
    private inStreamDecryption: Cryption;
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
                    // this represents 0, 0, 0, 0, 0, 0, 21, 179 === 5555
                    b[15] = 21;
                    b[16] = 179;
                    socket.write(b);

                } else if (this.loginProtocolStage === 1) {

                    console.log("Server 2nd response:");
                    this.loginProtocolStage = 2;
                    const rsaBlock = data.toJSON().data.slice(43);
                    // try fromBytesBE if any issues
                    const clientSessionKey = Long.fromBytes(rsaBlock.slice(1, 9));
                    console.log(clientSessionKey);
                    console.log("Client session key:", clientSessionKey);
                    const serverSessionKey = Long.fromBytes(rsaBlock.slice(9, 17));
                    console.log("Server session key:", serverSessionKey);
                    console.log("Username: TODO");
                    console.log("Password: TODO");

                    // shift to integer and ISAAC seed with +=50
                    // really not a fan of us using the long package again, surely
                    // we can extend the 53bit cap another way?
                    const sessionKey = [
                        (clientSessionKey.shiftRight(32).toInt()) + 50,
                        (clientSessionKey.toInt()) + 50,
                        (serverSessionKey.shiftRight(32).toInt()) + 50,
                        (serverSessionKey.toInt()) + 50
                    ];
                    // Our key gen for the out stream
                    this.outStreamEncryption = new Cryption(sessionKey);
                    // Our key gen for the in stream
                    this.inStreamDecryption = new Cryption(sessionKey);
                    // Write out our response, player status and whether to log or not
                    socket.write(Buffer.from([2, 0, 0]));

                } else if (this.loginProtocolStage === 2) {

                    /**
                     * Incoming packet parsing
                     */
                    ParseIncomingPackets(data, this.inStreamDecryption, this.outStreamEncryption);

                    /**
                     * Outgoing packet sending & encrypting
                     */
                    // Send our initial 73 & 81 packets once upon load
                    if (this.isTheInitialLoad === true) {
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
                                1, // clear await queue
                                1, // update required
                                21, // ycoord
                                21,  // xcoord
                                0, // updateNPlayers movements
                                2047, // player list updating bit
                            )
                        );
                        this.isTheInitialLoad = false;
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

