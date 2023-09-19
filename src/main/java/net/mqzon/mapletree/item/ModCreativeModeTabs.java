package net.mqzon.mapletree.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.mqzon.mapletree.Mapletree;
import net.mqzon.mapletree.block.ModBlocks;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Mapletree.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MAPLETREE_TAB = CREATIVE_MODE_TABS.register("mapletree_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MAPLE_SAPLING.get()))
                    .title(Component.translatable("creativetab.mapletree_tab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.MAPLE_SAPLING.get());
                        pOutput.accept(ModBlocks.RED_MAPLE_SAPLING.get());
                        pOutput.accept(ModBlocks.MAPLE_LEAVES.get());
                        pOutput.accept(ModBlocks.RED_MAPLE_LEAVES.get());
                        pOutput.accept(ModBlocks.MAPLE_LOG.get());
                        pOutput.accept(ModBlocks.MAPLE_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_MAPLE_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_MAPLE_WOOD.get());
                        pOutput.accept(ModBlocks.MAPLE_PLANKS.get());

                        pOutput.accept(ModBlocks.MAPLE_STAIRS.get());
                        pOutput.accept(ModBlocks.MAPLE_SLAB.get());
                        pOutput.accept(ModBlocks.MAPLE_FENCE.get());
                        pOutput.accept(ModBlocks.MAPLE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.MAPLE_DOOR.get());
                        pOutput.accept(ModBlocks.MAPLE_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.MAPLE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.MAPLE_BUTTON.get());

                        pOutput.accept(ModItems.MAPLE_SIGN.get());
                        pOutput.accept(ModItems.MAPLE_HANGING_SIGN.get());

                        pOutput.accept(ModItems.SAP_BUCKET.get());
                        pOutput.accept(ModItems.SYRUP_BOTTLE.get());
                    })).build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
