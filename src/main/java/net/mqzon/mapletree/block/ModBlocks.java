package net.mqzon.mapletree.block;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.block.custom.MapleLeavesBlock;
import net.mqzon.mapletree.particle.ModParticles;
import net.mqzon.mapletree.world.tree.ModSaplingGenerators;

public class ModBlocks {

    public static final Block MAPLE_SAPLING = registerBlock("maple_sapling",
            new SaplingBlock(ModSaplingGenerators.MAPLE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));
    public static final Block RED_MAPLE_SAPLING = registerBlock("red_maple_sapling",
            new SaplingBlock(ModSaplingGenerators.RED_MAPLE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block POTTED_MAPLE_SAPLING = registerBlockWithoutBlockItem("potted_maple_sapling",
            new FlowerPotBlock(MAPLE_SAPLING, AbstractBlock.Settings.copy(Blocks.POTTED_OAK_SAPLING)));
    public static final Block POTTED_RED_MAPLE_SAPLING = registerBlockWithoutBlockItem("potted_red_maple_sapling",
            new FlowerPotBlock(RED_MAPLE_SAPLING, AbstractBlock.Settings.copy(Blocks.POTTED_OAK_SAPLING)));

    public static final Block MAPLE_LEAVES = registerBlock("maple_leaves",
            new MapleLeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES), ModParticles.MAPLE_LEAVES_PARTICLE));
    public static final Block RED_MAPLE_LEAVES = registerBlock("red_maple_leaves",
            new MapleLeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES), ModParticles.RED_MAPLE_LEAVES_PARTICLE));

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
    public static final Block MAPLE_FENCE = registerBlock("maple_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE)));
    public static final Block MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)));
    public static final Block MAPLE_DOOR = registerBlock("maple_door",
            new DoorBlock(WoodType.OAK.setType(), AbstractBlock.Settings.copy(Blocks.OAK_DOOR)));
    public static final Block MAPLE_TRAPDOOR = registerBlock("maple_trapdoor",
            new TrapdoorBlock(WoodType.OAK.setType(),AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR)));
    public static final Block MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate",
            new PressurePlateBlock(WoodType.OAK.setType(), AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR)));
    public static final Block MAPLE_BUTTON = registerBlock("maple_button",
            new ButtonBlock(WoodType.OAK.setType(), 15, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)));

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(Mapletree.MOD_ID, name), block);
    }

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

        StrippableBlockRegistry.register(MAPLE_LOG, STRIPPED_MAPLE_LOG);
        StrippableBlockRegistry.register(MAPLE_WOOD, STRIPPED_MAPLE_WOOD);

        FlammableBlockRegistry FlammableBlocks = FlammableBlockRegistry.getDefaultInstance();
        FlammableBlocks.add(MAPLE_LEAVES, 30, 60);
        FlammableBlocks.add(RED_MAPLE_LEAVES, 30, 60);

        FlammableBlocks.add(MAPLE_LOG, 5, 5);
        FlammableBlocks.add(MAPLE_WOOD, 5, 5);
        FlammableBlocks.add(STRIPPED_MAPLE_LOG, 5, 5);
        FlammableBlocks.add(STRIPPED_MAPLE_WOOD, 5, 5);

        FlammableBlocks.add(MAPLE_PLANKS,5, 20);
        FlammableBlocks.add(MAPLE_SLAB,5, 20);
        FlammableBlocks.add(MAPLE_STAIRS,5, 20);
        FlammableBlocks.add(MAPLE_FENCE,5, 20);
        FlammableBlocks.add(MAPLE_FENCE_GATE,5, 20);
    }
}
