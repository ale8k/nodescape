import * as Long from "long";

/**
 * A simple static utility class designated to handling
 * anything RSString
 * @author ale8k
 */
export default class RSString {
    /**
     * Reads through an array of bytes until the delimiter,
     * this delimit the username, we then read the password
     * and return an array with them both
     * @param array the array of bytes representing the string(s)
     */
    public static readRSStringUsernameAndPassword(array: number[]): string[] {
        const copy: number[] = JSON.parse(JSON.stringify(array));
        const splitIndex = array.findIndex((value) => value === 10);

        const usernameStringArr = array.slice(3, splitIndex);
        const username = String.fromCharCode.apply(null, usernameStringArr);

        const passwordStringArr = copy.slice(splitIndex + 1, copy.length - 1);
        const password = String.fromCharCode.apply(null, passwordStringArr);

        return [username, password];
    }
    /**
     * Writes a string into an RSString in bytes and returns it in Long format
     * Usecase: Username / Passwords
     */
    public static writeStringToLong(name: string): Long {
        return Long.fromString(name);
    }
}
