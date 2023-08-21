package net.mqzon.mapletree.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.block.ModBlocks;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?,?>> MAPLE_KEY = registerKey("maple");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?,?>> context) {
        register(context, MAPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.MAPLE_LOG.get()),
                new StraightTrunkPlacer(7,2,0),
                BlockStateProvider.simple(ModBlocks.MAPLE_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                new TwoLayersFeatureSize(1, 0, 2)).build());

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Mapletree.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstapContext<ConfiguredFeature<?,?>> context,
            ResourceKey<ConfiguredFeature<?,?>> key,
            F feature,
            FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
