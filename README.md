This mod adds maple trees to minecraft.  
**Preview**
![Mapletree](https://github.com/MQZON/Mapletree/blob/master/images/Mapletree_preview.png?raw=true)

Maple trees can be obtained by purchasing a sapling from a wandering trader, or through the Mapletree creative mode tab.
Maple can be used as a regular wood type for all wood items.

![Maple Sapling Trade](https://github.com/MQZON/Mapletree/blob/master/images/Maple_Sapling_Trade.png?raw=true)
![Red Maple Sapling Trade](https://github.com/MQZON/Mapletree/blob/master/images/Red_Maple_Sapling_Trade.png?raw=true)

Maple Leaves can also be crafted into Maple Leaf Piles. 
Leaf Piles act like snow layers, allowing you to place up to eight layers within a block space. 
Leaf Piles make a nice crunchy sound when you walk on them, and reduce fall damage like Hay Bales when you fall on three or more layers.

<details>
<summary>Leaf Pile Recipes (all are shapeless)</summary>
   
   ![Maple Leaf Pile Recipe](https://github.com/MQZON/Mapletree/blob/master/images/Maple_Leaf_Pile_Recipe.png?raw=true)  
   ![Maple Leaf Recipe](https://github.com/MQZON/Mapletree/blob/master/images/Maple_Leaf_Recipe.png?raw=true)  
   ![Red Maple Leaf Pile Recipe](https://github.com/MQZON/Mapletree/blob/master/images/Red_Maple_Leaf_Pile_Recipe.png?raw=true)  
   ![Red Maple Leaf Recipe](https://github.com/MQZON/Mapletree/blob/master/images/Red_Maple_Leaf_Recipe.png?raw=true)  
</details>

Maple trees can also be used to obtain Syrup and syrupy foods!
You can right-click on a Maple Log with a bucket* to obtain a Sap Bucket.
Sap can then be evaporated into Syrup by placing three buckets into a cauldron that is directly over a heat source.
Heat sources include Lava, Magma, Fires & Campfires (regular or soul variants).
After a little while the Sap will evaporate into Syrup, which can be collected with a Glass Bottle.

Once you have collected some Syrup, you can either consume it directly (like Honey) or use it to craft some delicious new syrupy foods. 
All syrupy foods, Syrup Bottles included, will grant the Saturation effect for a short time.
The Saturation effect restores additional hunger and saturation points, making these foods quite powerful!

*This process may change in the future to be a bit less silly. 

<details>
<summary>Food Recipes (all are shapeless)</summary>

   ![Glazed Carrots Recipe](https://github.com/MQZON/Mapletree/blob/master/images/Glazed_Carrots_Recipe.png?raw=true)  
   ![Glazed Salmon Recipe](https://github.com/MQZON/Mapletree/blob/master/images/Glazed_Salmon_Recipe.png?raw=true)
   ![Pancakes Recipe](https://github.com/MQZON/Mapletree/blob/master/images/Pancakes_Recipe.png?raw=true)
</details>

Source installation information for modders
-------------------------------------------
This code follows the Minecraft Forge installation methodology. It will apply
some small patches to the vanilla MCP source code, giving you and it access 
to some of the data and functions you need to build a successful mod.

Note also that the patches are built against "un-renamed" MCP source code (aka
SRG Names) - this means that you will not be able to read them directly against
normal code.

Setup Process:
==============================

Step 1: Open your command-line and browse to the folder where you extracted the zip file.

Step 2: You're left with a choice.
If you prefer to use Eclipse:
1. Run the following command: `gradlew genEclipseRuns` (`./gradlew genEclipseRuns` if you are on Mac/Linux)
2. Open Eclipse, Import > Existing Gradle Project > Select Folder 
   or run `gradlew eclipse` to generate the project.

If you prefer to use IntelliJ:
1. Open IDEA, and import project.
2. Select your build.gradle file and have it import.
3. Run the following command: `gradlew genIntellijRuns` (`./gradlew genIntellijRuns` if you are on Mac/Linux)
4. Refresh the Gradle Project in IDEA if required.

If at any point you are missing libraries in your IDE, or you've run into problems you can 
run `gradlew --refresh-dependencies` to refresh the local cache. `gradlew clean` to reset everything 
{this does not affect your code} and then start the process again.

Mapping Names:
=============================
By default, the MDK is configured to use the official mapping names from Mojang for methods and fields 
in the Minecraft codebase. These names are covered by a specific license. All modders should be aware of this
license, if you do not agree with it you can change your mapping names to other crowdsourced names in your 
build.gradle. For the latest license text, refer to the mapping file itself, or the reference copy here:
https://github.com/MinecraftForge/MCPConfig/blob/master/Mojang.md

Additional Resources: 
=========================
Community Documentation: https://mcforge.readthedocs.io/en/latest/gettingstarted/  
LexManos' Install Video: https://www.youtube.com/watch?v=8VEdtQLuLO0  
Forge Forum: https://forums.minecraftforge.net/  
Forge Discord: https://discord.gg/UvedJ9m  
