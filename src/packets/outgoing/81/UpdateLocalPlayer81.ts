import { setBit, convertToFixedBitArray } from "../../../utils";
import Append0x10 from "./update-masks/Append0x10";
import { Socket } from "net";
import IMovement, { movementData1, movementData2, movementData3 } from "./interfaces/IMovement";


/**
 *
 * // 0 and 2047 are to skip multiplayer, for now anyways
 * // masks which needs 2 ubytes -> test them all out individually and see
 * // if client calls on specific mask
 *
 * example 81call
 * UpdateLocalPlayer81(socket, movementObject, number0, number2047 maskId?, maskObject?);
 *
 * {
 *  updateOurPlayer: 1
 *  movementType: 3,
 *  movementData: {
 *      Uses IMovement interface type embedded
 *   }
 * }
 *
 * Movement data examples:
 * 0: [],
 * 1: [direction, updateRequired]
 * 2: [direction1, direction2, updateRequired]
 * 3: [plane, teleport, updateRequired, x(7bit), y(7bit)]
 * @author ale8k
 */
export default function UpdateLocalPlayer81(
    socket: Socket,
    key: number,
    movement: IMovement,
    updateOthersMovements: number,
    updateOthersMask: number,
    maskId?: number,
    maskData?: object
    ): void {

    /**
     * Begin bit writing here:
     */
    const bitArr = [];

    /**
     * METHOD 117
     */
    // Update our player or not
    // if this is off, it'll skip the entire block lol
    bitArr.push(movement.updatePlayer);
    if (movement.updatePlayer !== 0) {
        let moveData;
        // Set our movement type and corresponding expected bits
        bitArr.push(...convertToFixedBitArray(movement.movementType, 2));
        switch (movement.movementType) {
            case 0:
                // Type 0: Do nothing
                // Just run an updatemask
                break;
            case 1:
                moveData = movement.movementData as movementData1;
                bitArr.push(...convertToFixedBitArray(moveData.direction, 3));
                bitArr.push(moveData.updateRequired);
                break;
            case 2:
                // TODO
                break;
            case 3:
                // Type 3: Set plane height
                moveData = movement.movementData as movementData3;
                bitArr.push(...convertToFixedBitArray(moveData.plane, 2));
                bitArr.push(moveData.teleport); // teleport
                bitArr.push(moveData.updateRequired);// whether or not to send mask
                bitArr.push(...convertToFixedBitArray(moveData.y as number, 7));
                bitArr.push(...convertToFixedBitArray(moveData.x as number, 7));
                break;
        }

    }
    /**
     * METHOD 134
     */
    bitArr.push(...convertToFixedBitArray(updateOthersMovements as number, 8));

    /**
     * METHOD 91
     */
    bitArr.push(...convertToFixedBitArray(updateOthersMask as number, 11));

    /**
     * Update masks
     * If update required is set, it'll append this mask
     * All movementData types have an updateRequied property,
     * so we're fine checking it on a nullable. It'll always be there dw.
     */
    if (movement.movementData?.updateRequired === 1) {
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
    socket.write(buf);
}
