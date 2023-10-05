package net.mqzon.mapletree.event;


import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.block.ModBlocks;
import net.mqzon.mapletree.config.MapletreeCommonConfigs;

import java.util.List;

@Mod.EventBusSubscriber(modid = Mapletree.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> trades = event.getGenericTrades();

        if(MapletreeCommonConfigs.MAPLE_TRADE.get()) {
            ItemStack mapleSapling = new ItemStack(ModBlocks.MAPLE_SAPLING.get(), 1);
            trades.add(new BasicItemListing(new ItemStack(Items.EMERALD, 5),
                    mapleSapling, 8, 1, 1));
        }

        if(MapletreeCommonConfigs.RED_MAPLE_TRADE.get()) {
            ItemStack mapleSapling = new ItemStack(ModBlocks.RED_MAPLE_SAPLING.get(), 1);
            trades.add(new BasicItemListing(new ItemStack(Items.EMERALD, 5),
                    mapleSapling, 8, 1, 1));
        }
    }
}
