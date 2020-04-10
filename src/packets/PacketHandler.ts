import { Socket } from "net";
import IsaacCipher from "./IsaacCipher";
import { LoadMapZone73, UpdateLocalPlayer81 } from "./outgoing";
import { EventEmitter } from "events";

/**
 * Handles all incoming packets and redirects us
 * to the correct response method
 * @author ale8k
 */
export default class PacketHandler {
    /**
     * The opcode decryption cipher
     */
    private _inStreamDecryption: IsaacCipher;
    /**
     * The opcode encryption cipher
     */
    private _outStreamEncryption: IsaacCipher;
    /**
     * The game emitter, allowing us to talk between events
     */
    private _gameEmitter: EventEmitter;
    /**
     * The socket
     */
    private _socket: Socket;

    /**
     * Contains all out events for the gameEmitter related
     * to PacketHandling
     */
    constructor(socket: Socket, gameEmitter: EventEmitter) {
        this._socket = socket;
        gameEmitter.on("login-successful", (inStreamKey: number[], outStreamKey: number[]) => {
            this._inStreamDecryption = new IsaacCipher(inStreamKey);
            this._outStreamEncryption = new IsaacCipher(outStreamKey);
            this.listenForPackets(this._socket);
            console.log("YO! Event emitter just shot shit at us, heres the isaacs");
        });
    }

    private listenForPackets(socket: Socket): void {
        socket.on("data", (data) => {
            console.log("PacketHandler byte[0]: " + data[0]);
            //this.parseOpcode(data[0]);
            //console.log(data.toJSON());

            //73: Load the map zone
            socket.write(
                LoadMapZone73(
                    this._outStreamEncryption.nextKey(),
                    406, // higher = east, lower = west  // x
                    406 // higher = north, lower = south // y coord
                )
            );
            // 83: Update our player (eventually will update others...)
            socket.write(
                UpdateLocalPlayer81(
                    this._outStreamEncryption.nextKey(),
                    1, // update our player
                    3, // move type
                    0, // planelevel
                    1, // clear await queuee
                    1, // update required
                    21, // ycoord
                    21,  // xcoord
                    0, // updateNPlayers movements
                    2047, // player list updating bit
                )
            );
        });

    }

    /**
     * Parses Isaac encrypted opcodes
     * @param opcode an encrypted opcode
     */
    private parseOpcode(opcode: number): number {
        const encryptedOpcode = opcode & 0xff;
        const decryptedOpcode = encryptedOpcode - this._inStreamDecryption.nextKey() & 0xff;
        console.log(decryptedOpcode);
        return decryptedOpcode;
    }
}
