
import { setBit, convertToFixedBitArray } from "../../utils";
/**
 * Updates the local player in a given zone (8x8 set of tiles in a region)
 * The packet is dynamically sized based on the bits received
 * @param key the encrypted opcode
 * @param updateOurPlayer
 * @param movementType
 * @param planeHeight
 * @param clearAwaitingPointQueue
 * @param updateRequired
 * @param ycoord
 * @param xcoord
 * @param updateNPlayers
 * @param playerListUpdating
 * @author ale8k
 */
export default function UpdateLocalPlayer81(
        key: number,
        // bit args
        updateOurPlayer: number,
        movementType: number,
        planeHeight?: number,
        clearAwaitingPointQueue?: number,
        updateRequired?: number,
        ycoord?: number,
        xcoord?: number,
        updateNPlayers?: number,
        playerListUpdating?: number,
    ) {

    /**
     * Begin bit writing here:
     */
    const bitArr = [];

    /**
     * METHOD 117
     */
    // Update our player or not
    bitArr.push(updateOurPlayer);
    if (updateOurPlayer !== 0) {
        // Set our movement type and corresponding expected bits
        bitArr.push(...convertToFixedBitArray(movementType, 2));
        switch (movementType) {
            case 0:
                // Type 0: Do nothing
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                // Type 3: Set plane height
                bitArr.push(...convertToFixedBitArray(planeHeight as number, 2));
                break;
        }
        // Clear awaiting point queue
        bitArr.push(clearAwaitingPointQueue);
        // Update required bit, need more info on this
        // It still carries on reading...
        // OK it does carry on reading, but the bitmask relies on this!
        // if the count is 0, then the loop will never run.
        // i can confirm this but logging it in the client (which ima do now)
        bitArr.push(updateRequired);
        // our x/y coordinate of player (7bit)
        bitArr.push(...convertToFixedBitArray(ycoord as number, 7));
        bitArr.push(...convertToFixedBitArray(xcoord as number, 7));
    }
    /**
     * METHOD 134
     */
    bitArr.push(...convertToFixedBitArray(updateNPlayers as number, 8));

    /**
     * METHOD 91
     */
    bitArr.push(...convertToFixedBitArray(playerListUpdating as number, 11));

    /**
     * METHOD 49 (Actually 107 really)
     * Handles update masks, if the update required flag is missing within our player updates (method117)
     * then this is skipped entirely, so we can perform a check for that bit here.
     * If its present, execute a big mask (we'll pass it in eventually, for now hardcoded)
     * else just let the packet end
     *
     * 0x10
     * The 0x10 mask updates appearance of the player in exact same way as in updating player list.
     * Only difference is that appearance is updated from a set-sized buffer filled from the current buffer.
     * An unsigned inversed byte is read first which describes appearance buffer size, and the buffer is filled.
     *
     * 0x10:
     * Ubyte: gender
     * Ubyte: overhead icon id
     * Loop: 12 times, high bytes for armour
     * Loop: 5 times,  colour of body parts
     * Loop: 7 times, anim idx's
     * Long: player name
     * Ubyte: combat level
     * Ubyte: skill level
     */
    if (updateRequired === 1) {
        bitArr.push(...convertToFixedBitArray(0x10, 8));
        // size, reads backwards. fuck knows why
        bitArr.push(...convertToFixedBitArray((255 - 55), 8));
        // gender
        bitArr.push(...convertToFixedBitArray(0, 8));
        // overhead icon id
        bitArr.push(...convertToFixedBitArray(0, 8));

        /**
         * Rune Pl8 - 1127 + 0x200
         * Rune Chain - 1113
         * Rune Full Helm - 1163
         * Rune Med helm - 1147
         * rune 2h sword - 1319
         * Rune Pl8 legs - 1079
         */
        bitArr.push(...convertToFixedBitArray(1183 + 0x200, 16)); // shield 0 + 0x100
        bitArr.push(...convertToFixedBitArray(1127 + 0x200, 16)); // body 18 + 0x100
        bitArr.push(...convertToFixedBitArray(0 + 0x100, 16)); // arms 26 + 0x100
        bitArr.push(...convertToFixedBitArray(1059 + 0x200, 16)); // gloves 33 + 0x100
        bitArr.push(...convertToFixedBitArray(1079 + 0x200, 16)); // legs 36 + 0x100
        bitArr.push(...convertToFixedBitArray(4131 + 0x200, 16)); // boots 42 + 0x100
        bitArr.push(...convertToFixedBitArray(10 + 0x100, 16)); // what's this 10 + 0x100
        bitArr.push(...convertToFixedBitArray(0 + 0x100, 16));
        bitArr.push(...convertToFixedBitArray(0 + 0x100, 16));
        bitArr.push(...convertToFixedBitArray(0 + 0x100, 16));
        bitArr.push(...convertToFixedBitArray(0 + 0x100, 16)); // beard
        bitArr.push(...convertToFixedBitArray(1163 + 0x200, 16)); //helm

        // body part colours
        bitArr.push(...convertToFixedBitArray(7, 8)); // hair colour
        bitArr.push(...convertToFixedBitArray(4, 8)); // torso
        bitArr.push(...convertToFixedBitArray(9, 8)); // leg
        bitArr.push(...convertToFixedBitArray(5, 8)); // feet
        bitArr.push(...convertToFixedBitArray(0, 8)); // skin

        // anim indices
        bitArr.push(...convertToFixedBitArray(0x328, 16)); // standing still
        bitArr.push(...convertToFixedBitArray(0x337, 16)); // turning while standing
        bitArr.push(...convertToFixedBitArray(0x333, 16)); // walking
        bitArr.push(...convertToFixedBitArray(0x334, 16)); // turning around (backwards)
        bitArr.push(...convertToFixedBitArray(0x335, 16)); // turning a quarter-way clockwise
        bitArr.push(...convertToFixedBitArray(0x336, 16)); // turning a quarter-way counter clockwise
        bitArr.push(...convertToFixedBitArray(0x338, 16)); // running

        // players name long
        bitArr.push(...convertToFixedBitArray(1, 64));
        // players combat level
        bitArr.push(...convertToFixedBitArray(10, 8));
        // players skill level
        bitArr.push(...convertToFixedBitArray(0, 16));
    }

    /**
     * Create our buffer
     */
    // The size of the written bits in bytes
    const bitArrSize = Math.ceil(bitArr.length / 8);
    // our offset is therefore our bitarrsize + any further bytes to be written
    const offset = bitArrSize;
    // our opcode is 1 byte, and packet size is a short, 3 bytes total
    const basePacketSize = 3;
    // set buffer size, this includes our bits + any further bytes we gonna write
    const buf = Buffer.alloc(offset + basePacketSize);
    // our encrypted opcode
    buf[0] = 81 + key;
    // set packet size including all bits and bytes
    buf.writeInt16BE((offset), 1);
    // write the bits
    let bitIndex = 7;
    let byteIndex = 3;

    for (let i = 0; i < bitArr.length; i++) {
        setBit(buf, byteIndex, bitIndex, bitArr[i] as number);
        bitIndex -= 1;

        if (bitIndex <= -1) {
            bitIndex = 7;
            byteIndex += 1;
        }
    }
    return buf;
}
