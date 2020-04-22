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
}
