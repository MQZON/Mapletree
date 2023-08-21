package net.mqzon.mapletree.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
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