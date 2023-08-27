package net.mqzon.mapletree.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Mapletree.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        logBlock((RotatedPillarBlock) ModBlocks.MAPLE_LOG.get());

        axisBlock((RotatedPillarBlock) ModBlocks.MAPLE_WOOD.get(),
                blockTexture(ModBlocks.MAPLE_LOG.get()),
                blockTexture(ModBlocks.MAPLE_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_MAPLE_LOG.get(),
                new ResourceLocation(Mapletree.MOD_ID, "block/stripped_maple_log"),
                new ResourceLocation(Mapletree.MOD_ID, "block/stripped_maple_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_MAPLE_WOOD.get(),
                new ResourceLocation(Mapletree.MOD_ID, "block/stripped_maple_log"),
                new ResourceLocation(Mapletree.MOD_ID, "block/stripped_maple_log"));

        blockWithItem(ModBlocks.MAPLE_PLANKS);
        blockWithItem(ModBlocks.MAPLE_LEAVES);
        saplingBlock(ModBlocks.MAPLE_SAPLING);

        simpleBlock(ModBlocks.POTTED_MAPLE_SAPLING.get(),
                models().withExistingParent(
                        "mapletree:potted_maple_sapling",
                        "minecraft:block/flower_pot_cross")
                        .texture("plant", "mapletree:block/maple_sapling")
                        .renderType("cutout"));

        simpleBlockItem(ModBlocks.MAPLE_LOG.get(),
                models().withExistingParent(
                        "mapletree:maple_log",
                        "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.MAPLE_WOOD.get(),
                models().withExistingParent(
                        "mapletree:maple_wood",
                        "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_MAPLE_LOG.get(),
                models().withExistingParent(
                        "mapletree:stripped_maple_log",
                        "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_MAPLE_WOOD.get(),
                models().withExistingParent(
                        "mapletree:stripped_maple_wood",
                        "minecraft:block/cube_column"));

        stairsBlock(((StairBlock) ModBlocks.MAPLE_STAIRS.get()), blockTexture(ModBlocks.MAPLE_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.MAPLE_SLAB.get()), blockTexture(ModBlocks.MAPLE_PLANKS.get()), blockTexture(ModBlocks.MAPLE_PLANKS.get()));

        fenceBlock(((FenceBlock) ModBlocks.MAPLE_FENCE.get()), blockTexture(ModBlocks.MAPLE_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.MAPLE_FENCE_GATE.get()), blockTexture(ModBlocks.MAPLE_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.MAPLE_DOOR.get()), modLoc("block/maple_door_bottom"), modLoc("block/maple_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.MAPLE_TRAPDOOR.get()), modLoc("block/maple_trapdoor"), true, "cutout");

        pressurePlateBlock(((PressurePlateBlock) ModBlocks.MAPLE_PRESSURE_PLATE.get()), blockTexture(ModBlocks.MAPLE_PLANKS.get()));
        buttonBlock(((ButtonBlock) ModBlocks.MAPLE_BUTTON.get()), blockTexture(ModBlocks.MAPLE_PLANKS.get()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(
                        ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                        blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}