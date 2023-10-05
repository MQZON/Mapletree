package net.mqzon.mapletree.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.block.custom.*;
import net.mqzon.mapletree.block.entity.ModWoodTypes;
import net.mqzon.mapletree.item.ModItems;
import net.mqzon.mapletree.worldgen.tree.MapleTreeGrower;
import net.mqzon.mapletree.worldgen.tree.RedMapleTreeGrower;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Mapletree.MOD_ID);

    public static final RegistryObject<Block> MAPLE_SAPLING = registerBlock("maple_sapling",
            () -> new SaplingBlock(new MapleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> RED_MAPLE_SAPLING = registerBlock("red_maple_sapling",
            () -> new SaplingBlock(new RedMapleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_MAPLE_SAPLING = registerBlockWithoutBlockItem("potted_maple_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.MAPLE_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_RED_MAPLE_SAPLING = registerBlockWithoutBlockItem("potted_red_maple_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.RED_MAPLE_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> MAPLE_LEAVES = registerBlock("maple_leaves",
            () -> new MapleLeavesBlock(BlockBehaviour.Properties.copy(
                    Blocks.MANGROVE_LEAVES).mapColor(MapColor.COLOR_ORANGE)
                    .isViewBlocking((BlockState s, BlockGetter g, BlockPos p) -> { return false;})
                    .isSuffocating((BlockState s, BlockGetter g, BlockPos p) -> { return false;})
                    .isRedstoneConductor((BlockState s, BlockGetter g, BlockPos p) -> { return false;})));
    public static final RegistryObject<Block> RED_MAPLE_LEAVES = registerBlock("red_maple_leaves",
            () -> new RedMapleLeavesBlock(BlockBehaviour.Properties.copy(
                            Blocks.MANGROVE_LEAVES).mapColor(MapColor.COLOR_RED)
                    .isViewBlocking((BlockState s, BlockGetter g, BlockPos p) -> { return false;})
                    .isSuffocating((BlockState s, BlockGetter g, BlockPos p) -> { return false;})
                    .isRedstoneConductor((BlockState s, BlockGetter g, BlockPos p) -> { return false;})));
    public static final RegistryObject<Block> MAPLE_LOG = registerBlock("maple_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> MAPLE_WOOD = registerBlock("maple_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> MAPLE_PLANKS = registerBlock("maple_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });

    public static final RegistryObject<Block> MAPLE_STAIRS = registerBlock("maple_stairs",
            () -> new StairBlock(() -> ModBlocks.MAPLE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> MAPLE_SLAB = registerBlock("maple_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
    public static final RegistryObject<Block> MAPLE_FENCE = registerBlock("maple_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), ModWoodTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_DOOR = registerBlock("maple_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), ModBlockSetTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_TRAPDOOR = registerBlock("maple_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), ModBlockSetTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), ModBlockSetTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_BUTTON = registerBlock("maple_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON),
                    ModBlockSetTypes.MAPLE, 15, true));
    public static final RegistryObject<Block> MAPLE_SIGN = registerBlockWithoutBlockItem("maple_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_WALL_SIGN = registerBlockWithoutBlockItem("maple_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_HANGING_SIGN = registerBlockWithoutBlockItem("maple_hanging_sign",
            () -> new ModCeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("maple_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.MAPLE));

    public static final RegistryObject<Block> FALLEN_LEAVES = registerBlock("fallen_leaves",
            () -> new LeafPileBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .mapColor(MapColor.COLOR_ORANGE)
                    .sound(new ForgeSoundType(1.0F, 1.0F,
                            () -> SoundEvents.GRASS_BREAK,
                            () -> SoundEvents.GRASS_BREAK,
                            () -> SoundEvents.GRASS_PLACE,
                            () -> SoundEvents.GRASS_HIT,
                            () -> SoundEvents.GRASS_BREAK))));

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockitem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockitem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
