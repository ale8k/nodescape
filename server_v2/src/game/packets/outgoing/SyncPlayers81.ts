import BitWriter from "../../../utils/write-data/BitWriter";
import { Subject, AsyncSubject } from "rxjs";
import { Socket } from "net";
import Player from "src/game/entities/game/Player";

/**
 * This packet is responsible for our local players appearance and location, as well as
 * surrounding players
 *
 * The packet works in 4 steps:
 *  - Synchronising our local players movement
 *  - Synchronising other players movment
 *  - Updating other players apparel
 *  - Updating our local players apparel
 *
 * This class utilises steps of the process and parses them into simple
 * methods for us to chain together before flushing the packet to the client.
 *
 * @author ale8k
 */
export default class SyncPlayers81 {
    private _bitWriter = new BitWriter();

     /**
      * Writes the bitBuffer of our bitWriter into a buffer of bytes
      * and emits it through the socket.
      */
     public flushPacket81(player: Player): void {
        const opcodeLength = 1;
        const sizeLength = 1;
        const payloadLength = Math.ceil(this._bitWriter.bufferLength / 8);
        const startingIndex = 3;
        const totalPacketLength = opcodeLength + sizeLength + payloadLength;
        const b = Buffer.alloc(totalPacketLength + 1); // +1 cause the sizing is a short
        b[0] = 81 + player.outStreamEncryptor.nextKey();
        b.writeInt16BE(payloadLength, 1);
        this._bitWriter.writeBitsToBuffer(b, startingIndex);
        player.socket.write(b);
     }

    /**
     * Emits a single bit repsenting whether to update our local player
     * or not
     */
    public updateLocalPlayer(num: number): SyncPlayers81 {
        this._bitWriter.writeBit(num);
        return this;
    }

    /**
     * Emits a single bit representing 'update required' in the client
     * @param num a single bit 0 / 1
     */
    public updateRequired(num: number): SyncPlayers81 {
        this._bitWriter.writeBit(num);
        return this;
    }

    /**
     * Sets the movement type for a player
     */
    public setMovementType(num: number): SyncPlayers81 {
        this._bitWriter.writeNumber(num, 2);
        return this;
    }

    /**
     * Sets a movement direction (3 bit)
     */
    public setDirection(num: number): SyncPlayers81 {
        this._bitWriter.writeNumber(num, 3);
        return this;
    }

    /**
     * Sets whether or not player is teleprtoing
     */
    public setTeleport(num: number): SyncPlayers81 {
        this._bitWriter.writeBit(num);
        return this;
    }

    /**
     * Sets the players plane / height
     */
    public setPlane(num: number): SyncPlayers81 {
        this._bitWriter.writeNumber(num, 2);
        return this;
    }

    /**
     * Sets the local players x/y
     */
    public setLocalPlayerXY(num: number): SyncPlayers81 {
        this._bitWriter.writeNumber(num, 7);
        return this;
    }

    /**
     * Sets the amount of other players who need movement updates
     */
    public setAmountOfOthersForUpdates(num: number): SyncPlayers81 {
        this._bitWriter.writeNumber(num, 8);
        return this;
    }

    /**
     * Sets the update list next player index
     */
    public setNextUpdateListIndex(num: number): SyncPlayers81 {
        this._bitWriter.writeNumber(num, 11);
        return this;
    }


    /**
     * TODO:
     * Checks the number range of a given value, if the number
     * is out of the range, it'll throw an error. This ensures
     * our values for each packet bit append will be correct.
     */
    private checkNumberRange(): void {

    }

}
