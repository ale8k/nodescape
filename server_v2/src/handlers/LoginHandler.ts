import { ISAACGenerator } from "isaac-crypto";
import * as Long from "long";
import { EventEmitter } from "events";
import Client from "../game/entities/Client";
import RSString from "../utils/RSString";
import Player from "../game/entities/game/Player";

/**
 * Handles the login procedure for a single client
 * @author ale8k
 */
export default class LoginHandler {
    /**
     * This client's socket
     */
    private _client: Client;
    /**
     * Server generated server session key
     */
    private _serverSessionKey: bigint;
    /**
     * Emits the updated client object state back to the GameServer
     */
    private _clientEmitter$: EventEmitter;
    /**
     * Allows GameServer to check if a reconnection is active
     */
    public reconnecting = false;

    /**
     * Sets up a data event to handle incoming login associated data
     * @param {Client} client the client attempting to login
     * @param {EventEmitter} clientEmitter the {@link EventEmitter} to emit the response of a clients attempted login to
     */
    constructor(client: Client, clientEmitter: EventEmitter) {
        this._client = client;
        this._clientEmitter$ = clientEmitter;
        /**
         * Watch for incoming data within the login protocol only
         */
        this._client.socket.on("data", (data) => {
            if (this._client.loginStage === 0) {
                this.handleFirstStage(this._client, data);
            }
            if (this._client.loginStage === 1) {
                this.handleSecondStage(this._client, data);
            }
            if (this._client.loginStage === 2) {
                // kills the login procedure methods
                // if the loginStage never hits 2, this will be never happen
                // so we know we're safe emitting the client back here
                this._client.loginStage = 3;
                console.log("LOGIN STAGE IS: ", this._client.loginStage);
                const p = (this._client as Player); // This down cast is necessary
                p.packetBuffer = [];
                p.x = 41;
                p.y = 48;
                p.regionx = 3072;
                p.regiony = 3264;
                p.plane = 0;
                p.movementType = 3;
                p.updateOurPlayer = true;
                p.updateLocalPlayer = true;
                p.updateReferencePlayer = true; // Will always be initially true
                p.playerMoving = false;
                p.destinationX = p.x;
                p.destinationY = p.y;
                p.pathCoords = [];
                p.regionLoaded = false;
                this._clientEmitter$.emit("successful-login", p);
            }
        });
    }
    /**
     * Handles the first stage response of the login protocol
     * @param {Client} client the client for this connection instance
     * @param {Buffer} data incoming data for this client
     */
    private handleFirstStage(client: Client, data: Buffer): void {
        if (data[0] === 14) {
            const b = Buffer.alloc(17);
            this._serverSessionKey = BigInt(Math.ceil(Math.random() * 999999999));
            b.writeBigInt64BE(this._serverSessionKey);
            client.socket.write(b);
            client.loginStage = 1;
        }
    }
    /**
     * Handles the second stage response of the login protocol
     * Breaks up the second response from the client and assigns it to our local Client object
     * @todo Currently it will only connect status code 16 (new session), extend this
     * to support 18 (reconnection). We also want to check if the username/password exists,
     * for now I've hardcoded here some username/password combos
     * @param {Client} client the client for this connection instance
     * @param {Buffer} data incoming data for this client
     */
    private handleSecondStage(client: Client, data: Buffer): void {
        if (data[0] === 16) {
            const rsaBlock = data.toJSON().data.slice(43);
            const clientSessionKey = Long.fromBytes(rsaBlock.slice(1, 9));
            const serverSessionKey = Long.fromBytes(rsaBlock.slice(9, 17));
            client.userId = rsaBlock[17];

            const inSessionKey = [
                (clientSessionKey.shiftRight(32).toInt()),
                (clientSessionKey.toInt()),
                (serverSessionKey.shiftRight(32).toInt()),
                (serverSessionKey.toInt())
            ];

            const outSessionKey = [
                (clientSessionKey.shiftRight(32).toInt()) + 50,
                (clientSessionKey.toInt()) + 50,
                (serverSessionKey.shiftRight(32).toInt()) + 50,
                (serverSessionKey.toInt()) + 50
            ];

            client.inStreamDecryptor = new ISAACGenerator(inSessionKey);
            client.outStreamEncryptor = new ISAACGenerator(outSessionKey);

            const usernameAndPassword = RSString.readRSStringUsernameAndPassword(rsaBlock.splice(18));
            console.log(usernameAndPassword);
            client.username = usernameAndPassword[0];
            client.password = usernameAndPassword[1];

            if (client.username === "testing" && client.password === "" || client.username === "alex" && client.password === "") {
                client.loginStage = 2;
                console.log("Client successfully connected, username: ", client.username);
                client.socket.write(Buffer.from([2, 2, 0]));
            } else {
                client.socket.write(Buffer.from([3, 0, 0]));
                client.socket.on("close", () => {
                    console.log("Incorrect username / password");
                });
            }
        }
        if (data[0] === 18) {
            client.socket.destroy();
            console.log("Reconnection is not handled.");
        }
    }
}
