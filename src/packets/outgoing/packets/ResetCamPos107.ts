import { Socket } from "net";

/**
 * Resets the camera position to the native position
 * @param key next isaac gen
 * @param socket the socket
 * @author ale8k
 */
export default function ResetCamPos107(key: number, socket: Socket) {
    const b = Buffer.alloc(1);
    b[0] = 107 + key;
    socket.write(b);
}
