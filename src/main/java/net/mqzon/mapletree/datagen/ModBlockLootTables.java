package net.mqzon.mapletree.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.mqzon.mapletree.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.MAPLE_LOG.get());
        this.dropSelf(ModBlocks.MAPLE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_MAPLE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_MAPLE_WOOD.get());
        this.dropSelf(ModBlocks.MAPLE_PLANKS.get());
        this.dropSelf(ModBlocks.MAPLE_SAPLING.get());

        this.dropPottedContents(ModBlocks.POTTED_MAPLE_SAPLING.get());

        this.add(ModBlocks.MAPLE_LEAVES.get(), (block) ->
                createLeavesDrops(
                        block,
                        ModBlocks.MAPLE_SAPLING.get(),
                        NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(ModBlocks.MAPLE_STAIRS.get());
        this.dropSelf(ModBlocks.MAPLE_BUTTON.get());
        this.dropSelf(ModBlocks.MAPLE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.MAPLE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.MAPLE_FENCE.get());
        this.dropSelf(ModBlocks.MAPLE_FENCE_GATE.get());

        this.add(ModBlocks.MAPLE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MAPLE_SLAB.get()));
        this.add(ModBlocks.MAPLE_DOOR.get(),
                block -> createDoorTable(ModBlocks.MAPLE_DOOR.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
