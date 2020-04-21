/**
 * Represents the interface of an object to be passed
 * into UpdateLocalPlayer81
 * @author ale8k
 */
export default interface IMovement {
    updatePlayer: 0 | 1;
    movementType: 0 | 1 | 2 | 3;
    movementData?: movementData1 | movementData2 | movementData3;
}

// Some info on the data.
// direction: 0-7 represents our players facing direction
// updateRequired: whether or not to send a bitmask
// plane: players current height level, there's 3 in runescape. (idk about negatives yet)
// teleport: whether or not to clear the movement awaiting queue and just send them to the co-ords given in type 3
// x: the x val for move type 3
// y: the y val for move type 3
export type movementData1 = {
    direction: 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7;
    updateRequired: 0 | 1;
};

export type movementData2 = {
    direction1: 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7;
    direction2: 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7;
    updateRequired: 0 | 1;
};

export type movementData3 = {
    plane: 0 | 1 | 2 | 3;
    teleport: 0 | 1;
    updateRequired: 0 | 1;
    x: number;
    y: number;
};


