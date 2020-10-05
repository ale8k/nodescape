import Player from "src/game/entities/game/Player";
import { Socket } from "net";
import RegionHandler from "../RegionHandler";
import { ISAACGenerator } from "isaac-crypto";

let dummyPlayer: Player;

beforeEach(() => {
    dummyPlayer = {
        socket: {} as Socket,
        loginStage: 0,
        inStreamDecryptor: {} as ISAACGenerator,
        outStreamEncryptor: {} as ISAACGenerator,
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
});

describe("RegionHandlers watchForChange should change correctly according to players x/y", () => {
    it("Should not change the region", () => {
        expect(RegionHandler.watchForRegionChange(dummyPlayer)).toEqual([0, 0]);
    });

    it("Should not change the region to the northern region", () => {
        dummyPlayer.y = 100;
        expect(RegionHandler.watchForRegionChange(dummyPlayer)).toEqual([0, 1]);
    });

    it("Should not change the region to the north-east region", () => {
        dummyPlayer.x = 100;
        dummyPlayer.y = 100;
        expect(RegionHandler.watchForRegionChange(dummyPlayer)).toEqual([1, 1]);
    });

    it("Should not change the region to the east region", () => {
        dummyPlayer.x = 100;
        expect(RegionHandler.watchForRegionChange(dummyPlayer)).toEqual([1, 0]);
    });

    it("Should not change the region to the south-east region", () => {
        dummyPlayer.x = 100;
        dummyPlayer.y = 0;
        expect(RegionHandler.watchForRegionChange(dummyPlayer)).toEqual([1, -1]);
    });

    it("Should not change the region to the southern region", () => {
        dummyPlayer.y = 0;
        expect(RegionHandler.watchForRegionChange(dummyPlayer)).toEqual([0, -1]);
    });

    it("Should not change the region to the south-west region", () => {
        dummyPlayer.x = 0;
        dummyPlayer.y = 0;
        expect(RegionHandler.watchForRegionChange(dummyPlayer)).toEqual([-1, -1]);
    });

    it("Should not change the region to the west region", () => {
        dummyPlayer.x = 0;
        expect(RegionHandler.watchForRegionChange(dummyPlayer)).toEqual([-1, 0]);
    });

    it("Should not change the region to the north-west region", () => {
        dummyPlayer.x = 0;
        dummyPlayer.y = 100;
        expect(RegionHandler.watchForRegionChange(dummyPlayer)).toEqual([-1, 1]);
    });
});

describe("RegionHandlers updatePlayersRegion should add/take 64 according to the given region change", () => {
    it("Should not mutate the players region co-ordinates", () => {
        RegionHandler.updatePlayersRegion(dummyPlayer, 0, 0);
        expect(dummyPlayer.regionx).toEqual(3200);
        expect(dummyPlayer.regiony).toEqual(3200);
    });

    it("Should mutate the players region co-ordinates to the northern region", () => {
        RegionHandler.updatePlayersRegion(dummyPlayer, 0, 1);
        expect(dummyPlayer.regionx).toEqual(3200);
        expect(dummyPlayer.regiony).toEqual(3264);
    });

    it("Should mutate the players region co-ordinates to the north-east region", () => {
        RegionHandler.updatePlayersRegion(dummyPlayer, 1, 1);
        expect(dummyPlayer.regionx).toEqual(3264);
        expect(dummyPlayer.regiony).toEqual(3264);
    });

    it("Should mutate the players region co-ordinates to the east region", () => {
        RegionHandler.updatePlayersRegion(dummyPlayer, 1, 0);
        expect(dummyPlayer.regionx).toEqual(3264);
        expect(dummyPlayer.regiony).toEqual(3200);
    });

    it("Should mutate the players region co-ordinates to the south-east region", () => {
        RegionHandler.updatePlayersRegion(dummyPlayer, 1, -1);
        expect(dummyPlayer.regionx).toEqual(3264);
        expect(dummyPlayer.regiony).toEqual(3136);
    });

    it("Should mutate the players region co-ordinates to the southern region", () => {
        RegionHandler.updatePlayersRegion(dummyPlayer, 0, -1);
        expect(dummyPlayer.regionx).toEqual(3200);
        expect(dummyPlayer.regiony).toEqual(3136);
    });

    it("Should mutate the players region co-ordinates to the south-west region", () => {
        RegionHandler.updatePlayersRegion(dummyPlayer, -1, -1);
        expect(dummyPlayer.regionx).toEqual(3136);
        expect(dummyPlayer.regiony).toEqual(3136);
    });

    it("Should mutate the players region co-ordinates to the west region", () => {
        RegionHandler.updatePlayersRegion(dummyPlayer, -1, 0);
        expect(dummyPlayer.regionx).toEqual(3136);
        expect(dummyPlayer.regiony).toEqual(3200);
    });

    it("Should mutate the players region co-ordinates to the south-east region", () => {
        RegionHandler.updatePlayersRegion(dummyPlayer, -1, 1);
        expect(dummyPlayer.regionx).toEqual(3136);
        expect(dummyPlayer.regiony).toEqual(3264);
    });

});





