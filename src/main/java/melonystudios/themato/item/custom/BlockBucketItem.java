package melonystudios.themato.item.custom;

import melonystudios.themato.dispenser.BlockBucketDispenseBehavior;
import melonystudios.themato.util.MTUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Supplier;

public class BlockBucketItem extends BlockItem {
    private final Supplier<SoundEvent> emptySound;

    public BlockBucketItem(Supplier<SoundEvent> emptySound, Block block, Properties properties) {
        super(block, properties);
        this.emptySound = emptySound;
        DispenserBlock.registerBehavior(this, new BlockBucketDispenseBehavior());
    }

    @Override
    @Nonnull
    public ActionResultType useOn(ItemUseContext context) {
        ActionResultType resultType = super.useOn(context);
        PlayerEntity player = context.getPlayer();
        if (resultType.consumesAction() && player != null && !player.isCreative()) {
            MTUtils.setItemInHand(player, context.getHand(), new ItemStack(Items.BUCKET));
        }
        return resultType;
    }

    @Override
    @Nonnull
    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }

    @Override
    @Nonnull
    protected SoundEvent getPlaceSound(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        return this.emptySound.get();
    }

    public boolean emptyContents(@Nullable PlayerEntity player, World world, BlockPos pos, @Nullable BlockRayTraceResult hitResult) {
        if (World.isInWorldBounds(pos) && world.isEmptyBlock(pos)) {
            if (!world.isClientSide) world.setBlock(pos, this.getBlock().defaultBlockState(), 3);
            world.playSound(player, pos, this.emptySound.get(), SoundCategory.BLOCKS, 1, 1);
            return true;
        } else {
            return false;
        }
    }
}
