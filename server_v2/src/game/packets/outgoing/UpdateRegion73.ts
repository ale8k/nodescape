import Player from "src/game/entities/game/Player";
import WriteShort from "../../../utils/write-data/WriteShort";

/**
 * This packet updates our local players current region
 * @author ale8k
 */
export default class UpdateRegion73 {
    /**
     * The local player sending this packet
     */
    private _localPlayer: Player;
    /**
     * The buffer for this packet
     */
    private _b: Buffer;

    constructor(player: Player) {
        this._localPlayer = player;
    }
    /**
     * Sends an independent packet which updates the local players
     * current region
     * @param {number} regionx region x
     * @param {number} regiony region y
     * @returns {UpdateRegion73} returns this instance, to be used in extension
     */
    public updateRegion(regionx: number, regiony: number): UpdateRegion73 {
        const player = this._localPlayer;
        this._b = Buffer.alloc(5);
        this._b[0] = 73 + player.outStreamEncryptor.nextKey();
        WriteShort.BES(((regionx / 8) + 6), this._b, 1);
        WriteShort.BE(((regiony / 8) + 6), this._b, 3);
        return this;
    }
    /**
     * Gets the buffer from this packets
     * @returns {Buffer} the buffer used by this packet builder
     */
    public getPacket73(): Buffer {
        return this._b;
    }

}
