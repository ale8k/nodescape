import Cryption from "../Cryption";
import { shortToBytes } from "../utils";

/**
 * Creates packet 73.
 * An 8x8 zone of tiles.
 * @param c (short) the server cryption class instance, to encrypt each packet
 * @param x (short) the x co-ordinate of the 8x8 zone
 * @param y the y co-ordinate of the 8x8 zone
 * @info This packet is a fixed size packet of 4 bytes.
 * @author ale8k
 */
export default function LoadMapZone73(c: Cryption, xcoord: number, ycoord: number): Buffer {
    const x = shortToBytes(xcoord);
    const y = shortToBytes(ycoord);
    const b = Buffer.from([c.getNextKey(), ...x, ...y]);
    // the 317 client removes +128 to the x coords second byte,
    // so we're adding it here
    b[2] += 128;
    return b;
}

// additional info about packet 73:
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
                         * See: https://explv.github.io/?centreX=3120&centreY=3300&centreZ=0&zoom=9 for info
                         *
                         * To simplify, there's 64x64 tiles in a 'region', Please note tile index starts at 0, so it's actually 63x63(0)
                         * 8x8 tiles is a zone, and 8x(8x8tiles) creates a map of 64x64 tiles.
                         *
                         * The client stores 104x104 tiles (or 13x13 zones) at a time in the ram.
                         *
                         * You'll also find +/- 6 calculations in some servers (and perhaps the client too) -
                         * this is because some code uses zone coordinates relative to the top left of the area,
                         * some relative to the centre.
                         * When the player is within 16 tiles of the edge the server sends the packet
                         * to reload the area around the player's current zone.
                         */
