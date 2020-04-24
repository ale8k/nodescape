import BitWriter from "../../../../utils/write-data/BitWriter";
import Player from "src/game/entities/game/Player";

/**
 * This packet is responsible for our local players appearance and location, as well as
 * surrounding players
 *
 * The process works as follows:
 *      Set local movetype & add us to mobs awaiting update list / or choose not to
 *      Set other movetype -> need more info
 *      Write indexes of everyone player needs to be updated
 *          add them to mobs awaiting update list / or choose not to
 *          discord walk queue bit
 *          sends their x/y relative to our local players
 *      Write update masks in correct order (i.e., by index) for each player added
 *          i.e., if players at playerlist index 6, 12 and 18 needed updates,
 *          we'll append 3 masks in the order of 0 = 6, 1 = 12, 2 = 18
 *      If the local player wants to be updated though, he'll always be at index[0] because his method
 *      (set local movetype) always run first. So it'd be something like...
 *          0 = 0, 1 = 6, 2 = 12, 3 = 13
 *
 * This finishes the procedure.
 *
 * For the sake of simplicity, I've designed this packet by each method as named in
 * 'Majors' client.
 * I.e., a p81 would look like so:
 *  new SyncPlayer81()
 *      .syncLocalPlayerMovement(...args)
 *      .syncOtherPlayerMovement(...args)
 *      .updatePlayerList(...args)
 *      .writePlayerSyncMasks(...args)
 *      .flushPacket81();
 *
 * I think this is probably the most obvious solution to this.
 *
 * @author ale8k
 */
export default class SyncPlayers81 {
    private _bitWriter = new BitWriter();

    /**
     * Should only update if players location has changed
     */
    public syncLocalPlayerMovement(): SyncPlayers81 {
        return this;
    }
    /**
     * Should only call if others have been added to the updateList
     */
    public syncOtherPlayerMovement(): SyncPlayers81 {
        return this;
    }
    /**
     * Should only be called if connections > 1
     */
    public updatePlayerList(): SyncPlayers81 {
        return this;
    }
    /**
     * Should only be called if mobsAwaitingUpdate > 0
     */
    public writePlayerSyncMasks(): SyncPlayers81 {
        return this;
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

}
