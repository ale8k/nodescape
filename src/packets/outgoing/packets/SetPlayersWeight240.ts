import { Socket } from "net";

/**
 * Sets/updates the players weight percentage
 * @param key next isaac gen
 * @param socket the socket
 * @param kg the current kg of weight the player has equipped and carried
 * @author ale8k
 */
export default function SetPlayersWeight(key: number, socket: Socket, weightKg: number): void {
    const b = Buffer.alloc(3);
    b[0] = 240 + key;
    b.writeUInt16BE(weightKg, 1);
    socket.write(b);
}
