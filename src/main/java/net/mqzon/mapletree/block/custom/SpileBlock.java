package net.mqzon.mapletree.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import net.mqzon.mapletree.block.ModBlocks;
import net.mqzon.mapletree.util.ModTags;
import org.jetbrains.annotations.Nullable;

public class SpileBlock extends Block {
    public static final MapCodec<SpileBlock> CODEC = createCodec(SpileBlock::new);
    public static final EnumProperty<Direction> FACING = HorizontalFacingBlock.FACING;
    public static final BooleanProperty TAPPING = Properties.ACTIVE;
    protected static final VoxelShape EAST_SHAPE = Block.createCuboidShape(0.0, 14.0, 7.0, 8.0, 16.0, 9.0);
    protected static final VoxelShape WEST_SHAPE = Block.createCuboidShape(8.0, 14.0, 7.0, 16.0, 16.0, 9.0);
    protected static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(7.0, 14.0, 0.0, 9.0, 16.0, 8.0);
    protected static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(7.0, 14.0, 8.0, 9.0, 16.0, 16.0);


    public SpileBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(TAPPING, Boolean.valueOf(false)));

    }

    @Override
    public MapCodec<SpileBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch ((Direction)state.get(FACING)) {
            case NORTH:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case EAST:
            default:
                return EAST_SHAPE;
        }
    }

    private boolean canPlaceOn(BlockView world, BlockPos pos, Direction side) {
        BlockState blockState = world.getBlockState(pos);
        return blockState.isSideSolidFullSquare(world, pos, side);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = state.get(FACING);
        return this.canPlaceOn(world, pos.offset(direction.getOpposite()), direction);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state,
            WorldView world,
            ScheduledTickView tickView,
            BlockPos pos,
            Direction direction,
            BlockPos neighborPos,
            BlockState neighborState,
            Random random
    ) {
        if (direction.getOpposite() == state.get(FACING) && !state.canPlaceAt(world, pos)) {
            return Blocks.AIR.getDefaultState();
        } else {
            return super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        if (!ctx.canReplaceExisting()) {
            BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(ctx.getSide().getOpposite()));
            if (blockState.isOf(this) && blockState.get(FACING) == ctx.getSide()) {
                return null;
            }
        }

        BlockState blockState = this.getDefaultState();
        WorldView worldView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();

        for (Direction direction : ctx.getPlacementDirections()) {
            if (direction.getAxis().isHorizontal()) {
                blockState = blockState.with(FACING, direction.getOpposite());
                if (blockState.canPlaceAt(worldView, blockPos)) {
                    BlockState placingOn = worldView.getBlockState(blockPos.offset(direction));
                    return blockState.with(TAPPING, Boolean.valueOf(placingOn.isIn(ModTags.Blocks.MAPLE_LOGS)));
                }
            }
        }

        return null;
    }
    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }
//    @Override
//    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {

//        wireOrientation.
//        if (!world.isClient) {
//            if (isHeated(world, pos)) {
//                world.setBlockState(pos, state.with(LIT, true));
//            } else {
//                world.setBlockState(pos, state.with(LIT, false));
//            }
//        }
//    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return state.get(TAPPING);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockState blockBelow = world.getBlockState(pos.down());
        if (blockBelow.isOf(Blocks.CAULDRON)) {
            world.setBlockState(pos.down(), ModBlocks.SAP_CAULDRON.getDefaultState());
        }

        if (blockBelow.isOf(ModBlocks.SAP_CAULDRON) && blockBelow.get(SapCauldron.LEVEL) < 3) {
           world.setBlockState(pos.down(), FillableLeveledCauldronBlock.raiseFillLevel(blockBelow, world, pos.down()));
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TAPPING);
        builder.add(FACING);
    }

}
