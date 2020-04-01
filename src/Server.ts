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
                        let b = Buffer.alloc(0);
                        /**
                         * 73: Loads map region
                         * This actually takes the 8x8 of the 'zone', not the tile. A tile consists of 8x8 zones,
                         * a zone is 8x8 single tiles. So, we get a tile position relative to a zone.
                         *
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
                        b = Buffer.alloc(5);
                        b[0] = 73 + this.outStreamCryption.getNextKey();
                        // we need to write little endians here so we can suffix the second byte with
                        // of the first co-ordinate short with +128 (the client removes this on client side)
                        b[1] = 1;
                        b[2] = 147 + 128;
                        b.writeInt16BE(403, 3);
                        socket.write(b);

                        /**
                         * 81: Initialise player
                         */
                        b = Buffer.alloc(9);
                        b[0] = 81 + this.outStreamCryption.getNextKey();
                        // Packet size, VARIABLE_SIZE : SHORT
                        b.writeInt16BE(6, 1);

                        // update our player or not
                        this.setBit(b, 3, 7, 1);
                        // VALUE: 3 - Type 3, update our players plane level
                        this.setBit(b, 3, 6, 1);
                        this.setBit(b, 3, 5, 1);
                        // setting plane level here, 0-3 (we use 0 for now)
                        this.setBit(b, 3, 4, 0);
                        this.setBit(b, 3, 3, 0);
                        // clear awaitig-point queue, i.e., remove our further steps left to do by client. Like when teleing
                        this.setBit(b, 3, 2, 1);
                        // is there an update required? (i.e., logged in, update our player)
                        this.setBit(b, 3, 1, 1);
                        // x
                        this.setBit(b, 3, 0, 0);
                        this.setBit(b, 4, 7, 0);
                        this.setBit(b, 4, 6, 1);
                        this.setBit(b, 4, 5, 0);
                        this.setBit(b, 4, 4, 1);
                        this.setBit(b, 4, 3, 0);
                        this.setBit(b, 4, 2, 1);
                        // y
                        this.setBit(b, 4, 1, 0);
                        this.setBit(b, 4, 0, 0);
                        this.setBit(b, 5, 7, 1);
                        this.setBit(b, 5, 6, 0);
                        this.setBit(b, 5, 5, 1);
                        this.setBit(b, 5, 4, 0);
                        this.setBit(b, 5, 3, 1);
                        // How many other players the client needs to update,
                        // currently no multiplayer so none,
                        // this will need some considerable thought lol
                        this.setBit(b, 5, 2, 0);
                        this.setBit(b, 5, 1, 0);
                        this.setBit(b, 5, 0, 0);
                        this.setBit(b, 6, 7, 0);
                        this.setBit(b, 6, 6, 0);
                        this.setBit(b, 6, 5, 0);
                        this.setBit(b, 6, 4, 0);
                        this.setBit(b, 6, 3, 0);
                        // player list updating, not really sure here. Used wL's 2047 value
                        this.setBit(b, 6, 2, 1);
                        this.setBit(b, 6, 1, 1);
                        this.setBit(b, 6, 0, 1);
                        this.setBit(b, 7, 7, 1);
                        this.setBit(b, 7, 6, 1);
                        this.setBit(b, 7, 5, 1);
                        this.setBit(b, 7, 4, 1);
                        this.setBit(b, 7, 3, 1);
                        this.setBit(b, 7, 2, 1);
                        this.setBit(b, 7, 1, 1);
                        this.setBit(b, 7, 0, 1);
                        // initial player update done
                        // b[8] is empty byte, without it packet is being rejected?
                        socket.write(b);

                        /**
                         * 253: Send message to client
                         */
                        // b = Buffer.alloc(5);
                        // b[0] = 253 + this.outStreamCryption.getNextKey();
                        // b.writeInt8(1, 1);
                        // b.writeInt8(33, 2);
                        // socket.write(b);

                        /**
                         * 24: Send message to client
                         */
                        b = Buffer.alloc(3);
                        b[0] = 24 + this.outStreamCryption.getNextKey();
                        // b.writeInt8(1, 1);
                        // b.writeInt8(33, 2);
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

