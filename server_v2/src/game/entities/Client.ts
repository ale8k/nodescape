import { ISAACGenerator } from "isaac-crypto";
import { Socket } from "net";

/**
 * Represents a client attempting to login/reconnect
 * @author ale8k
 */
export default class Client {
    /**
     * Holds the socket for this client
     */
    public socket: Socket;
    /**
     * The current login stage for this client
     * @todo create an enum specifically for login
     */
    public loginStage: number;
    /**
     * The inStream opcode decryptor
     */
    public inStreamDecryptor: ISAACGenerator;
    /**
     * The outStream opcode decryptor
     */
    public outStreamEncryptor: ISAACGenerator;
    /**
     * User id
     */
    public userId: number;
    /**
     * Username
     */
    public username: string;
    /**
     * Password
     */
    public password: string;
    /**
     * Local player index
     */
    public localPlayerIndex: number;

    constructor(socket: Socket) {
        this.socket = socket;
        this.loginStage = 0;
    }
}
