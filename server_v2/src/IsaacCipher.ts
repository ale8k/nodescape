/* Generated from Java with JSweet 2.2.0-SNAPSHOT - http://www.jsweet.org */
export default class IsaacCipher {
    private accumulator: number = 0;
    private count: number = 0;
    private counter: number = 0;
    private last: number = 0;
    private memory: number[] = [];
    private results: number[] = [];

    public constructor(seed: number[]) {
        this.memory = new Array<number>(256).fill(0);
        this.results = new Array<number>(256).fill(0);
        for (let index: number = 0; index < seed.length; index++) {
            this.results[index] = seed[index];
        }
        this.init();
    }

    public nextKey(): number {
        if (this.count-- === 0) {
            this.isaac();
            this.count = 255;
        }
        return this.results[this.count];
    }

    private init(): void {
        let i1: number;
        let j1: number;
        let k1: number;
        let l1: number;
        let i2: number;
        let j2: number;
        let k2: number;
        let l: number;
        l = i1 = j1 = k1 = l1 = i2 = j2 = k2 = -1640531527;
        for (let i: number = 0; i < 4; i++) {
            {
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
        }
        for (let j: number = 0; j < 256; j += 8) {
            {
                l += this.results[j];
                i1 += this.results[j + 1];
                j1 += this.results[j + 2];
                k1 += this.results[j + 3];
                l1 += this.results[j + 4];
                i2 += this.results[j + 5];
                j2 += this.results[j + 6];
                k2 += this.results[j + 7];
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
                this.memory[j] = l;
                this.memory[j + 1] = i1;
                this.memory[j + 2] = j1;
                this.memory[j + 3] = k1;
                this.memory[j + 4] = l1;
                this.memory[j + 5] = i2;
                this.memory[j + 6] = j2;
                this.memory[j + 7] = k2;
            }
        }
        for (let k: number = 0; k < 256; k += 8) {
            {
                l += this.memory[k];
                i1 += this.memory[k + 1];
                j1 += this.memory[k + 2];
                k1 += this.memory[k + 3];
                l1 += this.memory[k + 4];
                i2 += this.memory[k + 5];
                j2 += this.memory[k + 6];
                k2 += this.memory[k + 7];
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
                this.memory[k] = l;
                this.memory[k + 1] = i1;
                this.memory[k + 2] = j1;
                this.memory[k + 3] = k1;
                this.memory[k + 4] = l1;
                this.memory[k + 5] = i2;
                this.memory[k + 6] = j2;
                this.memory[k + 7] = k2;
            }
        }
        this.isaac();
        this.count = 256;
    }

    private isaac(): void {
        this.last += ++this.counter;
        for (let index: number = 0; index < 256; index++) {
            {
                const mem: number = this.memory[index];
                if ((index & 3) === 0) {
                    this.accumulator ^= this.accumulator << 13;
                } else if ((index & 3) === 1) {
                    this.accumulator ^= this.accumulator >>> 6;
                } else if ((index & 3) === 2) {
                    this.accumulator ^= this.accumulator << 2;
                } else if ((index & 3) === 3) {
                    this.accumulator ^= this.accumulator >>> 16;
                }
                this.accumulator += this.memory[index + 128 & 255];
                this.memory[index] = this.memory[(mem & 1020) >> 2] + this.accumulator + this.last;
                this.results[index] = this.last = this.memory[(this.memory[index] >> 8 & 1020) >> 2] + mem;
            }
        }
    }
}
