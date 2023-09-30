package net.mqzon.mapletree.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class MapletreeCommonConfigs {
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec.ConfigValue<Boolean> MAPLE_TRADE;

    static {
        BUILDER.push("Mapletree Configurations");
        MAPLE_TRADE = BUILDER
                .comment("Saplings can be obtained from wandering traders")
                .comment("Change true to false to disable the sapling trade")
                .define("Maple Trade Enabled", Boolean.TRUE);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}