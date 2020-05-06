import BitWriter from "../../../../utils/write-data/BitWriter";
import Player from "src/game/entities/game/Player";
import RSString from "../../../../utils/RSString";
import Masks from "./Masks";
import MovementHandler from "../../../../handlers/MovementHandler";
import PlayerHandler from "../../../../handlers/PlayerHandler";

/**
 * This packet is responsible for our local players appearance and location, as well as
 * surrounding players
 * @author ale8k
 */
export default class SyncPlayers81 {
    /**
     * DEBUG MASK
     */
    public maskData = [0, 0, 1183, 1127, 0, 1059, 1079, 4131, 10, 0, 0, 0, 0, 1163, 7, 4, 9, 5, 0, 0x328, 0x337, 0x333, 0x334, 0x335, 0x336, 0x338,
        ...RSString.writeStringToLongBytes37("DEBUG"), 10, 69];
    /**
     * The bit writer which writes up until the masks
     */
    private _bitWriter = new BitWriter();
    /**
     * The mask instance used to append masks to an existing bit writer
     */
    private _masks = new Masks();
    /**
     * A list of all the masks going to be used in the playerListUpdating array
     */
    private _playersWhoNeedUpdatesMasks: number[][] = [];
    /**
     * The local player sending this packet
     */
    private _localPlayer: Player;
    /**
     * The current logged in list of players
     */
    private _playerList: Player[];
    /**
     * The indexes of each currently logged in player
     */
    private _playerIndex: Set<number>;

    /**
     *
     * @param {Player} player local player
     * @param {Player[]} playerList total list of all player instances
     * @param {Set<number>} playerIndex total list of all connected player indexes
     */
    constructor(player: Player, playerList: Player[], playerIndex: Set<number>) {
        this._localPlayer = player;
        this._playerList = playerList;
        this._playerIndex = playerIndex;
        // The update procedure
        this.syncLocalPlayerMovement(player);
        this.syncOtherPlayerMovement();
        this.updatePlayerList();
        this.writePlayerSyncMasks();
    }

    /**
     * Determines the movement update type
     * and appends any data it needs to to our bitWriter
     * @param {Player} player local player
     * @returns {SyncPlayers81} a reference to the instance of this packet builder, for use in extension methods
     */
    public syncLocalPlayerMovement(player: Player): SyncPlayers81 {
        const br = this._bitWriter;
        const lp = this._localPlayer;
        const updateOurPlayer = lp.updateOurPlayer ? 1 : 0;
        const playerUpdate = lp.playerUpdated ? 1 : 0;
        br.writeBit(updateOurPlayer); // update our player always for now
        switch (lp.movementType) {
            case 0:
                br.writeNumber(0, 2);
                break;
            case 1:
                br.writeNumber(1, 2);
                br.writeNumber(player.direction as number, 3);
                br.writeBit(playerUpdate); // update mask
                break;
            case 2:
                br.writeNumber(2, 2);
                br.writeNumber(player.direction as number, 3);
                br.writeNumber(player.direction2 as number, 3);
                br.writeBit(playerUpdate); // update mask
                break;
            case 3:
                br.writeNumber(3, 2); // type 3 - we have a teleport flag to determine that bit
                br.writeNumber(lp.plane, 2);
                br.writeBit(1); // always teleported
                br.writeBit(playerUpdate); // update mask
                br.writeNumber(lp.y, 7);
                br.writeNumber(lp.x, 7);
                break;
        }
        if (playerUpdate === 1 || lp.movementType === 0 && updateOurPlayer === 1) {
            this._playersWhoNeedUpdatesMasks.push(this.maskData); // just debug data
        }
        return this;
    }
    /**
     * Handles 0 other players movements for now
     * @returns {SyncPlayers81} a reference to the instance of this packet builder, for use in extension methods
     */
    public syncOtherPlayerMovement(): SyncPlayers81 {
        // Ideally it'll go through each Player in our playerlist and write their co-ordinates. For now,
        // we hardcode 0. As this would be the final step in the process for us.
        this._bitWriter.writeNumber(0, 8);
        return this;
    }
    /**
     * Writes each player who requires an update to the bitWriter
     * @todo Needs cleaning up.
     * @param playerIndex the list of indexes
     * @param playerList the list of player instances
     * @returns {SyncPlayers81} a reference to the instance of this packet builder, for use in extension methods
     */
    public updatePlayerList(): SyncPlayers81 {
        /**
         * So, when updating we should only update those in
         * a) our region
         * b) in range of our local player
         * This complicates things a little... But shouldn't be too hard
         * At the moment we know who to write a mask far because they're all in consecutive order
         * in the player list, now we'll no longer know at all
         * So...
         * Maybe...
         * We loop through all players in the region
         * and check their co-ords relative to ours?
         * Then we know which masks?
         */
        // The playerList excluding our local player, to be passed to the PlayerHandler
        // so that it may get all the players in our region
        const filteredPlayerList = this._playerList.filter((player) => {
            return player.localPlayerIndex !== this._localPlayer.localPlayerIndex;
        });
        // We need tests now, this is becoming unmanageable...
        PlayerHandler.getPlayersInLocalPlayersRegion(this._localPlayer, filteredPlayerList);

        // If the index is 1, we know there's only us to update for
        if (this._playerIndex.size === 1) {
            this._bitWriter.writeNumber(2047, 11);
        } else {
            filteredPlayerList.forEach(otherPlayer => {
                const otherX = MovementHandler.getOtherPlayerRelativeXY(this._localPlayer, otherPlayer, "x");
                const otherY = MovementHandler.getOtherPlayerRelativeXY(this._localPlayer, otherPlayer, "y");
                this._bitWriter.writeNumber(otherPlayer.localPlayerIndex, 11); // players index
                this._bitWriter.writeBit(1); // mask update
                this._bitWriter.writeBit(0); // teleport
                this._bitWriter.writeNumber(otherY, 5);
                this._bitWriter.writeNumber(otherX, 5);
                // After this, we push the updated mask data for *this* player onto the mask array
                this._playersWhoNeedUpdatesMasks.push(this.maskData); // just debug data
            });
            // Crucial, after our players have been written, we not pass 2047 to END the loop
            this._bitWriter.writeNumber(2047, 11);

        }

        // Because this part requires padding, we're going to pad it off.
        // It requires padding due to the bitaccess being ended here, i.e., it'll begin
        // reading from the next 'full' byte after for the masks.
        while (this._bitWriter.bufferLength % 8 !== 0) {
            this._bitWriter.writeBit(0);
        }

        return this;
    }
    /**
     * Should only be called if mobsAwaitingUpdate > 0
     * @returns {SyncPlayers81} a reference to the instance of this packet builder, for use in extension methods
     */
    public writePlayerSyncMasks(): SyncPlayers81 {
        this._playersWhoNeedUpdatesMasks.forEach(mask => {
            this._masks.append0x10(mask, this._bitWriter);
        });
        return this;
    }
    /**
     * Writes the bitBuffer of our bitWriter into a buffer of bytes
     * and emits it through the socket.
     * @returns {Buffer} the buffer for this packet builder instance
     */
    public getPacket81(): Buffer {
        const payloadLength = this._bitWriter.bufferLength / 8;
        const b = Buffer.alloc(payloadLength + 3); // opcode and plength shrot
        b[0] = 81 + this._localPlayer.outStreamEncryptor.nextKey();
        b.writeInt16BE(payloadLength, 1);
        this._bitWriter.writeBitsToBuffer(b, 3);
        return b;
    }

}
