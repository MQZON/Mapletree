package net.mqzon.mapletree.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent SYRUP_BOTTLE = createFood(4, 0.1F);
    public static final FoodComponent GLAZED_CARROTS =createFood(3, 0.6F);
    public static final FoodComponent GLAZED_SALMON = createFood(5, 0.6F);
    public static final FoodComponent PANCAKES = createFood(7, 0.5F);

    private static FoodComponent createFood(int nutrition, float saturation) {
        return new FoodComponent.Builder().nutrition(nutrition).saturationModifier(saturation).build();
    }
}
