export default interface IPacket {
    opcode: number;
    payload: (number | undefined)[];
}
