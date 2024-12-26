package net.mqzon.mapletree.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.mqzon.mapletree.block.ModBlocks;
import net.mqzon.mapletree.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.MAPLE_LEAVES)
                .add(ModBlocks.RED_MAPLE_LEAVES);

        getOrCreateTagBuilder(BlockTags.REPLACEABLE_BY_TREES)
                .add(ModBlocks.MAPLE_LEAVES)
                .add(ModBlocks.RED_MAPLE_LEAVES);

        getOrCreateTagBuilder(ModTags.Blocks.MAPLE_LOGS)
                .add(ModBlocks.MAPLE_LOG)
                .add(ModBlocks.MAPLE_WOOD)
                .add(ModBlocks.STRIPPED_MAPLE_LOG)
                .add(ModBlocks.STRIPPED_MAPLE_WOOD);

        getOrCreateTagBuilder(BlockTags.OVERWORLD_NATURAL_LOGS).add(ModBlocks.MAPLE_LOG);

        getOrCreateTagBuilder(BlockTags.COMPLETES_FIND_TREE_TUTORIAL)
                .add(ModBlocks.MAPLE_LOG)
                .add(ModBlocks.MAPLE_WOOD)
                .add(ModBlocks.STRIPPED_MAPLE_LOG)
                .add(ModBlocks.STRIPPED_MAPLE_WOOD)
                .add(ModBlocks.MAPLE_LEAVES)
                .add(ModBlocks.RED_MAPLE_LEAVES);

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ModBlocks.MAPLE_LOG)
                .add(ModBlocks.MAPLE_WOOD)
                .add(ModBlocks.STRIPPED_MAPLE_LOG)
                .add(ModBlocks.STRIPPED_MAPLE_WOOD);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAPLE_LOG)
                .add(ModBlocks.MAPLE_WOOD)
                .add(ModBlocks.STRIPPED_MAPLE_LOG)
                .add(ModBlocks.STRIPPED_MAPLE_WOOD);

        getOrCreateTagBuilder(BlockTags.PLANKS).add(ModBlocks.MAPLE_PLANKS);

        getOrCreateTagBuilder(BlockTags.SLABS).add(ModBlocks.MAPLE_SLAB);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(ModBlocks.MAPLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.MAPLE_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.MAPLE_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.DOORS).add(ModBlocks.MAPLE_DOOR);
        getOrCreateTagBuilder(BlockTags.TRAPDOORS).add(ModBlocks.MAPLE_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES).add(ModBlocks.MAPLE_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.BUTTONS).add(ModBlocks.MAPLE_BUTTON);

        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(ModBlocks.MAPLE_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(ModBlocks.MAPLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.MAPLE_FENCE);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(ModBlocks.MAPLE_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.MAPLE_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.MAPLE_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(ModBlocks.MAPLE_BUTTON);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.MAPLE_LEAVES)
                .add(ModBlocks.RED_MAPLE_LEAVES);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.MAPLE_LOG)
                .add(ModBlocks.MAPLE_WOOD)
                .add(ModBlocks.STRIPPED_MAPLE_LOG)
                .add(ModBlocks.STRIPPED_MAPLE_WOOD)
                .add(ModBlocks.MAPLE_PLANKS)
                .add(ModBlocks.MAPLE_SLAB)
                .add(ModBlocks.MAPLE_STAIRS)
                .add(ModBlocks.MAPLE_FENCE)
                .add(ModBlocks.MAPLE_FENCE_GATE)
                .add(ModBlocks.MAPLE_DOOR)
                .add(ModBlocks.MAPLE_TRAPDOOR)
                .add(ModBlocks.MAPLE_PRESSURE_PLATE)
                .add(ModBlocks.MAPLE_BUTTON);
    }
}
