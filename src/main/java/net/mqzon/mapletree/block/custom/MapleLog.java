package net.mqzon.mapletree.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.mqzon.mapletree.item.ModItems;

public class MapleLog extends ModFlammableRotatedPillarBlock {
    public MapleLog(Properties pProperties) {
        super(pProperties);
    }

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (itemstack.is(Items.BUCKET)) {
            pPlayer.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
            ItemStack itemstack1 = ItemUtils.createFilledResult(itemstack, pPlayer, ModItems.SAP_BUCKET.get().getDefaultInstance());
            pPlayer.setItemInHand(pHand, itemstack1);
            return InteractionResult.sidedSuccess(pLevel.isClientSide());
        } else {
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        }
    }
}
