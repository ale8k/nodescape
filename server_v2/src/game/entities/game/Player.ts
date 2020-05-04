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
}
