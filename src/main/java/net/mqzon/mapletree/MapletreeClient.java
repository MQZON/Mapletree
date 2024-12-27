package net.mqzon.mapletree;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.render.RenderLayer;
import net.mqzon.mapletree.block.ModBlocks;
import net.mqzon.mapletree.entity.ModBoats;
import net.mqzon.mapletree.particle.ModParticles;
import net.mqzon.mapletree.particle.custom.MapleLeavesParticle;

public class MapletreeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(ModParticles.MAPLE_LEAVES_PARTICLE, MapleLeavesParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.RED_MAPLE_LEAVES_PARTICLE, MapleLeavesParticle.Factory::new);

        TerraformBoatClientHelper.registerModelLayers(ModBoats.MAPLE_BOAT_ID, false);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_MAPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_MAPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_RED_MAPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_TRAPDOOR, RenderLayer.getCutout());
    }
}
