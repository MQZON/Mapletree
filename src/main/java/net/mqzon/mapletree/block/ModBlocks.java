package net.mqzon.mapletree.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mqzon.mapletree.Mapletree;

public class ModBlocks {

    public static final Block MAPLE_LEAVES = registerBlock("maple_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));

    public static final Block MAPLE_LOG = registerBlock("maple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).requiresTool()));
    public static final Block MAPLE_WOOD = registerBlock("maple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).requiresTool()));
    public static final Block STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).requiresTool()));
    public static final Block STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).requiresTool()));

    public static final Block MAPLE_PLANKS = registerBlock("maple_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).requiresTool()));


    public static final Block MAPLE_SLAB = registerBlock("maple_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));

    public static final Block MAPLE_STAIRS = registerBlock("maple_stairs",
            new StairsBlock(MAPLE_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Mapletree.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Mapletree.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Mapletree.LOGGER.info("Registering Mod Blocks for " +Mapletree.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.MAPLE_LEAVES); // Todo: Create custom item group
            entries.add(ModBlocks.MAPLE_LOG);
            entries.add(ModBlocks.MAPLE_WOOD);
            entries.add(ModBlocks.STRIPPED_MAPLE_LOG);
            entries.add(ModBlocks.STRIPPED_MAPLE_WOOD);
            entries.add(ModBlocks.MAPLE_PLANKS);
            entries.add(ModBlocks.MAPLE_SLAB);
            entries.add(ModBlocks.MAPLE_STAIRS);
        });

        StrippableBlockRegistry.register(MAPLE_LOG, STRIPPED_MAPLE_LOG);
        StrippableBlockRegistry.register(MAPLE_WOOD, STRIPPED_MAPLE_WOOD);

        FlammableBlockRegistry FlammableBlocks = FlammableBlockRegistry.getDefaultInstance();
        FlammableBlocks.add(MAPLE_LEAVES, 30, 60);

        FlammableBlocks.add(MAPLE_LOG, 5, 5);
        FlammableBlocks.add(MAPLE_WOOD, 5, 5);
        FlammableBlocks.add(STRIPPED_MAPLE_LOG, 5, 5);
        FlammableBlocks.add(STRIPPED_MAPLE_WOOD, 5, 5);

        FlammableBlocks.add(MAPLE_PLANKS,5, 20);
        FlammableBlocks.add(MAPLE_SLAB,5, 20);
        FlammableBlocks.add(MAPLE_STAIRS,5, 20);
    }
}
