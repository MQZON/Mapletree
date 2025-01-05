package net.mqzon.mapletree.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TexturedModel;
import net.mqzon.mapletree.block.ModBlocks;
import net.mqzon.mapletree.boat.ModBoats;
import net.mqzon.mapletree.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    private static final BlockStateModelGenerator.CrossType NOT_TINTED = BlockStateModelGenerator.CrossType.NOT_TINTED;

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.MAPLE_SAPLING, ModBlocks.POTTED_MAPLE_SAPLING, NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.RED_MAPLE_SAPLING, ModBlocks.POTTED_RED_MAPLE_SAPLING, NOT_TINTED);

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
        maplePool.family(ModBlocks.MAPLE_FAMILY);
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_MAPLE_LOG, ModBlocks.MAPLE_HANGING_SIGN, ModBlocks.MAPLE_WALL_HANGING_SIGN);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModBlocks.MAPLE_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.RED_MAPLE_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBoats.MAPLE_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModBoats.MAPLE_CHEST_BOAT, Models.GENERATED);

//        itemModelGenerator.register(ModBlocks.SPILE.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.SAP_BUCKET, Models.GENERATED);

        itemModelGenerator.register(ModItems.SYRUP_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_CARROTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLAZED_SALMON, Models.GENERATED);
        itemModelGenerator.register(ModItems.PANCAKES, Models.GENERATED);
    }
}
