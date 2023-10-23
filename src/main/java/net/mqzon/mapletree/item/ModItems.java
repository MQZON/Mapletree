package net.mqzon.mapletree.item;

import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.HoneyBottleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.block.ModBlocks;
import net.mqzon.mapletree.block.entity.ModWoodTypes;
import net.mqzon.mapletree.item.custom.ModBoatItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Mapletree.MOD_ID);

    public static final RegistryObject<Item> MAPLE_SIGN = ITEMS.register("maple_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16),
                    ModBlocks.MAPLE_SIGN.get(), ModBlocks.MAPLE_WALL_SIGN.get()));

    public static final RegistryObject<Item> MAPLE_HANGING_SIGN = ITEMS.register("maple_hanging_sign",
            () -> new HangingSignItem(ModBlocks.MAPLE_HANGING_SIGN.get(),
                    ModBlocks.MAPLE_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> MAPLE_BOAT = ITEMS.register("maple_boat",
            () -> new ModBoatItem(false, new Item.Properties().stacksTo(1), ModWoodTypes.MAPLE));
    public static final RegistryObject<Item> MAPLE_CHEST_BOAT = ITEMS.register("maple_chest_boat",
            () -> new ModBoatItem(true, new Item.Properties().stacksTo(1), ModWoodTypes.MAPLE));
    public static final RegistryObject<Item> SAP_BUCKET = ITEMS.register("sap_bucket",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SYRUP_BOTTLE = ITEMS.register("syrup_bottle",
            () -> new HoneyBottleItem(new Item.Properties().food(ModFoods.SYRUP_BOTTLE).stacksTo(16)));
    public static final RegistryObject<Item> GLAZED_CARROTS = ITEMS.register("glazed_carrots",
            () -> new Item(new Item.Properties().food(ModFoods.GLAZED_CARROTS)));
    public static final RegistryObject<Item> GLAZED_SALMON = ITEMS.register("glazed_salmon",
            () -> new Item(new Item.Properties().food(ModFoods.GLAZED_SALMON)));
    public static final RegistryObject<Item> PANCAKES = ITEMS.register("pancakes",
            () -> new Item(new Item.Properties().food(ModFoods.PANCAKES)));

    public static  void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
