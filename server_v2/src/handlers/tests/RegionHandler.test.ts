import Player from "src/game/entities/game/Player";
import IsaacCipher from "src/IsaacCipher";
import { Socket } from "net";
import RegionHandler from "../RegionHandler";

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
    x: 32,
    y: 32,
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

test("Region handler watchForRegionChange should determine the correct direction of a region change", () => {
    // No change     0  0
    expect(RegionHandler.watchForRegionChange(dummyPlayer)).toEqual([0, 0]);

    // North         0  1
    dummyPlayer.x = 32;
    dummyPlayer.y = 100;
    expect(RegionHandler.watchForRegionChange(dummyPlayer)).toEqual([0, 1]);

    // North East    1  1
    dummyPlayer.x = 100;
    dummyPlayer.y = 100;
    expect(RegionHandler.watchForRegionChange(dummyPlayer)).toEqual([1, 1]);

    // East          1  0
    dummyPlayer.x = 100;
    dummyPlayer.y = 32;
    expect(RegionHandler.watchForRegionChange(dummyPlayer)).toEqual([1, 0]);

    // South East    1 -1
    dummyPlayer.x = 100;
    dummyPlayer.y = 0;
    expect(RegionHandler.watchForRegionChange(dummyPlayer)).toEqual([1, -1]);

    // South         0 -1
    dummyPlayer.x = 32;
    dummyPlayer.y = 0;
    expect(RegionHandler.watchForRegionChange(dummyPlayer)).toEqual([0, -1]);

    // South West   -1 -1
    dummyPlayer.x = 0;
    dummyPlayer.y = 0;
    expect(RegionHandler.watchForRegionChange(dummyPlayer)).toEqual([-1, -1]);

    // West         -1  0
    dummyPlayer.x = 0;
    dummyPlayer.y = 32;
    expect(RegionHandler.watchForRegionChange(dummyPlayer)).toEqual([-1, 0]);

    // North West   -1  1
    dummyPlayer.x = 0;
    dummyPlayer.y = 100;
    expect(RegionHandler.watchForRegionChange(dummyPlayer)).toEqual([-1, 1]);
});
