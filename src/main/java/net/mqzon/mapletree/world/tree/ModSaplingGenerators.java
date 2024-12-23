package net.mqzon.mapletree.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator MAPLE = new SaplingGenerator(Mapletree.MOD_ID + ":maple",
            Optional.empty(), Optional.of(ModConfiguredFeatures.MAPLE), Optional.empty());
}
