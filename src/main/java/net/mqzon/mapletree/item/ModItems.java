package net.mqzon.mapletree.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mqzon.mapletree.Mapletree;

public class ModItems {

    public static Item SAP_BUCKET = registerItem("sap_bucket", new Item(new Item.Settings()));

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
