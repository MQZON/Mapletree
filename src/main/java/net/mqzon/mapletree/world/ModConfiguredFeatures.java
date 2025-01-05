package net.mqzon.mapletree.world;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.UpwardsBranchingTrunkPlacer;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.block.ModBlocks;
import net.mqzon.mapletree.world.foliage.MapleFoliagePlacer;
import net.mqzon.mapletree.world.foliage.SpheroidShellPlacer;
import net.mqzon.mapletree.world.trunk.MegaMapleTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> MAPLE = registryKey("maple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MAPLE_BEES_005 = registryKey("maple_bees_005");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_MAPLE = registryKey("mega_maple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_MAPLE = registryKey("red_maple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_MAPLE_BEES_005 = registryKey("red_maple_bees_005");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, MAPLE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MAPLE_LOG),
                new StraightTrunkPlacer(7, 2, 0),
                BlockStateProvider.of(ModBlocks.MAPLE_LEAVES),
                DefaultMapleFoliage(),
                new TwoLayersFeatureSize(1, 0, 2)
        ).build());

        register(context, MAPLE_BEES_005, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MAPLE_LOG),
                new StraightTrunkPlacer(7, 2, 0),
                BlockStateProvider.of(ModBlocks.MAPLE_LEAVES),
                DefaultMapleFoliage(),
                new TwoLayersFeatureSize(1, 0, 2)
        ).decorators(List.of(new BeehiveTreeDecorator(0.05F))).build());

        register(context, MEGA_MAPLE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MAPLE_LOG),
                new MegaMapleTrunkPlacer(32, 0, 0),
                BlockStateProvider.of(Blocks.LIME_STAINED_GLASS),
                DefaultMegaMapleFoliage(),
                new TwoLayersFeatureSize(1, 1, 2)
        ).decorators(List.of(new BeehiveTreeDecorator(0.05F))).build());

        register(context, RED_MAPLE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MAPLE_LOG),
                new StraightTrunkPlacer(7, 2, 0),
                BlockStateProvider.of(ModBlocks.RED_MAPLE_LEAVES),
                DefaultMapleFoliage(),
                new TwoLayersFeatureSize(1, 0, 2)
        ).build());

        register(context, RED_MAPLE_BEES_005, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MAPLE_LOG),
                new StraightTrunkPlacer(7, 2, 0),
                BlockStateProvider.of(ModBlocks.RED_MAPLE_LEAVES),
                DefaultMapleFoliage(),
                new TwoLayersFeatureSize(1, 0, 2)
        ).decorators(List.of(new BeehiveTreeDecorator(0.05F))).build());
    }

    private static MapleFoliagePlacer DefaultMapleFoliage() {
        return new MapleFoliagePlacer(
                ConstantIntProvider.create(4),
                ConstantIntProvider.create(2),
                ConstantIntProvider.create(7),
                0.75F,
                0.75F,
                0F,
                0F);
    }

    private static SpheroidShellPlacer DefaultMegaMapleFoliage() {
        return new SpheroidShellPlacer(ConstantIntProvider.create(16), ConstantIntProvider.create(0), 16);
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Mapletree.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
