package net.mqzon.mapletree.world.trunk;

import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.mixin.TrunkPlacerTypeInvoker;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> MEGA_MAPLE_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("maple_foliage_placer", MegaMapleTrunkPlacer.CODEC);

    public static void register() {
        Mapletree.LOGGER.info("Registering Trunk Placer for " + Mapletree.MOD_ID);
    }
}
