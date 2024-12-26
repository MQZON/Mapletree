package net.mqzon.mapletree.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mqzon.mapletree.Mapletree;

public class ModParticles {
    public static final SimpleParticleType MAPLE_LEAVES_PARTICLE = FabricParticleTypes.simple();
    public static final SimpleParticleType RED_MAPLE_LEAVES_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Mapletree.MOD_ID, "maple_leaves"),
                MAPLE_LEAVES_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Mapletree.MOD_ID, "red_maple_leaves"),
                RED_MAPLE_LEAVES_PARTICLE);
    }
}
