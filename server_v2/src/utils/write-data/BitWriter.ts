/**
 * A helper class to aid us in writing bits to a NodeJS
 * @author ale8k
 */
export default class BitWriter {
    /**
     * The bitArray for the class to write to
     */
    private _bitArr: number[];

    constructor() {
        this._bitArr = [];
    }

    /**
     * Returns the bit array length, this will be used
     * in sizing correction
     * @returns {number} the length of the internal BitWriter buffer
     */
    public get bufferLength(): number {
        return this._bitArr.length;
    }

    /**
     * Converts the interal bit array into a byte array and writes the bytes to a given buffer
     * @param {number} byteIndex the index to start writing the bits from
     * @param {Buffer} b the buffer to perform the method on
     */
    public writeBitsToBuffer(b: Buffer, byteIndex: number): void {
        let bitIndex = 7;

        for (let i = 0; i < this._bitArr.length; i++) {
            this.writeBitInteral(b, byteIndex, bitIndex, this._bitArr[i] as number);
            bitIndex -= 1;

            if (bitIndex <= -1) {
                bitIndex = 7;
                byteIndex += 1;
            }
        }
    }
    /**
     * Writes a bit to the interal BitWriter buffer
     * @param {number} num the bit value
     * @returns {BitWriter} returns this BitWriter instance
     */
    public writeBit(num: number): BitWriter {
        if (num === 0 || num === 1) {
            this._bitArr.push(num);
            return this;
        } else {
            throw new Error("A bit value can only be 0 / 1");
        }
    }
    /**
     * Converts a number into an array of bits with a specified fixed size,
     * and then writes it to the internal BitWriter buffer.
     * Please note, if you pass a number that has a minimum bits of
     * say 4, and try to fix it to size 1. This will not work.
     * Pushes the bits onto the interal bit array.
     * @param {number} num the number to convert into a bit arr
     * @param {number} amount the amount of bits to emit
     * @returns {BitWriter} returns this BitWriter instance
     */
    public writeNumber(num: number, amount: number): BitWriter {
        const bitArr = this.convertToBitArray(num);
        const bitArrLength = bitArr.length; // remembers the initial length

        if (bitArr.length < amount) {
            for (let i = 0; i < amount - bitArrLength; i++) {
                bitArr.unshift(0);
            }
        }
        this._bitArr.push(...bitArr);
        return this;
    }
    /**
     * Converts a number into bits and overwrites bits in the cached buffer
     * with a brand new value. This is used in sizing a variable frame.
     * @param {number} num the number we wish to write into bits
     * @param {number} amount the length of how far to replace
     * @param {number} index the index to begin replacing the bits currently written from
     * @returns {BitWriter} returns this BitWriter instance
     */
    public writeNumberOver(num: number, amount: number, index: number): BitWriter {
        const bitArr = this.convertToBitArray(num);
        const bitArrLength = bitArr.length; // remembers the initial lengthh

        if (bitArr.length < amount) {
            for (let i = 0; i < amount - bitArrLength; i++) {
                bitArr.unshift(0);
            }
        }

        let bitArrIndex = index;

        for (let i = 0; i < bitArr.length; i++) {
            this._bitArr[bitArrIndex++] = bitArr[i];
        }

        return this;
    }
    /**
     * Takes a whole integer values and parses it into an array of bits
     * @param {number} number the integer
     * @returns {number[]} the number converted into an array of bits
     */
    private convertToBitArray(number: number): number[] {
        const numBitArr = (number)?.toString(2).split("").map(numString => {
            return parseInt(numString);
        });
        return numBitArr;
    }
    /**
     * Write a bit to a NodeJS Buffer
     * The naming is to stop collision with writeBit to our internal bit buffer
     * @param {Buffer | uint8Array} buffer the buffer
     * @param {number} i buffer index
     * @param {number} bit bit index
     * @param {number} value bit value
     */
    private writeBitInteral(b: Buffer | Uint8Array, index: number, bit: number, value: number): void {
        if (value === 0) {
            b[index] &= ~(1 << bit);
        } else {
            b[index] |= (1 << bit);
        }
    }

}
