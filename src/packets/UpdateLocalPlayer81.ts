
import { setBit } from "../utils";

export default function UpdateLocalPlayer81(
        key: number, 
        updateOurPlayer?: number,
        movementType?: number, 
        planeHeight?: number,
        clearAwaitingPointQueue?: number,
        updateRequired?: number,
        xcoord?: number,
        ycoord?: number,
        updateNPlayers?: number,
        playerListUpdating?: number,
    ) {
    // NodeJS doesn't have dynamic buffers...
    const b = Buffer.alloc(9);
    // set our encrypted opcode
    b[0] = 81 + key;
    // placeholder for packet size
    b.writeInt16BE(6, 1);
    // track our offset now, as we're beginning packet creation
    let offset = 3;
    // update our player or not
    setBit(b, 3, 7, 1);
    // VALUE: 3 - Type 3, update our players plane level
    setBit(b, 3, 6, 1);
    setBit(b, 3, 5, 1);
    // setting plane level here, 0-3 (we use 0 for now)
    setBit(b, 3, 4, 0);
    setBit(b, 3, 3, 0);
    // clear awaitig-point queue, i.e., remove our further steps left to do by client. Like when teleing
    setBit(b, 3, 2, 1);
    // is there an update required? (i.e., logged in, update our player)
    setBit(b, 3, 1, 1);
    // x
    setBit(b, 3, 0, 0);
    setBit(b, 4, 7, 0);
    setBit(b, 4, 6, 1);
    setBit(b, 4, 5, 0);
    setBit(b, 4, 4, 1);
    setBit(b, 4, 3, 0);
    setBit(b, 4, 2, 1);
    // y
    setBit(b, 4, 1, 0);
    setBit(b, 4, 0, 0);
    setBit(b, 5, 7, 1);
    setBit(b, 5, 6, 0);
    setBit(b, 5, 5, 1);
    setBit(b, 5, 4, 0);
    setBit(b, 5, 3, 1);
    // How many other players the client needs to update,
    // currently no multiplayer so none,
    // this will need some considerable thought lol
    setBit(b, 5, 2, 0);
    setBit(b, 5, 1, 0);
    setBit(b, 5, 0, 0);
    setBit(b, 6, 7, 0);
    setBit(b, 6, 6, 0);
    setBit(b, 6, 5, 0);
    setBit(b, 6, 4, 0);
    setBit(b, 6, 3, 0);
    // player list updating, not really sure here. Used wL's 2047 value
    setBit(b, 6, 2, 1);
    setBit(b, 6, 1, 1);
    setBit(b, 6, 0, 1);
    setBit(b, 7, 7, 1);
    setBit(b, 7, 6, 1);
    setBit(b, 7, 5, 1);
    setBit(b, 7, 4, 1);
    setBit(b, 7, 3, 1);
    setBit(b, 7, 2, 1);
    setBit(b, 7, 1, 1);
    setBit(b, 7, 0, 1);
    // initial player update done
    // b[8] is empty byte, without it packet is being rejected?
    return b;
}