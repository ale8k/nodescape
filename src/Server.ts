import * as net from "net";
import * as Long from "long";
import Cryption from "./Cryption";


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
                        const b = Buffer.alloc(14);
                        /**
                         * 73: Loads map region for Lumbridge
                         * This actually takes the 8x8 of the 'zone', not the tile. So we / 8.
                         * Not fully sure what Graham means below... I just follow advice for now.
                         *
                         * From Graham:
                         * 8x8 tiles = a zone. This is the granularity used in a bunch of packets
                         * (e.g. for sending ground items, projectiles, constructing dynamic/instanced maps, etc.)
                         * 64x64 tiles (or 8x8 zones) = a single map. This is the granularity used on disk in the cache.
                         * 104x104 tiles (or 13x13 zones) = the area that the client keeps in RAM at any one time.
                         *
                         * You'll also find +/- 6 calculations in some servers (and perhaps the client too) -
                         * this is because some code uses zone coordinates relative to the top left of the area,
                         * some relative to the centre.
                         * When the player is within 16 tiles of the edge the server sends the packet
                         * to reload the area around the player's current zone.
                         */
                        b[0] = 73 + this.outStreamCryption.getNextKey();
                        // we need to write little endians here so we can suffix the second byte with
                        // of the first co-ordinate short with +128 (the client removes this on client side)
                        b[1] = 1;
                        b[2] = 144 + 128;
                        console.log(b[2]);
                        b.writeInt16BE(400, 3);

                        /**
                         * 81: Initialise player
                         */
                        b[5] = 81 + this.outStreamCryption.getNextKey();
                        // Packet size, VARIABLE_SIZE : SHORT
                        b.writeInt16BE(6, 6);
                        /**
                         * Begin writing bits of player initialisation
                         */
                        // update our player or not
                        this.setBit(b, 8, 7, 1);
                        // VALUE: 3 - Type 3, update our players plane level
                        this.setBit(b, 8, 6, 1);
                        this.setBit(b, 8, 5, 1);
                        // setting plane level here, 0-3 (we use 0 for now)
                        this.setBit(b, 8, 4, 0);
                        this.setBit(b, 8, 3, 0);
                        // clear awaitig-point queue, i.e., remove our further steps left to do by client. Like when teleing
                        this.setBit(b, 8, 2, 1);
                        // is there an update required? (i.e., logged in, update our player)
                        this.setBit(b, 8, 1, 1);
                        // x, y co-ords8(20x20)
                        this.setBit(b, 8, 0, 0);
                        this.setBit(b, 9, 7, 1);
                        this.setBit(b, 9, 6, 0);
                        this.setBit(b, 9, 5, 0);
                        this.setBit(b, 9, 4, 0);
                        this.setBit(b, 9, 3, 0);
                        this.setBit(b, 9, 2, 0);

                        this.setBit(b, 9, 1, 0);
                        this.setBit(b, 9, 0, 1);
                        this.setBit(b, 10, 7, 0);
                        this.setBit(b, 10, 6, 0);
                        this.setBit(b, 10, 5, 0);
                        this.setBit(b, 10, 4, 0);
                        this.setBit(b, 10, 3, 0);
                        // How many other players the client needs to update,
                        // currently no multiplayer so none,
                        // this will need some considerable thought lol
                        this.setBit(b, 10, 2, 0);
                        this.setBit(b, 10, 1, 0);
                        this.setBit(b, 10, 0, 0);
                        this.setBit(b, 11, 7, 0);
                        this.setBit(b, 11, 6, 0);
                        this.setBit(b, 11, 5, 0);
                        this.setBit(b, 11, 4, 0);
                        this.setBit(b, 11, 3, 0);
                        // player list updating, not really sure here. Used wL's 2047 value
                        this.setBit(b, 11, 2, 1);
                        this.setBit(b, 11, 1, 1);
                        this.setBit(b, 11, 0, 1);
                        this.setBit(b, 12, 7, 1);
                        this.setBit(b, 12, 6, 1);
                        this.setBit(b, 12, 5, 1);
                        this.setBit(b, 12, 4, 1);
                        this.setBit(b, 12, 3, 1);
                        this.setBit(b, 12, 2, 1);
                        this.setBit(b, 12, 1, 1);
                        this.setBit(b, 12, 0, 1);
                        // initial player update done
                        console.log(b.toJSON());
                        socket.write(b);
                    }

                }

            });

            socket.on("close", (err) => {
                this.loginProtocolStage = 0;
                console.log("Ended");
            });

        }).listen(43594, () => console.log("Server running"));
    }

    /**
     * Reads bits from a NodeJS Buffer
     * @param buffer the buffer
     * @param i buffer index
     * @param bit bit index
     */
    private readBit(buffer: Buffer | Uint8Array, i: number, bit: number) {
        return (buffer[i] >> bit) % 2;
    }

    /**
     * Writes bits to a NodeJS Buffer
     * @param buffer the buffer
     * @param i buffer index
     * @param bit bit index
     * @param value bit value
     */
    private setBit(buffer: Buffer | Uint8Array, i: number, bit: number, value: number) {
        if (value === 0) {
            buffer[i] &= ~(1 << bit);
        } else {
            buffer[i] |= (1 << bit);
        }
    }


}

new Server();

