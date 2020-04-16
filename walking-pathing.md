A post I written on Rune-server with my findings and question.

So I'm working on pathing for the server I've started writing (I've never looked at the RS clients before this!) and the bytes it sends back in packet 164 I noticed only come when an object is in the way, so I presumed these might be co-ordinates for us to linearly step to.

I tested this by starting at 20,34 (x,y) as our co-ords at 3200,3200 base.
Clicked 1 tile north (opposite side of the wall)

So, I went through each co-ord given back by 164:
In the client, each one of these bytes is waypoint x/y - x/y (does one for each)
So I did this: (bytex + ourx & 0xff), (bytey + oury & 0xff)

3, 253, (3 + 20 & 0xff, 253 + 34 & 0xff) (23, 31)
3, 248, (3 + 20 & 0xff, 248 + 34 & 0xff) (23, 26)
6, 245, (6 + 20 & 0xff, 245 + 34 & 0xff) (26, 23)
8, 245, (8 + 20 & 0xff, 245 + 34 & 0xff) (28, 23)
9, 244, (9 + 20 & 0xff, 244 + 34 & 0xff) (29, 22)
12, 244, (12 + 20 & 0xff, 244 + 34 & 0xff) (32, 22)
12, 255, (12 + 20 & 0xff, 255 + 34 & 0xff) (32, 33)
10, 1, (10 + 20 & 0xff, 1 + 34 & 0xff) (30, 35)
9, 1, (9 + 20 & 0xff, 1 + 34 & 0xff) (29, 35)
7, 3, (7 + 20 & 0xff, 3 + 34 & 0xff) (27, 37)
6, 3, (6 + 20 & 0xff, 3 + 34 & 0xff) (26, 37)
3, 6, (3 + 20 & 0xff, 6 + 34 & 0xff) (23, 40)
0, 6, (0 + 20 & 0xff, 6 + 34 & 0xff) (20, 40)
0, 4 (0 + 20 & 0xff, 4 + 34 & 0xff) (20, 38)


So I plotted these on the map and uhh, it's kind of right but not right IIRC Runescape correctly? It steps through a wall
at some point...

[url=https://ibb.co/GHgB2zg][img]https://i.ibb.co/FHGNwRG/Capture.png[/img][/url]

I noticed it all looks roughly 3 squares off on the y axis. So I tried it again with all the same co-ords
but y - 3. Is this what I should be doing? According to that map I seem to be stepping through trees
a few times too... (turns out this explv isn't the same map so we're ok here, the -3 works. but why?)

[url=https://imgbb.com/][img]https://i.ibb.co/1sMXs1Z/y-3.png[/img][/url]
  
The only explanation I can find is outgoing.writeByte(waypointCount + waypointCount + 3); in the client.
I just presumed the +3 was for the weird neg byte on the end and w/e else this crazy method is doing lol.

Any help would be greatly appreciated!