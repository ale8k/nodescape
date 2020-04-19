import { Socket } from "net";
import IsaacCipher from "src/packets/IsaacCipher";

/**
 * A general interface representing a players client
 * and the state of that player currently
 * - I'm guessing at this point honestly lol
 * @author ale8k
 */
export default interface IClient {
    name: string;
    password: string; // do we really need this?
    player_id: number;
    currentX: number;
    currentY: number;
    currentRegionX: number;
    currentRegionY: number;
    playerSocket: Socket; // can we reference socketed connections like this?
    inStreamDecryption?: IsaacCipher;
    outStreamEncryption: IsaacCipher;
}
