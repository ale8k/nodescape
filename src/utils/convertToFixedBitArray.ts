import { convertToBitArray } from ".";

/**
 * Converts a number in an array of bits with a specified fixed
 * size of bits. I.e., 3 = [1, 1] and if our fixed size was 5,
 * it would output [0, 0, 0, 1, 1]
 * @param num the number to convert into a bit arr
 * @param amount the amount of bits to emit
 * @author ale8k.
 */
export default function convertToFixedBitArray(num: number, amount: number) {
    const bitArr = convertToBitArray(num);
    const bitArrLength = bitArr.length; // remembers the initial length

    if (bitArr.length < amount) {
        for (let i = 0; i < amount - bitArrLength; i++) {
            bitArr.unshift(0);
        }
    }

    return bitArr;
}
