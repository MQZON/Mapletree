package net.mqzon.mapletree.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.mqzon.mapletree.block.entity.ModBlockEntities;

public class ModHangingSignBlockEntity extends HangingSignBlockEntity {
    public ModHangingSignBlockEntity(BlockPos p_250603_, BlockState p_251674_) {
        super(p_250603_, p_251674_);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.HANGING_SIGN_BLOCK_ENTITIES.get();
    }
}
