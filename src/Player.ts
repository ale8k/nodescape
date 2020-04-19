import { LoginState } from "./enums/Login.enum";
import IsaacCipher from "./packets/IsaacCipher";

interface IPlayerDetails {
    username: string;
    password: string;
    x: number;
    y: number;
    regionx: number;
    regiony: number;
    plane: number;
}

export default class Player {
    public loginState: LoginState;
    public inStrDecryption: IsaacCipher;
    public outStrEncryption: IsaacCipher;
    public inStrCacheBuffer: number[];
    public playerId: number;
    public initialSetup: boolean;
    public playerDetails: IPlayerDetails;
}
