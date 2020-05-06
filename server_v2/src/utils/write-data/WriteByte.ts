/**
 * A helper class which writes all forms of bytes,
 * including Jagex's special categories
 * @author ale8k
 */
export default class WriteByte {
    /**
     * Writes a Big-endian byte at specified index
     * @param {number} value the value we wish to write
     * @param {Buffer} b the buffer we wish to write to
     * @param {number} index the byte index we wish to start at when writing the value
     */
    public BE(value: number, b: Buffer, index: number): void {
        b[index] = (value & 0xff);
    }
    /**
     * Writes a Big-endian byte with the 'S' suffix at specified index
     * @param {number} value the value we wish to write
     * @param {Buffer} b the buffer we wish to write to
     * @param {number} index the byte index we wish to start at when writing the value
     */
    public BES(value: number, b: Buffer, index: number): void {
        b[index] = (value - 128);
    }
}
