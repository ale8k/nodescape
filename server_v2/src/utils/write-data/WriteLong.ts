/**
 * A static helper class which writes all forms of longs,
 * including Jagex's special categories
 * @author ale8k
 */
export default class WriteLong {
    /**
     * Writes a Big-endian long at specified index
     */
    public BE(value: number, b: Buffer, index: number): void {
        b[index] = (value >> 56);
        b[(index + 1)] = (value >> 48);
        b[(index + 2)] = (value >> 40);
        b[(index + 3)] = (value >> 32);
        b[(index + 4)] = (value >> 24);
        b[(index + 5)] = (value >> 16);
        b[(index + 6)] = (value >> 8);
        b[(index + 7)] = value;
    }
}

