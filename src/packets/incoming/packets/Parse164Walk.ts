
// First, decrypt X
// X gives 2 bytes,
// Byte1 and Byte2

// (Byte2 & 0xff) << 8 = val1, Byte1 - 128 & 0xff = val2
// val1 + val2 = x base + co-ords

// For Y, take Byte1 from X and use it as
// val2 for Y
// Byte1 of Y do (Byte1 & 0xff) << 8

// Now we have y base + co-ords

// Hopefully this works.......

//   250,  5, 200, 10,
//    72, 14,   0,  4

//      244,  5, 200, 10,
//    72, 14,   0

//   As for the occasional random thing on the end..
//   Idk wtf we gonna do!
//   but we do have the length, so we'll parse this but as for the next byte it can add
//   not sure how we gonna handle this ? maybe turn it off in the client
export default function Parse164Walk(length: number, cacheBuffer: number[]) {
    console.log("Packet 164 come through!");
    console.log("His length is", length);
}
