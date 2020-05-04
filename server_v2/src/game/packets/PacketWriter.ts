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

        // Pushes needed response packets on here
        // Please note: movement is different and isn't pushed on, as it's a part of our
        // 81 updates, which are basically everything related to a player.
        // I do think we may be able to push masks on here though, currently the packet 81
        // implementation handles it, I think this is wrong. We could do something like...
        // bufferArray.push(base81)
        // bufferArray.push(mask 0x10)
        // bufferArray.push(regionupdate 73)
        // write bufferArray
        // This ^ seems like the most sensible solution, as our masks will be synchronized into a set
        // order based on the array push. May need to adjust p81!
        // The only issue we may have is we'll need to go into bufferArray[index of p81] and adjust
        // the size of the total buffer to accomodate the masks, but that's not that bad I guess
        while (packets.length > 0) {
            const readPacket = packets.shift();
            const responsePacket = PacketWriter.routePacketToHandler(readPacket, player);

            if (responsePacket !== 0) {
                bufferArray.push(responsePacket as Buffer);
            } else {
                console.log("No response for packet: ", readPacket?.opcode);
            }

        }

        // Empty points of memory to pass to 81, unless we're walking/running
        // Perhaps place these on the player entity?
        let direction;
        let direction2;

        // Update direction 1/2 if the players moving
        // Also, do we really need a playerMoving flag? I wonder if the type is enough...
        // I think we may do incase they switch to running maybe?
        if (player.playerMoving) {
            if (player.x === player.destinationX && player.y === player.destinationY) {
                console.log("Movement ended");
                player.playerMoving = false;
                player.movementType = 0;
            } else {
                player.movementType = 1; // No running for now, shouldn't be hard to update though
                direction = PacketWriter.getNextMovementDirection(player);
                PacketWriter.updatePlayersXY(player);
            }
        }
        // Push 81 on always, it'll always be needed, notice the direction 1/2
        // these can be undefined if move type is 0/3
        bufferArray.push(new SyncPlayers81(player, playerList, playerIndex, direction, direction2).getPacket81());
        // Write our buffered array of packets in one big chunk
        player.socket.write(Buffer.concat(bufferArray));
        // Clear the incoming packet buffer for our local player
        player.packetBuffer = [];
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
        console.log("player path coords", player.pathCoords);
        return 0;
    }
    /**
     * Gets the next movement direction for the player to move in
     * 0 - Top left
     * 1 - Top
     * 2 - Top right
     * 3 - Left
     * 4 - Right
     * 5 - Bottom left
     * 6 - Bottom
     * 7 - Bottom right
     * 8 - Our clause, same tile
     * @todo move this into Player entity
     * @param player local player
     */
    private static getNextMovementDirection(player: Player): number {
        const x = player.x;
        const y = player.y;
        const dX = player.destinationX;
        const dY = player.destinationY;

        if (x > dX && y < dY) {
            return 0;
        } else if (x < dX && y > dY) {
            return 7;
        } else if (x < dX && y < dY) {
            return 2;
        } else if (x > dX && y > dY) {
            return 5;
        } else if (x < dX && y === dY) {
            return 4;
        } else if (x > dX && y === dY) {
            return 3;
        } else if (y < dY && x === dX) {
            return 1;
        } else if (y > dY && x === dX) {
            return 6;
        } else {
            // Represents we have not moved (i.e., clicked same tile)
            return 8;
        }
    }
    /**
     * Updates the players current x/y co-ordinates (relative to the region)
     * based on the direction they are going to move in
     * @todo move this into the Player entity
     * @param player local player
     */
    private static updatePlayersXY(player: Player): void {
        const dX = player.destinationX;
        const dY = player.destinationY;
        if (player.x > dX && player.y < dY) {
            player.x--;
            player.y++;
        } else if (player.x < dX && player.y > dY) {
            player.x++;
            player.y--;
        } else if (player.x < dX && player.y < dY) {
            player.x++;
            player.y++;
        } else if (player.x > dX && player.y > dY) {
            player.x--;
            player.y--;
        } else if (player.x < dX && player.y === dY) {
            player.x++;
        } else if (player.x > dX && player.y === dY) {
            player.x--;
        } else if (player.y < dY && player.x === dX) {
            player.y++;
        } else if (player.y > dY && player.x === dX) {
            player.y--;
        }
    }
}
