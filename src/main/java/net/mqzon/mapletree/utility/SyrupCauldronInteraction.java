package net.mqzon.mapletree.utility;

import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.mqzon.mapletree.block.ModBlocks;
import net.mqzon.mapletree.block.custom.FillableLayeredCauldronBlock;
import net.mqzon.mapletree.item.ModItems;

import java.util.Map;

public class SyrupCauldronInteraction implements CauldronInteraction {
    public static Map<Item, CauldronInteraction> SYRUP = CauldronInteraction.newInteractionMap();
    @Override
    public InteractionResult interact(BlockState blockState, Level level, BlockPos blockPos,
                                      Player player, InteractionHand hand, ItemStack stack) {
        return emptyBottle(level, blockPos, player, hand, stack, ModBlocks.SYRUP_CAULDRON.get().defaultBlockState(), SoundEvents.BOTTLE_EMPTY);
    }

    public static void bootstrap(){
        EMPTY.put(ModItems.SYRUP_BOTTLE.get(), new SyrupCauldronInteraction());
        SYRUP.put(ModItems.SYRUP_BOTTLE.get(), (blockState, level, blockPos, player, hand, stack) -> {
            BlockState newState = FillableLayeredCauldronBlock.raiseFillLevel(blockState, level, blockPos);
            if (newState != blockState) {
                return emptyBottle(level, blockPos, player, hand, stack, newState, SoundEvents.BOTTLE_EMPTY);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        });
        SYRUP.put(Items.GLASS_BOTTLE, (blockState, level, blockPos, player, hand, stack) -> {
            if (!level.isClientSide){
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUtils.createFilledResult(stack, player, new ItemStack(ModItems.SYRUP_BOTTLE.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                LayeredCauldronBlock.lowerFillLevel(blockState, level, blockPos);
                level.playSound((Player)null, blockPos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.gameEvent((Entity)null, GameEvent.FLUID_PICKUP, blockPos);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        });
    }

    static InteractionResult emptyBottle(Level level, BlockPos blockPos, Player player, InteractionHand hand,
                                         ItemStack stack, BlockState blockState, SoundEvent emptySound) {
        if (!level.isClientSide) {
            Item item = stack.getItem();
            player.setItemInHand(hand, ItemUtils.createFilledResult(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
            player.awardStat(Stats.USE_CAULDRON);
            player.awardStat(Stats.ITEM_USED.get(item));
            level.setBlockAndUpdate(blockPos, blockState);
            level.playSound((Player)null, blockPos, emptySound, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.gameEvent((Entity)null, GameEvent.FLUID_PLACE, blockPos);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
