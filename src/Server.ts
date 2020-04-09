import * as net from "net";
import * as Long from "long";
import Cryption from "./Cryption";
import { LoadMapZone73, UpdateLocalPlayer81 } from "./packets";
import * as utils from "./utils";

/**
 * Entry point for the server
 * @author ale8k
 */
class Server {
    // TODO: Implement code 16 for reconnection
    private loginProtocolStage: number = 0;
    private outStreamCryption: Cryption;

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
                if (data.toJSON().data.length > 3) {
                    console.log(data.toJSON(), "\n");
                }
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
                    // prepare outstream key gen
                    // TODO: include 'instream' and setup 'instream' cryption so we can read packets
                    this.outStreamCryption = new Cryption(sessionKey);
                    // Write out our response, player status and whether to log or not
                    socket.write(Buffer.from([2, 0, 0]));

                } else if (this.loginProtocolStage === 2) {

                    if (test === true) {
                        // 73: Load the map zone
                        socket.write(
                            LoadMapZone73(
                                this.outStreamCryption.getNextKey(),
                                406, // higher = east, lower = west  // x
                                406 // higher = north, lower = south // y coord
                            )
                        );

                        // UpdateLocalPlayer81(
                        //     this.outStreamCryption.getNextKey(),
                        //     1, 3, 3, 0, 0, 3, 3
                        // );
                        // 83: Update local player
                        socket.write(
                            UpdateLocalPlayer81(
                                this.outStreamCryption.getNextKey(),
                                1, // update our player
                                3, // move type
                                0, // planelevel
                                1, // clear await queue
                                1, // update required
                                21, // ycoord
                                21,  // xcoord
                                0, // updateNPlayers movements
                                2047, // player list updating bit
                                false,
                                0, // update block list
                            )
                        );
                    }

                }
            });

            socket.on("close", (err) => {
                this.loginProtocolStage = 0;
                console.log("Ended");
            });

        }).listen(43594, () => {
            console.log("Server running");
        });
    }

}

new Server();

