/**
 * A helper class to aid us in writing bits to a NodeJS
 * @author ale8k
 */
export default class WriteByte {
    /**
     * Writes bits to a NodeJS Buffer
     * @param buffer the buffer
     * @param i buffer index
     * @param bit bit index
     * @param value bit value
     */
    public static writeBit(buffer: Buffer | Uint8Array, i: number, bit: number, value: number): void {
        if (value === 0) {
            buffer[i] &= ~(1 << bit);
        } else {
            buffer[i] |= (1 << bit);
        }
    }
}
