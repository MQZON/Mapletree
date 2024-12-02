package net.mqzon.mapletree;

import net.fabricmc.api.ModInitializer;

import net.mqzon.mapletree.block.ModBlocks;
import net.mqzon.mapletree.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mapletree implements ModInitializer {
	public static final String MOD_ID = "mapletree";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}