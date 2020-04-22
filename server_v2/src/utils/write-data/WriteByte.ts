/**
 * A static helper class which writes all forms of bytes,
 * including Jagex's special categories
 * @author ale8k
 */
export default class WriteByte {
    /**
     * Writes a Big-endian byte at specified index
     */
    public BE(value: number, b: Buffer, index: number): void {
        b[index] = (value & 0xff);
    }
    /**
     * Writes a Big-endian byte with the 'S' suffix at specified index
     */
    public BES(value: number, b: Buffer, index: number): void {
        b[index] = (value - 128);
    }
}
