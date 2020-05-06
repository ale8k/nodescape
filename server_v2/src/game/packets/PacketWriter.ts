import IPacket from "./interfaces/IPacket";
import Player from "../entities/game/Player";
import SyncPlayers81 from "./outgoing/81/SyncPlayers81";
import UpdateRegion73 from "./outgoing/UpdateRegion73";
import ParseWalkByTile164 from "./incoming/ParseWalkByTile164";
import MovementHandler from "../../handlers/MovementHandler";
import RegionHandler from "../../handlers/RegionHandler";

/**
 * A static helper class which handles responding to incoming game packets
 * by writing the correct responses
 * @author ale8k
 */
export default class PacketWriter {
    /**
     * Responds to each packet within the current local player packet buffer
     * @param {IPacket[]} packets the decrypted array of current cached packets
     * @param {Player} player the local player
     * @param {Player[]} playerList the total player list
     * @param {Set<number>} playerIndex the total player index list
     * @todo When looping through or shifting the packet array, filter out duplicates and only take the
     * latest one. Otherwise we're gonna stack up a shitload of pointless packets to send...
     */
    public static respondToPackets(packets: IPacket[], player: Player, playerList: Player[], playerIndex: Set<number>): void {
        const bufferArray: Buffer[] = []; // A place to push each buffer onto for our final response

        while (packets.length > 0) {
            const readPacket = packets.shift();
            const responsePacket = PacketWriter.routePacketToHandler(readPacket, player);
            // If the packet requires a packet in response other than 81, push it onto
            // the response buffer array
            if (responsePacket !== 0) {
                bufferArray.push(responsePacket as Buffer);
            } else {
                console.log("No response for packet: ", readPacket?.opcode);
            }

        }

        // If player is moving, process their movement for next P81
        // If player leaves current region, update their region
        if (player.playerMoving) {
            MovementHandler.processPlayerMovement(player);
            const [regionXChanged, regionYChanged] = RegionHandler.watchForRegionChange(player);

            if (regionXChanged || regionYChanged) {
                RegionHandler.updatePlayersRegion(player, regionXChanged, regionYChanged);
                //
            }
        }

        // Push 81 on always, it'll always be needed, notice the direction 1/2
        // these can be undefined if move type is 0/3
        bufferArray.push(new SyncPlayers81(player, playerList, playerIndex).getPacket81());
        // Write our buffered array of packets in one big chunk
        player.socket.write(Buffer.concat(bufferArray));
        // Clear the incoming packet buffer for our local player
        player.packetBuffer = [];
    }
    /**
     * Updates the local player with all the initial packets required upon login
     * @param {Player} player the local player
     * @param {Player[]} playerList the total player list
     * @param {Set<number>} playerIndex the total player index list
     */
    public static sendInitialPackets(player: Player, playerList: Player[], playerIndex: Set<number>): void {
        const totalPackets = [];
        totalPackets.push(new UpdateRegion73(player).updateRegion(player.regionx, player.regiony).getPacket73());
        totalPackets.push(new SyncPlayers81(player, playerList, playerIndex).getPacket81());
        player.socket.write(Buffer.concat(totalPackets));
        // Finally reset our movement to type 0, because we can't move on login
        player.movementType = 0;
        player.playerUpdated = false;
    }
    /**
     * Takes an individual packet and directs it to the correct handler,
     * this ultimately returns the buffer/data we need to update our outgoing packets
     * @param {IPacket | undefined} packet the packet being read, note this may be undefined in the case there are no more
     * packets to route
     * @param {Player} player local player
     * @returns {Buffer | number} returns either a response buffer or 0, note 0 represents packet 81 will respond
     * to this packet
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
        // Parse the packet
        const walkPacket = ParseWalkByTile164(packet);
        // Set the final/first x/y co-ord
        player.destinationX = walkPacket.baseXwithX - player.regionx;
        player.destinationY = walkPacket.baseYwithY - player.regiony;

        // If client sent pathing bytes, parse them baby and add them to our local players path
        if (walkPacket.pathCoords.length > 0) {
            player.pathCoords = walkPacket.pathCoords.map((coord, i) => {
                return i % 2 === 0 ? coord + player.destinationX & 0xff : coord + player.destinationY & 0xff;
            });
        }

        // Set our player to moving
        player.playerMoving = true;
        // console.log("player path coords", player.pathCoords);
        return 0;
    }
}
