/**
 * Parses packet 164, retrieves the basex+x, basey+y and additional diaganol bytes
 * if we clicked in a none linear fashion
 * @param length
 * @param cacheBuffer
 * @author ale8k
 * TODO: add correct typings rather than object literals, wtf even is this Alex lol
 */
export default function Parse164Walk({ opcode, length, payload }: { opcode: number, length: number, payload: number[] }) : { opcode: number, baseXwithX: number, baseYwithY: number, pathCoords: number[], randomByteOnTheEndLol: number} {
    const payloadLength = payload[1];
    const baseXwithX = (payload[2] - 128 & 0xff) + ((payload[3] & 0xff) << 8);
    //console.log(payload[payloadLength]);
    const baseYwithY = (payload[payloadLength - 1] & 0xff) + ((payload[payloadLength] & 0xff) << 8);
    // I think this may indicate we're running? Not sure lol
    const takeOrAddCoords = payload[payloadLength + 1];
    const bytes = payload.slice(4, payloadLength - 1);
    return {
        opcode,
        baseXwithX,
        baseYwithY,
        pathCoords: bytes,
        randomByteOnTheEndLol: takeOrAddCoords
    };

}
