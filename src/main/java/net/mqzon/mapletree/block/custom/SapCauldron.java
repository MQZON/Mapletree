package net.mqzon.mapletree.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.mqzon.mapletree.block.ModBlocks;
import net.mqzon.mapletree.util.ModTags;
import org.jetbrains.annotations.Nullable;

public class SapCauldron extends FillableLeveledCauldronBlock {
    public static final BooleanProperty LIT = Properties.LIT;

    public SapCauldron(Biome.Precipitation precipitation, CauldronBehavior.CauldronBehaviorMap behaviorMap, Settings settings) {
        super(precipitation, behaviorMap, settings);
        this.setDefaultState(this.getDefaultState().with(LIT, Boolean.valueOf(false)));
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(LIT, isHeated(ctx.getWorld(), ctx.getBlockPos()));
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (!world.isClient) {
            if (isHeated(world, pos)) {
                world.setBlockState(pos, state.with(LIT, true));
            } else {
                world.setBlockState(pos, state.with(LIT, false));
            }
        }
    }

    public static boolean isHeated(World world, BlockPos pos) {
        return world.getBlockState(pos.down()).isIn(ModTags.Blocks.HEAT_SOURCES);
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return state.get(LIT) && state.get(LEVEL) == 3;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.setBlockState(pos, ModBlocks.SYRUP_CAULDRON.getDefaultState());
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LEVEL);
        builder.add(LIT);
    }
}
