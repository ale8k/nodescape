import IsaacCipher from "src/IsaacCipher";
import * as Long from "long";

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
export default function ParseIncomingPackets(buffer: Buffer, inStreamDecryption: IsaacCipher) {
    // only works for first 2 packets...???
    const encryptedOpcode = buffer[0] & 0xff;
    const decryptedOpcode = encryptedOpcode - inStreamDecryption.nextKey() & 0xff;

    console.log(decryptedOpcode);
    console.log(buffer.toJSON());
}
