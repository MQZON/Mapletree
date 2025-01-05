package net.mqzon.mapletree.world.foliage;

import com.google.common.collect.Lists;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

import java.util.List;

import static java.lang.Math.sqrt;
import static net.minecraft.util.math.MathHelper.floor;

public class SpheroidShellPlacer extends BlobFoliagePlacer {

    public static final MapCodec<SpheroidShellPlacer> CODEC = RecordCodecBuilder.mapCodec(
//            instance -> fillFoliagePlacerFields(instance)
//                    .<IntProvider, Float, Float, Float, Float>and(
//                            instance.group(
//                                    IntProvider.createValidatingCodec(4, 16).fieldOf("heigbt").forGetter(foliagePlacer -> foliagePlacer.heigbt),
//                                    Codec.floatRange(0.0F, 1.0F).fieldOf("wide_bottom_layer_hole_chance").forGetter(foliagePlacer -> foliagePlacer.wideBottomLayerHoleChance),
//                                    Codec.floatRange(0.0F, 1.0F).fieldOf("corner_hole_chance").forGetter(foliagePlacer -> foliagePlacer.wideBottomLayerHoleChance),
//                                    Codec.floatRange(0.0F, 1.0F).fieldOf("hanging_leaves_chance").forGetter(foliagePlacer -> foliagePlacer.hangingLeavesChance),
//                                    Codec.floatRange(0.0F, 1.0F).fieldOf("hanging_leaves_extension_chance").forGetter(foliagePlacer -> foliagePlacer.hangingLeavesExtensionChance)
//                            )
//                    )
//                    .apply(instance, SpheroidShellPlacer::new)
            instance -> createCodec(instance).apply(instance, SpheroidShellPlacer::new)
    );
//    private final int thickness;
//    private final float bumpiness;

    public SpheroidShellPlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset, height);
//        this.thickness = thickness;
//        this.bumpiness = bumpiness;
    }


    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.SPHEROID_SHELL_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        // start at treenode (top) and work down foliageHeight (or trunkheight?)
        //semi-major axis is the distance from center/origin to the outer radius
        //semi-minor acis is the distance from the center/origin to the top
        // spheroid equation: 1 = (x^2 + z^2)/sMaj + (y^2)/sMin

        // equation for circle at height y: localR = sqrt((sMaj^2/2)(sMaj^2 - (y^2/sMin^2)))

        // value for z given x is +/- sqrt(r^2 - ry^2/sMin - x^2)
        //y is current height
        float sMaj = 16; //radius; // semi-major axis
        float sMin = 24; //foliageHeight; // semi-minor axis (this assumes the height is a hemi-spheroid. May want to split out param)
        BlockPos.Mutable currentCenter = treeNode.getCenter().mutableCopy();
        for (int i = 0; i < 24; i++) { //start from top? //foliageheight
            int y = trunkHeight - i; //trunkHeight
            double r = sqrt(sMaj * sMaj * 0.5 * (1 - ((y * y) / (sMin * sMin))));
            List<BlockPos> points = makeRing(currentCenter, r);
            points.forEach((point) -> placeFoliageBlock(world, placer, random, config, point));

            currentCenter.move(Direction.DOWN);
        }
    }

    // Generates positions for a horizontal ring of radius 'r' about center
    // Iterates over "x" offsets along radius, calculating the corresponding "z" offset.
    // Once offsets are determined, they are reused for each quadrant.
    private List<BlockPos> makeRing(BlockPos center, double r) {
        List<BlockPos> points = Lists.<BlockPos>newArrayList();
        for (int xOffset = 0; xOffset < r; xOffset ++) {
            int zOffset = floor(sqrt(r*r - xOffset*xOffset));

            BlockPos.Mutable m1 = new BlockPos.Mutable().set(center, xOffset, 0, zOffset);
            BlockPos.Mutable m2 = new BlockPos.Mutable().set(center, xOffset, 0, -zOffset);
            BlockPos.Mutable m3 = new BlockPos.Mutable().set(center, -xOffset, 0, zOffset);
            BlockPos.Mutable m4 = new BlockPos.Mutable().set(center, -xOffset, 0, -zOffset);

            // Apply thickness

            // Apply bumpiness

            points.add(m1);
            points.add(m2);
            points.add(m3);
            points.add(m4);
        }
        return points;
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 0;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }
}
