package net.mqzon.mapletree.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.block.ModBlocks;
import net.mqzon.mapletree.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, Mapletree.MOD_ID, existingFileHelper);
    }

    public static final TagKey<Item> MAPLE_LOGS = TagKey.create(Registries.ITEM, new ResourceLocation("mapletree:maple_logs"));
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.copy(ModBlockTagGenerator.MAPLE_LOGS, MAPLE_LOGS);

        this.tag(ItemTags.COMPLETES_FIND_TREE_TUTORIAL).addTag(MAPLE_LOGS).add(ModBlocks.MAPLE_LEAVES.get().asItem());

        this.tag(ItemTags.LOGS).addTag(MAPLE_LOGS);
        this.tag(ItemTags.LOGS_THAT_BURN).addTag(MAPLE_LOGS);

        this.tag(ItemTags.BUTTONS).add(ModBlocks.MAPLE_BUTTON.get().asItem());
        this.tag(ItemTags.DOORS).add(ModBlocks.MAPLE_DOOR.get().asItem());
        this.tag(ItemTags.FENCES).add(ModBlocks.MAPLE_FENCE.get().asItem());
        this.tag(ItemTags.FENCE_GATES).add(ModBlocks.MAPLE_FENCE_GATE.get().asItem());
        this.tag(ItemTags.LEAVES).add(ModBlocks.MAPLE_LEAVES.get().asItem());
        this.tag(ItemTags.PLANKS).add(ModBlocks.MAPLE_PLANKS.get().asItem());
        this.tag(ItemTags.SAPLINGS).add(ModBlocks.MAPLE_SAPLING.get().asItem());
        this.tag(ItemTags.SLABS).add(ModBlocks.MAPLE_SLAB.get().asItem());
        this.tag(ItemTags.STAIRS).add(ModBlocks.MAPLE_STAIRS.get().asItem());
        this.tag(ItemTags.TRAPDOORS).add(ModBlocks.MAPLE_TRAPDOOR.get().asItem());

        this.tag(ItemTags.WOODEN_BUTTONS).add(ModBlocks.MAPLE_BUTTON.get().asItem());
        this.tag(ItemTags.WOODEN_DOORS).add(ModBlocks.MAPLE_DOOR.get().asItem());
        this.tag(ItemTags.WOODEN_FENCES).add(ModBlocks.MAPLE_FENCE.get().asItem());
        this.tag(ItemTags.WOODEN_SLABS).add(ModBlocks.MAPLE_SLAB.get().asItem());
        this.tag(ItemTags.WOODEN_STAIRS).add(ModBlocks.MAPLE_STAIRS.get().asItem());
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.MAPLE_PRESSURE_PLATE.get().asItem());
        this.tag(ItemTags.WOODEN_TRAPDOORS).add(ModBlocks.MAPLE_TRAPDOOR.get().asItem());

        this.tag(ItemTags.SIGNS).add(ModItems.MAPLE_SIGN.get());
    }
}
