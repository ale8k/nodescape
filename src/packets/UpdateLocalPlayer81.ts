
import { setBit, convertToBitArray, convertToFixedBitArray } from "../utils";
import convertTo8Bit from "src/utils/convertToFixedBitArray";

export default function UpdateLocalPlayer81(
        key: number, 
        updateOurPlayer: number,
        movementType: number, 
        planeHeight?: number,
        clearAwaitingPointQueue?: number,
        updateRequired?: number,
        xcoord?: number,
        ycoord?: number,
        updateNPlayers?: number,
        playerListUpdating?: number,
    ) {

    const buf = Buffer.alloc(100);
    // our encrypted opcode
    buf[0] = 81 + key;
    // packet size placeholder
    buf.writeInt16BE(0, 1);
    // offset of the packet start
    let offset = 3;
    

    /**
     * begin bit writing here:
     */
    let bitArr = [];
    // it works like so, we keep pushing bits to the bit array
    // once its complete, we call writeBits(buf, bitArr, 3) passing our buffer,
    // the bit array, and an index to start from. The method writes to it and returns it
    // back to us - it may also returns the index to continue from whereever it left off

    // update our player or not
    bitArr.push(updateOurPlayer);
    
    // set our movement type and corresponding expected bits
    bitArr.push(...convertToBitArray(movementType));

    switch (movementType) {
        case 0:
            break;
        case 1:
            break;
        case 2:
            break;
        case 3:
            // set the player's plane/height level 
            // TODO: this obviously needs to be dynamic, for now, 
            // we hardcode height 3
            bitArr.push(...convertToBitArray(3));
            break;
    }

    // whether or not to clear the awaiting point queue, i.e., tiles 
    // for the player to go to. We would clear it if they were say... teleporting
    bitArr.push(clearAwaitingPointQueue);

    // update required bit, need more info on this
    bitArr.push(updateRequired);

    // our x/y coordinate relative to the 'region (Graham refers to this as a map)'
    // a map is 64x64 tiles.
    // the client reads these in 7 bit values
    bitArr.push(...convertToFixedBitArray(10, 7));
    bitArr.push(...convertToFixedBitArray(10, 7));

    // update other player movements, it reads this in an 8 bit value
    // TODO: finish the bit writing for this
    bitArr.push(...convertToFixedBitArray(0, 8));

    // player list updating, it reads an 11 bit value
    // this value is the next player to be updated about.
    // the max value in 11 bits is 2047, therefore this is our starting
    // player
    bitArr.push(...convertToFixedBitArray(2047, 11));
    //console.log(bitArr);


    // //NodeJS doesn't have dynamic buffers...
    // const b = Buffer.alloc(9);
    // // set our encrypted opcode
    // b[0] = 81 + key;
    // // placeholder for packet size
    // b.writeInt16BE(6, 1);
    // // track our offset now, as we're beginning packet creation
    // let offfset = 3;
    // // update our player or not
    // setBit(b, 3, 7, 1);
    // // VALUE: 3 - Type 3, update our players plane level
    // setBit(b, 3, 6, 1);
    // setBit(b, 3, 5, 1);
    // // setting plane level here, 0-3 (we use 0 for now)
    // setBit(b, 3, 4, 0);
    // setBit(b, 3, 3, 0);
    // // clear awaitig-point queue, i.e., remove our further steps left to do by client. Like when teleing
    // setBit(b, 3, 2, 1);
    // // is there an update required? (i.e., logged in, update our player)
    // setBit(b, 3, 1, 1);
    // // x
    // setBit(b, 3, 0, 0);
    // setBit(b, 4, 7, 0);
    // setBit(b, 4, 6, 1);
    // setBit(b, 4, 5, 0);
    // setBit(b, 4, 4, 1);
    // setBit(b, 4, 3, 0);
    // setBit(b, 4, 2, 1);
    // // y
    // setBit(b, 4, 1, 0);
    // setBit(b, 4, 0, 0);
    // setBit(b, 5, 7, 1);
    // setBit(b, 5, 6, 0);
    // setBit(b, 5, 5, 1);
    // setBit(b, 5, 4, 0);
    // setBit(b, 5, 3, 1);
    // // How many other players the client needs to update,
    // // currently no multiplayer so none,
    // // this will need some considerable thought lol
    // setBit(b, 5, 2, 0);
    // setBit(b, 5, 1, 0);
    // setBit(b, 5, 0, 0);
    // setBit(b, 6, 7, 0);
    // setBit(b, 6, 6, 0);
    // setBit(b, 6, 5, 0);
    // setBit(b, 6, 4, 0);
    // setBit(b, 6, 3, 0);
    // // player list updating, not really sure here. Used wL's 2047 value
    // setBit(b, 6, 2, 1);
    // setBit(b, 6, 1, 1);
    // setBit(b, 6, 0, 1);
    // setBit(b, 7, 7, 1);
    // setBit(b, 7, 6, 1);
    // setBit(b, 7, 5, 1);
    // setBit(b, 7, 4, 1);
    // setBit(b, 7, 3, 1);
    // setBit(b, 7, 2, 1);
    // setBit(b, 7, 1, 1);
    // setBit(b, 7, 0, 1);
    // // initial player update done
    // // b[8] is empty byte, without it packet is being rejected?
    // return b;
}