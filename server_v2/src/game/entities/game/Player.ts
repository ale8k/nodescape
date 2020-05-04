import Client from "../Client";

/**
 * Extends a client into a full-fledged player context
 * @author ale8k
 */
export default class Player extends Client {
    /**
     * Holds the packets that have come in for this player
     * (will be wiped every 600ms)
     */
    public packetBuffer: number[];
    /**
     * The players current X co-ordinate relative to a region
     */
    public x: number;
    /**
     * The players current X co-ordinate relative to a region
     */
    public y: number;
    /**
     * The players current region X co-ordinate
     */
    public regionx: number;
    /**
     * The players current region Y co-ordinate
     */
    public regiony: number;
    /**
     * The players current plane height
     */
    public plane: number;
    /**
     * The players current movement type
     */
    public movementType: number;
    /**
     * A flag representing if the player has updated and requires a bitmask
     * appending to their next packet 81
     */
    public playerUpdated: boolean;
    /**
     * A flag representing if the player is moving, i.e., they have queued co-ordinates
     * to walk to
     * - Please note, this only applies to movement types 1 and 2, not 3
     */
    public playerMoving: boolean;
    /**
     * Players final x co-ord
     */
    public destinationX: number;
    /**
     * Players final y co-ord
     */
    public destinationY: number;
    /**
     * If the player attempted to walk, and pathing was required, this will be filled
     * with pathing co-ordinates which lead upto destination x/y
     */
    public pathCoords: number[];
    /**
     * The direction the player will move in first (and only this if walking)
     */
    public direction: number;
    /**
     * The second direction the player will move in (and only this if running)
     */
    public direction2: number;

    /**
     * Below is a bunch of static methods responsible for updating the players movement
     * related data, they're static cause all players share same method of moving
     * But I'm unsure if they should really be in the entity itself or a handler...
     */

    /**
     * Processes player movement if required
     * If the player's moving flag has updated, this will fire and update
     * the players movement direction and movement type
     * @param player local player
     */
    public static processPlayerMovement(player: Player): void {
        player.movementType = 1;
        player.direction = Player.getNextMovementDirection(player);
        console.log("players xy:", player.x, player.y, "players dest xy:", player.destinationX, player.destinationY, "players path coords:", player.pathCoords);
        if (player.x === player.destinationX && player.y === player.destinationY) {
            player.playerMoving = false;
            player.movementType = 0;
            console.log("dest xy reached");

            if (player.pathCoords.length > 0) {
                Player.updatePlayersDestinationXY(player);
                player.playerMoving = true;
                player.movementType = 1;
                player.direction = Player.getNextMovementDirection(player);
            }
        }
        Player.updatePlayersXY(player);
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
     * @param player local player
     */
    public static getNextMovementDirection(player: Player): number {
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
     * Updates the destination x/y with the next set of x/y path co-ords, i.e.,
     * If there are path co-ordinates to further step to, update them into our current
     * destination X/Y
     * @param player local player
     */
    public static updatePlayersDestinationXY(player: Player): void {
        if (player.pathCoords.length !== 0) {
            player.destinationX = player.pathCoords.shift() as number;
            player.destinationY = player.pathCoords.shift() as number;
        } else {
            console.log("Pathing co-ords finished/empty");
        }
    }
    /**
     * Updates the players current x/y co-ordinates (relative to the region)
     * based on the direction they are going to move in
     * @param player local player
     */
    public static updatePlayersXY(player: Player): void {
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
