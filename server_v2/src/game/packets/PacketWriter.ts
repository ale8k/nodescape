import IPacket from "./interfaces/IPacket";
import Player from "../entities/game/Player";
import SyncPlayers81 from "./outgoing/81/SyncPlayers81";
import UpdateRegion73 from "./outgoing/UpdateRegion73";
import ParseWalkByTile164 from "./incoming/ParseWalkByTile164";

/**
 * A static helper class which handles responding to incoming game packets
 * by writing the correct responses
 * @todo place handlers in their own classes
 * @author ale8k
 */
export default class PacketWriter {
    /**
     * Responds to each packet within the current local player packet buffer
     * @param packets the decrypted array of current cached packets
     * @param player the local player
     * @param playerList the total player list
     * @param playerIndex the total player index list
     * @todo When looping through or shifting the packet array, filter out duplicates and only take the
     * latest one. Otherwise we're gonna stack up a shitload of pointless packets to send...
     */
    public static respondToPackets(packets: IPacket[], player: Player, playerList: Player[], playerIndex: Set<number>): void {
        const bufferArray: Buffer[] = []; // A place to push each buffer onto for our final response

        while (packets.length > 0) {
            const readPacket = packets.shift();
            const responsePacket = PacketWriter.routePacketToHandler(readPacket, player);

            if (responsePacket !== 0) {
                bufferArray.push(responsePacket as Buffer);
            } else {
                console.log("No response for packet: ", readPacket?.opcode);
            }
        }

        /**
         * Movement
         * Movement works like so:
         *      player is at x/y
         *      player destination x/y updates
         *      while player x/y !== x/y, walk in z direction
         *      check if pathcoord exist
         *      update destination x/y
         *      rinse repeat until empty
         *      set player to not moving
         */

        // Flush packets and wipe buffer for next cycle
        bufferArray.push(new SyncPlayers81(player, playerList, playerIndex).getPacket81());
        player.socket.write(Buffer.concat(bufferArray));
        player.packetBuffer = [];
    }
    /**
     * Updates the local player with all the initial packets required upon login
     * @param player the local player
     */
    public static sendInitialPackets(player: Player, playerList: Player[], playerIndex: Set<number>): void {
        const totalPackets = [];
        totalPackets.push(new UpdateRegion73(player).updateRegion(3200, 3200).getPacket73());
        totalPackets.push(new SyncPlayers81(player, playerList, playerIndex).getPacket81());
        player.socket.write(Buffer.concat(totalPackets));
        // Finally reset our movement to type 0, because we can't move on login
        player.movementType = 0;
        player.playerUpdated = false;
    }
    /**
     * Takes an individual packet and directs it to the correct handler,
     * this ultimately returns the buffer/data we need to update our outgoing packets
     * @param packet the packet being read
     * @param player local player
     */
    private static routePacketToHandler(packet: IPacket | undefined, player: Player): Buffer | number {
        switch (packet?.opcode) {
            case 164:
                return PacketWriter.HandleWalkByTile164(packet, player);
            default:
                return 0;
        }
    }
    /**
     * Temp place for 164 handle
     */
    private static HandleWalkByTile164(packet: IPacket, player: Player): Buffer | number {
        console.log("Handling 164 brav");
        // Parse the packet
        const walkPacket = ParseWalkByTile164(packet);
        // Set the final/first x/y co-ord
        player.destinationX = walkPacket.baseXwithX - player.regionx;
        player.destinationY = walkPacket.baseYwithY - player.regiony;
        console.log("player x", player.x, "player y", player.y, "player dx", player.destinationX, "player dy", player.destinationY);

        // If client sent pathing bytes, parse them baby and add them to our local players path
        if (walkPacket.pathCoords.length > 0) {
            player.pathCoords = walkPacket.pathCoords.map((coord, i) => {
                return i % 2 === 0 ? coord + player.destinationX & 0xff : coord + player.destinationY & 0xff;
            });
        }

        // Set our player to moving
        player.playerMoving = true;
        // Hardcode type 1 for now, until we support running
        player.movementType = 1;
        console.log("player path coords", player.pathCoords);
        return 0;
    }
}
