package net.mqzon.mapletree.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.Map;
import java.util.function.Predicate;

public class FillableLayeredCauldronBlock extends LayeredCauldronBlock {
    public FillableLayeredCauldronBlock(Properties pProperties, Predicate<Biome.Precipitation> pFillPredicate, Map<Item, CauldronInteraction> pInteractions) {
        super(pProperties, pFillPredicate, pInteractions);
    }

    public static BlockState raiseFillLevel(BlockState currentState, Level level, BlockPos pos) {
        if (currentState.getValue(LEVEL) < 3) {
            BlockState newState = currentState.cycle(LEVEL);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(currentState));
            return newState;
        }
        return currentState;
    }
}
