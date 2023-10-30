package net.mqzon.mapletree.utility;

import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
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

public class SapCauldronInteraction implements CauldronInteraction {
    public static Map<Item, CauldronInteraction> SAP = CauldronInteraction.newInteractionMap();
    @Override
    public InteractionResult interact(BlockState pBlockState, Level pLevel, BlockPos pBlockPos,
                                      Player pPlayer, InteractionHand pHand, ItemStack pStack) {
        return CauldronInteraction.emptyBucket(pLevel, pBlockPos, pPlayer, pHand, pStack,
                ModBlocks.SAP_CAULDRON.get().defaultBlockState(), SoundEvents.BUCKET_EMPTY);
    }

    public static void bootstrap(){
        EMPTY.put(ModItems.SAP_BUCKET.get(), new SapCauldronInteraction());
        SAP.put(ModItems.SAP_BUCKET.get(), (blockState, level, blockPos, player, hand, stack) -> {
            BlockState newState = FillableLayeredCauldronBlock.raiseFillLevel(blockState, level, blockPos);
            if (newState != blockState) {
                return CauldronInteraction.emptyBucket(level, blockPos, player, hand, stack, newState, SoundEvents.BUCKET_EMPTY);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        });
        SAP.put(Items.BUCKET, (blockState, level, blockPos, player, hand, stack) -> {
            if (!level.isClientSide){
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUtils.createFilledResult(stack, player, new ItemStack(ModItems.SAP_BUCKET.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                LayeredCauldronBlock.lowerFillLevel(blockState, level, blockPos);
                level.playSound((Player)null, blockPos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.gameEvent((Entity)null, GameEvent.FLUID_PICKUP, blockPos);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        });
    }
}
