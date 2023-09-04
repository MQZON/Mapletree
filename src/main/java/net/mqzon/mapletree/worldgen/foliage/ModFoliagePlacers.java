package net.mqzon.mapletree.worldgen.foliage;

import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.worldgen.foliage.custom.MapleFoliagePlacer;

import java.util.function.Supplier;

public class ModFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES =
            DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, Mapletree.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<?>> MAPLE_FOLIAGE_PLACER = registerFoliagePlacer(
            "maple_foliage_placer",  () -> new FoliagePlacerType<>(MapleFoliagePlacer.CODEC));


    private static <T extends FoliagePlacerType<?>> RegistryObject<T>
    registerFoliagePlacer(String pKey, Supplier<T> foliagePlacer) {
        return FOLIAGE_PLACER_TYPES.register(pKey, foliagePlacer);
    }


    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACER_TYPES.register(eventBus);
    }
}
