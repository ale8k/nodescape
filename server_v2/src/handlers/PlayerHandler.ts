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
     */
    public static getPlayersInLocalPlayersRegion(player: Player, totalPlayerList: Player[]): void {

    }
    /**
     * Filters a player list of players in our region but are not in our local players
     * visible range
     * @param {Player} player local player
     * @param {Player[]} playerList the list of all players in our local players region
     */
    public static getPlayersInVisibleRange(player: Player, playerList: Player[]): void {

    }
}
