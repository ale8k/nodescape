import { setBit, convertToFixedBitArray } from "../../../utils";
import Append0x10 from "./update-masks/Append0x10";

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
 *
 *
 *
 * P81 Summary:
 *
 * Starts with our playermovement
 * Checks if we wanna update our dude, if not, skips this phase
 * Otherwise it reads movement type
 *
 * 0 - Tell it to do nothing, BUT add us to update list (i.e., read a bitmask)
 * 1 - Tell dude to move (walk), decide if you want a bitmask
 * 2 - Tell dude to move (run), decide if you want a bitmask
 * 3 - Teleport our dude basically, set teleport flag (clears awaitign point queue), decide if you want a bit mask
 * finally, reads two 7 bit values which are our x/y.
 *
 * SYnc others movement
 * Can skip this by saying there's 0 other players lol
 *
 * Update our players bitmasks
 * can skip this saying 0 players (via 2047 clause)
 *
 * Our bitmasks, depending on whether our movement method said if 'update required'
 * then it'll either run a bitmask or it won't.
 * We then append a bitmask and that completes the update.
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
    // if this is off, it'll skip the entire block lol
    bitArr.push(updateOurPlayer);
    if (updateOurPlayer !== 0) {
        // Set our movement type and corresponding expected bits
        bitArr.push(...convertToFixedBitArray(movementType, 2));
        switch (movementType) {
            case 0:
                // Type 0: Do nothing
                // Just run an updatemask
                break;
            case 1:
                console.log("walk walk");
                bitArr.push(...convertToFixedBitArray(3, 3));
                bitArr.push(updateRequired);
                break;
            case 2:
                break;
            case 3:
                // Type 3: Set plane height
                bitArr.push(...convertToFixedBitArray(planeHeight as number, 2));
                bitArr.push(clearAwaitingPointQueue); // teleport
                bitArr.push(updateRequired);// whether or not to send mask
                bitArr.push(...convertToFixedBitArray(ycoord as number, 7));
                bitArr.push(...convertToFixedBitArray(xcoord as number, 7));
                break;
        }

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
     * Update masks
     * If update required is set, it'll append this mask
     */
    if (updateRequired === 1) {
        Append0x10(bitArr as number[]);
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
