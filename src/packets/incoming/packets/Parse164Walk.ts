/**
 * Mushrooms location packet:
 *   3, 11, 8, 9,   1,  1,
 * 1,  3, 0, 3, 138, 13,
 * 0
 * @param length
 * @param cacheBuffer
 * @param currentX
 * @param currentY
 */
export default function Parse164Walk(length: number, cacheBuffer: number[], currentX: number, currentY: number) {
    console.log("Packet 164 come through!");
    console.log("His length is", length, "and total packet: ", cacheBuffer);
    // 8, 9:
    // 8 - 128 & 0xff = 136
    // (9 & 0xff) << 8 = 2304
    // 2440 (correct)

    // Because it's LE, we perform << on second byte!
    // 138, 13:
    // 138 & 0xff = 138
    // (13 & 0xff) << 8 = 3228
    // 3466 (correct)
    const payloadLength = cacheBuffer[1];
    const baseXwithX = (cacheBuffer[2] - 128 & 0xff) + ((cacheBuffer[3] & 0xff) << 8);
    console.log(cacheBuffer[payloadLength]);
    const baseYwithY = (cacheBuffer[payloadLength - 1] & 0xff) + ((cacheBuffer[payloadLength] & 0xff) << 8);
    console.log("basex ", baseXwithX, "basey ", baseYwithY);
    const takeOrAddCoords = cacheBuffer[payloadLength + 1];
    console.log("takeOrAdd: ", takeOrAddCoords); // really not sure?
    const movementResponseArr = [];

    //  42, 11,
    //  8, 9,
    //  1,  1, 1,  3, 0, 3, (pretend theres 1 more lol)
    //  138, 13,
    //  0
    // So I think we check if 0 is neg or poaitive and use that to - or + our current loc with this,
    // I'm also gonna array these up and use it for building the packet 81 block (maskless) for movement
    // I bet this is how it works!
    const bytes = cacheBuffer.slice(4, payloadLength - 1);
    for (let i = 0; i < Math.ceil(bytes.length); i++) {
        movementResponseArr.push([
            bytes[i] + currentX & 0xff,
            bytes[i + 1] + currentY& 0xff
        ]);
        i += 1;
    }
    console.log(movementResponseArr);
    return movementResponseArr;

}
