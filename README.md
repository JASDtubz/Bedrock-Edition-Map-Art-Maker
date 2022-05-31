<!--
    Copyright Loshun Ltd. 2022
    Updated Friday, May 20
    Version 1.1.0
-->

# Bedrock-Edition-Map-Art-Maker
For making map art in Minecraft Bedrock Edition

Run program using a javafx ide and then type the image location into the text box on the app. Then select your algorithm method and watch your map be converted to map art.

Do not copy this repository because nothing will happen. I did not create any dependencies and files that can help run the program quickly. Instead copy the java classes individually and to the right spots. (You need to know how JavaFX works in order to do this)

Join discord [link](https://discord.gg/Pv6agYuc4C) for help and to suggest more features!

There is also a browser version which is still in progress of being made at this [link](https://jasdtubz.github.io/Bedrock-Edition-Map-Art-Maker/html/).

Note that all version notes are to the JavaFX version.

## Version 0
### November 6, 2021
- Full version released.
- Image link requires perfect syntax.
- Dithering is not included.
- Chunk buttons start at 0.
- Uneditable palette.
  - Education edition blocks were used.
  - Experimental blocks such as "Sculk Block" were used.
- BlueJ version not perfect.
  - Status label not working.
  - Chunk text file not appearing consistently.

## Version 1
### March 19, 2022
- 2 Dithering algorithms were added.
- Function button added to create map using the /function command in Minecraft.
  - You have to manually copy and paste the created .mcfunction files to a behavior pack.
    - Make sure to do "/function make1" first then do "/function make2".
    - You need to know how to work with behavior packs.
  - Need to have Education edition and all Experimental features turned on.
  - You have to go to the southeastern corner of the map to do the functions.
- Added Spruce Leaves, Birch Leaves, Glow Lichen and Spruce Wood because they were forgotten.
- Removed Grass Block and Oak Leaves due to biome color changes.
  - Will be added later when checkbox for "Superflat" is added.
- Blocks.txt was appearing in the wrong orientation and was not fixed yet.
- Thinking of discontinuing the BlueJ version due to its weird compiling issues.

## Version 1.0
### April 5, 2022
- Fixed blocks.txt and is now displaying correctly.
- Replaced "fill" command with "setblock" command.
- Rows will adjust themselves to fit the build height in the function commands.
- Added Dripleaf because they were forgotten.

## Version 1.1
### May 31, 2022
- Added a block palete.
- Added a third dithering algorithm
  - This algorithm was not supposed to be added, but I kept it in anyways.
- Added a Version annotation and should be ignored.
- Entire code rewrite soon.
- Browser version on its way.
  - Added a program to find map chunks as a placeholder and for the full version.
