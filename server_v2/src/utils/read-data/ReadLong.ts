import * as Long from "long";

/**
 * A static helper class which reads all forms of longs,
 * including Jagex's special categories
 * Need to really up the game here lol
 * @author ale8k
 */
export default class ReadLong {
    public static BE(b: Buffer, index: number): Long {
        const bytes = b.toJSON().data.slice(index, index + 8);
        return Long.fromBytes(bytes);
    }
}
