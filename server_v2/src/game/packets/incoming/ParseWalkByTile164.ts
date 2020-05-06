import IPacket from "../interfaces/IPacket";

/**
 * Parses packet 164, retrieves the basex+x, basey+y and additional pathing bytes
 * if a pathing route
 * @param {IPacket} packet the contents of a Packet
 * @returns {opcode: number, baseXwithX: number, baseYwithY: number, pathCoords: number[], randomByteOnTheEndLol: number}
 * an object representing the structure of what a parsed packet 164 should look like (needs typing?)
 * @author ale8k
 */
export default function ParseWalkByTile164({ opcode, payload }: IPacket): { opcode: number, baseXwithX: number, baseYwithY: number, pathCoords: number[], randomByteOnTheEndLol: number} {
    const pLoad = payload as number[];
    const payloadLength = pLoad[1];
    const baseXwithX = (pLoad[2] - 128 & 0xff) + ((pLoad[3] & 0xff) << 8);
    const baseYwithY = (pLoad[payloadLength - 1] & 0xff) + ((pLoad[payloadLength] & 0xff) << 8);
    const takeOrAddCoords = pLoad[payloadLength + 1]; // still no idea what this is...
    const bytes = pLoad.slice(4, payloadLength - 1);
    return {
        opcode,
        baseXwithX,
        baseYwithY,
        pathCoords: bytes,
        randomByteOnTheEndLol: takeOrAddCoords
    };

}
