import { shortToBytes } from "../../../utils";
import { Socket } from "net";

/**
 * Creates packet 73.
 * An 8x8 zone of tiles.
 * Need more info
 * @param c (short) the server cryption class instance, to encrypt each packet
 * @param x (short) the x co-ordinate of the 8x8 zone
 * @param y the y co-ordinate of the 8x8 zone
 * @info This packet is a fixed size packet of 4 bytes.
 * @author ale8k
 */
export default function LoadMapZone73(key: number, socket: Socket, xBaseCoord: number, yBaseCoord: number): void {
    // (3200 / 8) + 6 = 406
    const x = shortToBytes(((xBaseCoord / 8) + 6));
    const y = shortToBytes(((yBaseCoord / 8) + 6));
    const b = Buffer.from([73 + key, ...x, ...y]);
    // the 317 client removes +128 to the x coords second byte,
    // so we're adding it heree
    b[2] += 128;
    socket.write(b);
}


// additional info about packet 73:
/**
 * 73: Loads map region
 * This actually takes the 8x8 of the 'zone', not the tile. A tile(region he means) consists of 8x8 zones,
 * a zone is 8x8 single tiles. So, we get a tile position relative to a zone.
 *
 * 8x8 tiles = 64 tiles, so a zone is 64 tiles
 *
 * From Graham:
 * 8x8 tiles = a zone. This is the granularity used in a bunch of packets
 * (e.g. for sending ground items, projectiles, constructing dynamic/instanced maps, etc.)
 * 64x64 tiles (or 8x8 zones) = a single map (region on that xplv thing).
 * This is the granularity used on disk in the cache.
 * 104x104 tiles (or 13x13 zones) = the area that the client keeps in RAM at any one time.
 *
 * You'll also find +/- 6 calculations in some servers (and perhaps the client too) -
 * this is because some code uses zone coordinates relative to the top left of the area,
 * some relative to the centre.
 * When the player is within 16 tiles of the edge the server sends the packet
 * to reload the area around the player's current zone.
 */
