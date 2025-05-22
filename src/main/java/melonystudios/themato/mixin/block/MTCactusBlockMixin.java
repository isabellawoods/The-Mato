package melonystudios.themato.mixin.block;

import melonystudios.themato.block.MTBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CactusBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import javax.annotation.Nullable;

@Mixin(CactusBlock.class)
public class MTCactusBlockMixin extends Block {
    public MTCactusBlockMixin(Properties properties) {
        super(properties);
    }

    @Unique
    @Override
    @Nullable
    public BlockState getToolModifiedState(BlockState state, World world, BlockPos pos, PlayerEntity player, ItemStack stack, ToolType toolType) {
        if (player.getMainHandItem().getItem() instanceof AxeItem || player.getOffhandItem().getItem() instanceof AxeItem) {
            if (state.is(Blocks.CACTUS)) return MTBlocks.STRIPPED_CACTUS.get().defaultBlockState();
        }
        return super.getToolModifiedState(state, world, pos, player, stack, toolType);
    }
}
