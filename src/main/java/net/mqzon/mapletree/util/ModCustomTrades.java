package net.mqzon.mapletree.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.mqzon.mapletree.block.ModBlocks;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerWanderingTraderOffers(2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 5),
                            new ItemStack(ModBlocks.MAPLE_SAPLING, 1), 8, 1, 1
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 5),
                            new ItemStack(ModBlocks.RED_MAPLE_SAPLING, 1), 8, 1, 1
                    ));
                });
    }
}
