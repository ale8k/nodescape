/**
 * A static helper class which reads all forms of bytes,
 * including Jagex's special categories
 * @author ale8k
 */
export default class ReadByte {
    /**
     * Reads a Big-endian byte at specified index
     */
    public static BE(b: Buffer, index: number): number {
        return b[index] & 0xff;
    }
    /**
     * Reads a Big-endian byte with the 'S' suffix at specified index
     * May not work as expected
     */
    public static BES(b: Buffer, index: number): number {
        return 128 - b[index] & 0xff;
    }
    /**
     * Reads an unsigned Big-endian at specified index
     */
    public static UBE(b: Buffer, index: number): number {
        return b[index] & 0xff;
    }
    /**
     * Reads an unsigned Big-endian byte with the 'A' suffix at specified index
     * May not work as expected
     */
    public static UBEA(b: Buffer, index: number): number {
        return b[index] - 128 & 0xff;
    }
    /**
     * Reads an unsigned Big-endian byte with the 'S' suffix at specified index
     * May not work as expected
     */
    public static UBES(b: Buffer, index: number): number {
        return 128 - b[index] & 0xff;
    }
}
