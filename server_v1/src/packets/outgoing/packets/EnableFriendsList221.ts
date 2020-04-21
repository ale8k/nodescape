import { Socket } from "net";

/**
 * Once a players current friends can be resolved or the player object as a whole,
 * we *then* send this packet to render the UI
 * @param key next isaac gen
 * @param socket the socket
 * @author ale8k
 */
export default function EnableFriendsList221(key: number, socket: Socket): void {
    const b = Buffer.alloc(2);
    b[0] = 221 + key;
    b[1] = 2; // 1 doesn't work, idk why, but 2 loads them
    socket.write(b);
}

