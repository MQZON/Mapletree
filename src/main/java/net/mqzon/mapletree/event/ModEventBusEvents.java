package net.mqzon.mapletree.event;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.entity.ModEntityTypes;
import net.mqzon.mapletree.entity.render.ModBoatRenderer;
import net.mqzon.mapletree.particle.ModParticles;
import net.mqzon.mapletree.particle.custom.MapleLeafParticle;


@Mod.EventBusSubscriber(value= Dist.CLIENT,modid = Mapletree.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.MAPLE_LEAVES.get(), MapleLeafParticle.Provider::new);
        event.registerSpriteSet(ModParticles.RED_MAPLE_LEAVES.get(), MapleLeafParticle.Provider::new);
    }


    @SubscribeEvent
    public static void registerEntityRenderers(FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntityTypes.MAPLE_BOAT.get(), context -> new ModBoatRenderer(context, false));
        EntityRenderers.register(ModEntityTypes.MAPLE_CHEST_BOAT.get(), context -> new ModBoatRenderer(context, true));
    }

}
