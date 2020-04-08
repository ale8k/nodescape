
// /**
//  * The initial converted wL code
//  */


// let b = Buffer.alloc(0);
// /**
//  * 73: Loads map region
//  * This actually takes the 8x8 of the 'zone', not the tile. A tile consists of 8x8 zones,
//  * a zone is 8x8 single tiles. So, we get a tile position relative to a zone.
//  *
//  *
//  * From Graham:
//  * 8x8 tiles = a zone. This is the granularity used in a bunch of packets
//  * (e.g. for sending ground items, projectiles, constructing dynamic/instanced maps, etc.)
//  * 64x64 tiles (or 8x8 zones) = a single map. This is the granularity used on disk in the cache.
//  * 104x104 tiles (or 13x13 zones) = the area that the client keeps in RAM at any one time.
//  *
//  * You'll also find +/- 6 calculations in some servers (and perhaps the client too) -
//  * this is because some code uses zone coordinates relative to the top left of the area,
//  * some relative to the centre.
//  * When the player is within 16 tiles of the edge the server sends the packet
//  * to reload the area around the player's current zone.
//  */
// b = Buffer.alloc(5);
// b[0] = 73 + this.outStreamCryption.getNextKey();
// // we need to write little endians here so we can suffix the second byte with
// // of the first co-ordinate short with +128 (the client removes this on client side)
// b[1] = 1;
// b[2] = 147 + 128;
// b.writeInt16BE(403, 3);
// socket.write(b);

// /**
//  * 81: Initialise player
//  */
// b = Buffer.alloc(9);
// b[0] = 81 + this.outStreamCryption.getNextKey();
// // Packet size, VARIABLE_SIZE : SHORT
// b.writeInt16BE(6, 1);

// // update our player or not
// setBit(b, 3, 7, 1);
// // VALUE: 3 - Type 3, update our players plane level
// setBit(b, 3, 6, 1);
// setBit(b, 3, 5, 1);
// // setting plane level here, 0-3 (we use 0 for now)
// setBit(b, 3, 4, 0);
// setBit(b, 3, 3, 0);
// // clear awaitig-point queue, i.e., remove our further steps left to do by client. Like when teleing
// setBit(b, 3, 2, 1);
// // is there an update required? (i.e., logged in, update our player)
// setBit(b, 3, 1, 1);
// // x
// setBit(b, 3, 0, 0);
// setBit(b, 4, 7, 0);
// setBit(b, 4, 6, 1);
// setBit(b, 4, 5, 0);
// setBit(b, 4, 4, 1);
// setBit(b, 4, 3, 0);
// setBit(b, 4, 2, 1);
// // y
// setBit(b, 4, 1, 0);
// setBit(b, 4, 0, 0);
// setBit(b, 5, 7, 1);
// setBit(b, 5, 6, 0);
// setBit(b, 5, 5, 1);
// setBit(b, 5, 4, 0);
// setBit(b, 5, 3, 1);
// // How many other players the client needs to update,
// // currently no multiplayer so none,
// // this will need some considerable thought lol
// setBit(b, 5, 2, 0);
// setBit(b, 5, 1, 0);
// setBit(b, 5, 0, 0);
// setBit(b, 6, 7, 0);
// setBit(b, 6, 6, 0);
// setBit(b, 6, 5, 0);
// setBit(b, 6, 4, 0);
// setBit(b, 6, 3, 0);
// // player list updating, not really sure here. Used wL's 2047 value
// setBit(b, 6, 2, 1);
// setBit(b, 6, 1, 1);
// setBit(b, 6, 0, 1);
// setBit(b, 7, 7, 1);
// setBit(b, 7, 6, 1);
// setBit(b, 7, 5, 1);
// setBit(b, 7, 4, 1);
// setBit(b, 7, 3, 1);
// setBit(b, 7, 2, 1);
// setBit(b, 7, 1, 1);
// setBit(b, 7, 0, 1);
// // initial player update done
// // b[8] is empty byte, without it packet is being rejected?
// socket.write(b);
