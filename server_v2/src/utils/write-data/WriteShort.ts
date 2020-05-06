/**
 * A helper class which writes all forms of shorts,
 * including Jagex's special categories
 * @author ale8k
 */
export default class WriteShort {
    /**
     * Writes a Big-endian short at specified index
     * @param {number} value the value we wish to write
     * @param {Buffer} b the buffer we wish to write to
     * @param {number} index the byte index we wish to start at when writing the value
     */
    public static BE(value: number, b: Buffer, index: number): void {
        b[index] = (value >> 8);
        b[(index + 1)] = value;
    }
    /**
     * Writes a Big-endian short with the 'S' suffix at specified index
     * @param {number} value the value we wish to write
     * @param {Buffer} b the buffer we wish to write to
     * @param {number} index the byte index we wish to start at when writing the value
     */
    public static BES(value: number, b: Buffer, index: number): void {
        b[index] = (value >> 8);
        b[(index + 1)] = (value + 128);
    }
    /**
     * Writes a Little-endian short at specified index
     * @param {number} value the value we wish to write
     * @param {Buffer} b the buffer we wish to write to
     * @param {number} index the byte index we wish to start at when writing the value
     */
    public static LE(value: number, b: Buffer, index: number): void {
        b[index] = value;
        b[(index + 1)] = (value >> 8);
    }
    /**
     * Writes a Little-endian short with the 'S' suffix at specified index
     * @param {number} value the value we wish to write
     * @param {Buffer} b the buffer we wish to write to
     * @param {number} index the byte index we wish to start at when writing the value
     */
    public static LES(value: number, b: Buffer, index: number): void {
        b[index] = (value + 128);
        b[(index + 1)] = (value >> 8);
    }
}
