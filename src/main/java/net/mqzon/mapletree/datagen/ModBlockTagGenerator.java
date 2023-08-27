package net.mqzon.mapletree.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Mapletree.MOD_ID, existingFileHelper);
    }
    public static final TagKey<Block> MAPLE_LOGS = TagKey.create(Registries.BLOCK, new ResourceLocation("mapletree:maple_logs"));

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(MAPLE_LOGS).add(
                ModBlocks.MAPLE_LOG.get(),
                ModBlocks.MAPLE_WOOD.get(),
                ModBlocks.STRIPPED_MAPLE_LOG.get(),
                ModBlocks.STRIPPED_MAPLE_WOOD.get()
        );

        this.tag(BlockTags.COMPLETES_FIND_TREE_TUTORIAL).addTag(MAPLE_LOGS).add(ModBlocks.MAPLE_LEAVES.get());
        this.tag(BlockTags.OVERWORLD_NATURAL_LOGS).add(ModBlocks.MAPLE_LOG.get());
        this.tag(BlockTags.REPLACEABLE_BY_TREES).add(ModBlocks.MAPLE_LEAVES.get());

        this.tag(BlockTags.LOGS).addTag(MAPLE_LOGS);
        this.tag(BlockTags.LOGS_THAT_BURN).addTag(MAPLE_LOGS);

        this.tag(BlockTags.BUTTONS).add(ModBlocks.MAPLE_BUTTON.get());
        this.tag(BlockTags.DOORS).add(ModBlocks.MAPLE_DOOR.get());
        this.tag(BlockTags.FENCES).add(ModBlocks.MAPLE_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(ModBlocks.MAPLE_FENCE_GATE.get());
        this.tag(BlockTags.FLOWER_POTS).add(ModBlocks.POTTED_MAPLE_SAPLING.get());
        this.tag(BlockTags.LEAVES).add(ModBlocks.MAPLE_LEAVES.get());
        this.tag(BlockTags.PLANKS).add(ModBlocks.MAPLE_PLANKS.get());
        this.tag(BlockTags.PRESSURE_PLATES).add(ModBlocks.MAPLE_PRESSURE_PLATE.get());
        this.tag(BlockTags.SAPLINGS).add(ModBlocks.MAPLE_SAPLING.get());
        this.tag(BlockTags.SLABS).add(ModBlocks.MAPLE_SLAB.get());
        this.tag(BlockTags.STAIRS).add(ModBlocks.MAPLE_STAIRS.get());
        this.tag(BlockTags.TRAPDOORS).add(ModBlocks.MAPLE_TRAPDOOR.get());

        this.tag(BlockTags.WOODEN_BUTTONS).add(ModBlocks.MAPLE_BUTTON.get());
        this.tag(BlockTags.WOODEN_DOORS).add(ModBlocks.MAPLE_DOOR.get());
        this.tag(BlockTags.WOODEN_FENCES).add(ModBlocks.MAPLE_FENCE.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.MAPLE_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_SLABS).add(ModBlocks.MAPLE_SLAB.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(ModBlocks.MAPLE_STAIRS.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.MAPLE_TRAPDOOR.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE).add(ModBlocks.MAPLE_LEAVES.get());

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
    }
}