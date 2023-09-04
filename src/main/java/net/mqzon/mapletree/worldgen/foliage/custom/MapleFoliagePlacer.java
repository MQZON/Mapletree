package net.mqzon.mapletree.worldgen.foliage.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.mqzon.mapletree.worldgen.foliage.ModFoliagePlacers;

public class MapleFoliagePlacer extends FoliagePlacer {
    public static final Codec<MapleFoliagePlacer> CODEC = RecordCodecBuilder.create((p_273246_) -> {
        return foliagePlacerParts(p_273246_).and(p_273246_.group(IntProvider.codec(4, 16).fieldOf("height").forGetter((p_273527_) -> {
            return p_273527_.height;
        }), Codec.floatRange(0.0F, 1.0F).fieldOf("wide_bottom_layer_hole_chance").forGetter((p_273760_) -> {
            return p_273760_.wideBottomLayerHoleChance;
        }), Codec.floatRange(0.0F, 1.0F).fieldOf("corner_hole_chance").forGetter((p_273020_) -> {
            return p_273020_.wideBottomLayerHoleChance;
        }))).apply(p_273246_, MapleFoliagePlacer::new);
    });
    private final IntProvider height;
    private final float wideBottomLayerHoleChance;
    private final float cornerHoleChance;

    public MapleFoliagePlacer(IntProvider pRadius, IntProvider pOffset,
                              IntProvider pHeight, float wideBottomLayerHoleChance,
                              float cornerHoleChance) {
        super(pRadius, pOffset);
        this.height = pHeight;
        this.wideBottomLayerHoleChance = wideBottomLayerHoleChance;
        this.cornerHoleChance = cornerHoleChance;
    }

    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacers.MAPLE_FOLIAGE_PLACER.get();
    }

    protected void createFoliage(LevelSimulatedReader pLevel, FoliagePlacer.FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig, int pMaxFreeTreeHeight, FoliagePlacer.FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        boolean flag = pAttachment.doubleTrunk();
        BlockPos blockpos = pAttachment.pos().below(pOffset);
        int i = pFoliageRadius + pAttachment.radiusOffset() - 1;
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, i - 2, pFoliageHeight - 3, flag);
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, i - 1, pFoliageHeight - 4, flag);

        for(int j = pFoliageHeight - 5; j >= 0; --j) {
            this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, i, j, flag);
        }

        this.placeLeavesRowWithHangingLeavesBelow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, i, -1, flag, 0, 0);
        this.placeLeavesRowWithHangingLeavesBelow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, i - 1, -2, flag, 0, 0);
    }

    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.height.sample(pRandom);
    }

    /**
     * Skips certain positions based on the provided shape, such as rounding corners randomly.
     * The coordinates are passed in as absolute value, and should be within [0, {@code range}].
     */
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        if (pLocalY == -1 && (pLocalX == pRange || pLocalZ == pRange) && pRandom.nextFloat() < this.wideBottomLayerHoleChance) {
            return true;
        } else {
            boolean flag = pLocalX == pRange && pLocalZ == pRange;
            boolean flag1 = pRange > 2;
            if (flag1) {
                return flag || pLocalX + pLocalZ > pRange * 2 - 2 && pRandom.nextFloat() < this.cornerHoleChance;
            } else {
                return flag && pRandom.nextFloat() < this.cornerHoleChance;
            }
        }
    }
}
