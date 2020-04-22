/**
 * A static helper class which writes all forms of longs,
 * including Jagex's special categories
 * @author ale8k
 */
export default class WriteInt {
    /**
     * Writes a Big-endian long at specified index
     */
    public BE(value: number, b: Buffer, index: number): void {
        b[index] = (value >> 56);
        b[(index)] = (value >> 48);
        b[(index)] = (value >> 40);
        b[(index)] = (value >> 32);
        b[(index)] = (value >> 24);
        b[(index)] = (value >> 16);
        b[(index)] = (value >> 8);
        b[(index)] = value;
    }
}

