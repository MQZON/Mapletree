package net.mqzon.mapletree.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.mqzon.mapletree.block.ModBlocks;

import java.util.Map;
import java.util.function.Predicate;

public class SapCauldron extends FillableLayeredCauldronBlock {
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;

    public SapCauldron(Properties pProperties, Predicate<Biome.Precipitation> pFillPredicate, Map<Item, CauldronInteraction> pInteractions) {
        super(pProperties, pFillPredicate, pInteractions);
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, Boolean.valueOf(false)));
    }

    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        pLevel.setBlockAndUpdate(pPos, pState.setValue(LIT, Boolean.valueOf(this.isHeatSource(pLevel.getBlockState(pPos.below())))));
    }

    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState,
                                  LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        return pFacing == Direction.DOWN
                ? pState.setValue(LIT, Boolean.valueOf(this.isHeatSource(pFacingState)))
                : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    private boolean isHeatSource(BlockState pState) {
        return pState.is(Blocks.LAVA) ||
                pState.is(Blocks.MAGMA_BLOCK) ||
                pState.is(Blocks.FIRE) ||
                pState.is(Blocks.CAMPFIRE) ||
                pState.is(Blocks.SOUL_FIRE) ||
                pState.is(Blocks.SOUL_CAMPFIRE);
    }

    public boolean isRandomlyTicking(BlockState pState) {
        return pState.getValue(LIT) && pState.getValue(LEVEL) == 3;
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(LIT) && pState.getValue(LEVEL) == 3) {
            pLevel.setBlockAndUpdate(pPos, ModBlocks.SYRUP_CAULDRON.get().defaultBlockState());
        }
        super.randomTick(pState, pLevel, pPos, pRandom);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(LIT);
    }
}
