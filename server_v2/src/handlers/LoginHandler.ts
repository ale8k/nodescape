import Client from "../Client";
import * as Long from "long";
import IsaacCipher from "../IsaacCipher";
import RSString from "../utils/RSString";

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
     * Sets up a data event to handle incoming login associated data
     * @param client the client attempting to login
     */
    constructor(client: Client) {
        this._client = client;
        /**
         * Watch for incoming data within the login protocol only
         */
        this._client.socket.on("data", (data) => {
            console.log(this._client.loginStage);
            if (this._client.loginStage === 0) {
                this.handleFirstStage(this._client, data);
            }
            if (this._client.loginStage === 1) {
                this.handleSecondStage(this._client, data);
            }
            if (this._client.loginStage === 2) {
                console.log(data.toJSON());
            }
        });
    }

    /**
     * Handles the first stage response of the login protocol
     * @param client the client for this connection instance
     * @param data incoming data for this client
     */
    private handleFirstStage(client: Client, data: Buffer) {
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
     * @param client the client for this connection instance
     * @param data incoming data for this client
     */
    private handleSecondStage(client: Client, data: Buffer) {
        if (data[0] === 16) {
            console.log(data.toJSON());
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

            client.inStreamDecryptor = new IsaacCipher(inSessionKey);
            client.outStreamDecryptor = new IsaacCipher(outSessionKey);
            console.log(client.userId);
            console.log(rsaBlock[18]);

            const usernameAndPassword = RSString.readRSStringUsernameAndPassword(rsaBlock.splice(18));
            client.username = usernameAndPassword[0];
            client.password = usernameAndPassword[1];
            client.socket.write(Buffer.from([2, 2, 0]));
            client.loginStage = 2;
        }
        if (data[0] === 18) {
            console.log("Reconnection is not handled.");
        }
    }

}
