package net.mqzon.mapletree.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.ConsumeEffect;
import net.minecraft.sound.SoundEvents;

public class ModConsumableComponents extends ConsumableComponents {
    public static final ConsumableComponent SYRUP_BOTTLE;
    public static final ConsumableComponent GLAZED_CARROTS;
    public static final ConsumableComponent GLAZED_SALMON;
    public static final ConsumableComponent PANCAKES;

    private static ConsumeEffect syrupEffect(Float chance) {
        return new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SATURATION, 5), chance);
    }

    static {
        SYRUP_BOTTLE = drink().consumeSeconds(2.0F).sound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK).consumeEffect(syrupEffect(1.0F)).build();
        GLAZED_CARROTS = food().consumeEffect(syrupEffect(0.334F)).build();
        GLAZED_SALMON = food().consumeEffect(syrupEffect(1.0F)).build();
        PANCAKES = food().consumeEffect(syrupEffect(1.0F)).build();
    }
}
