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
                        b.writeInt16BE(404, 3);
                        socket.write(b);

                        /**
                         * 81: Initialise player
                         */
                        b = Buffer.from([0, 0, 0, 0, 0, 0, 0, 0]);
                        b[0] = 81 + this.outStreamCryption.getNextKey();
                        // Packet size, VARIABLE_SIZE : SHORT
                        // Acts as a placeholder until we know our packet size
                        // either 5 or includes this (i.e., 5 + 2 + 1)
                        b[1] = 0;
                        b[2] = 5;

                        /**
                         * Our player movements: client method117
                         */
                        // update our player or not
                        this.setBit(b, 3, 7, 1);

                        // Movement type
                        this.setBit(b, 3, 6, 0);
                        this.setBit(b, 3, 5, 0);

                        /**
                         * Other player movements: client method134
                         * We skip this currently as there is no other players to update
                         */
                        // how many 'other' players to update
                        this.setBit(b, 3, 4, 0);
                        this.setBit(b, 3, 3, 0);
                        this.setBit(b, 3, 2, 0);
                        this.setBit(b, 3, 1, 0);
                        this.setBit(b, 3, 0, 0);
                        this.setBit(b, 4, 7, 0);
                        this.setBit(b, 4, 6, 0);
                        this.setBit(b, 4, 5, 0);

                        /**
                         * Player list updating: client method91
                         */
                        // 11 bit value representing next player in the update list
                        // the client checks if this exists, if it does, it'll update appearance
                        // for this player next
                        this.setBit(b, 4, 4, 0);
                        this.setBit(b, 4, 3, 0);
                        this.setBit(b, 4, 2, 0);
                        this.setBit(b, 4, 1, 0);
                        this.setBit(b, 4, 0, 0);
                        this.setBit(b, 5, 7, 0);
                        this.setBit(b, 5, 6, 0);
                        this.setBit(b, 5, 5, 0);
                        this.setBit(b, 5, 4, 0);
                        this.setBit(b, 5, 3, 0);
                        this.setBit(b, 5, 2, 1);

                        // Appearance updating, can't do this cause it's null... wtf lol.

                        // Location updating starts here

                        // think this tells client if it had a chunk in the update list,
                        // imma just say yeah for now lol
                        this.setBit(b, 5, 1, 0);

                        // clear awaiting point queue, like when teleing. (no)
                        this.setBit(b, 5, 0, 0);

                        // x coord
                        this.setBit(b, 6, 7, 0);
                        this.setBit(b, 6, 6, 0);
                        this.setBit(b, 6, 5, 1);
                        this.setBit(b, 6, 4, 1);
                        this.setBit(b, 6, 3, 1);
                        // y coord
                        this.setBit(b, 6, 2, 0);
                        this.setBit(b, 6, 1, 0);
                        this.setBit(b, 6, 0, 1);
                        this.setBit(b, 7, 7, 1);
                        this.setBit(b, 7, 6, 1);

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

