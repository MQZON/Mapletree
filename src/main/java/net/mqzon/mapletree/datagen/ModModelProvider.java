package net.mqzon.mapletree.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.TexturedModel;
import net.mqzon.mapletree.block.ModBlocks;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerTintableCross(ModBlocks.MAPLE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.RED_MAPLE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSingleton(ModBlocks.MAPLE_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerSingleton(ModBlocks.RED_MAPLE_LEAVES, TexturedModel.LEAVES);

        blockStateModelGenerator.registerLog(ModBlocks.MAPLE_LOG)
                .log(ModBlocks.MAPLE_LOG).wood(ModBlocks.MAPLE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MAPLE_LOG)
                .log(ModBlocks.STRIPPED_MAPLE_LOG).wood(ModBlocks.STRIPPED_MAPLE_WOOD);

        BlockStateModelGenerator.BlockTexturePool maplePool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MAPLE_PLANKS);
        maplePool.slab(ModBlocks.MAPLE_SLAB);
        maplePool.stairs(ModBlocks.MAPLE_STAIRS);

        maplePool.fence(ModBlocks.MAPLE_FENCE);
        maplePool.fenceGate(ModBlocks.MAPLE_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.MAPLE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.MAPLE_TRAPDOOR);
        maplePool.pressurePlate(ModBlocks.MAPLE_PRESSURE_PLATE);
        maplePool.button(ModBlocks.MAPLE_BUTTON);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
