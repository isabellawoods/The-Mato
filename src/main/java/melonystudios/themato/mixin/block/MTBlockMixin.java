package melonystudios.themato.mixin.block;

import melonystudios.themato.sound.MTSoundTypes;
import melonystudios.themato.util.MTTags;
import it.unimi.dsi.fastutil.objects.Object2ByteLinkedOpenHashMap;
import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public abstract class MTBlockMixin extends AbstractBlock {
    @Shadow
    @Final
    private static ThreadLocal<Object2ByteLinkedOpenHashMap<Block.RenderSideCacheKey>> OCCLUSION_CACHE;

    public MTBlockMixin(Properties properties) {
        super(properties);
    }

    /// Copied from [Vanilla Backport](https://modrinth.com/mod/vanillabackport) (formerly Caves & Cliffs Backport).
    /// @author blackgear27
    @Inject(method = "shouldRenderFace", at = @At("HEAD"), cancellable = true)
    private static void shouldRenderFace(BlockState state, IBlockReader world, BlockPos pos, Direction side, CallbackInfoReturnable<Boolean> callback) {
        if (world.getBlockState(pos).getBlock().is(MTTags.Blocks.USES_UPDATED_CULLING)) {
            BlockPos adjacentPos = pos.relative(side);
            BlockState adjacentState = world.getBlockState(adjacentPos);
            if (state.skipRendering(adjacentState, side)) {
                callback.setReturnValue(false);
            } else if (adjacentState.canOcclude()) {
                Block.RenderSideCacheKey cache = new Block.RenderSideCacheKey(state, adjacentState, side);
                Object2ByteLinkedOpenHashMap<Block.RenderSideCacheKey> map = OCCLUSION_CACHE.get();
                byte id = map.getAndMoveToFirst(cache);

                if (id != 127) {
                    callback.setReturnValue(id != 0);
                } else {
                    VoxelShape occlusionShape = state.getFaceOcclusionShape(world, pos, side);
                    if (occlusionShape.isEmpty()) {
                        callback.setReturnValue(true);
                    } else {
                        VoxelShape adjacentOcclusionShape = adjacentState.getFaceOcclusionShape(world, adjacentPos, side.getOpposite());
                        boolean canCompare = VoxelShapes.joinIsNotEmpty(occlusionShape, adjacentOcclusionShape, IBooleanFunction.ONLY_FIRST);
                        if (map.size() == 2048) map.removeLastByte();

                        map.putAndMoveToFirst(cache, (byte) (canCompare ? 1 : 0));
                        callback.setReturnValue(canCompare);
                    }
                }
            } else {
                callback.setReturnValue(true);
            }
        }
    }

    @Inject(method = "getSoundType", at = @At("HEAD"), cancellable = true)
    public void getSoundType(BlockState state, CallbackInfoReturnable<SoundType> callback) {
        if (state.is(MTTags.Blocks.USES_CALCITE_SOUNDS)) {
            callback.setReturnValue(MTSoundTypes.CALCITE);
        } else if (state.is(MTTags.Blocks.USES_POWDER_SNOW_SOUNDS)) {
            callback.setReturnValue(MTSoundTypes.POWDER_SNOW);
        }
    }
}
