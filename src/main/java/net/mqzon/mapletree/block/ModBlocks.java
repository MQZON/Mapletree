package net.mqzon.mapletree.block;

import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.block.custom.*;
import net.mqzon.mapletree.particle.ModParticles;
import net.mqzon.mapletree.util.ModCauldronBehaviors;
import net.mqzon.mapletree.world.tree.ModSaplingGenerators;

public class ModBlocks {

    public static final Block MAPLE_SAPLING = registerBlock("maple_sapling",
            new SaplingBlock(ModSaplingGenerators.MAPLE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "maple_sapling")))
                    .mapColor(MapColor.ORANGE)));
    public static final Block RED_MAPLE_SAPLING = registerBlock("red_maple_sapling",
            new SaplingBlock(ModSaplingGenerators.RED_MAPLE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "red_maple_sapling")))
                    .mapColor(MapColor.RED)));

    public static final Block MAPLE_LEAF_PILE = registerBlock("maple_leaf_pile",
            new LeafPileBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.ORANGE)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "maple_leaf_pile")))
                    .sounds(LeafPileBlock.LeafPileSounds)));
    public static final Block RED_MAPLE_LEAF_PILE = registerBlock("red_maple_leaf_pile",
            new LeafPileBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.RED)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "red_maple_leaf_pile")))
                    .sounds(LeafPileBlock.LeafPileSounds)));

    public static final Block POTTED_MAPLE_SAPLING = registerBlockWithoutBlockItem("potted_maple_sapling",
            new FlowerPotBlock(MAPLE_SAPLING, AbstractBlock.Settings.copy(Blocks.POTTED_OAK_SAPLING)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "potted_maple_sapling")))
            ));
    public static final Block POTTED_RED_MAPLE_SAPLING = registerBlockWithoutBlockItem("potted_red_maple_sapling",
            new FlowerPotBlock(RED_MAPLE_SAPLING, AbstractBlock.Settings.copy(Blocks.POTTED_OAK_SAPLING)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "potted_red_maple_sapling")))
            ));

    public static final Block MAPLE_LEAVES = registerBlock("maple_leaves",
            new ParticleLeavesBlock(50,ModParticles.MAPLE_LEAVES_PARTICLE, AbstractBlock.Settings.copy(Blocks.PALE_OAK_LEAVES)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "maple_leaves")))
                    .mapColor(MapColor.ORANGE)));
    public static final Block RED_MAPLE_LEAVES = registerBlock("red_maple_leaves",
            new ParticleLeavesBlock(50, ModParticles.RED_MAPLE_LEAVES_PARTICLE, AbstractBlock.Settings.copy(Blocks.PALE_OAK_LEAVES)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "red_maple_leaves")))
                    .mapColor(MapColor.RED)));

    public static final Block MAPLE_LOG = registerBlock("maple_log",
            new MapleLog(AbstractBlock.Settings.copy(Blocks.OAK_LOG).mapColor(MapColor.OAK_TAN)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "maple_log")))
            ));
    public static final Block MAPLE_WOOD = registerBlock("maple_wood",
            new MapleLog(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).mapColor(MapColor.OAK_TAN)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "maple_wood")))
            ));
    public static final Block STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
            new MapleLog(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.OAK_TAN)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "stripped_maple_log")))
            ));
    public static final Block STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
            new MapleLog(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.OAK_TAN)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "stripped_maple_wood")))
            ));

    public static final Block MAPLE_PLANKS = registerBlock("maple_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "maple_planks")))
                    .mapColor(MapColor.TERRACOTTA_WHITE)));

    public static final Block MAPLE_SLAB = registerBlock("maple_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB).mapColor(MapColor.TERRACOTTA_WHITE)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "maple_slab")))
            ));
    public static final Block MAPLE_STAIRS = registerBlock("maple_stairs",
            new StairsBlock(MAPLE_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "maple_stairs")))
                    .mapColor(MapColor.TERRACOTTA_WHITE)
            ));
    public static final Block MAPLE_FENCE = registerBlock("maple_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE).mapColor(MapColor.TERRACOTTA_WHITE)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "maple_fence")))
            ));
    public static final Block MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
            new FenceGateBlock(WoodType.OAK,
                    AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.TERRACOTTA_WHITE)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "maple_fence_gate")))
            ));
    public static final Block MAPLE_DOOR = registerBlock("maple_door",
            new DoorBlock(WoodType.OAK.setType(),
                    AbstractBlock.Settings.copy(Blocks.OAK_DOOR).mapColor(MapColor.TERRACOTTA_WHITE)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "maple_door")))
            ));
    public static final Block MAPLE_TRAPDOOR = registerBlock("maple_trapdoor",
            new TrapdoorBlock(WoodType.OAK.setType(), AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "maple_trapdoor")))
                    .mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final Block MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate",
            new PressurePlateBlock(WoodType.OAK.setType(), AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "maple_pressure_plate")))
                    .mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final Block MAPLE_BUTTON = registerBlock("maple_button",
            new ButtonBlock(WoodType.OAK.setType(), 15, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "maple_button")))
                    .mapColor(MapColor.TERRACOTTA_WHITE)));

    public static final Identifier MAPLE_SIGN_TEXTURE = Identifier.of(Mapletree.MOD_ID, "boat/signs/maple");
    public static final Identifier MAPLE_HANGING_SIGN_TEXTURE = Identifier.of(Mapletree.MOD_ID, "boat/signs/hanging/maple");
    public static final Identifier MAPLE_HANGING_GUI_SIGN_TEXTURE = Identifier.of(Mapletree.MOD_ID, "textures/gui/hanging_signs/maple");

    public static final Block MAPLE_STANDING_SIGN = registerBlock("maple_standing_sign",
            new TerraformSignBlock(MAPLE_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "maple_standing_sign")))
                    .mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final Block MAPLE_WALL_SIGN = registerBlock("maple_wall_sign",
            new TerraformWallSignBlock(MAPLE_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "maple_wall_sign")))
                    .mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final Block MAPLE_HANGING_SIGN = registerBlockWithoutBlockItem("maple_hanging_sign",
            new TerraformHangingSignBlock(MAPLE_HANGING_SIGN_TEXTURE, MAPLE_HANGING_GUI_SIGN_TEXTURE,
                    AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.TERRACOTTA_WHITE)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "maple_hanging_sign")))
            ));
    public static final Block MAPLE_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("maple_wall_hanging_sign",
            new TerraformWallHangingSignBlock(MAPLE_HANGING_SIGN_TEXTURE, MAPLE_HANGING_GUI_SIGN_TEXTURE,
                    AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).mapColor(MapColor.TERRACOTTA_WHITE)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "maple_wall_hanging_sign")))
            ));

    public static final BlockFamily MAPLE_FAMILY = BlockFamilies.register(MAPLE_PLANKS)
            .sign(MAPLE_STANDING_SIGN, MAPLE_WALL_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();

    public static final Block SPILE = registerBlock("spile",
            new SpileBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).requiresTool()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "spile")))));

    public static final Block SAP_CAULDRON = registerBlock("sap_cauldron",
            new SapCauldron(Biome.Precipitation.NONE, ModCauldronBehaviors.SAP_CAULDRON_BEHAVIOR, AbstractBlock.Settings.copy(Blocks.CAULDRON)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "sap_cauldron")))
            ));
    public static final Block SYRUP_CAULDRON = registerBlock("syrup_cauldron",
            new SyrupCauldron(Biome.Precipitation.NONE, ModCauldronBehaviors.SYRUP_CAULDRON_BEHAVIOR, AbstractBlock.Settings.copy(Blocks.CAULDRON)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, "syrup_cauldron")))
            ));


    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(Mapletree.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Mapletree.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Mapletree.MOD_ID, name),
                new BlockItem(block, new Item.Settings() .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Mapletree.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        Mapletree.LOGGER.info("Registering Mod Blocks for " +Mapletree.MOD_ID);

        StrippableBlockRegistry.register(MAPLE_LOG, STRIPPED_MAPLE_LOG);
        StrippableBlockRegistry.register(MAPLE_WOOD, STRIPPED_MAPLE_WOOD);

        FlammableBlockRegistry FlammableBlocks = FlammableBlockRegistry.getDefaultInstance();
        FlammableBlocks.add(MAPLE_LEAVES, 30, 60);
        FlammableBlocks.add(RED_MAPLE_LEAVES, 30, 60);

        FlammableBlocks.add(MAPLE_LEAF_PILE, 60, 100);
        FlammableBlocks.add(RED_MAPLE_LEAF_PILE, 60, 100);

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
