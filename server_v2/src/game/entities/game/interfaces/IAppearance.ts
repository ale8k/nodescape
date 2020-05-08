import IEquipment from "./IEquipment";
import IBodyColours from "./IBodyColours";

type genderId = 0 | 1;
type headIconId = 0 | 1 | 2;

export default interface IAppearance {
    gender: genderId;
    headIcon: headIconId;
    equipment: IEquipment;
    bodyColours: IBodyColours;
}



