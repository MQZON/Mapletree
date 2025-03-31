package net.mqzon.mapletree.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.TradedItem;
import net.mqzon.mapletree.block.ModBlocks;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        TradeOffer MapleSaplingOffer = new TradeOffer(
                new TradedItem(Items.EMERALD, 5),
                new ItemStack(ModBlocks.MAPLE_SAPLING, 1), 8, 1, 1
        );
        TradeOffer RedMapleSaplingOffer = new TradeOffer(
                new TradedItem(Items.EMERALD, 5),
                new ItemStack(ModBlocks.RED_MAPLE_SAPLING, 1), 8, 1, 1
        );
        Identifier specialItems = TradeOfferHelper.WanderingTraderOffersBuilder.SELL_SPECIAL_ITEMS_POOL;
        TradeOffers.Factory saplingFactory = (entity, random) -> MapleSaplingOffer;
        TradeOffers.Factory redSaplingFactory = (entity, random) -> RedMapleSaplingOffer;

        TradeOfferHelper.registerWanderingTraderOffers(( builder ) -> builder.addOffersToPool(specialItems, saplingFactory));
        TradeOfferHelper.registerWanderingTraderOffers(( builder ) -> builder.addOffersToPool(specialItems, redSaplingFactory));

    }
}
