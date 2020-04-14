/**
 * Returns packet variable byte length
 * @param packet the packet in question
 * @author ale8k
 */
export default function GetVarBytePacketLength(packet: number[]) {
    // + 2 for opcode and sizing byte
    return packet[1] + 2;
}
