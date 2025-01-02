package net.mqzon.mapletree.boat;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
//import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.mqzon.mapletree.Mapletree;

public class ModBoats {
    public static final Identifier MAPLE = Identifier.of(Mapletree.MOD_ID, "maple");
    public static final Item MAPLE_BOAT = TerraformBoatItemHelper.registerBoatItem(MAPLE, false);
    public static final Item MAPLE_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(MAPLE, true);

//    public static final Identifier MAPLE_BOAT_ID = Identifier.of(Mapletree.MOD_ID, "maple_boat");
//    public static final Identifier MAPLE_CHEST_BOAT_ID = Identifier.of(Mapletree.MOD_ID, "maple_chest_boat");

//    public static final RegistryKey<TerraformBoatType> MAPLE_BOAT_KEY = TerraformBoatTypeRegistry.createKey(MAPLE_BOAT_ID);

    public static void registerBoats() {
//        TerraformBoatType mapleBoat = new TerraformBoatType.Builder()
//                .item(ModItems.MAPLE_BOAT)
//                .chestItem(ModItems.MAPLE_CHEST_BOAT)
//                .planks(ModBlocks.MAPLE_PLANKS.asItem())
//                .build();
//
//        Registry.register(TerraformBoatTypeRegistry.INSTANCE, MAPLE_BOAT_KEY, mapleBoat);
    }
}
