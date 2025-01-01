package net.mqzon.mapletree.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.HangingSignItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SignItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.block.ModBlocks;
import net.mqzon.mapletree.entity.ModBoats;
import net.mqzon.mapletree.item.custom.ModDrinkItem;

public class ModItems {
    public static final Item MAPLE_SIGN = registerItem("maple_sign",
            new SignItem(new Item.Settings().maxCount(16), ModBlocks.MAPLE_STANDING_SIGN, ModBlocks.MAPLE_WALL_SIGN));
    public static final Item MAPLE_HANGING_SIGN = registerItem("maple_hanging_sign",
            new HangingSignItem(ModBlocks.MAPLE_HANGING_SIGN, ModBlocks.MAPLE_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)));

    public static final Item MAPLE_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.MAPLE_BOAT_ID, ModBoats.MAPLE_BOAT_KEY, false);
    public static final Item MAPLE_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.MAPLE_CHEST_BOAT_ID, ModBoats.MAPLE_BOAT_KEY, true);

    public static Item SAP_BUCKET = registerItem("sap_bucket", new Item(new Item.Settings().maxCount(1)));

    public static final Item SYRUP_BOTTLE = registerItem("syrup_bottle", new ModDrinkItem(new Item.Settings().food(ModFoodComponents.SYRUP_BOTTLE).maxCount(16)));
    public static final Item GLAZED_CARROTS = registerItem("glazed_carrots", new Item(new Item.Settings().food(ModFoodComponents.GLAZED_CARROTS)));
    public static final Item GLAZED_SALMON = registerItem("glazed_salmon", new Item(new Item.Settings().food(ModFoodComponents.GLAZED_SALMON)));
    public static final Item PANCAKES = registerItem("pancakes", new Item(new Item.Settings().food(ModFoodComponents.PANCAKES)));

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
