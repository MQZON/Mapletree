package net.mqzon.mapletree.block.custom;

import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.world.biome.Biome;

public class SyrupCauldron extends FillableLeveledCauldronBlock{
    public SyrupCauldron(Biome.Precipitation precipitation, CauldronBehavior.CauldronBehaviorMap behaviorMap, Settings settings) {
        super(precipitation, behaviorMap, settings);
    }
}
