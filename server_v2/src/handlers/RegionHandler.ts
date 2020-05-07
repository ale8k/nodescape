import Player from "src/game/entities/game/Player";

/**
 * Static helper class handler for loading a players region
 * If a region change is detected, the update region packet will be sent
 * @author ale8k
 */
export default class RegionHandler {
    /**
     * The minimum co-ordinate a player can enter before a region change is required
     */
    private static readonly minimumTileCoord: number = 15;
    /**
     * The maximum co-ordinate a player can enter before a region change is required
     */
    private static readonly maximumTileCoord: number = 86;

    /**
     * Is performed on each movement cycle, contains the logic
     * determining if a new region load is required
     * The region change flags in this method work as so:
     *  -1 Represents a negative change, 0 represents no change and +1 represents a positive change
     * @param {Player} player local player
     * @returns {number[]} an array determining whether to apply a pos/neg change to the players current region
     */
    public static watchForRegionChange(player: Player): number[] {
        let regionXChange = 0;
        let regionYChange = 0;
        const minTile = this.minimumTileCoord;
        const maxTile = this.maximumTileCoord;

        if (player.x < minTile) {
            regionXChange = -1;
        } else if (player.x > maxTile) {
            regionXChange = 1;
        }

        if (player.y < minTile) {
            regionYChange = -1;
        } else if (player.y > maxTile) {
            regionYChange = 1;
        }

        return [regionXChange, regionYChange];
    }
    /**
     * Updates the player's instance regionx/y properties to their new region
     * Also calls updatePlayersCoordsForNewRegion
     * @param {Player} player local player
     * @param {number} regionXChange 0/-1/1 representing direction to update region co-ordinate
     * @param {number} regionYChange 0/-1/1 representing direction to update region co-ordinate
     */
    public static updatePlayersRegion(player: Player, regionXChange: number, regionYChange: number): void {
        let xPathCoordChange = 0;
        let yPathCoordChange = 0;

        switch(regionXChange) {
            case 0:
                break;
            case 1:
                player.regionx += 64;
                player.x -= 64;
                player.destinationX -= 64;
                xPathCoordChange = 1;
                break;
            case -1:
                player.regionx -= 64;
                player.x += 64;
                player.destinationX += 64;
                xPathCoordChange = -1;
                break;
        }
        switch(regionYChange) {
            case 0:
                break;
            case 1:
                player.regiony += + 64;
                player.y -= 64;
                player.destinationY -= 64;
                yPathCoordChange = 1;
                break;
            case -1:
                player.regiony -= 64;
                player.y += 64;
                player.destinationY += 64;
                yPathCoordChange = -1;
                break;
        }
        xPathCoordChange !== 0 ? this.updatePlayersPathCoords(player, "x", xPathCoordChange) : null;
        yPathCoordChange !== 0 ? this.updatePlayersPathCoords(player, "y", yPathCoordChange) : null;
    }
    /**
     * Updates the players x/y path co-ordinates relative to their new region
     * @param {Player} player local player
     * @param {string} xOrY whether to update the x/y co-ordinates of the pathing array
     * @param {number} posOrNeg determines whether or not to +/- 64 depending on the region change value (0, -1, 1)
     */
    private static updatePlayersPathCoords(player: Player, xOrY: string, posOrNeg: number): void {
        const pathCoords = player.pathCoords;
        if (pathCoords.length > 0) {
            if (xOrY === "x") {
                pathCoords.forEach((coord, i) => {
                    if (i % 2 === 0) {
                        switch (posOrNeg) {
                            case 1:
                                pathCoords[i] -= 64;
                                break;
                            case -1:
                                pathCoords[i] += 64;
                                break;
                        }
                    }
                });
            }
            if (xOrY === "y") {
                pathCoords.forEach((coord, i) => {
                    if (i % 2 !== 0) {
                        switch (posOrNeg) {
                            case 1:
                                pathCoords[i] -= 64;
                                break;
                            case -1:
                                pathCoords[i] += 64;
                                break;
                        }
                    }
                });
            }
        }
        player.pathCoords = pathCoords;
    }

}
