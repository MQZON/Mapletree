package net.mqzon.mapletree.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.mqzon.mapletree.particle.ModParticles;

public class MapleLeavesBlock extends LeavesBlock {
    private final SimpleParticleType particleType;

    public static final MapCodec<MapleLeavesBlock> CODEC = createCodec(settings1 -> new MapleLeavesBlock(settings1, ModParticles.MAPLE_LEAVES_PARTICLE));

    @Override
    public MapCodec<MapleLeavesBlock> getCodec() {
        return CODEC;
    }

    public MapleLeavesBlock(Settings settings, SimpleParticleType particleType) {
        super(settings);
        this.particleType = particleType;
    }


    @Override
    public void randomDisplayTick(BlockState state, World world, net.minecraft.util.math.BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);
        if (random.nextInt(10) == 0) {
            net.minecraft.util.math.BlockPos blockPos = pos.down();
            BlockState blockState = world.getBlockState(blockPos);
            if (!isFaceFullSquare(blockState.getCollisionShape(world, blockPos), net.minecraft.util.math.Direction.UP)) {
                ParticleUtil.spawnParticle(world, pos, random, this.particleType);
            }
        }
    }
}
