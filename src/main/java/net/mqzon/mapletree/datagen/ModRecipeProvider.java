package net.mqzon.mapletree.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.mqzon.mapletree.block.ModBlocks;

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
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get())).save(consumer);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_SLAB.get(), ingredient_maple_planks)
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get())).save(consumer);
        fenceBuilder(ModBlocks.MAPLE_FENCE.get(), ingredient_maple_planks)
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get())).save(consumer);
        fenceGateBuilder(ModBlocks.MAPLE_FENCE_GATE.get(), ingredient_maple_planks)
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get())).save(consumer);
        doorBuilder(ModBlocks.MAPLE_DOOR.get(), ingredient_maple_planks)
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get())).save(consumer);
        trapdoorBuilder(ModBlocks.MAPLE_TRAPDOOR.get(), ingredient_maple_planks)
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get())).save(consumer);
        pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.MAPLE_PRESSURE_PLATE.get(), ingredient_maple_planks)
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get())).save(consumer);
        buttonBuilder(ModBlocks.MAPLE_BUTTON.get(), ingredient_maple_planks)
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get())).save(consumer);
    }
}
