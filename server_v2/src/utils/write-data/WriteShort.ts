/**
 * A helper class which writes all forms of shorts,
 * including Jagex's special categories
 * @author ale8k
 */
export default class WriteShort {
    /**
     * Writes a Big-endian short at specified index
     */
    public static BE(value: number, b: Buffer, index: number): void {
        b[index] = (value >> 8);
        b[(index + 1)] = value;
    }
    /**
     * Writes a Big-endian short with the 'S' suffix at specified index
     */
    public static BES(value: number, b: Buffer, index: number): void {
        b[index] = (value >> 8);
        b[(index + 1)] = (value + 128);
    }
    /**
     * Writes a Little-endian short at specified index
     */
    public static LE(value: number, b: Buffer, index: number): void {
        b[index] = value;
        b[(index + 1)] = (value >> 8);
    }
    /**
     * Writes a Little-endian short with the 'S' suffix at specified index
     */
    public static LES(value: number, b: Buffer, index: number): void {
        b[index] = (value + 128);
        b[(index + 1)] = (value >> 8);
    }
}
