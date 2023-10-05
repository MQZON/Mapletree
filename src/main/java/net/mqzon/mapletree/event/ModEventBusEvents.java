package net.mqzon.mapletree.event;

import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.particle.ModParticles;
import net.mqzon.mapletree.particle.custom.MapleLeafParticle;

@Mod.EventBusSubscriber(modid = Mapletree.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(ModParticles.MAPLE_LEAVES.get(), MapleLeafParticle.Provider::new);
            event.registerSpriteSet(ModParticles.RED_MAPLE_LEAVES.get(), MapleLeafParticle.Provider::new);
    }

}
