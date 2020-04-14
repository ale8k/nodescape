import { Socket } from "net";

/**
 * Sets the skill level of a given skill, including the current xp
 * By skill level, it means the increases given by pots etc.
 * @param key next isaac gen
 * @param socket the socket
 * @author ale8k
 */
export default function SetSkillLevelAndXp134(key: number, socket: Socket, skillId: number, skillXp: number, skillLevel: number): void {
    const b = Buffer.alloc(7);
    b[0] = 134 + key;
    b[1] = skillId;
    // the client reads skill xp updates like this
    b[2] = (skillXp >> 8);
    b[3] = (skillXp);
    b[4] = (skillXp >> 24);
    b[5] = (skillXp >> 16);
    // skill level?
    b[6] = skillLevel;
    socket.write(b);
}
