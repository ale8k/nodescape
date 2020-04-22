/**
 * A static helper class which writes all forms of ints,
 * including Jagex's special categories
 * @author ale8k
 */
export default class WriteInt {
    /**
     * Writes a Big-endian int at specified index
     */
    public BE(value: number, b: Buffer, index: number): void {
        b[index] = (value >> 24);
        b[(index + 1)] = (value >> 16);
        b[(index + 2)] = (value >> 8);
        b[(index + 3)] = value;
    }

    /**
     * Writes a Little-endian int at specified index
     */
    public LE(value: number, b: Buffer, index: number): void {
        b[index] = value;
        b[(index + 1)] = (value >> 8);
        b[(index + 2)] = (value >> 16);
        b[(index + 3)] = (value >> 24);
    }
}
