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

    constructor(player: Player) {
        this._localPlayer = player;
    }
    /**
     * Sends an independent packet which updates the local players
     * current region
     * @param regionx region x
     * @param regiony region y
     */
    public updateRegion(regionx: number, regiony: number): void {
        const player = this._localPlayer;

        const b = Buffer.alloc(5);
        b[0] = 73 + player.outStreamEncryptor.nextKey();
        WriteShort.BES(((regionx / 8) + 6), b, 1);
        WriteShort.BE(((regiony / 8) + 6), b, 3);
        player.socket.write(b);
    }

}
