import BitWriter from "../../../../utils/write-data/BitWriter";
import Player from "src/game/entities/game/Player";
import RSString from "../../../../utils/RSString";

/**
 * This packet is responsible for our local players appearance and location, as well as
 * surrounding players
 *
 * The process works as follows:
 *      Set local movetype & add us to mobs awaiting update list / or choose not to
 *      Set other movetype -> need more info
 *      Write indexes of everyone player needs to be updated
 *          Check if 0x10 mask been sent for this other player in our local players client,
 *          if it has, they've got appearance sync buffer so use that initially :).
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
    /**
     * DEBUG MASK
     */
    public maskData = [0, 0, 1183, 1127, 0, 1059, 1079, 4131, 10, 0, 0, 0, 0, 1163, 7, 4, 9, 5, 0,
        0x328, 0x337, 0x333, 0x334, 0x335, 0x336, 0x338, ...RSString.writeStringToLongBytes37("DEBUG"), 10, 0];

    private _localPlayer: Player;
    private _bitWriter = new BitWriter();
    // the indexes of the player to update and their respective mask will work 1:1,
    // this is probably the easiest way to know who's mask is who's
    private _playersWhoNeedUpdatesIndex: number[] = [];
    private _playersWhoNeedUpdatesMasks: number[][] = [];
    private _playersToUpdateCount: number = 0; // just helps us track

    constructor(player: Player) {
        this._localPlayer = player;
    }

    /**
     * Determines the movement update type
     * and appends any data it needs to to our bitWriter
     * @param direction the direction the player moved in
     * @param direction2 the second direction for movement type 2 (a.k.a running)
     */
    public syncLocalPlayerMovement(direction?: number, direction2?: number): SyncPlayers81 {
        const br = this._bitWriter;
        const lp = this._localPlayer;

        if (!lp.movementUpdated && !lp.planeUpdated) {
            br.writeNumber(0, 2); // type 0
        }
        if (lp.movementUpdated && !lp.planeUpdated) {
            if (!lp.playerRunning) {
                br.writeNumber(1, 2); // type 1
                br.writeNumber(direction as number, 3);
            } else {
                br.writeNumber(2, 2); // type 2
                br.writeNumber(direction as number, 3);
                br.writeNumber(direction2 as number, 3);
            }
            lp.needMaskUpdate ? br.writeBit(1) : br.writeBit(0);
        }
        if(lp.planeUpdated) {
            br.writeNumber(3, 2); // type 3 - we have a teleport flag to determine that bit
            br.writeNumber(lp.plane, 2);
            lp.playedTeleported ? br.writeBit(1) : br.writeBit(0);
            lp.needMaskUpdate ? br.writeBit(1) : br.writeBit(0);
            br.writeNumber(lp.y, 7);
            br.writeNumber(lp.x, 7);
        }
        // finally, if we need a mask update, shove us on the darn list first!! (and our index pls)
        this._playersWhoNeedUpdatesIndex.push(this._playersToUpdateCount++); // we use 0 just to track the first instance
        this._playersWhoNeedUpdatesMasks.push(this.maskData); // just debug data
        return this;
    }
    /**
     * Handles 0 other players movements for now
     */
    public syncOtherPlayerMovement(playerList: Player[]): SyncPlayers81 {
        // Ideally it'll go through each Player in our playerlist and write their co-ordinates. For now,
        // we hardcode 0. As this would be the final step in the process for us.
        this._bitWriter.writeNumber(0, 8);
        return this;
    }
    /**
     * Should only be called if connections > 1 (aka playerList length > 1)
     */
    public updatePlayerList(playerIndex: Set<number>, playerList: Player[]): SyncPlayers81 {
        if (playerList.length === 1) {
            this._bitWriter.writeNumber(2047, 11);
            return this;
        } else {
            playerList.forEach((player, index) => {
                if (player.needMaskUpdate) { // check if they need a mask update
                    //playerIndex.has(index); // quick check to see they still here
                    this._playersWhoNeedUpdatesIndex.push(this._playersToUpdateCount++); // add their index to the update list
                    this._playersWhoNeedUpdatesMasks.push(this.maskData); // just debug data
                    this._bitWriter.writeBit(1); // send update true to client
                }
                this._bitWriter.writeNumber(0, 5); // y co-ord, hardcoded for now
                this._bitWriter.writeNumber(0, 5); // x co-ord, hardcoded for now
            });
        }
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
    public flushPacket81(): void {
        // const opcodeLength = 1;
        // const sizeLength = 1;
        // const payloadLength = Math.ceil(this._bitWriter.bufferLength / 8);
        // const startingIndex = 3;
        // const totalPacketLength = opcodeLength + sizeLength + payloadLength;
        // const b = Buffer.alloc(totalPacketLength + 1); // +1 cause the sizing is a short
        // b[0] = 81 + this._localPlayer.outStreamEncryptor.nextKey();
        // b.writeInt16BE(payloadLength, 1);
        // this._bitWriter.writeBitsToBuffer(b, startingIndex);
        // this._localPlayer.socket.write(b);
    }

}
