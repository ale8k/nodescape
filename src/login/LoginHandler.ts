import { Socket } from "net";
import * as Long from "long";
import { EventEmitter } from "events";

/**
 * Handles the login procedure and if successful,
 * redirects our event listener to the packet handler.
 * @author ale8k
 */
export default class LoginHandler {
    /**
     * The stage level within the login protocol
     */
    private _loginProtocolStage: number;
    /**
     * The opcode decryption cipher key
     */
    private _inStreamKey: number[];
    /**
     * The opcode encryption cipher key
     */
    private _outStreamKey: number[];
    /**
     * The game emitter, allowing us to talk between events
     */
    private _gameEmitter: EventEmitter;

    constructor(socket: Socket, gameEmitter: EventEmitter) {
        this._loginProtocolStage = 0;
        this._gameEmitter = gameEmitter;
        this.listenForLoginAttempts(socket);
    }

    /**
     * Handles the routing of the login protocol
     * As soon as this is complete, switch over to the PacketHandler
     * data event
     * TODO: Handle reconnections
     * @param socket the socket
     */
    public listenForLoginAttempts(socket: Socket): void {
        socket.on("data", (data) => {
            console.log("LoginHandler byte[0]: " + data[0]);
            switch (this._loginProtocolStage) {
                case 0:
                    this.writeFirstLoginBlock(socket);
                    break;
                case 1:
                    this.writeSecondLoginBlock(socket, data);
                    break;
                case 2:
                    console.log("Logged in event emitted");
                    this._loginProtocolStage = 3;
                    this._gameEmitter.emit("login-successful", this._inStreamKey, this._outStreamKey);
                    break;
            }
        });
    }

    /**
     * Writes protocol stage 1, which is:
     * 8 empty bytes, the response code (byte) and the server session key (long).
     * @param socket the socket
     */
    private writeFirstLoginBlock(socket: Socket): void {
        try {
            const b = Buffer.alloc(17);
            // server key is 0, 0, 0, 69
            b[15] = 0;
            b[16] = 69;
            socket.write(b);
        } catch (e) {
            this._loginProtocolStage = 0;
            throw e;
        } finally {
            this._loginProtocolStage = 1;
            console.log("First login block sent");
        }
    }

    /**
     * Skips the initial 43 bytes (connect status, size, 255, 317 etc.)
     * and grabs the RSA encrypted block (which isn't encrypted in our client).
     * We use the keys to emit them to the packet handler, so that it can create
     * IsaacCipher instances.
     * Finally we write our connect status, bot flag and player status flag.
     * TODO: Handle connect codes.
     * @param socket the socket
     * @param data the data emitted from the client
     */
    private writeSecondLoginBlock(socket: Socket, data: Buffer): void {
        try {
            const rsaBlock = data.toJSON().data.slice(43);
            const clientSessionKey = Long.fromBytes(rsaBlock.slice(1, 9));
            const serverSessionKey = Long.fromBytes(rsaBlock.slice(9, 17));

            let sessionKey = [
                (clientSessionKey.shiftRight(32).toInt()),
                (clientSessionKey.toInt()),
                (serverSessionKey.shiftRight(32).toInt()),
                (serverSessionKey.toInt())
            ];
            this._inStreamKey = sessionKey;

            sessionKey = [
                (clientSessionKey.shiftRight(32).toInt()) + 50,
                (clientSessionKey.toInt()) + 50,
                (serverSessionKey.shiftRight(32).toInt()) + 50,
                (serverSessionKey.toInt()) + 50
            ];
            this._outStreamKey = sessionKey;

            socket.write(Buffer.from([2, 0, 0]));

        } catch (e) {
            this._loginProtocolStage = 0;
            throw e;
        } finally {
            this._loginProtocolStage = 2;
            console.log("Second login block sent");
        }
    }

}
