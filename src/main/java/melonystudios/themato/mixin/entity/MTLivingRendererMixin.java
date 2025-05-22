package melonystudios.themato.mixin.entity;

import melonystudios.themato.effect.MTEffects;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingRenderer.class)
public class MTLivingRendererMixin {
    @Inject(method = "isShaking", at = @At("HEAD"), cancellable = true)
    private void isShaking(LivingEntity livEntity, CallbackInfoReturnable<Boolean> callback) {
        callback.setReturnValue(livEntity.hasEffect(MTEffects.FREEZING.get()));
    }
}
