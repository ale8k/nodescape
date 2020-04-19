import { Socket } from "net";

/**
 * Logs a player out of the server
 * @param key next isaac gen
 * @param socket the socket
 * @author ale8k
 */
export default function Logout109(key: number, socket: Socket) {
    const b = Buffer.alloc(1);
    b[0] = 109 + key;
    socket.write(b);
}
