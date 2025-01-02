package net.mqzon.mapletree.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.event.GameEvent;

public class FillableLeveledCauldronBlock extends LeveledCauldronBlock {
    public FillableLeveledCauldronBlock(Biome.Precipitation precipitation, CauldronBehavior.CauldronBehaviorMap behaviorMap, Settings settings) {
        super(precipitation, behaviorMap, settings);
    }

    public static BlockState raiseFillLevel(BlockState state, World world, BlockPos pos) {
        if (state.get(LEVEL) < 3) {
            BlockState newState = state.with(LEVEL, (Integer) state.get(LEVEL) + 1);
            world.setBlockState(pos, newState);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(newState));
            return newState;
        }
        return state;
    }
}
