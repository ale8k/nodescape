import BitWriter from "../../../utils/write-data/BitWriter";
import Player from "src/game/entities/game/Player";
import RSString from "src/utils/RSString";

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
    // // // // // // // // // //
    // MASK ONLY METHODS HERE  //
    // // // // // // // // // //
    /**
     * Append an update mask to the packet
     * @todo handle other masks
     * @todo create data type class for each mask / interface idc which
     */
    public appendUpdateMask(maskId: number, maskData: number[]): SyncPlayers81 {
        switch (maskId) {
            case 0x10:
                this.append0x10(maskData);
                break;
        }

        return this;
    }
    /**
     * Writes the mask 0x10 with given data, as we're already in bit format, we're going to continue
     * to write this via bits (even though it reads shorts etc fine), just seems convenient
     * @param maskData the data to append
     */
    private append0x10(maskData: number[]): void {
        this._bitWriter.writeNumber(0x10, 8);
        // we hardcode the size for now, maybe we'll pass this in? I don't know
        // it reads a negative byte for the size.
        this._bitWriter.writeNumber((255 - 55), 8);

        maskData.forEach((value, i) => {
            switch (i) {
                case 0:
                case 1:
                    this._bitWriter.writeNumber(value, 8);
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    const armourType = value > 200 ? value + 0x200 : value + 0x100;
                    this._bitWriter.writeNumber(armourType, 16);
                    break;
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                    this._bitWriter.writeNumber(value, 8);
                    break;
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                    this._bitWriter.writeNumber(value, 16);
                    break;
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                    this._bitWriter.writeNumber(value, 8);
                    break;
                case 35:
                    this._bitWriter.writeNumber(value, 16);
                    break;
            }
        });
    }

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

    // // // // // // // // // //
    // P81 METHODS ONLY HERE   //
    // // // // // // // // // //
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
        // HARDCODE TEST
        if (num !== 2047) {
            this.setPlayerAtIndex(0, 1, 0, 0);
        }
        return this;
    }

    /**
     * Writes the data for the playerList update without appearance data
     * ONLY TESTING RIGHT NOW.
     */
    public setPlayerAtIndex(updateRequired: number, teleport: number, y: number, x: number): SyncPlayers81 {
        this._bitWriter.writeBit(updateRequired);
        this._bitWriter.writeBit(teleport);
        this._bitWriter.writeNumber(y, 5);
        this._bitWriter.writeNumber(x, 5);
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
