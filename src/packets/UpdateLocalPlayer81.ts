
import { setBit, convertToBitArray, convertToFixedBitArray } from "../utils";
import convertTo8Bit from "src/utils/convertToFixedBitArray";
import * as Long from "long";

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
        updatePlayersAppearance?: boolean,
        playerIsInUpdateBlockList?: number,

        // byte args
        gender?: number,
        overheadId?: number

    ) {

    /**
     * Begin bit writing here:
     *
     * it works like so, we keep pushing bits to the bit array
     * once its complete, we call writeBits(buf, bitArr, 3) passing our buffer,
     * the bit array, and an index to start from. The method writes to it and returns it
     * back to us - it may also returns the index to continue from whereever it left off
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

    // We're updating 0 other players, allows us to skip this method and play
    // single player
    // How many other players movements will be updated (8bit)
    bitArr.push(...convertToFixedBitArray(updateNPlayers as number, 8));
  
    /**
     * METHOD 91
     */

    // Player list updating (11bit), we setting player 1 and ONLY 1
    bitArr.push(...convertToFixedBitArray(playerListUpdating as number, 11));

    // next it WOULD update the appearance, but the stream needs setting in our
    // block flag updating (method49), so this actually happens on the next packet, not this one!
    // silly doc didn't explain this lol

    if (updatePlayersAppearance) {
        console.log("boop");
    } else {

    }

    // So we skip to whether or not the client has a chunk
    // in the update block list, our block flag list, which it doesn't initially.
    // So this is 'no' the first time around and 'yes' the next.
    bitArr.push(playerIsInUpdateBlockList as number);

    /**
     * WE MAY ACTUALLY NEED TO SKIP THESE BITS, NOT SURE THEY'RE RELEVANT
     * AS WE DON'T HAVE MULTIPLAYER RIGHT NOW
     */
    // Clear awaiting point queue for other player (s) relative to our player
    // we don't have any bloody players though lol
    // figure out why it checks this for the other players here
    bitArr.push(clearAwaitingPointQueue);

    // X/Y for other player (s) relative to our player
    //bitArr.push(...convertToFixedBitArray(12, 5));
    //bitArr.push(...convertToFixedBitArray(12, 5));

    // this ends the player list updating process

    /**
     * METHOD 49 (Actually 107 really)
     */
    // It actually reads a single byte, which is the flag of updating we wish
    // to perform on our / other players. It's all done here. The update mask we're
    // currently supporting is 0x10, appearance update.
    /**
     * Masks written in bit format, to make it easier for us to write them:
     * Please note, they're all done in 8 bit formats or 16 bit if 0x40 is called,
     * They're also all little endian. Ofc for 0x10, this doesn't matter.
     * 
     * 0x10: 10000
     */


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