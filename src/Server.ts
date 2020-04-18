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
    SetPlayersWeight,
    SetPlayersRunEnergy
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

/**
 * Entry point for the server
 * @author ale8k
 */
export default class Server {
    /**
     * Handles the current state of our login procedure
     */
    public static LOGIN_STATE: LoginState = LoginState.FirstResponse;
    /**
     * In stream opcode isaac cipher (set by loginhandler)
     */
    public static INSTREAM_DECRYPTION: IsaacCipher;
    /**
     * Out stream opcode isaac cipher (set by loginhandler)
     */
    public static OUTSTREAM_ENCRYPTION: IsaacCipher;
    /**
     * The emitter which handles directing incoming and outgoing packets
     */
    private _gameLoopEventEmitter: EventEmitter = new EventEmitter();
    /**
     * A place for us to store the incoming data outside of our
     * 600ms cycle
     */
    private _inStreamCacheBuffer: number[] = [];
    /**
     * A flag to check if our initial game setup has been completed.
     * If it has, proceed to process game packets
     */
    private _gameInitialSetupComplete = false;
    /**
     * Sets the game cycle rate (600 default)
     */
    public static GAME_CYCLE_RATE = 600;
    /**
     * The players ID from the RSA login block
     */
    public static PLAYER_ID: number;
    /**
     * Players starting/current x
     */
    private x: number = 22;
    /**
     * Players starting/current y
     */
    private y: number = 20;
    /**
     * Players starting/current region x
     */
    private regionx = 3200;
    /**
     * Players starting/current region y
     */
    private regiony = 3200;
    /**
     * Players starting/current plane level
     */
    private currentPlane = 0;
    /**
     * Array of sockets for each player
     */

    public startServer(): void {
        net.createServer((socket: Socket) => {
            console.log("A Client is attempting to establish a connection...");

            /**
             * Single primary data event
             * Handles the login procedure and if successful, pushes data
             * to our game instream buffer for the packets to be read per tick
             */
            socket.on("data", (data) => {
                if (Server.LOGIN_STATE === LoginState.FirstResponse) {
                    LoginHandler.sendFirstResponse(socket);
                } else if (Server.LOGIN_STATE === LoginState.SecondResponse) {
                    LoginHandler.sendSecondResponse(socket, data, this._gameLoopEventEmitter);
                } else if (Server.LOGIN_STATE === LoginState.LoggedIn) {

                    // Basics we need to setup before generically handling packets
                    if (this._gameInitialSetupComplete === false) {
                        console.log("Setting up initial game stage!");
                        // Push the very first game packet to our cache buffer
                        this._inStreamCacheBuffer.push(...data.toJSON().data);
                        // setup event listener and send initial packets
                        this.setupGame(socket);
                    } else {
                        this._inStreamCacheBuffer.push(...data.toJSON().data);
                    }
                }
            });

            /**
             * Close
             * TODO: A lot lol.
             */
            socket.on("close", (e) => {
                console.log("A client was disconnected...");
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
    private setupGame(socket: Socket): void {
        const oe = Server.OUTSTREAM_ENCRYPTION;
        // a place to store the parsed opcode, length and payload pre packet parsing
        let packet: { opcode: number, length: number, payload: number[] };
        // the destination for our x/y in movement
        let destinationX = this.x;
        let destinationY = this.y;
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

            while (this._inStreamCacheBuffer.length > 0) {
                packet = PacketReader.getPacketOpcodeAndLength(this._inStreamCacheBuffer, Server.INSTREAM_DECRYPTION);


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

                    destinationX = walkPacket.baseXwithX - this.regionx;
                    destinationY = walkPacket.baseYwithY - this.regiony;

                    playerIsMoving = true;
                    // pathing conversion
                    if (walkPacket.pathCoords.length > 0) {
                        walkPacket.pathCoords = walkPacket.pathCoords.map((coord, i) => {
                            return i % 2 === 0 ? coord + destinationX & 0xff : coord + destinationY & 0xff;
                        });
                    }
                }


            }

            if (playerIsMoving) {
                this.processMovement(socket, destinationX, destinationY, oe, movement);

                // update next path, if pathing bytes available
                if (this.x === destinationX && this.y === destinationY) {
                    playerIsMoving = false;

                    if (walkPacket.pathCoords.length > 0) {
                        destinationX = walkPacket.pathCoords.shift() as number;
                        destinationY = walkPacket.pathCoords.shift() as number;
                        playerIsMoving = true;
                    }
                }
            } else {
                console.log(colours.FgGreen, "Idle packet sent");
                UpdateLocalPlayer81(socket, oe.nextKey(), idleMovement, 0, 2047);
            }

        });

        this.sendInitialLoginPackets(socket);
        console.log("Callback attached and initial packets sent");
        this._gameInitialSetupComplete = true;
    }

    /**
     * Sends all the essential starting packets
     * @param s our players socket
     */
    private sendInitialLoginPackets(s: Socket): void {
        const oe = Server.OUTSTREAM_ENCRYPTION;

        SendPlayerIdx249(oe.nextKey(), s, Server.PLAYER_ID);
        console.log("Player index sent to client");

        GameIds.SIDEBAR_IDS.forEach((sideBarIconId, sideBarLocationId) => {
            SetSidebarInterface71(oe.nextKey(), s, sideBarLocationId, sideBarIconId);
        });

        new Array(20).fill(0).forEach((zero, i) => {
            SetSkillLevelAndXp134(oe.nextKey(), s, i, 13700000, 99);
        });

        EnableFriendsList221(oe.nextKey(), s);
        SetPlayersWeight(oe.nextKey(), s, 1069);
        SetPlayersRunEnergy(oe.nextKey(), s, 55);
        ResetCamPos107(oe.nextKey(), s);
        LoadMapZone73(oe.nextKey(), s, this.regionx, this.regiony);
        WriteMessage253(oe.nextKey(), s, "Welcome to Runescape!");

        // This would realistically have data pulled from a db put into this object.
        const initialMovement: IMovement = {
            updatePlayer: 1,
            movementType: 3,
            movementData: {
                plane: this.currentPlane,
                teleport: 1,
                updateRequired: 1,
                x: this.x,
                y: this.y
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
    private processMovement(socket: Socket, destinationX: number, destinationY: number, oe: IsaacCipher, movement: IMovement): void {
        if (this.x > destinationX && this.y < destinationY) {
            this.x--;
            this.y++;
            (movement.movementData as movementData1).direction = 0;
            UpdateLocalPlayer81(socket, oe.nextKey(), movement, 0, 2047);
        } else if (this.x < destinationX && this.y > destinationY) {
            this.x++;
            this.y--;
            (movement.movementData as movementData1).direction = 7;
            UpdateLocalPlayer81(socket, oe.nextKey(), movement, 0, 2047);
        } else if (this.x < destinationX && this.y < destinationY) {
            this.x++;
            this.y++;
            (movement.movementData as movementData1).direction = 2;
            UpdateLocalPlayer81(socket, oe.nextKey(), movement, 0, 2047);
        } else if (this.x > destinationX && this.y > destinationY) {
            this.x--;
            this.y--;
            (movement.movementData as movementData1).direction = 5;
            UpdateLocalPlayer81(socket, oe.nextKey(), movement, 0, 2047);
        } else if (this.x < destinationX && this.y === destinationY) {
            this.x++;
            (movement.movementData as movementData1).direction = 4;
            UpdateLocalPlayer81(socket, oe.nextKey(), movement, 0, 2047);
        } else if (this.x > destinationX && this.y === destinationY) {
            this.x--;
            (movement.movementData as movementData1).direction = 3;
            UpdateLocalPlayer81(socket, oe.nextKey(), movement, 0, 2047);
        } else if (this.y < destinationY && this.x === destinationX) {
            this.y++;
            (movement.movementData as movementData1).direction = 1;
            UpdateLocalPlayer81(socket, oe.nextKey(), movement, 0, 2047);
        } else if (this.y > destinationY && this.x === destinationX) {
            this.y--;
            (movement.movementData as movementData1).direction = 6;
            UpdateLocalPlayer81(socket, oe.nextKey(), movement, 0, 2047);
        }
    }

}

new Server().startServer();

