# NodeScape
A Runescape private server written in JavaScript running on the NodeJS chromium based engine.

# Resources used
I used a number of resources to get this running:

- https://explv.github.io/
- Graham from rune-server.ee: https://www.rune-server.ee/runescape-development/rs2-server/help/691785-player-update-protocol-could-use-little-guidance-p.html
- https://rsps.fandom.com/wiki/Data_Types
- https://rsps.fandom.com/wiki/317_Protocol
- Accidental cycle discovery: https://www.rune-server.ee/runescape-development/rs2-server/help/692079-opcode-decryption-how-approach.html
- Block-flag discovery: https://www.rune-server.ee/runescape-development/rs2-server/help/692068-block-flag-based-updating-0x10-render-failing.html
- Manually going through the client for packet sizes: https://www.rune-server.ee/runescape-development/rs2-server/informative-threads/692158-317-client-server-packet-list.html
- Update list mask consideration: https://www.rune-server.ee/runescape-development/rs2-server/help/692560-player-list-updating-should-consider-masks-loop.html

# Tests
This project used Jest as the testing framework, coupled with ts-jest to enable strict type checks.
Rather than a traditional test of each unit function, you'll notice the tests only apply to critical functions relating
to the player. It is designed this way because we cannot test another players end-result. 

To run the tests, simply run in node: 
```
npm run test
```

# Further queries?
If you'd like to contribute or have any further queries, please feel free to join my discord server / GitHub org, [DevIsle](https://discord.gg/UN24d99 "DevIsle Discord invite").