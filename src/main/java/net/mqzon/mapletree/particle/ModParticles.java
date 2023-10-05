package net.mqzon.mapletree.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mqzon.mapletree.Mapletree;

import java.util.function.Supplier;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Mapletree.MOD_ID);

    public static final RegistryObject<SimpleParticleType> MAPLE_LEAVES = registerParticle(
            "maple_leaves", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> RED_MAPLE_LEAVES = registerParticle(
            "red_maple_leaves", () -> new SimpleParticleType(false));

    private static <T extends ParticleType<?>> RegistryObject<T> registerParticle(String name, Supplier<T> particle) {
        return PARTICLE_TYPES.register(name, particle);
    }


    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}
