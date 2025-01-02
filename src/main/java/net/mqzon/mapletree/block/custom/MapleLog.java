package net.mqzon.mapletree.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.mqzon.mapletree.item.ModItems;

public class MapleLog extends PillarBlock {
    public MapleLog(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isOf(Items.BUCKET)) {
            stack.decrement(1);
            player.playSound(SoundEvents.ENTITY_COW_MILK);
            if (stack.isEmpty()) {
                player.setStackInHand(hand, new ItemStack(ModItems.SAP_BUCKET));
            } else if (!player.getInventory().insertStack(new ItemStack(ModItems.SAP_BUCKET))) {
                player.dropItem(new ItemStack(ModItems.SAP_BUCKET), false);
            }
            return ActionResult.SUCCESS;
        } else {
            return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
        }
    }
}
