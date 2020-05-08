import IEquipment from "./IEquipment";
import IBodyColours from "./IBodyColours";
import IAnimIndices from "./IAnimIndices";



/**
 * Represents a {@link localPlayer Player}'s .appearance; With the data pre-binary.
 * @author ale8k
 */
export default interface IAppearance {
    gender: genderId;
    headIcon: headIconId;
    equipment: IEquipment;
    bodyColours: IBodyColours;
    animIndices: IAnimIndices;
    playerName: string;
    combatLevel: combatLevelRange;
    skillLevel: skillLevelRange;
}

type genderId = 0 | 1;
type headIconId = 0 | 1 | 2;
// The range typing hasn't been resolved yet, so we're working with this...
// https://github.com/Microsoft/TypeScript/issues/15480
// I may try create something interesting for this as some point to decreate the literal
// size of this type lol.
type combatLevelRange =
3 | 4 | 5 | 6 | 7 | 8 | 9 | 10
| 11 | 12 | 13 | 14 | 15 | 16 | 17 | 18 | 19 | 20
| 21 | 22 | 23 | 24 | 25 | 26 | 27 | 28 | 29 | 30
| 31 | 32 | 33 | 34 | 35 | 36 | 37 | 38 | 39 | 40
| 41 | 42 | 43 | 44 | 45 | 46 | 47 | 48 | 49 | 50
| 51 | 52 | 53 | 54 | 55 | 56 | 57 | 58 | 59 | 60
| 61 | 62 | 63 | 64 | 65 | 66 | 67 | 68 | 69 | 70
| 71 | 72 | 73 | 74 | 75 | 77 | 77 | 78 | 79 | 80
| 81 | 82 | 83 | 84 | 85 | 88 | 87 | 88 | 89 | 90
| 91 | 92 | 93 | 94 | 95 | 99 | 97 | 98 | 99 | 100
| 101 | 102 | 103 | 104 | 105 | 106 | 107 | 108 | 109 | 110
| 111 | 112 | 113 | 114 | 115 | 116 | 117 | 118 | 119 | 120
| 121 | 122 | 123 | 124 | 125 | 126;
// Simply can't hardcode every possible skill level... There's got to be a way
type skillLevelRange = number;

