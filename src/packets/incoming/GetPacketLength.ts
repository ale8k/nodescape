/**
 * Returns packet length for a given [decrypted] opcode
 * The return will differ between fixed and variable packets
 * @param opcode the [decrypted] opcode
 * @author ale8k
 */
export default function GetPacketLength(opcode: number): number {
  /**
   * Fixed packet check
   */
  switch (opcode) {
    // Idle packet
    case 0:
      return 0;
    // Focus change
    case 3:
      return 1;
    // Anti-cheat (validates walking...?)
    case 36:
      return 4;
    // Flagged account
    case 45:
      return 1;
    // Typing on an interface
    case 60:
      return 1;
    // Camera movement
    case 86:
      return 4;
    // Region loading finished - responds to 73
    case 121:
      return 0;
    // Closes interface
    case 130:
      return 0;
    // Anti cheat stuff
    case 136:
      return 0;
    // More anti cheat stuff
    case 152:
      return 1;
    // In-game button clicked
    case 185:
      return 2;
    // Idle logout
    case 202:
      return 0;
    // Region change
    case 210:
      return 0;
    // Mouse click anywhere on game screen
    case 241:
      return 4;
    // Biiiig anti cheat one
    case 246:
      return 15;
    default:
      return 0;
  }
}
