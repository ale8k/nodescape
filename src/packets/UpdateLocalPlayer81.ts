
import { setBit, convertToBitArray, convertToFixedBitArray } from "../utils";
import convertTo8Bit from "src/utils/convertToFixedBitArray";
/**
 * Updates the local player in a given zone (8x8 set of tiles in a region)
 * The packet is dynamically sized based on the bits received 
 * @param key the encrypted opcode
 * @param updateOurPlayer 
 * @param movementType 
 * @param planeHeight 
 * @param clearAwaitingPointQueue 
 * @param updateRequired 
 * @param xcoord 
 * @param ycoord 
 * @param updateNPlayers 
 * @param playerListUpdating 
 * @author ale8k
 */
export default function UpdateLocalPlayer81(
        key: number, 
        updateOurPlayer: number,
        movementType: number, 
        planeHeight?: number,
        clearAwaitingPointQueue?: number,
        updateRequired?: number,
        xcoord?: number,
        ycoord?: number,
        updateNPlayers?: number,
        playerListUpdating?: number,
    ) {

    /**
     * begin bit writing here:
     */
    let bitArr = [];
    // it works like so, we keep pushing bits to the bit array
    // once its complete, we call writeBits(buf, bitArr, 3) passing our buffer,
    // the bit array, and an index to start from. The method writes to it and returns it
    // back to us - it may also returns the index to continue from whereever it left off

    // update our player or not
    bitArr.push(updateOurPlayer);
    
    // set our movement type and corresponding expected bits
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

    // whether or not to clear the awaiting point queue, i.e., tiles 
    // for the player to go to. We would clear it if they were say... teleporting
    bitArr.push(clearAwaitingPointQueue);

    // update required bit, need more info on this
    bitArr.push(updateRequired);

    // our x/y coordinate relative to the 'region (Graham refers to this as a map)'
    // a map is 64x64 tiles.
    // the client reads these in 7 bit values
    bitArr.push(...convertToFixedBitArray(xcoord as number, 7));
    bitArr.push(...convertToFixedBitArray(ycoord as number, 7));

    // update other player movements, it reads this in an 8 bit value
    // TODO: finish the bit writing for this
    bitArr.push(...convertToFixedBitArray(0, 8));

    // player list updating, it reads an 11 bit value
    // this value is the next player to be updated about.
    // the max value in 11 bits is 2047, therefore this is our starting
    // player
    bitArr.push(...convertToFixedBitArray(2047, 11));
    //console.log(bitArr);

    /**
     * Create our buffer
     */
    const buf = Buffer.alloc(Math.ceil(bitArr.length / 8) + 4);
    // our encrypted opcode
    buf[0] = 81 + key;

    // packet size placeholder
    // set packet size now we know what it is
    buf.writeInt16BE(Math.ceil(bitArr.length / 8) + 1, 1);

    // write the bits
    // we know we gotta start at index 3, because opcode + size = 3 bytes
    let bitIndex = 7;
    let byteIndex = 3;

    // something is wrong here, it's not writing correctly
    for (let i = 0; i < bitArr.length; i++) {
        setBit(buf, byteIndex, bitIndex, bitArr[i] as number);
        console.log("Writing byte index:" + byteIndex + ", and bit index:" + bitIndex);
        bitIndex -= 1;

        if (bitIndex <= -1) {
            bitIndex = 7;
            byteIndex += 1;
        }
    }

    return buf;
}