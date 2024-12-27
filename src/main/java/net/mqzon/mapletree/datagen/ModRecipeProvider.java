package net.mqzon.mapletree.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.mqzon.mapletree.block.ModBlocks;
import net.mqzon.mapletree.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static final Ingredient MAPLE_PLANKS_INGREDIENT = Ingredient.ofItems(ModBlocks.MAPLE_PLANKS.asItem());
    public static final String HAS_MAPLE_PLANKS = hasItem(ModBlocks.MAPLE_PLANKS);
    public static final AdvancementCriterion<?> HAS_MAPLE_PLANKS_CRITERION = conditionsFromItem(ModBlocks.MAPLE_PLANKS);

    @Override
    public void generate(RecipeExporter exporter) {
        offerBarkBlockRecipe(exporter, ModBlocks.MAPLE_WOOD, ModBlocks.MAPLE_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_MAPLE_WOOD, ModBlocks.STRIPPED_MAPLE_LOG);

        offerPlanksRecipe(exporter, ModBlocks.MAPLE_PLANKS, ModTags.Items.MAPLE_LOGS, 4);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_SLAB, ModBlocks.MAPLE_PLANKS);
        createStairsRecipe(ModBlocks.MAPLE_STAIRS, MAPLE_PLANKS_INGREDIENT).criterion(HAS_MAPLE_PLANKS, HAS_MAPLE_PLANKS_CRITERION).offerTo(exporter);
        createFenceRecipe(ModBlocks.MAPLE_FENCE, MAPLE_PLANKS_INGREDIENT).criterion(HAS_MAPLE_PLANKS, HAS_MAPLE_PLANKS_CRITERION).offerTo(exporter);
        createFenceGateRecipe(ModBlocks.MAPLE_FENCE_GATE, MAPLE_PLANKS_INGREDIENT).criterion(HAS_MAPLE_PLANKS, HAS_MAPLE_PLANKS_CRITERION).offerTo(exporter);
        createDoorRecipe(ModBlocks.MAPLE_DOOR, MAPLE_PLANKS_INGREDIENT).criterion(HAS_MAPLE_PLANKS, HAS_MAPLE_PLANKS_CRITERION).offerTo(exporter);
        createTrapdoorRecipe(ModBlocks.MAPLE_TRAPDOOR, MAPLE_PLANKS_INGREDIENT).criterion(HAS_MAPLE_PLANKS, HAS_MAPLE_PLANKS_CRITERION).offerTo(exporter);
        offerPressurePlateRecipe(exporter, ModBlocks.MAPLE_PRESSURE_PLATE, ModBlocks.MAPLE_PLANKS);
        offerShapelessRecipe(exporter, ModBlocks.MAPLE_BUTTON, ModBlocks.MAPLE_PLANKS, "wooden_button", 1);
    }
}
