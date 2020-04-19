import * as net from "net";
import { Socket } from "net";
import { EventEmitter } from "events";
import IsaacCipher from "./packets/IsaacCipher";
import {
    SetSidebarInterface71,
    LoadMapZone73,
    UpdateLocalPlayer81,
    ResetCamPos107,
    SetSkillLevelAndXp134,
    EnableFriendsList221,
    SendPlayerIdx249,
    WriteMessage253,
    SetPlayersWeight240,
    SetPlayersRunEnergy110,
    Logout109
} from "./packets/outgoing";
import {
    PacketReader,
    Parse164Walk,
    Parse248Walk
} from "./packets/incoming";
import GameIds from "./GameIds";
import { LoginState } from "./enums/Login.enum";
import LoginHandler from "./packets/login/LoginHandler";
import IMovement, { movementData3, movementData1 } from "./packets/outgoing/81/interfaces/IMovement";
// DEBUG
import { colours } from "./ConsoleColours";
import ActionIds from "./ActionIds";
import Player from "./Player";

/**
 * Entry point for the server
 * @author ale8k
 */
export default class Server {
    /**
     * The emitter which handles directing incoming and outgoing packets
     */
    private _gameLoopEventEmitter: EventEmitter = new EventEmitter();

    /**
     * Sets the game cycle rate (600 default)
     */
    public static GAME_CYCLE_RATE = 600;

    public startServer(): void {
        // As the server starts, turn our game loop on
        setInterval(() => {
            this._gameLoopEventEmitter.emit("tick");
        }, Server.GAME_CYCLE_RATE);

        net.createServer((socket: Socket) => {
            console.log("A Client is attempting to establish a connection...");

            /**
             * This is created per each individual socket that attempts to connect.
             */
            const client = new Player();
            client.loginState = LoginState.FirstResponse;
            client.initialSetup = false;
            client.playerDetails = {
                username: "test",
                password: "password123",
                x: 22,
                y: 20,
                regionx: 3200,
                regiony: 3200,
                plane: 0
            };
            client.inStrCacheBuffer = [];

            /**
             * Single primary data event
             */
            socket.on("data", (data) => {
                if (client.loginState === LoginState.FirstResponse) {
                    LoginHandler.sendFirstResponse(socket, client);
                } else if (client.loginState === LoginState.SecondResponse) {
                    LoginHandler.sendSecondResponse(socket, data, client);
                } else if (client.loginState === LoginState.LoggedIn) {
                    //console.log("Client PID: ", client.playerId, " - Has successfully logged in");
                    // Basics we need to setup before generically handling packets
                    if (client.initialSetup === false) {
                        console.log("Setting up initial game stage!");
                        // Push the very first game packet to our cache buffer
                        client.inStrCacheBuffer.push(...data.toJSON().data);
                        // setup event listener and send initial packets
                        this.setupGame(socket, client);
                    } else {
                        client.inStrCacheBuffer.push(...data.toJSON().data);
                    }
                }
            });

            /**
             * Close
             */
            socket.on("close", (e) => {
                console.log(colours.FgRed, "A client was disconnected...");
            });

        }).listen(43594, () => {
            console.log("Server running");
        });
    }

    /**
     * Sends initial packets and adds our gameloop
     * event listener callback
     * The inStreamBuffer cache increments based on all incoming data
     * @param socket the primary socket
     */
    private setupGame(socket: Socket, client: Player): void {
        const oe = client.outStrEncryption;
        // a place to store the parsed opcode, length and payload pre packet parsing
        let packet: { opcode: number, length: number, payload: number[] };
        // the destination for our x/y in movement
        let destinationX = client.playerDetails.x;
        let destinationY = client.playerDetails.y;
        // represents data model brought back from 98, 164 or 248
        let walkPacket: {
            opcode: number;
            baseXwithX: number;
            baseYwithY: number;
            pathCoords: number[];
            randomByteOnTheEndLol: number;
        };
        // a flag which tells us do we need to send more movement based packet 81's
        // i.e., is the destinationX/Y === to our X/Y yet?
        let playerIsMoving = false;
        // IMovement object which represents an idle game tick
        const idleMovement: IMovement = {
            updatePlayer: 0,
            movementType: 0
        };
        // a walking movement object which represents the player should move in one direction
        const movement: IMovement = {
            updatePlayer: 1,
            movementType: 1,
            movementData: {
                updateRequired: 0,
                direction: 0
            }
        };
        // typescript can be poop sometimes
        movement.movementData = movement.movementData as movementData1;

        /**
         * The game tick loop callback function (i.e., handler)
         */
        this._gameLoopEventEmitter.on("tick", () => {
            while (client.inStrCacheBuffer.length > 0) {
                packet = PacketReader.getPacketOpcodeAndLength(client.inStrCacheBuffer, client.inStrDecryption);
                console.log(packet.opcode);
                /**
                 * Handle walk
                 */
                if (packet.opcode === 164 || packet.opcode === 248 || packet.opcode === 98) {
                    switch (packet.opcode) {
                        case 248:
                            walkPacket = Parse248Walk(packet);
                            break;
                        case 164:
                            walkPacket = Parse164Walk(packet);
                            break;
                        case 98:
                            walkPacket = Parse164Walk(packet);
                            break;
                    }
                    destinationX = walkPacket.baseXwithX - client.playerDetails.regionx;
                    destinationY = walkPacket.baseYwithY - client.playerDetails.regiony;

                    playerIsMoving = true;
                    // pathing conversion
                    if (walkPacket.pathCoords.length > 0) {
                        walkPacket.pathCoords = walkPacket.pathCoords.map((coord, i) => {
                            return i % 2 === 0 ? coord + destinationX & 0xff : coord + destinationY & 0xff;
                        });
                    }
                }
                /**
                 * Handles actions (we need an action handling system!)
                 */
                if (packet.opcode === 185) {
                    // read the action id [1][2]
                    const actionId = ((packet.payload[1] & 0xff) << 8) + (packet.payload[2] & 0xff);
                    console.log(actionId);
                    if (actionId === ActionIds.LOGOUT) {
                        console.log("Player clicked logout");
                        Logout109(oe.nextKey(), socket);

                    }
                }


            }

            if (playerIsMoving) {
                this.processMovement(socket, destinationX, destinationY, oe, movement, client);

                // update next path, if pathing bytes available
                if (client.playerDetails.x === destinationX && client.playerDetails.y === destinationY) {
                    playerIsMoving = false;

                    if (walkPacket.pathCoords.length > 0) {
                        destinationX = walkPacket.pathCoords.shift() as number;
                        destinationY = walkPacket.pathCoords.shift() as number;
                        playerIsMoving = true;
                    }
                }
            } else {
                // console.log(colours.FgGreen, "Idle packet sent for player ID: ", client.playerId);
                UpdateLocalPlayer81(socket, oe.nextKey(), idleMovement, 0, 2047);
            }

        });

        this.sendInitialLoginPackets(socket, client);
        console.log("Callback attached and initial packets sent");
        client.initialSetup = true;
    }

    /**
     * Sends all the essential starting packets
     * @param s our players socket
     */
    private sendInitialLoginPackets(s: Socket, client: Player): void {
        const oe = client.outStrEncryption;

        SendPlayerIdx249(oe.nextKey(), s, client.playerId);
        console.log("Player index sent to client");

        GameIds.SIDEBAR_IDS.forEach((sideBarIconId, sideBarLocationId) => {
            SetSidebarInterface71(oe.nextKey(), s, sideBarLocationId, sideBarIconId);
        });

        new Array(20).fill(0).forEach((zero, i) => {
            SetSkillLevelAndXp134(oe.nextKey(), s, i, 13700000, 99);
        });

        EnableFriendsList221(oe.nextKey(), s);
        SetPlayersWeight240(oe.nextKey(), s, 1069);
        SetPlayersRunEnergy110(oe.nextKey(), s, 55);
        ResetCamPos107(oe.nextKey(), s);
        LoadMapZone73(oe.nextKey(), s, client.playerDetails.regionx, client.playerDetails.regiony);
        WriteMessage253(oe.nextKey(), s, "Welcome to Runescape!");

        // This would realistically have data pulled from a db put into this object.
        const initialMovement: IMovement = {
            updatePlayer: 1,
            movementType: 3,
            movementData: {
                plane: client.playerDetails.plane,
                teleport: 1,
                updateRequired: 1,
                x: client.playerDetails.x,
                y: client.playerDetails.y
            } as movementData3
        };

        UpdateLocalPlayer81(s, oe.nextKey(), initialMovement, 0, 2047);

    }

    /**
     * Sends a player 1 step towards a given x/y co-ordinate
     * @param socket the socket
     * @param destinationX destination to drive the player towards
     * @param destinationY destination to drive the player towards
     * @param oe outstream encryption
     * @param movement the movement object for packet 81 to parse
     */
    private processMovement(socket: Socket, destinationX: number, destinationY: number, oe: IsaacCipher, movement: IMovement,
        client: Player): void {
        let x = client.playerDetails.x;
        let y = client.playerDetails.y;
        if (x > destinationX && y < destinationY) {
            x--;
            y++;
            (movement.movementData as movementData1).direction = 0;
            UpdateLocalPlayer81(socket, oe.nextKey(), movement, 0, 2047);
        } else if (x < destinationX && y > destinationY) {
            x++;
            y--;
            (movement.movementData as movementData1).direction = 7;
            UpdateLocalPlayer81(socket, oe.nextKey(), movement, 0, 2047);
        } else if (x < destinationX && y < destinationY) {
            x++;
            y++;
            (movement.movementData as movementData1).direction = 2;
            UpdateLocalPlayer81(socket, oe.nextKey(), movement, 0, 2047);
        } else if (x > destinationX && y > destinationY) {
            x--;
            y--;
            (movement.movementData as movementData1).direction = 5;
            UpdateLocalPlayer81(socket, oe.nextKey(), movement, 0, 2047);
        } else if (x < destinationX && y === destinationY) {
            x++;
            (movement.movementData as movementData1).direction = 4;
            UpdateLocalPlayer81(socket, oe.nextKey(), movement, 0, 2047);
        } else if (x > destinationX && y === destinationY) {
            x--;
            (movement.movementData as movementData1).direction = 3;
            UpdateLocalPlayer81(socket, oe.nextKey(), movement, 0, 2047);
        } else if (y < destinationY && x === destinationX) {
            y++;
            (movement.movementData as movementData1).direction = 1;
            UpdateLocalPlayer81(socket, oe.nextKey(), movement, 0, 2047);
        } else if (y > destinationY && x === destinationX) {
            y--;
            (movement.movementData as movementData1).direction = 6;
            UpdateLocalPlayer81(socket, oe.nextKey(), movement, 0, 2047);
        }
        client.playerDetails.x = x;
        client.playerDetails.y = y;
    }

}

new Server().startServer();

