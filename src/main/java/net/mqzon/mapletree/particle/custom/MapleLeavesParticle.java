package net.mqzon.mapletree.particle.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;

public class MapleLeavesParticle extends LeavesParticle {
    protected MapleLeavesParticle(ClientWorld world, double x, double y, double z, SpriteProvider spriteProvider, float f, float g, boolean bl, boolean bl2, float h, float i) {
        super(world, x, y, z, spriteProvider, f, g, bl, bl2, h, i);
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new MapleLeavesParticle(world, x, y, z, this.sprites, 0.25F, 2.0F, false, true, 1.0F, 0.0F);
        }
    }
}
