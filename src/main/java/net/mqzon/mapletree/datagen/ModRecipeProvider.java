package net.mqzon.mapletree.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.mqzon.mapletree.block.ModBlocks;
import net.mqzon.mapletree.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output) { super(output); }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        woodFromLogs(consumer, ModBlocks.MAPLE_WOOD.get(), ModBlocks.MAPLE_LOG.get());
        woodFromLogs(consumer, ModBlocks.STRIPPED_MAPLE_WOOD.get(), ModBlocks.STRIPPED_MAPLE_LOG.get());

        Ingredient ingredient_maple_planks = Ingredient.of(ModBlocks.MAPLE_PLANKS.get().asItem());
        planksFromLogs(consumer, ModBlocks.MAPLE_PLANKS.get(), ModItemTagGenerator.MAPLE_LOGS, 4);

        stairBuilder(ModBlocks.MAPLE_STAIRS.get(), ingredient_maple_planks)
                .group("wooden_stairs")
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get())).save(consumer);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_SLAB.get(), ingredient_maple_planks)
                .group("wooden_slab")
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get())).save(consumer);
        fenceBuilder(ModBlocks.MAPLE_FENCE.get(), ingredient_maple_planks)
                .group("wooden_fence")
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get())).save(consumer);
        fenceGateBuilder(ModBlocks.MAPLE_FENCE_GATE.get(), ingredient_maple_planks)
                .group("wooden_fence_gate")
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get())).save(consumer);
        doorBuilder(ModBlocks.MAPLE_DOOR.get(), ingredient_maple_planks)
                .group("wooden_door")
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get())).save(consumer);
        trapdoorBuilder(ModBlocks.MAPLE_TRAPDOOR.get(), ingredient_maple_planks)
                .group("wooden_trapdoor")
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get())).save(consumer);
        pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.MAPLE_PRESSURE_PLATE.get(), ingredient_maple_planks)
                .group("wooden_pressure_plate")
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get())).save(consumer);
        buttonBuilder(ModBlocks.MAPLE_BUTTON.get(), ingredient_maple_planks)
                .group("wooden_button")
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get())).save(consumer);
        signBuilder(ModItems.MAPLE_SIGN.get(), ingredient_maple_planks)
                .group("wooden_sign")
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get())).save(consumer);
        hangingSign(consumer, ModItems.MAPLE_HANGING_SIGN.get(), ModBlocks.STRIPPED_MAPLE_LOG.get());
        woodenBoat(consumer,ModItems.MAPLE_BOAT.get(),ModBlocks.MAPLE_PLANKS.get());
        chestBoat(consumer,ModItems.MAPLE_CHEST_BOAT.get(),ModItems.MAPLE_BOAT.get());

        smeltingResultFromBase(consumer, ModItems.SYRUP_BOTTLE.get(), ModItems.SAP_BUCKET.get());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.GLAZED_CARROTS.get(), 3)
                .requires(Items.CARROT, 3).requires(ModItems.SYRUP_BOTTLE.get(), 1)
                .unlockedBy("has_syrup", has(ModItems.SYRUP_BOTTLE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.GLAZED_SALMON.get())
                .requires(Items.COOKED_SALMON, 1).requires(ModItems.SYRUP_BOTTLE.get(), 1)
                .unlockedBy("has_syrup", has(ModItems.SYRUP_BOTTLE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.PANCAKES.get())
                .requires(Items.WHEAT, 1).requires(Items.EGG, 1).requires(Items.MILK_BUCKET, 1)
                .requires(ModItems.SYRUP_BOTTLE.get(), 1)
                .unlockedBy("has_syrup", has(ModItems.SYRUP_BOTTLE.get())).save(consumer);
    }
}
