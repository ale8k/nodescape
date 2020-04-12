/**
 * Returns packet fixed length for a given [decrypted] opcode
 * @param opcode the [decrypted] opcode
 * @author ale8k
 */
export default function GetFixedPacketLength(opcode: number): number {
  /**
   * Fixed packet check
   * The + 1 is for the opcode
   */
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
      return 1 + 1;
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
    // Sent when player equips item
    case 41:
      return 6 + 1;
    // Flagged account
    case 45:
      return 1 + 1;
    // Typing on an interface
    case 60:
      return 1 + 1;
    // Camera movement
    case 86:
      return 4 + 1;
    // Sent when player changes privacy option (like public chat etc.)
    case 95:
      return 3 + 1;
    // Region loading finished - responds to 73
    case 121:
      return 0 + 1;
    // Closes interface
    case 130:
      return 0 + 1;
    // Anti cheat stuff
    case 136:
      return 0 + 1;
    // More anti cheat stuff
    case 152 + 1:
      return 1 + 1;
    // In-game button clicked
    case 185:
      return 2 + 1;
    // Idle logout
    case 202:
      return 0 + 1;
    // Region change
    case 210:
      return 4 + 1;
    // Sent when a player reports another player
    case 218:
      return 8 + 1;
    // Mouse click anywhere on game screen
    case 241:
      return 4 + 1;
    // Biiiig anti cheat one
    case 246:
      return 15 + 1;
    default:
      return 0 + 1;
  }
}
