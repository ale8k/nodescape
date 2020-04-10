import IsaacCipher from "../IsaacCipher";
import { Socket } from "net";
import { UpdateLocalPlayer81, LoadMapZone73 } from "../outgoing";

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
export default function ParseIncomingPackets(
    buffer: Buffer,
    inStreamDecryption: IsaacCipher,
    socket: Socket,
    outStreamEncryption: IsaacCipher) {

    //const encryptedOpcode = buffer[0] & 0xff;
    //const decryptedOpcode = encryptedOpcode - inStreamDecryption.nextKey() & 0xff;
    //console.log(decryptedOpcode);

    console.log("Opcode parsed: " + ((buffer[0] & 0xff) - inStreamDecryption.nextKey() & 0xff));

    // 73: Load the map zone
    socket.write(
        LoadMapZone73(
            outStreamEncryption.nextKey(),
            406, // higher = east, lower = west  // x
            406 // higher = north, lower = south // y coord
        )
    );

    // 83: Update our player (eventually will update others...)
    // socket.write(
    //     UpdateLocalPlayer81(
    //         outStreamEncryption.nextKey(),
    //         1, // update our player
    //         3, // move type
    //         0, // planelevel
    //         1, // clear await queuee
    //         1, // update required
    //         21, // ycoord
    //         21,  // xcoord
    //         0, // updateNPlayers movements
    //         2047, // player list updating bit
    //     )
    // );
}
