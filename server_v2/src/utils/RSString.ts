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
     * Writes a string into a long size sets of bytes, encoded in base37
     */
    public static writeStringToLongBytes37(name: string): number[] {
        return Long.fromNumber(this.encodeBase37(name)).toBytes();
    }
    /**
     * Encodes a string into Base37
     * @param str the string to encode
     */
    private static encodeBase37(str: string): number {
        // grabs the character code
        function c(char: string): number {
            return char.charCodeAt(0);
        }
        let encoded = 0;

        for (let index = 0; index < str.length && index < 12; index++) {
            const char = str.charCodeAt(index);
            encoded *= 37;

            if (char >= c("A") && char <= c("Z")) {
                encoded += char - c("A") + 1;
            } else if (char >= c("a") && char <= c("z")) {
                encoded += char - c("a") + 1;
            } else if (char >= c("0") && char <= c("9")) {
                encoded += char - c("0") + 26 + 1;
            }
        }

        while (encoded % 37 === 0 && encoded !== 0) {
            encoded /= 37;
        }
        return encoded;
    }
}
