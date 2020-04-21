import { Socket } from "net";

/**
 * Sets/updates the players run energy percentage
 * @param key next isaac gen
 * @param socket the socket
 * @param weightPercentage the current percentage of run energy the player has equipped and carried
 * @author ale8k
 */
export default function SetPlayersRunEnergy110(key: number, socket: Socket, runPercentage: number): void {
    const b = Buffer.alloc(2);
    b[0] = 110 + key;
    b[1] = runPercentage;
    socket.write(b);
}
