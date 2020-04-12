import IsaacCipher from "../IsaacCipher";

/**
 * Parses an encrypted opcode into a decrypted one
 * @author ale8k
 */
export default function ParsePacketOpcode(opcode: number, inStreamDecryption: IsaacCipher) {
    const encryptedOpcode = opcode & 0xff;
    const decryptedOpcode = encryptedOpcode - inStreamDecryption.nextKey() & 0xff;
    return decryptedOpcode;
}
