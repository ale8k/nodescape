import { Socket } from "net";

/**
 * Sends the member status along with the player ID to the client
 * @param key next isaac gen
 * @param socket the socket
 * @param playerId player UID received from the client
 * @author ale8k
 */
export default function SendPlayerIdx249(key: number, socket: Socket, playerId: number): void {
    // 249: Sends mem status and player's index in servers playerlist to client
    const b = Buffer.alloc(4);
    b[0] = 249 + key;
    b[1] = 1 + 128;
    b[2] = (playerId + 128);
    b[3] = (playerId >> 8);
    socket.write(b);
    console.log("Player index sent to client");
}
