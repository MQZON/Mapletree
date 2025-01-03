package net.mqzon.mapletree.world.trunk;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class MegaMapleTrunkPlacer extends LargeOakTrunkPlacer {
    public MegaMapleTrunkPlacer(int i, int j, int k) {
        super(i, j, k);
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        return this.generateLargeOakTrunk(world, replacer, random, height, startPos, config);
    }

    public List<FoliagePlacer.TreeNode> generateLargeOakTrunk(
            TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config
    ) {
        int treeHeight = height + 2;
        int mainTrunkLength = MathHelper.floor((double)treeHeight * 0.618);
        setToDirt(world, replacer, random, startPos.down(), config);
        int topBranchEnd = startPos.getY() + mainTrunkLength;
        int currentHeight = treeHeight - 5;
        List<MegaMapleTrunkPlacer.BranchPosition> list = Lists.<MegaMapleTrunkPlacer.BranchPosition>newArrayList();
        list.add(new MegaMapleTrunkPlacer.BranchPosition(startPos.up(currentHeight), topBranchEnd));

        for (; currentHeight >= 0; currentHeight--) {
            float branchSize = shouldGenerateBranch(treeHeight, currentHeight);
            if (!(branchSize < 0.0F)) {
                double branchLength = branchSize * (random.nextFloat() + 0.328);
                double randomPositionOnCircle = random.nextFloat() * 2.0F * Math.PI;
                double xOffset = branchLength * Math.sin(randomPositionOnCircle) + 0.5;
                double zOffset = branchLength * Math.cos(randomPositionOnCircle) + 0.5;
                BlockPos blockPos = startPos.add(MathHelper.floor(xOffset), currentHeight - 1, MathHelper.floor(zOffset));
                BlockPos blockPos2 = blockPos.up(5);

                if (this.checkBranch(world, blockPos, blockPos2 )) {
                    int r = startPos.getX() - blockPos.getX();
                    int s = startPos.getZ() - blockPos.getZ();
                    double t = (double)blockPos.getY() - Math.sqrt((double)(r * r + s * s)) * 0.381;
                    int u = t > (double)topBranchEnd ? topBranchEnd : (int)t;
                    BlockPos blockPos3 = new BlockPos(startPos.getX(), u, startPos.getZ());
                    if (this.checkBranch(world, blockPos3, blockPos )) {
                        list.add(new MegaMapleTrunkPlacer.BranchPosition(blockPos, blockPos3.getY()));
                    }
                }
            }
        }

        this.makeBranch(world, replacer, random, startPos, startPos.up(mainTrunkLength), config);
        this.makeBranches(world, replacer, random, treeHeight, startPos, list, config);
        List<FoliagePlacer.TreeNode> list2 = Lists.<FoliagePlacer.TreeNode>newArrayList();

        for (MegaMapleTrunkPlacer.BranchPosition branchPosition : list) {
            if (this.isHighEnough(treeHeight, branchPosition.getEndY() - startPos.getY())) {
                list2.add(branchPosition.node);
            }
        }

        return list2;
    }

    private boolean checkBranch(TestableWorld world, BlockPos startPos, BlockPos branchPos) {
        if (!Objects.equals(startPos, branchPos)) {
            BlockPos blockPos = branchPos.add(-startPos.getX(), -startPos.getY(), -startPos.getZ());
            int i = this.getLongestSide(blockPos);
            float f = (float) blockPos.getX() / (float) i;
            float g = (float) blockPos.getY() / (float) i;
            float h = (float) blockPos.getZ() / (float) i;

            for (int j = 0; j <= i; j++) {
                BlockPos blockPos2 = startPos.add(
                        MathHelper.floor(0.5F + (float) j * f),
                        MathHelper.floor(0.5F + (float) j * g),
                        MathHelper.floor(0.5F + (float) j * h));
                if (!this.canReplaceOrIsLog(world, blockPos2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void makeBranch(
            TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos startPos, BlockPos branchPos, TreeFeatureConfig config
    ) {
        BlockPos blockPos = branchPos.add(-startPos.getX(), -startPos.getY(), -startPos.getZ());
        int i = this.getLongestSide(blockPos);
        float f = (float)blockPos.getX() / (float)i;
        float g = (float)blockPos.getY() / (float)i;
        float h = (float)blockPos.getZ() / (float)i;

        for (int j = 0; j <= i; j++) {
            BlockPos blockPos2 = startPos.add(
                    MathHelper.floor(0.5F + (float)j * f),
                    MathHelper.floor(0.5F + (float)j * g),
                    MathHelper.floor(0.5F + (float)j * h));
            Direction.Axis axis = this.getLogAxis(startPos, blockPos2);
            this.getAndSetState(world, replacer, random, blockPos2, config, state -> state.withIfExists(PillarBlock.AXIS, axis));
        }
    }

    private int getLongestSide(BlockPos offset) {
        int x = MathHelper.abs(offset.getX());
        int y = MathHelper.abs(offset.getY());
        int z = MathHelper.abs(offset.getZ());
        return Math.max(x, Math.max(y, z));
    }

    private Direction.Axis getLogAxis(BlockPos branchStart, BlockPos branchEnd) {
        Direction.Axis axis = Direction.Axis.Y;
        int i = Math.abs(branchEnd.getX() - branchStart.getX());
        int j = Math.abs(branchEnd.getZ() - branchStart.getZ());
        int k = Math.max(i, j);
        if (k > 0) {
            if (i == k) {
                axis = Direction.Axis.X;
            } else {
                axis = Direction.Axis.Z;
            }
        }

        return axis;
    }

    private boolean isHighEnough(int treeHeight, int height) {
        return (double)height >= (double)treeHeight * 0.2;
    }

    private void makeBranches(
            TestableWorld world,
            BiConsumer<BlockPos, BlockState> replacer,
            Random random,
            int treeHeight,
            BlockPos startPos,
            List<MegaMapleTrunkPlacer.BranchPosition> branchPositions,
            TreeFeatureConfig config
    ) {
        for (MegaMapleTrunkPlacer.BranchPosition branchPosition : branchPositions) {
            int endHeight = branchPosition.getEndY();
            BlockPos branchEnd = new BlockPos(startPos.getX(), endHeight, startPos.getZ());
            boolean branchEndsInTrunk = branchEnd.equals(branchPosition.node.getCenter());
            boolean branchIsHighEnough = this.isHighEnough(treeHeight, endHeight - startPos.getY());
            if (!branchEndsInTrunk && branchIsHighEnough) {
                this.makeBranch(world, replacer, random, branchEnd, branchPosition.node.getCenter(), config);
            }
        }
    }

    /**
     * If the returned value is greater than or equal to 0, a branch will be generated.
     */
    private static float shouldGenerateBranch(int treeHeight, int currentHeight) {
        // Branches only generate above 30% of the tree height
        if ((float)currentHeight < (float)treeHeight * 0.3F) {
            return -1.0F;
        } else {
            float halfHeight = (float)treeHeight / 2.0F;
            float g = halfHeight - (float)currentHeight;
            float h = MathHelper.sqrt(halfHeight * halfHeight - g * g);
            if (g == 0.0F) {
                h = halfHeight;
            } else if (Math.abs(g) >= halfHeight) {
                return 0.0F;
            }

            return h * 0.5F;
        }
    }

    static class BranchPosition {
        final FoliagePlacer.TreeNode node;
        private final int endY;

        public BranchPosition(BlockPos pos, int endHeight) {
            this.node = new FoliagePlacer.TreeNode(pos, 0, false);
            this.endY = endHeight;
        }

        public int getEndY() {
            return this.endY;
        }
    }
}
