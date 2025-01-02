package net.mqzon.mapletree.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.mqzon.mapletree.block.ModBlocks;
import net.mqzon.mapletree.boat.ModBoats;
import net.mqzon.mapletree.item.ModItems;
import net.mqzon.mapletree.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {

            public static final Ingredient MAPLE_PLANKS_INGREDIENT = Ingredient.ofItems(ModBlocks.MAPLE_PLANKS.asItem());
            public static final String HAS_MAPLE_PLANKS = hasItem(ModBlocks.MAPLE_PLANKS);
            public final AdvancementCriterion<?> HAS_MAPLE_PLANKS_CRITERION = conditionsFromItem(ModBlocks.MAPLE_PLANKS);
            public static final String HAS_MAPLE_LEAVES = hasItem(ModBlocks.MAPLE_LEAVES);
            public final AdvancementCriterion<?> HAS_MAPLE_LEAVES_CRITERION = conditionsFromItem(ModBlocks.MAPLE_LEAVES);
            public static final String RED_HAS_MAPLE_LEAVES = hasItem(ModBlocks.RED_MAPLE_LEAVES);
            public final AdvancementCriterion<?> RED_HAS_MAPLE_LEAVES_CRITERION = conditionsFromItem(ModBlocks.RED_MAPLE_LEAVES);
            public static final String HAS_SYRUP = hasItem(ModItems.SYRUP_BOTTLE);
            public final AdvancementCriterion<?> HAS_SYRUP_CRITERION = conditionsFromItem(ModItems.SYRUP_BOTTLE);

            @Override
            public void generate() {

                offerShapelessRecipe(ModBlocks.MAPLE_LEAF_PILE, ModBlocks.MAPLE_LEAVES, "misc",8);
                offerShapelessRecipe(ModBlocks.RED_MAPLE_LEAF_PILE, ModBlocks.RED_MAPLE_LEAVES, "misc",8);
                createShapeless(RecipeCategory.MISC, ModBlocks.MAPLE_LEAVES).input(ModBlocks.MAPLE_LEAF_PILE, 8)
                        .criterion(HAS_MAPLE_LEAVES,HAS_MAPLE_LEAVES_CRITERION).offerTo(exporter);
                createShapeless(RecipeCategory.MISC, ModBlocks.RED_MAPLE_LEAVES).input(ModBlocks.RED_MAPLE_LEAF_PILE, 8)
                        .criterion(RED_HAS_MAPLE_LEAVES,RED_HAS_MAPLE_LEAVES_CRITERION).offerTo(exporter);

                offerBarkBlockRecipe(ModBlocks.MAPLE_WOOD, ModBlocks.MAPLE_LOG);
                offerBarkBlockRecipe(ModBlocks.STRIPPED_MAPLE_WOOD, ModBlocks.STRIPPED_MAPLE_LOG);

                offerPlanksRecipe(ModBlocks.MAPLE_PLANKS, ModTags.Items.MAPLE_LOGS, 4);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_SLAB, ModBlocks.MAPLE_PLANKS);
                createStairsRecipe(ModBlocks.MAPLE_STAIRS, MAPLE_PLANKS_INGREDIENT).criterion(HAS_MAPLE_PLANKS, HAS_MAPLE_PLANKS_CRITERION).offerTo(exporter);
                createFenceRecipe(ModBlocks.MAPLE_FENCE, MAPLE_PLANKS_INGREDIENT).criterion(HAS_MAPLE_PLANKS, HAS_MAPLE_PLANKS_CRITERION).offerTo(exporter);
                createFenceGateRecipe(ModBlocks.MAPLE_FENCE_GATE, MAPLE_PLANKS_INGREDIENT).criterion(HAS_MAPLE_PLANKS, HAS_MAPLE_PLANKS_CRITERION).offerTo(exporter);
                createDoorRecipe(ModBlocks.MAPLE_DOOR, MAPLE_PLANKS_INGREDIENT).criterion(HAS_MAPLE_PLANKS, HAS_MAPLE_PLANKS_CRITERION).offerTo(exporter);
                createTrapdoorRecipe(ModBlocks.MAPLE_TRAPDOOR, MAPLE_PLANKS_INGREDIENT).criterion(HAS_MAPLE_PLANKS, HAS_MAPLE_PLANKS_CRITERION).offerTo(exporter);
                offerPressurePlateRecipe(ModBlocks.MAPLE_PRESSURE_PLATE, ModBlocks.MAPLE_PLANKS);
                offerShapelessRecipe(ModBlocks.MAPLE_BUTTON, ModBlocks.MAPLE_PLANKS, "wooden_button", 1);
                createSignRecipe(ModItems.MAPLE_SIGN, MAPLE_PLANKS_INGREDIENT).criterion(HAS_MAPLE_PLANKS, HAS_MAPLE_PLANKS_CRITERION).offerTo(exporter);
                offerHangingSignRecipe(ModItems.MAPLE_HANGING_SIGN, ModBlocks.STRIPPED_MAPLE_LOG);
                offerBoatRecipe(ModBoats.MAPLE_BOAT, ModBlocks.MAPLE_PLANKS);
                offerChestBoatRecipe(ModBoats.MAPLE_CHEST_BOAT, ModBoats.MAPLE_BOAT);

                createShapeless(RecipeCategory.FOOD, ModItems.GLAZED_CARROTS, 3).input(ModItems.SYRUP_BOTTLE)
                        .input(Items.CARROT, 3).criterion(HAS_SYRUP, HAS_SYRUP_CRITERION).offerTo(exporter);
                createShapeless(RecipeCategory.FOOD, ModItems.GLAZED_SALMON).input(ModItems.SYRUP_BOTTLE)
                        .input(Items.COOKED_SALMON).criterion(HAS_SYRUP, HAS_SYRUP_CRITERION).offerTo(exporter);
                createShapeless(RecipeCategory.FOOD, ModItems.PANCAKES).input(ModItems.SYRUP_BOTTLE)
                        .input(Items.WHEAT).input(Items.EGG).input(Items.MILK_BUCKET).criterion(HAS_SYRUP, HAS_SYRUP_CRITERION).offerTo(exporter);
            }
        };


    }




    @Override
    public String getName() {
        return "Mapletree Recipes";
    }
}
