package net.mqzon.mapletree.worldgen.tree;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.mqzon.mapletree.worldgen.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class RedMapleTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
        return pHasFlowers ? ModConfiguredFeatures.RED_MAPLE_BEES_005 : ModConfiguredFeatures.RED_MAPLE;
    }
}
