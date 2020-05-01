import BitWriter from "src/utils/write-data/BitWriter";

export default class Masks {
    /**
     * Writes the mask 0x10 into a BitWriter
     * @param maskData the data to append
     * @param bitWriter the bitWriter to write to
     * @param p81 a reference back to the packet81
     */
    public append0x10(maskData: number[], bitWriter: BitWriter): void {
        /**
         * DEBUG, GOING TO WRITE MASK ID MANUALLY
         */
        // bitWriter.writeNumber(0x10, 8);

        // Grabs the start bit index from which the byte
        // for the size is going to be written
        const startingSizeBitIndex = bitWriter.bufferLength;
        bitWriter.writeNumber(0, 8); // placeholder for the size

        let size = 0;

        maskData.forEach((value, i) => {
            switch (i) {
                case 0:
                case 1:
                    bitWriter.writeNumber(value, 8);
                    size += 1;
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    const armourType = value > 200 ? value + 0x200 : value + 0x100;
                    bitWriter.writeNumber(armourType, 16);
                    size += 2;
                    break;
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                    bitWriter.writeNumber(value, 8);
                    size += 1;
                    break;
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                    bitWriter.writeNumber(value, 16);
                    size += 2;
                    break;
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                    bitWriter.writeNumber(value, 8);
                    size += 1;
                    break;
                case 35:
                    bitWriter.writeNumber(value, 16);
                    size += 2;
                    break;
            }
        });
        // Not sure on our + 1 here, maybe the next mask?
        bitWriter.writeNumberOver((255 - size + 1), 8, startingSizeBitIndex);
        console.log("MASK SIZE IS: ", size);
    }

}
