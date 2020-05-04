import Player from "src/game/entities/game/Player";

/**
 * Handles updating the {@link Player}'s movement flags,
 * such that when their next update comes the appropriate movement type and direction
 * can be selected and set.
 * @author ale8k
 */
export default class MovementHandler {
    /**
     * Processes player movement if required
     * If the player's moving flag has updated, this will fire and update
     * the players movement direction and movement type
     * @param player local player
     */
    public static processPlayerMovement(player: Player): void {
        player.movementType = 1;
        player.direction = MovementHandler.getNextMovementDirection(player);
        console.log("players xy:", player.x, player.y, "players dest xy:", player.destinationX, player.destinationY, "players path coords:", player.pathCoords);
        if (player.x === player.destinationX && player.y === player.destinationY) {
            player.playerMoving = false;
            player.movementType = 0;
            console.log("dest xy reached");

            if (player.pathCoords.length > 0) {
                MovementHandler.updatePlayersDestinationXY(player);
                player.playerMoving = true;
                player.movementType = 1;
                player.direction = MovementHandler.getNextMovementDirection(player);
            }
        }
        MovementHandler.updatePlayersXY(player);
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
     * Updates the destination x/y with the next set of x/y path co-ords, i.e.,
     * If there are path co-ordinates to further step to, update them into our current
     * destination X/Y
     * @param player local player
     */
    private static updatePlayersDestinationXY(player: Player): void {
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
