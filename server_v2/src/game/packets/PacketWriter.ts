import IPacket from "./interfaces/IPacket";
import Player from "../entities/game/Player";
import SyncPlayers81 from "./outgoing/81/SyncPlayers81";
import UpdateRegion73 from "./outgoing/UpdateRegion73";

/**
 * A static helper class which handles responding to incoming game packets
 * by writing the correct responses
 * @author ale8k
 */
export default class PacketWriter {
    /**
     * Responds to each packet within the current local player packet buffer
     * @param packets the decrypted array of current cached packets
     * @param player the local player
     * @param playerList the total player list
     * @param playerIndex the total player index list
     */
    public static respondToPackets(packets: IPacket[], player: Player, playerList: Player[], playerIndex: Set<number>): void {
        console.log(packets);
        new SyncPlayers81(player, playerList, playerIndex);
        // Wipe our buffer for next cycle
        player.packetBuffer = [];
    }
    /**
     * Updates the local player with all the initial packets required upon login
     * @param player the local player
     */
    public static sendInitialPackets(player: Player, playerList: Player[], playerIndex: Set<number>): void {
        new UpdateRegion73(player).updateRegion(3200, 3200);
        new SyncPlayers81(player, playerList, playerIndex);
        // Finally reset our movement to type 0, because we can't move on login
        player.movementType = 0;
        player.playerUpdated = false;
    }
}
