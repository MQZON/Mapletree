package net.mqzon.mapletree.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class LeafPileBlock extends SnowLayerBlock {
    public LeafPileBlock(Properties pProperties) {
        super(pProperties);
    }

    public void fallOn(Level p_153362_, BlockState p_153363_, BlockPos p_153364_, Entity p_153365_, float p_153366_) {
        p_153365_.causeFallDamage(p_153366_, 0.2F, p_153362_.damageSources().fall());
    }
}
