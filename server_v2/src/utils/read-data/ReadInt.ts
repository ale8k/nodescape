/**
 * A static helper class which reads all forms of ints,
 * including Jagex's special categories
 * @author ale8k
 */
export default class ReadInt {
    /**
     * Reads a Big-endian int at specified index
     */
    public static BE(b: Buffer, index: number): number {
        return ((b[(index)] & 0xff) << 24) +
                ((b[(index + 1)] & 0xff) << 16) +
                ((b[(index + 2)] & 0xff) << 8) +
                (b[(index + 3)] & 0xff);
    }
}
