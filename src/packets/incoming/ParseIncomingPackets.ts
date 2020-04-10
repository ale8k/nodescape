import Cryption from "src/IsaacCipher";

/**
 * Reads 'any' packet and attempts to parse it.
 * After parsing the opcode, it'll proceed to the corresponding
 * method associated with parsing that particular packet.
 *
 * Current packet id/opcode's supported:
 *  248: Map walk (Variable byte)
 *  241: Mouse blick (Fixed 4)
 *  210: Region change (Fixed 0) // don't really get how this works
 *  164: Regular walk (Variable byte)
 *  98: Walk on command (Variable byte) // this may be complex to do...
 *  86: Camera movement (Fixed 4)
 *  0: Idle (Fixed 0) // need to figure a way to allow this to determine our game loop!!
 *
 * @param buffer the incoming buffer
 */
export default function ParseIncomingPackets(buffer: Buffer, inStreamDecryption: Cryption, outStreamEncryption: Cryption) {
    // Overflow to get correct encrypt val, i.e., undo what the client is doing
    //const opcode = buffer[0] & 0xff;
    //console.log(buffer[0] - inStreamDecryption.nextKey());


    /**
     * 164: Regular walk
     */

}
