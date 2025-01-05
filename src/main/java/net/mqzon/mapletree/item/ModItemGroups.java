package net.mqzon.mapletree.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.block.ModBlocks;
import net.mqzon.mapletree.boat.ModBoats;

public class ModItemGroups {
    public static final ItemGroup MAPLE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Mapletree.MOD_ID, "maple_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.MAPLE_SAPLING))
                    .displayName(Text.translatable("itemgroup.mapletree.maple_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.MAPLE_SAPLING);
                        entries.add(ModBlocks.RED_MAPLE_SAPLING);
                        entries.add(ModBlocks.MAPLE_LEAVES);
                        entries.add(ModBlocks.RED_MAPLE_LEAVES);
                        entries.add(ModBlocks.MAPLE_LEAF_PILE);
                        entries.add(ModBlocks.RED_MAPLE_LEAF_PILE);

                        entries.add(ModBlocks.MAPLE_LOG);
                        entries.add(ModBlocks.MAPLE_WOOD);
                        entries.add(ModBlocks.STRIPPED_MAPLE_LOG);
                        entries.add(ModBlocks.STRIPPED_MAPLE_WOOD);
                        entries.add(ModBlocks.MAPLE_PLANKS);
                        entries.add(ModBlocks.MAPLE_SLAB);
                        entries.add(ModBlocks.MAPLE_STAIRS);
                        entries.add(ModBlocks.MAPLE_FENCE);
                        entries.add(ModBlocks.MAPLE_FENCE_GATE);
                        entries.add(ModBlocks.MAPLE_DOOR);
                        entries.add(ModBlocks.MAPLE_TRAPDOOR);
                        entries.add(ModBlocks.MAPLE_PRESSURE_PLATE);
                        entries.add(ModBlocks.MAPLE_BUTTON);
                        entries.add(ModItems.MAPLE_SIGN);
                        entries.add(ModItems.MAPLE_HANGING_SIGN);
                        entries.add(ModBoats.MAPLE_BOAT);
                        entries.add(ModBoats.MAPLE_CHEST_BOAT);

                        entries.add(ModBlocks.SPILE);
                        entries.add(ModItems.SAP_BUCKET);

                        entries.add(ModItems.SYRUP_BOTTLE);
                        entries.add(ModItems.GLAZED_CARROTS);
                        entries.add(ModItems.GLAZED_SALMON);
                        entries.add(ModItems.PANCAKES);
                    }).build());

    public static void registerItemGroups() {
        Mapletree.LOGGER.info("Registering Item Groups for " + Mapletree.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.MAPLE_SAPLING);
            entries.add(ModBlocks.RED_MAPLE_SAPLING);
            entries.add(ModBlocks.MAPLE_LEAVES);
            entries.add(ModBlocks.RED_MAPLE_LEAVES);
            entries.add(ModBlocks.MAPLE_LEAF_PILE);
            entries.add(ModBlocks.RED_MAPLE_LEAF_PILE);
            entries.add(ModBlocks.MAPLE_LOG);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.MAPLE_LOG);
            entries.add(ModBlocks.MAPLE_WOOD);
            entries.add(ModBlocks.STRIPPED_MAPLE_LOG);
            entries.add(ModBlocks.STRIPPED_MAPLE_WOOD);
            entries.add(ModBlocks.MAPLE_PLANKS);
            entries.add(ModBlocks.MAPLE_SLAB);
            entries.add(ModBlocks.MAPLE_STAIRS);
            entries.add(ModBlocks.MAPLE_FENCE);
            entries.add(ModBlocks.MAPLE_FENCE_GATE);
            entries.add(ModBlocks.MAPLE_DOOR);
            entries.add(ModBlocks.MAPLE_TRAPDOOR);
            entries.add(ModBlocks.MAPLE_PRESSURE_PLATE);
            entries.add(ModBlocks.MAPLE_BUTTON);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
            entries.add(ModBlocks.MAPLE_FENCE_GATE);
            entries.add(ModBlocks.MAPLE_DOOR);
            entries.add(ModBlocks.MAPLE_TRAPDOOR);
            entries.add(ModBlocks.MAPLE_PRESSURE_PLATE);
            entries.add(ModBlocks.MAPLE_BUTTON);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(ModBlocks.SPILE);
            entries.add(ModItems.MAPLE_SIGN);
            entries.add(ModItems.MAPLE_HANGING_SIGN);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(ModBoats.MAPLE_BOAT);
            entries.add(ModBoats.MAPLE_CHEST_BOAT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModItems.SAP_BUCKET);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(ModItems.SYRUP_BOTTLE);
            entries.add(ModItems.GLAZED_CARROTS);
            entries.add(ModItems.GLAZED_SALMON);
            entries.add(ModItems.PANCAKES);
        });
    }
}
