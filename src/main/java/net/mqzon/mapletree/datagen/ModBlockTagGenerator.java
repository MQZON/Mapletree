package net.mqzon.mapletree.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Mapletree.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(
                ModBlocks.MAPLE_LEAVES.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_AXE).add(
                ModBlocks.MAPLE_LOG.get(),
                ModBlocks.MAPLE_WOOD.get(),
                ModBlocks.STRIPPED_MAPLE_LOG.get(),
                ModBlocks.STRIPPED_MAPLE_WOOD.get(),
                ModBlocks.MAPLE_PLANKS.get(),
                ModBlocks.MAPLE_STAIRS.get(),
                ModBlocks.MAPLE_SLAB.get(),
                ModBlocks.MAPLE_FENCE.get(),
                ModBlocks.MAPLE_FENCE_GATE.get(),
                ModBlocks.MAPLE_DOOR.get(),
                ModBlocks.MAPLE_TRAPDOOR.get(),
                ModBlocks.MAPLE_PRESSURE_PLATE.get(),
                ModBlocks.MAPLE_BUTTON.get()
        );

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.MAPLE_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.MAPLE_FENCE_GATE.get());
    }
}
