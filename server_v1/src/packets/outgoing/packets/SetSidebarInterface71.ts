import { Socket } from "net";

/**
 * Sets a single sidebar icon.
 * Client side it sets up all the UI handlers to allow user-interaction with
 * the sidebar buttons too.
 * @param key next isaac gen
 * @param socket the socket
 * @param sideBarLocationId the index of the interface sidebar we wish to set
 * @param sideBarIconId the id of the icon we wish to place in a given location id slot
 * @author ale8k
 */
export default function SetSidebarInterface71(key: number, socket: Socket, sideBarLocationId: number, sideBarIconId: number): void {
    const b = Buffer.alloc(4);
    b[0] = 71 + key;
    b.writeInt16BE(sideBarIconId, 1);
    b[3] = sideBarLocationId + 128;
    socket.write(b);
}
