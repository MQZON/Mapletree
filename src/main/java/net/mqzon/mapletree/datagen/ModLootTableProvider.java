package net.mqzon.mapletree.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.mqzon.mapletree.block.ModBlocks;
import net.mqzon.mapletree.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MAPLE_SAPLING);
        addDrop(ModBlocks.RED_MAPLE_SAPLING);

        addDrop(ModBlocks.POTTED_MAPLE_SAPLING, pottedPlantDrops(ModBlocks.MAPLE_SAPLING));
        addDrop(ModBlocks.POTTED_RED_MAPLE_SAPLING, pottedPlantDrops(ModBlocks.RED_MAPLE_SAPLING));

        addDrop(ModBlocks.MAPLE_LEAVES, leavesDrops(ModBlocks.MAPLE_LEAVES, ModBlocks.MAPLE_SAPLING, 0.0625f));
        addDrop(ModBlocks.RED_MAPLE_LEAVES, leavesDrops(ModBlocks.RED_MAPLE_LEAVES, ModBlocks.RED_MAPLE_SAPLING, 0.0625f));

        addDrop(ModBlocks.MAPLE_LOG);
        addDrop(ModBlocks.MAPLE_WOOD);
        addDrop(ModBlocks.STRIPPED_MAPLE_LOG);
        addDrop(ModBlocks.STRIPPED_MAPLE_WOOD);

        addDrop(ModBlocks.MAPLE_PLANKS);
        addDrop(ModBlocks.MAPLE_SLAB,slabDrops(ModBlocks.MAPLE_SLAB));
        addDrop(ModBlocks.MAPLE_STAIRS);
        addDrop(ModBlocks.MAPLE_FENCE);
        addDrop(ModBlocks.MAPLE_FENCE_GATE);
        addDrop(ModBlocks.MAPLE_DOOR,doorDrops(ModBlocks.MAPLE_DOOR));
        addDrop(ModBlocks.MAPLE_TRAPDOOR);
        addDrop(ModBlocks.MAPLE_PRESSURE_PLATE);
        addDrop(ModBlocks.MAPLE_BUTTON);

        addDrop(ModBlocks.MAPLE_STANDING_SIGN, drops(ModItems.MAPLE_SIGN));
        addDrop(ModBlocks.MAPLE_HANGING_SIGN, drops(ModItems.MAPLE_HANGING_SIGN));
    }
}
