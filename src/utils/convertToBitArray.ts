/**
 * Takes a whole integer values and parses it into an array of bits
 * @param number the integer
 * @author ale8k
 */
export default function convertToBitArray(number: number): number[] {
    const numBitArr = (number)?.toString(2).split("").map(numString => {
        return parseInt(numString);
    });
    return numBitArr;
}
