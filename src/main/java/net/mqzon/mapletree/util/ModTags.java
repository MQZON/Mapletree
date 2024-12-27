package net.mqzon.mapletree.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.mqzon.mapletree.Mapletree;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> MAPLE_LOGS = createTag("maple_logs");
        public static final TagKey<Block> MAPLE_LEAVES = createTag("maple_leaves");
        public static final TagKey<Block> MAPLE_SIGNS = createTag("maple_signs");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Mapletree.MOD_ID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> MAPLE_LOGS = createTag("maple_logs");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Mapletree.MOD_ID, name));
        }
    }
}
