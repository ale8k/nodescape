
import { setBit, convertToBitArray, convertToFixedBitArray } from "../utils";
import convertTo8Bit from "src/utils/convertToFixedBitArray";
import * as Long from "long";

/**
 * Our first packet only considers methods 117, our player
 * and method 49, the bit mask.
 * 
 * Because our bitmask is set in the first packet,
 * our next packet can consider method134, appearance updating,
 * because we have a mask prepared.
 */

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
    let bitArr = [];

    /**
     * METHOD 117
     */
    // Update our player or not
    bitArr.push(updateOurPlayer);

    // Set our movement type and corresponding expected bits
    bitArr.push(...convertToFixedBitArray(movementType, 2));
    switch (movementType) {
        case 0:
            break;
        case 1:
            break;
        case 2:
            break;
        case 3:
            // set the player's plane/height level 
            // TODO: this obviously needs to be dynamic, for now, 
            // we hardcode height 3
            bitArr.push(...convertToFixedBitArray(planeHeight as number, 2));
            break;
    }
    // Clear awaiting point queue
    bitArr.push(clearAwaitingPointQueue);
    // Update required bit, need more info on this
    bitArr.push(updateRequired);
    // our x/y coordinate of player (7bit)
    bitArr.push(...convertToFixedBitArray(ycoord as number, 7));
    bitArr.push(...convertToFixedBitArray(xcoord as number, 7));

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
     * 
     * 0x10
     * The 0x10 mask updates appearance of the player in exact same way as in updating player list. 
     * Only difference is that appearance is updated from a set-sized buffer filled from the current buffer.
     * An unsigned inversed byte is read first which describes appearance buffer size, and the buffer is filled.
     */
    bitArr.push(...convertToFixedBitArray(0x10, 8)); 
    // size, reads backwards. fuck knows why
    bitArr.push(...convertToFixedBitArray((255 - 48), 8));
    // gender
    bitArr.push(...convertToFixedBitArray(0, 8));
    bitArr.push(...convertToFixedBitArray(0, 8));
    // overhead icon id
    bitArr.push(...convertToFixedBitArray(0, 8));
    // 12 bytes for equipment (0 means nothing)
    for (let i = 0; i < 12; i++) {
        bitArr.push(...convertToFixedBitArray(0, 8));
    }
    // body part colours
    bitArr.push(...convertToFixedBitArray(7, 16));
    bitArr.push(...convertToFixedBitArray(8, 16));
    bitArr.push(...convertToFixedBitArray(9, 16));
    bitArr.push(...convertToFixedBitArray(5, 16));
    bitArr.push(...convertToFixedBitArray(0, 16));
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
    bitArr.push(...convertToFixedBitArray(3, 8));

    /**
     * Create our buffer
     */
    // The size of the written bits in bytes
    let bitArrSize = Math.ceil(bitArr.length / 8); 
    // our offset is therefore our bitarrsize + any further bytes to be written
    let offset = bitArrSize; 
    // our opcode is 1 byte, and packet size is a short, 3 bytes total
    let basePacketSize = 3; 
    // set buffer size, this includes our bits + any further bytes we gonna write
    const buf = Buffer.alloc(offset + basePacketSize + 1);
    // our encrypted opcode
    buf[0] = 81 + key;
    // set packet size including all bits and bytes
    buf.writeInt16BE((offset + 1), 1);
    // write the bits
    let bitIndex = 7;
    let byteIndex = 3;

    for (let i = 0; i < bitArr.length; i++) {
        setBit(buf, byteIndex, bitIndex, bitArr[i] as number);
        // console.log("Writing byte index:" + byteIndex + ", and bit index:" + bitIndex);
        bitIndex -= 1;

        if (bitIndex <= -1) {
            bitIndex = 7;
            byteIndex += 1;
        }
    }

    console.log("Final offset is: " + offset);

    return buf;
}