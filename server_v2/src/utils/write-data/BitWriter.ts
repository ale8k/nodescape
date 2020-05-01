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
     */
    public get bufferLength(): number {
        return this._bitArr.length;
    }


    /**
     * Converts the interal bit array into a byte array and writes the bytes to a given buffer
     * @param byteIndex the index to start writing the bits from
     * @param b the buffer to perform the method on
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
     * @param num the bit value
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
     * @param num the number to convert into a bit arr
     * @param amount the amount of bits to emit
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
     * @param num the number we wish to write into bits
     * @param amount the length of how far to replace
     * @param index the index to begin replacing the bits currently written from
     */
    public writeNumberOver(num: number, amount: number, index: number): BitWriter {
        const bitArr = this.convertToBitArray(num);
        const bitArrLength = bitArr.length; // remembers the initial length

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
     * @param number the integer
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
     * @param buffer the buffer
     * @param i buffer index
     * @param bit bit index
     * @param value bit value
     */
    private writeBitInteral(b: Buffer | Uint8Array, index: number, bit: number, value: number): void {
        if (value === 0) {
            b[index] &= ~(1 << bit);
        } else {
            b[index] |= (1 << bit);
        }
    }

}
