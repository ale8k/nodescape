/**
 * A static helper class which handles reading game packets
 * @author ale8k
 */
export default class PacketReader {
    /**
     * Returns packet length for a packet denoted with a byte declaring its length
     * @param packet the packet
     */
    private static getVarBytePacketLength(packet: number[]): number {
        // + 2 for opcode and sizing byte
        return packet[1] + 2;
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
                return 6 + 1;
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
