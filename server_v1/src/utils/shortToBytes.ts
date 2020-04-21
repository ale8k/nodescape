/**
 * Takes an unsigned 16-bit integer (short) and converts
 * it to an array of unsigned 8-bit integers (bytes)
 * @param short a ushort (0 - 65,535)
 * @author ale8k
 */
export default function shortToBytes(short: number): number[] {
    // 16bit - 8 bit (>>> 8) = highend endian,
    // short & 255 = 32bit overflow
    // highend + lowend overflow = short byte array
    return [short >>> 8, short & 0xff];
}
