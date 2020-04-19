import { Socket } from "net";
import { LoginState } from "../../enums/Login.enum";
import Long from "long";
import Server from "../../Server";
import IsaacCipher from "../IsaacCipher";
import { EventEmitter } from "events";

/**
 * Handles the login & game auth procedure via static methods
 * @author ale8k
 */
export default class LoginHandler {
    public static sendFirstResponse(socket: Socket): void {
        const b = Buffer.alloc(17);
        b[16] = 69;
        socket.write(b);
        Server.LOGIN_STATE = LoginState.SecondResponse;
        console.log("First client request received and first server response sent");
    }

    public static sendSecondResponse(socket: Socket, data: Buffer, gameEmitter: EventEmitter): void {
        const rsaBlock = data.toJSON().data.slice(43);
        const clientSessionKey = Long.fromBytes(rsaBlock.slice(1, 9));
        const serverSessionKey = Long.fromBytes(rsaBlock.slice(9, 17));
        // set player id
        Server.PLAYER_ID = rsaBlock[17];
        console.log("USERID: ", rsaBlock[17]);

        const inSessionKey = [
            (clientSessionKey.shiftRight(32).toInt()),
            (clientSessionKey.toInt()),
            (serverSessionKey.shiftRight(32).toInt()),
            (serverSessionKey.toInt())
        ];

        const sessionKey = [
            (clientSessionKey.shiftRight(32).toInt()) + 50,
            (clientSessionKey.toInt()) + 50,
            (serverSessionKey.shiftRight(32).toInt()) + 50,
            (serverSessionKey.toInt()) + 50
        ];
        Server.INSTREAM_DECRYPTION = new IsaacCipher(inSessionKey);
        Server.OUTSTREAM_ENCRYPTION = new IsaacCipher(sessionKey);

        socket.write(Buffer.from([2, 2, 0]));
        Server.LOGIN_STATE = LoginState.LoggedIn;
        console.log("Second client request received and second server response sent");
    }
}
