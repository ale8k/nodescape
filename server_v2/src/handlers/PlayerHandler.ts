import Player from "../game/entities/game/Player";

/**
 * Static helper class handler for player based actions/events
 * Is responsible for calculating actions relative to and/or including our local player
 * @author ale8k
 */
export default class PlayerHandler {
    /**
     * Checks our local players region and returns a list {@link playerList Player[]} of
     * all the players in that region (excluding our local player)
     * @param {Player} player local player
     * @param {Player[]} totalPlayerList the entire list of currently connected player instances
     * @returns {Player[]} an array of the players in our local players current region
     */
    public static getPlayersInLocalPlayersRegion(player: Player, totalPlayerList: Player[]): Player[] {
        return totalPlayerList.filter((otherPlayer) => {
            return otherPlayer.regionx === player.regionx && otherPlayer.regiony === player.regiony;
        });
    }
    /**
     * Filters a player list of players in our region but are not in our local players
     * visible range
     * 17 tiles is the mark when they flip to otherside, 16 is final visible tile
     * @param {Player} player local player
     * @param {Player[]} playerList the list of all players in our local players region
     * @returns {Player[]} an array of the players in our local players visible range
     */
    public static getPlayersInVisibleRange(player: Player, playerList: Player[]): Player[] {
        const lpXMaxRange = player.x + 17;
        const lpXMinRange = player.x - 17;
        const lpYMaxRange = player.y + 17;
        const lpYMinRange = player.y - 17;
        // Both their x and y need to be in range, otherwise remove them
        return playerList.filter((otherPlayer) => {
            if (otherPlayer.x  < lpXMaxRange && otherPlayer.x > lpXMinRange
                && otherPlayer.y < lpYMaxRange && otherPlayer.y > lpYMinRange) {
                    return true;
            }
        });
    }
}
