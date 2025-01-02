package net.mqzon.mapletree.util;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.mqzon.mapletree.block.ModBlocks;
import net.mqzon.mapletree.block.custom.FillableLeveledCauldronBlock;
import net.mqzon.mapletree.block.custom.SapCauldron;
import net.mqzon.mapletree.item.ModItems;

import java.util.Map;

public class ModCauldronBehaviors implements CauldronBehavior {

    public static CauldronBehavior.CauldronBehaviorMap SAP_CAULDRON_BEHAVIOR = CauldronBehavior.createMap("sap");
    public static CauldronBehavior.CauldronBehaviorMap SYRUP_CAULDRON_BEHAVIOR = CauldronBehavior.createMap("syrup");

    @Override
    public ActionResult interact(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack) {
        return null;
    }

    static CauldronBehavior ADD_SAP_TO_EMPTY_CAULDRON = (state, world, pos, player, hand, stack) -> {
        BlockState newState = ModBlocks.SAP_CAULDRON.getDefaultState()
                .with(LeveledCauldronBlock.LEVEL, Integer.valueOf(1))
                .with(SapCauldron.LIT, SapCauldron.isHeated(world, pos));
        return CauldronBehavior.fillCauldron(world, pos, player, hand, stack, newState, SoundEvents.ITEM_BUCKET_EMPTY);
    };
    static CauldronBehavior ADD_SYRUP_TO_EMPTY_CAULDRON = (state, world, pos, player, hand, stack) -> {
        BlockState newState = ModBlocks.SYRUP_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, Integer.valueOf(1));
        return CauldronBehavior.fillCauldron(world, pos, player, hand, stack, newState, SoundEvents.ITEM_BOTTLE_EMPTY);
    };
    static CauldronBehavior ADD_SAP_TO_SAP_CAULDRON = (state, world, pos, player, hand, stack) -> {
        BlockState newState = FillableLeveledCauldronBlock.raiseFillLevel(state, world, pos);
        if (newState != state) {
            return CauldronBehavior.fillCauldron(world, pos, player, hand, stack, newState, SoundEvents.ITEM_BUCKET_EMPTY);
        }
        return ActionResult.SUCCESS;
    };
    static CauldronBehavior ADD_SYRUP_TO_SYRUP_CAULDRON = (state, world, pos, player, hand, stack) -> {
        BlockState newState = FillableLeveledCauldronBlock.raiseFillLevel(state, world, pos);
        if (newState != state) {
            return CauldronBehavior.fillCauldron(world, pos, player, hand, stack, newState, SoundEvents.ITEM_BOTTLE_EMPTY);
        }
        return ActionResult.SUCCESS;
    };
    static CauldronBehavior REMOVE_SAP_FROM_SAP_CAULDRON = (state, world, pos, player, hand, stack) -> {
        if (!world.isClient) {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.SAP_BUCKET)));
            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
            world.playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.emitGameEvent(null, GameEvent.FLUID_PICKUP, pos);
        }
        return ActionResult.SUCCESS;
    };
    static CauldronBehavior REMOVE_SYRUP_FROM_SYRUP_CAULDRON = (state, world, pos, player, hand, stack) -> {
        if (!world.isClient) {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.SYRUP_BOTTLE)));
            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
            world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.emitGameEvent(null, GameEvent.FLUID_PICKUP, pos);
        }
        return ActionResult.SUCCESS;
    };

    public static void registerBehaviors() {
        Map<Item, CauldronBehavior> emptyCauldronMap = EMPTY_CAULDRON_BEHAVIOR.map();
        emptyCauldronMap.put(ModItems.SAP_BUCKET, ADD_SAP_TO_EMPTY_CAULDRON);
        emptyCauldronMap.put(ModItems.SYRUP_BOTTLE, ADD_SYRUP_TO_EMPTY_CAULDRON);

        Map<Item, CauldronBehavior> sapCauldronMap = SAP_CAULDRON_BEHAVIOR.map();
        sapCauldronMap.put(ModItems.SAP_BUCKET, ADD_SAP_TO_SAP_CAULDRON);
        sapCauldronMap.put(Items.BUCKET, REMOVE_SAP_FROM_SAP_CAULDRON);

        Map<Item, CauldronBehavior> syrupCauldronMap = SYRUP_CAULDRON_BEHAVIOR.map();
        syrupCauldronMap.put(ModItems.SYRUP_BOTTLE, ADD_SYRUP_TO_SYRUP_CAULDRON);
        syrupCauldronMap.put(Items.GLASS_BOTTLE, REMOVE_SYRUP_FROM_SYRUP_CAULDRON);
    }
}
