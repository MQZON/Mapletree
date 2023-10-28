package net.mqzon.mapletree.utility;

import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.mqzon.mapletree.block.ModBlocks;
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
        SAP.put(Items.BUCKET, ((blockState, level, blockPos, player, hand, stack) ->
                CauldronInteraction.fillBucket(blockState, level, blockPos, player, hand, stack, new ItemStack(ModItems.SAP_BUCKET.get()),
                        (p_175660_) -> true, SoundEvents.BUCKET_FILL)));
    }
}
