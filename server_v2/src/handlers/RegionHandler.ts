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
}
