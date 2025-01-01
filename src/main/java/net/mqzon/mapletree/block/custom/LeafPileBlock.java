package net.mqzon.mapletree.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.SnowBlock;
import net.minecraft.entity.Entity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LeafPileBlock extends SnowBlock {
    public LeafPileBlock(Settings settings) { super(settings); }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        entity.handleFallDamage(fallDistance, 0.2F, world.getDamageSources().fall());
    }

    public static final BlockSoundGroup LeafPileSounds = new BlockSoundGroup(
            1.0F,
            1.0F,
            SoundEvents.BLOCK_GRASS_BREAK,
            SoundEvents.BLOCK_GRASS_BREAK,
            SoundEvents.BLOCK_GRASS_PLACE,
            SoundEvents.BLOCK_GRASS_HIT,
            SoundEvents.BLOCK_GRASS_BREAK
    );
}
