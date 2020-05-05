import PlayerHandler from "../PlayerHandler";
import Player from "../../game/entities/game/Player";
import { Socket } from "net";
import IsaacCipher from "../../IsaacCipher";

const dummyPlayer: Player = {
    socket: {} as Socket,
    loginStage: 0,
    inStreamDecryptor: {} as IsaacCipher,
    outStreamEncryptor: {} as IsaacCipher,
    userId: 0,
    username: "string",
    password: "string",
    localPlayerIndex: 0,
    packetBuffer: [],
    x: 0,
    y: 0,
    regionx: 3200,
    regiony: 3200,
    plane: 0,
    movementType: 0,
    updateOurPlayer: true,
    playerUpdated: true,
    playerMoving: true,
    destinationX: 0,
    destinationY: 0,
    pathCoords: [],
    direction: 0,
    direction2: 0
};

const prefilteredList: Player[] = [{...dummyPlayer}, {...dummyPlayer}, {...dummyPlayer}];
prefilteredList[0].regionx = 0;
prefilteredList[1].regionx = 0;
prefilteredList[1].regiony = 0;
const filteredList: Player[] = [{...dummyPlayer}];

/**
 * We have 4 in the list, one is of a different region, we expect
 * the list length to be 3 and all players region x/y's to be 3200
 */
test("Player list should filter by local player regions both x and y", () => {
    expect(PlayerHandler.getPlayersInLocalPlayersRegion(dummyPlayer, prefilteredList)).toHaveLength(1);
    expect(PlayerHandler.getPlayersInLocalPlayersRegion(dummyPlayer, prefilteredList)).toEqual(filteredList);
});
