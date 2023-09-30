package net.mqzon.mapletree.entity.render;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.block.entity.ModWoodTypes;
import net.mqzon.mapletree.entity.custom.ModBoatEntity;
import net.mqzon.mapletree.entity.custom.ModChestBoatEntity;

import java.util.Map;

public class ModBoatRenderer extends BoatRenderer {
    private final Map<String, Pair<ResourceLocation, ListModel<Boat>>> BOAT_RESOURCES;
    private final boolean HAS_CHEST;


    public ModBoatRenderer(EntityRendererProvider.Context context, boolean hasChest) {
        super(context, hasChest);
        this.BOAT_RESOURCES = ImmutableMap.of(ModWoodTypes.MAPLE.name(), Pair.of(new ResourceLocation(Mapletree.MOD_ID, "textures/entity/" + (hasChest ? "chest_boat" : "boat") + "/maple" + ".png"), this.createBoatModel(context, hasChest)));
        this.HAS_CHEST = hasChest;
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context context, boolean chestBoat) {
        ModelLayerLocation modellayerlocation = chestBoat ?
                new ModelLayerLocation(new ResourceLocation("minecraft", "chest_boat/oak"), "main") :
                new ModelLayerLocation(new ResourceLocation("minecraft", "boat/oak"), "main");
        ModelPart modelpart = context.bakeLayer(modellayerlocation);
        return chestBoat ? new ChestBoatModel(modelpart) : new BoatModel(modelpart);
    }

    @Override
    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
        if (HAS_CHEST) return BOAT_RESOURCES.get(((ModChestBoatEntity) boat).getWoodType());
        return BOAT_RESOURCES.get(((ModBoatEntity) boat).getWoodType());
    }
}