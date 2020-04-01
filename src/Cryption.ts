/*
 * TODO: Refactor this file extensively, it sucks
 */
export default class Cryption {
    private keyArrayIdx: number = 0;
    private keySetArray: number[];
    private cryptArray: number[];
    private cryptVar1: number = 0;
    private cryptVar2: number = 0;
    private cryptVar3: number = 0;

    constructor(ai: number[]) {
        console.log("Cryption class initialised");
        this.cryptArray = new Array<number>(256).fill(0);
        this.keySetArray = new Array<number>(256).fill(0);
        this.keyArrayIdx = 256;

        for(let i: number = 0; i < ai.length; i++) {{
            this.keySetArray[i] = ai[i];
        }}

        this.initializeKeySet();
    }

    public getNextKey(): number {
        //console.log("Cryption key generated");
        if(this.keyArrayIdx-- === 0) {
            this.generateNextKeySet();
            this.keyArrayIdx = 255;
        }
        return this.keySetArray[this.keyArrayIdx];
    }

    private generateNextKeySet(): void {
        this.cryptVar2 += ++this.cryptVar3;
        for(let i: number = 0; i < 256; i++) {{
            const j: number = this.cryptArray[i];

            if((i & 3) === 0) {
                this.cryptVar1 ^= this.cryptVar1 << 13;
            } else if((i & 3) === 1) {
                this.cryptVar1 ^= this.cryptVar1 >>> 6;
            } else if((i & 3) === 2) {
                this.cryptVar1 ^= this.cryptVar1 << 2;
            } else if((i & 3) === 3) {
                this.cryptVar1 ^= this.cryptVar1 >>> 16;
            }

            this.cryptVar1 += this.cryptArray[i + 128 & 255];
            let k: number;
            this.cryptArray[i] = k = this.cryptArray[(j & 1020) >> 2] + this.cryptVar1 + this.cryptVar2;
            this.keySetArray[i] = this.cryptVar2 = this.cryptArray[(k >> 8 & 1020) >> 2] + j;
        }}
    }

    public initializeKeySet(): void {
        let i1: number;
        let j1: number;
        let k1: number;
        let l1: number;
        let i2: number;
        let j2: number;
        let k2: number;
        // if any troubles, replace for -1640531527(signed) / 2654435769(unsigned) / 0x9e3779b9(hexa)
        let l: number = i1 = j1 = k1 = l1 = i2 = j2 = k2 = 0x9e3779b9;

        for(let i = 0; i < 4; i++) {
            l ^= i1 << 11;
            k1 += l;
            i1 += j1;
            i1 ^= j1 >>> 2;
            l1 += i1;
            j1 += k1;
            j1 ^= k1 << 8;
            i2 += j1;
            k1 += l1;
            k1 ^= l1 >>> 16;
            j2 += k1;
            l1 += i2;
            l1 ^= i2 << 10;
            k2 += l1;
            i2 += j2;
            i2 ^= j2 >>> 4;
            l += i2;
            j2 += k2;
            j2 ^= k2 << 8;
            i1 += j2;
            k2 += l;
            k2 ^= l >>> 9;
            j1 += k2;
            l += i1;
        }

        for(let j = 0; j < 256; j += 8) {
            l += this.keySetArray[j];
            i1 += this.keySetArray[j + 1];
            j1 += this.keySetArray[j + 2];
            k1 += this.keySetArray[j + 3];
            l1 += this.keySetArray[j + 4];
            i2 += this.keySetArray[j + 5];
            j2 += this.keySetArray[j + 6];
            k2 += this.keySetArray[j + 7];
            l ^= i1 << 11;
            k1 += l;
            i1 += j1;
            i1 ^= j1 >>> 2;
            l1 += i1;
            j1 += k1;
            j1 ^= k1 << 8;
            i2 += j1;
            k1 += l1;
            k1 ^= l1 >>> 16;
            j2 += k1;
            l1 += i2;
            l1 ^= i2 << 10;
            k2 += l1;
            i2 += j2;
            i2 ^= j2 >>> 4;
            l += i2;
            j2 += k2;
            j2 ^= k2 << 8;
            i1 += j2;
            k2 += l;
            k2 ^= l >>> 9;
            j1 += k2;
            l += i1;
            this.cryptArray[j] = l;
            this.cryptArray[j + 1] = i1;
            this.cryptArray[j + 2] = j1;
            this.cryptArray[j + 3] = k1;
            this.cryptArray[j + 4] = l1;
            this.cryptArray[j + 5] = i2;
            this.cryptArray[j + 6] = j2;
            this.cryptArray[j + 7] = k2;
        }

        for(let k = 0; k < 256; k += 8) {
            l += this.cryptArray[k];
            i1 += this.cryptArray[k + 1];
            j1 += this.cryptArray[k + 2];
            k1 += this.cryptArray[k + 3];
            l1 += this.cryptArray[k + 4];
            i2 += this.cryptArray[k + 5];
            j2 += this.cryptArray[k + 6];
            k2 += this.cryptArray[k + 7];
            l ^= i1 << 11;
            k1 += l;
            i1 += j1;
            i1 ^= j1 >>> 2;
            l1 += i1;
            j1 += k1;
            j1 ^= k1 << 8;
            i2 += j1;
            k1 += l1;
            k1 ^= l1 >>> 16;
            j2 += k1;
            l1 += i2;
            l1 ^= i2 << 10;
            k2 += l1;
            i2 += j2;
            i2 ^= j2 >>> 4;
            l += i2;
            j2 += k2;
            j2 ^= k2 << 8;
            i1 += j2;
            k2 += l;
            k2 ^= l >>> 9;
            j1 += k2;
            l += i1;
            this.cryptArray[k] = l;
            this.cryptArray[k + 1] = i1;
            this.cryptArray[k + 2] = j1;
            this.cryptArray[k + 3] = k1;
            this.cryptArray[k + 4] = l1;
            this.cryptArray[k + 5] = i2;
            this.cryptArray[k + 6] = j2;
            this.cryptArray[k + 7] = k2;
        }

        this.generateNextKeySet();
    }
}


