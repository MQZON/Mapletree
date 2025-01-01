package net.mqzon.mapletree.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent SYRUP_BOTTLE = syrupyFood(4, 0.1F, 1);
    public static final FoodComponent GLAZED_CARROTS =syrupyFood(3, 0.6F, 0.334F);
    public static final FoodComponent GLAZED_SALMON = syrupyFood(5, 0.6F, 1);
    public static final FoodComponent PANCAKES = syrupyFood(7, 0.5F, 1);

    private static FoodComponent syrupyFood(int nutrition, float saturation, float chance) {
        return new FoodComponent.Builder().nutrition(nutrition).saturationModifier(saturation)
                .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 5), chance).build();
    }
}
