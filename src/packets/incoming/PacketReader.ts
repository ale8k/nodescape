import IsaacCipher from "../IsaacCipher";

/**
 * A helper class which handles all reading associated
 * methods with a packet
 * @author ale8k
 */
export default class PacketReader {
    /**
     * Mutates the array buffer based on the opcode
     * Returns an object for a given opcode and packet within the cache buffer (which is just an array lol)
     * This object has the decrypted id, packet length and payload
     * Now because it's returning the packet itself, it also clears the buffer here
     * as it's just convenient, sorry :P
     * @param inStreamCacheBuffer the current packet(s) in the buffer
     * @param inStreamDecryption our isaac decryption
     */
    public static getPacketOpcodeAndLength(inStreamCacheBuffer: number[], inStreamDecryption: IsaacCipher)
        : { opcode: number, length: number, payload: number[] } {
        let dOpcode = PacketReader.parsePacketOpcode(inStreamCacheBuffer[0], inStreamDecryption);
        let pLength;
        const pPayload = [];

        switch (dOpcode) {
            // Anti cheat packet for if the users click > 92 tiles from their current tile
            case 36:
                for (let j = 0; j < 5; j++) {
                    inStreamCacheBuffer.shift();
                }
                dOpcode = PacketReader.parsePacketOpcode(inStreamCacheBuffer[0], inStreamDecryption);
            // Sent when a player enters a chat message
            case 4:
            case 45:
            // Anti-cheat ?
            case 77:
            // Walk on command: Sent when player walks due to clicking a door or something
            case 98:
            // Command in chatbox, i.e., ::something
            case 103:
            // Sent when dude sends private message
            case 126:
            // Sent when player clicks a tile to walk normally
            case 164:
            case 165:
            // Anti-cheat ?
            case 226:
            case 246:
            // Sent when player walks using map (note, it has 14 additional bytes on the end
            // presumed to be anticheat that are ignored)
            case 248:
                pLength = PacketReader.getVarBytePacketLength(inStreamCacheBuffer);
                break;
            default:
                pLength = PacketReader.getFixedPacketLength(dOpcode);
                break;
        }

        // Removes the packet from the instream cache buffer and returns it in
        // our payload object
        for (let i = 0; i < pLength; i++) {
            pPayload.push(inStreamCacheBuffer.shift());
        }
        return { opcode: dOpcode, length: pLength, payload: pPayload as number[] };
    }

    /**
     * Returns packet variable byte length
     * @param packet the packet in question
     */
    private static getVarBytePacketLength(packet: number[]): number {
        // + 2 for opcode and sizing byte
        return packet[1] + 2;
    }

    /**
     * Parses an encrypted opcode into a decrypted one
     */
    private static parsePacketOpcode(opcode: number, inStreamDecryption: IsaacCipher): number {
        const encryptedOpcode = opcode & 0xff;
        const decryptedOpcode = encryptedOpcode - inStreamDecryption.nextKey() & 0xff;
        return decryptedOpcode;
    }

    /**
     * Returns packet fixed length for a given [decrypted] opcode
     * @param opcode the [decrypted] opcode
     */
    private static getFixedPacketLength(opcode: number): number {
        switch (opcode) {
            // Idle packet
            case 0:
                return 0 + 1;
            // Focus change
            case 3:
                return 1 + 1;
            // Item used on another player
            case 14:
                return 8 + 1;
            // Sent when player uses an item
            case 16:
                return 6 + 1;
            // ?
            case 17:
                return 2 + 1;
            // ??
            case 18:
                return 2 + 1;
            // ??
            case 21:
                return 2 + 1;
            // ??
            case 23:
                return 6 + 1;
            // Sent when player uses item on another item on the floor
            case 25:
                return 10 + 1;
            // Sent when player uses magic on object
            case 35:
                return 4 + 1;
            // Anti-cheat (validates walking...?)
            case 36:
                return 4 + 1;
            // Sent when player follows another player
            case 39:
                return 2 + 1;
            // ??
            case 40:
                return 2 + 1;
            // Sent when player equips item
            case 41:
                return 6 + 1;
            // ??
            case 43:
                return 6 + 1;
            // Flagged account
            case 45:
                return 1 + 1;
            // ??
            case 53:
                return 12 + 1;
            // ??
            case 57:
                return 8 + 1;
            // Typing on an interface
            case 60:
                return 1 + 1;
            // ??
            case 70:
                return 6 + 1;
            // ??
            case 72:
                return 2 + 1;
            // ??
            case 73:
                return 2 + 1;
            // ??
            case 74:
                return 8 + 1;
            // ??
            case 75:
                return 6 + 1;
            // ??
            case 78:
                return 0 + 1;
            // ??
            case 79:
                return 6 + 1;
            // ??
            case 85:
                return 1 + 1;
            // Camera movement
            case 86:
                return 4 + 1;
            // ??
            case 87:
                return 4 + 1;
            // Sent when player changes privacy option (like public chat etc.)
            case 95:
                return 3 + 1;
            // ??
            case 101:
                return 13 + 1;
            // ??
            case 117:
                return 6 + 1;
            // ??
            case 120:
                return 1 + 1;
            // Region loading finished - responds to 73
            case 121:
                return 0 + 1;
            // ??
            case 122:
                return 6 + 1;
            // ??
            case 128:
                return 2 + 1;
            // ??
            case 129:
                return 6 + 1;
            // Closes interface
            case 130:
                return 0 + 1;

            case 131:
                return 2 + 1;
            case 132:
                return 2 + 1;
            case 133:
                return 8 + 1;
            case 135:
                return 6 + 1;

            // Anti cheat stuff
            case 136:
                return 0 + 1;

            case 139:
                return 2 + 1;
            case 145:
                return 6 + 1;
            case 148:
                return 0 + 1;
            case 150:
                return 0 + 1;

            // More anti cheat stuff
            case 152 + 1:
                return 1 + 1;

            case 153:
                return 2 + 1;
            case 155:
                return 2 + 1;
            case 156:
                return 6 + 1;
            case 181:
                return 8 + 1;


            // In-game button clicked
            case 185:
                return 2 + 1;

            case 188:
                return 8 + 1;
            case 189:
                return 1 + 1;
            case 192:
                return 12 + 1;
            case 200:
                return 2 + 1;


            // Idle logout
            case 202:
                return 0 + 1;

            case 208:
                return 4 + 1;

            // Region change
            case 210:
                return 4 + 1;

            case 214:
                return 7 + 1;

            // Sent when a player reports another player
            case 218:
                return 8 + 1;

            case 228:
                return 6 + 1;
            case 230:
                return 1 + 1;
            case 234:
                return 6 + 1;
            case 236:
                return 6 + 1;
            case 237:
                return 10 + 1;
            case 238:
                return 1 + 1;
            case 240:
                return 4 + 1;

            // Mouse click anywhere on game screen
            case 241:
                return 4 + 1;
            // Biiiig anti cheat one - this is actually variable in my findings
            case 246:
                return 15 + 1;

            case 249:
                return 4 + 1;
            case 252:
                return 6 + 1;
            case 253:
                return 6 + 1;

            default:
                return 0 + 1;
        }
    }

}
