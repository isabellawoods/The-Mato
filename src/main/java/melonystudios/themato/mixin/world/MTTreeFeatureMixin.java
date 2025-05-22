package melonystudios.themato.mixin.world;

import melonystudios.themato.util.MTTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.feature.TreeFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.world.gen.feature.Feature.isDirt;

@Mixin(TreeFeature.class)
public class MTTreeFeatureMixin {
    @Inject(method = "isGrassOrDirtOrFarmland", at = @At("HEAD"), cancellable = true)
    private static void isGrassOrDirtOrFarmland(IWorldGenerationBaseReader reader, BlockPos pos, CallbackInfoReturnable<Boolean> callback) {
        callback.setReturnValue(reader.isStateAtPosition(pos, state -> isDirt(state.getBlock()) || state.is(MTTags.Blocks.SNOWY_TREES_SPAWNABLE_ON)));
    }
}
