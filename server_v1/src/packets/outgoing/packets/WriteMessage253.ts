import { Socket } from "net";

/**
 * Sends a message from the server to the client [chatbox] i.e., "Welcome to Runescape"
 * @param key next isaac gen
 * @param socket the socket
 * @author ale8k
 */
export default function EnableFriendsList221(key: number, socket: Socket, msg: string): void {
    const text = Buffer.from(" " + msg + " \n").toJSON().data;
    const b = Buffer.alloc(text.length + 2);
    b[0] = 253 + key;
    b[1] = text.length;
    let textOffset = 2;
    text.forEach(byte => {
        b[textOffset++] = text[(textOffset - 2)];
    });
    socket.write(b);
}
