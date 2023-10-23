package net.mqzon.mapletree.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SYRUP_BOTTLE = alwaysSaturatingFood(4, 0.1f, 5); //EQ19.8
    public static final FoodProperties GLAZED_CARROTS = saturatingFood(3, 0.6f, 5, 0.334f); //EQ11.6 (6.6-21.6)
    public static final FoodProperties GLAZED_SALMON = alwaysSaturatingFood(5, 0.6f, 5); //EQ26
    public static final FoodProperties PANCAKES = alwaysSaturatingFood(7, 0.5f, 5); //EQ29

    private static FoodProperties alwaysSaturatingFood(int nutrition, float saturationMod, int duration) {
        return saturatingFood(nutrition, saturationMod, duration, 1.0f);
    }
    private static FoodProperties saturatingFood(int nutrition, float saturationMod, int duration, float probability) {
        return (new FoodProperties.Builder())
                .nutrition(nutrition).saturationMod(saturationMod)
                .effect(() -> new MobEffectInstance(MobEffects.SATURATION, duration), probability).build();
    }
}
