package net.mqzon.mapletree.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.mqzon.mapletree.block.ModBlocks;
import net.mqzon.mapletree.item.ModItems;
import net.mqzon.mapletree.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.MAPLE_SAPLINGS)
                .add(ModBlocks.MAPLE_SAPLING.asItem())
                .add(ModBlocks.RED_MAPLE_SAPLING.asItem());

        getOrCreateTagBuilder(ModTags.Items.MAPLE_LEAVES)
                .add(ModBlocks.MAPLE_LEAVES.asItem())
                .add(ModBlocks.RED_MAPLE_LEAVES.asItem());

        getOrCreateTagBuilder(ModTags.Items.MAPLE_LOGS)
                .add(ModBlocks.MAPLE_LOG.asItem())
                .add(ModBlocks.MAPLE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.asItem())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.COMPLETES_FIND_TREE_TUTORIAL)
                .addTag(ModTags.Items.MAPLE_LEAVES)
                .addTag(ModTags.Items.MAPLE_LOGS);

        getOrCreateTagBuilder(ItemTags.SAPLINGS).addTag(ModTags.Items.MAPLE_SAPLINGS);
        getOrCreateTagBuilder(ItemTags.LEAVES).addTag(ModTags.Items.MAPLE_LEAVES);

        getOrCreateTagBuilder(ItemTags.LOGS).addTag(ModTags.Items.MAPLE_LOGS);
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN).addTag(ModTags.Items.MAPLE_LOGS);

        getOrCreateTagBuilder(ItemTags.PLANKS).add(ModBlocks.MAPLE_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.SLABS).add(ModBlocks.MAPLE_SLAB.asItem());
        getOrCreateTagBuilder(ItemTags.STAIRS).add(ModBlocks.MAPLE_STAIRS.asItem());
        getOrCreateTagBuilder(ItemTags.FENCES).add(ModBlocks.MAPLE_FENCE.asItem());
        getOrCreateTagBuilder(ItemTags.FENCE_GATES).add(ModBlocks.MAPLE_FENCE_GATE.asItem());
        getOrCreateTagBuilder(ItemTags.DOORS).add(ModBlocks.MAPLE_DOOR.asItem());
        getOrCreateTagBuilder(ItemTags.TRAPDOORS).add(ModBlocks.MAPLE_TRAPDOOR.asItem());
        getOrCreateTagBuilder(ItemTags.BUTTONS).add(ModBlocks.MAPLE_BUTTON.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).add(ModBlocks.MAPLE_SLAB.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).add(ModBlocks.MAPLE_STAIRS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).add(ModBlocks.MAPLE_FENCE.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS).add(ModBlocks.MAPLE_DOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS).add(ModBlocks.MAPLE_TRAPDOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.MAPLE_PRESSURE_PLATE.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS).add(ModBlocks.MAPLE_BUTTON.asItem());

        getOrCreateTagBuilder(ItemTags.SIGNS).add(ModItems.MAPLE_SIGN);

        getOrCreateTagBuilder(ItemTags.BOATS).add(ModItems.MAPLE_BOAT);
        getOrCreateTagBuilder(ItemTags.CHEST_BOATS).add(ModItems.MAPLE_CHEST_BOAT);
    }
}
