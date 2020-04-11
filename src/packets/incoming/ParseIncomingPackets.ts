import IsaacCipher from "../IsaacCipher";
import { Socket } from "net";
import { UpdateLocalPlayer81, LoadMapZone73 } from "../outgoing";

/**
 * I'm just hardcoding each packet and size here for us
 *
 */
export default function ParseIncomingPackets(
    buffer: Buffer,
    inStreamDecryption: IsaacCipher) {

    const encryptedOpcode = buffer[0] & 0xff;
    const decryptedOpcode = encryptedOpcode - inStreamDecryption.nextKey() & 0xff;
    console.log(decryptedOpcode);

}
