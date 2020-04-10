/**
 * Writes bits to a NodeJS Buffer
 * @param buffer the buffer
 * @param i buffer index
 * @param bit bit index
 * @param value bit value
 */
export default function setBit(buffer: Buffer | Uint8Array, i: number, bit: number, value: number): void {
    if (value === 0) {
        buffer[i] &= ~(1 << bit);
    } else {
        buffer[i] |= (1 << bit);
    }
}
