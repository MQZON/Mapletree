package net.mqzon.mapletree.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.entity.custom.ModBoatEntity;
import net.mqzon.mapletree.entity.custom.ModChestBoatEntity;

@Mod.EventBusSubscriber(modid = Mapletree.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Mapletree.MOD_ID);

    public static final RegistryObject<EntityType<ModBoatEntity>> MAPLE_BOAT =
            ENTITY_TYPES.register("maple_boat",
                    () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC)
                            .sized(1.375F, 0.5625F).clientTrackingRange(10)
                            .build(new ResourceLocation(Mapletree.MOD_ID, "maple_boat").toString()));
    public static final RegistryObject<EntityType<ModChestBoatEntity>> MAPLE_CHEST_BOAT =
            ENTITY_TYPES.register("maple_chest_boat",
                    () -> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC)
                            .sized(1.375F, 0.5625F).clientTrackingRange(10)
                            .build(new ResourceLocation(Mapletree.MOD_ID, "maple_chest_boat").toString()));
    public static void register(IEventBus eventBus) { ENTITY_TYPES.register(eventBus);}
}