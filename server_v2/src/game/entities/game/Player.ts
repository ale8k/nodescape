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
     * Tracks if their co-ords have changed
     */
    public movementUpdated: boolean;
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
}
