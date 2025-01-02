package net.mqzon.mapletree.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.block.ModBlocks;

public class ModItems {
    public static final Item MAPLE_SIGN = registerItem("maple_sign",
            new SignItem(ModBlocks.MAPLE_STANDING_SIGN, ModBlocks.MAPLE_WALL_SIGN, new Item.Settings().maxCount(16)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Mapletree.MOD_ID, "maple_sign")))));
    public static final Item MAPLE_HANGING_SIGN = registerItem("maple_hanging_sign",
            new HangingSignItem(ModBlocks.MAPLE_HANGING_SIGN, ModBlocks.MAPLE_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Mapletree.MOD_ID, "maple_hanging_sign")))));

    public static Item SAP_BUCKET = registerItem("sap_bucket", new Item(new Item.Settings().maxCount(1)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Mapletree.MOD_ID, "sap_bucket")))));

    public static final Item SYRUP_BOTTLE = registerItem("syrup_bottle", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Mapletree.MOD_ID, "syrup_bottle")))
            .food(ModFoodComponents.SYRUP_BOTTLE, ModConsumableComponents.SYRUP_BOTTLE).maxCount(16)
            .recipeRemainder(Items.GLASS_BOTTLE).useRemainder(Items.GLASS_BOTTLE)));
    public static final Item GLAZED_CARROTS = registerItem("glazed_carrots", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Mapletree.MOD_ID, "glazed_carrots")))
            .food(ModFoodComponents.GLAZED_CARROTS, ModConsumableComponents.GLAZED_CARROTS)));
    public static final Item GLAZED_SALMON = registerItem("glazed_salmon", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Mapletree.MOD_ID, "glazed_salmon")))
            .food(ModFoodComponents.GLAZED_SALMON, ModConsumableComponents.GLAZED_SALMON)));
    public static final Item PANCAKES = registerItem("pancakes", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Mapletree.MOD_ID, "pancakes")))
            .food(ModFoodComponents.PANCAKES, ModConsumableComponents.PANCAKES)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Mapletree.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Mapletree.LOGGER.info("Registering Mod Items for " + Mapletree.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(SAP_BUCKET);
        });
    }
}
