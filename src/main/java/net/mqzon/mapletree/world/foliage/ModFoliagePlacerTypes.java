package net.mqzon.mapletree.world.foliage;

import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.mixin.FoliagePlacerTypeInvoker;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<?> MAPLE_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("maple_foliage_placer", MapleFoliagePlacer.CODEC);

    public static void register() {
        Mapletree.LOGGER.info("Registering Foliage Placer for " + Mapletree.MOD_ID);
    }
}
