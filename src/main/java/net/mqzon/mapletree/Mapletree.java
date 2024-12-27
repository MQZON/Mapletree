package net.mqzon.mapletree;

import net.fabricmc.api.ModInitializer;

import net.mqzon.mapletree.block.ModBlocks;
import net.mqzon.mapletree.entity.ModBoats;
import net.mqzon.mapletree.item.ModItemGroups;
import net.mqzon.mapletree.item.ModItems;
import net.mqzon.mapletree.particle.ModParticles;
import net.mqzon.mapletree.world.foliage.ModFoliagePlacerTypes;
import net.mqzon.mapletree.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mapletree implements ModInitializer {
	public static final String MOD_ID = "mapletree";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModParticles.registerParticles();
		ModItemGroups.registerItemGroups();
		ModBoats.registerBoats();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModFoliagePlacerTypes.register();
		ModWorldGeneration.generateModWorldGen();
	}
}