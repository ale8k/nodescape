
 import { setBit } from "../utils";
 /**
                         * 81: Initialise player
                         */
                        b = Buffer.from([0, 0, 0, 0, 0, 0, 0, 0]);
                        b[0] = 81 + this.outStreamCryption.getNextKey();
                        // Packet size, VARIABLE_SIZE : SHORT
                        // Acts as a placeholder until we know our packet size
                        // either 5 or includes this (i.e., 5 + 2 + 1)
                        b[1] = 0;
                        b[2] = 5;

                        /**
                         * Our player movements: client method117
                         */
                        // update our player or not
                        this.setBit(b, 3, 7, 1);

                        // Movement type
                        this.setBit(b, 3, 6, 0);
                        this.setBit(b, 3, 5, 0);

                        /**
                         * Other player movements: client method134
                         * We skip this currently as there is no other players to update
                         */
                        // how many 'other' players to update
                        this.setBit(b, 3, 4, 0);
                        this.setBit(b, 3, 3, 0);
                        this.setBit(b, 3, 2, 0);
                        this.setBit(b, 3, 1, 0);
                        this.setBit(b, 3, 0, 0);
                        this.setBit(b, 4, 7, 0);
                        this.setBit(b, 4, 6, 0);
                        this.setBit(b, 4, 5, 0);

                        /**
                         * Player list updating: client method91
                         */
                        // 11 bit value representing next player in the update list
                        // the client checks if this exists, if it does, it'll update appearance
                        // for this player next
                        this.setBit(b, 4, 4, 0);
                        this.setBit(b, 4, 3, 0);
                        this.setBit(b, 4, 2, 0);
                        this.setBit(b, 4, 1, 0);
                        this.setBit(b, 4, 0, 0);
                        this.setBit(b, 5, 7, 0);
                        this.setBit(b, 5, 6, 0);
                        this.setBit(b, 5, 5, 0);
                        this.setBit(b, 5, 4, 0);
                        this.setBit(b, 5, 3, 0);
                        this.setBit(b, 5, 2, 1);

                        // Appearance updating, can't do this cause it's null... wtf lol.

                        // Location updating starts here

                        // think this tells client if it had a chunk in the update list,
                        // imma just say yeah for now lol
                        this.setBit(b, 5, 1, 0);

                        // clear awaiting point queue, like when teleing. (no)
                        this.setBit(b, 5, 0, 0);

                        // x coord
                        this.setBit(b, 6, 7, 0);
                        this.setBit(b, 6, 6, 0);
                        this.setBit(b, 6, 5, 1);
                        this.setBit(b, 6, 4, 1);
                        this.setBit(b, 6, 3, 1);
                        // y coord
                        this.setBit(b, 6, 2, 0);
                        this.setBit(b, 6, 1, 0);
                        this.setBit(b, 6, 0, 1);
                        this.setBit(b, 7, 7, 1);
                        this.setBit(b, 7, 6, 1);

                        socket.write(b);
