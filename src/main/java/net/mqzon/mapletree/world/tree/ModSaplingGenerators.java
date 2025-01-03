package net.mqzon.mapletree.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator MAPLE = new SaplingGenerator(Mapletree.MOD_ID + ":maple",
                        Optional.of(ModConfiguredFeatures.MEGA_MAPLE),
                        Optional.of(ModConfiguredFeatures.MAPLE),
                        Optional.of(ModConfiguredFeatures.MAPLE_BEES_005));

    public static final SaplingGenerator RED_MAPLE = new SaplingGenerator(Mapletree.MOD_ID + ":red_maple",
            Optional.empty(),
                        Optional.of(ModConfiguredFeatures.RED_MAPLE),
                        Optional.of(ModConfiguredFeatures.RED_MAPLE_BEES_005));

}
