package melonystudios.themato.mixin.world;

import melonystudios.themato.config.MTConfigs;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultBiomeFeatures.class)
public class MTDefaultBiomeFeaturesMixin {
    @Inject(method = "addDefaultLakes", at = @At("HEAD"), cancellable = true)
    private static void addDefaultLakes(BiomeGenerationSettings.Builder settings, CallbackInfo callback) {
        if (MTConfigs.COMMON_CONFIGS.removeWaterLakes.get()) {
            callback.cancel();
            settings.addFeature(GenerationStage.Decoration.LAKES, Features.LAKE_LAVA);
        }
    }
}
