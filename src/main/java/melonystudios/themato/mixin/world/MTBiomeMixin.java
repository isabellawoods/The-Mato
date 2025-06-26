package melonystudios.themato.mixin.world;

import melonystudios.themato.config.MTConfigs;
import melonystudios.themato.sound.MTSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.BackgroundMusicSelector;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(Biome.class)
public class MTBiomeMixin {
    @OnlyIn(Dist.CLIENT)
    @Inject(method = "getBackgroundMusic", at = @At("HEAD"), cancellable = true)
    public void getBackgroundMusic(CallbackInfoReturnable<Optional<BackgroundMusicSelector>> callback) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player != null && MTConfigs.COMMON_CONFIGS.replaceBiomeMusic.get()) {
            Biome biome = minecraft.player.level.getBiome(minecraft.player.blockPosition());
            if (biome.getRegistryName() == null) return;

            switch (biome.getRegistryName().toString()) {
                case "minecraft:badlands":
                case "minecraft:badlands_plateau":
                case "minecraft:modified_badlands_plateau":
                case "minecraft:wooded_badlands_plateau":
                case "minecraft:modified_wooded_badlands_plateau":
                case "minecraft:eroded_badlands":
                    callback.setReturnValue(Optional.of(BackgroundMusicTracks.createGameMusic(MTSounds.BADLANDS_MUSIC.get())));
                case "minecraft:bamboo_jungle":
                case "minecraft:bamboo_jungle_hills":
                    callback.setReturnValue(Optional.of(BackgroundMusicTracks.createGameMusic(MTSounds.BAMBOO_JUNGLE_MUSIC.get())));
                case "minecraft:desert":
                case "minecraft:desert_hills":
                case "minecraft:desert_lakes":
                    callback.setReturnValue(Optional.of(BackgroundMusicTracks.createGameMusic(MTSounds.DESERT_MUSIC.get())));
                case "minecraft:flower_forest":
                    callback.setReturnValue(Optional.of(BackgroundMusicTracks.createGameMusic(MTSounds.FLOWER_FOREST_MUSIC.get())));
                case "minecraft:forest":
                case "minecraft:wooded_hills":
                    callback.setReturnValue(Optional.of(BackgroundMusicTracks.createGameMusic(MTSounds.FOREST_MUSIC.get())));
                case "minecraft:jungle":
                case "minecraft:jungle_hills":
                case "minecraft:modified_jungle":
                    callback.setReturnValue(Optional.of(BackgroundMusicTracks.createGameMusic(MTSounds.JUNGLE_MUSIC.get())));
                case "minecraft:giant_spruce_taiga": // old growth spruce taiga
                case "minecraft:giant_spruce_taiga_hills":
                case "minecraft:giant_tree_taiga": // old growth pine taiga
                case "minecraft:giant_tree_taiga_hills":
                    callback.setReturnValue(Optional.of(BackgroundMusicTracks.createGameMusic(MTSounds.OLD_GROWTH_TAIGA_MUSIC.get())));
                case "minecraft:jungle_edge":
                case "minecraft:modified_jungle_edge":
                    callback.setReturnValue(Optional.of(BackgroundMusicTracks.createGameMusic(MTSounds.SPARSE_JUNGLE_MUSIC.get())));
                case "minecraft:swamp":
                case "minecraft:swamp_hills":
                    callback.setReturnValue(Optional.of(BackgroundMusicTracks.createGameMusic(MTSounds.SWAMP_MUSIC.get())));
            }
        }
    }
}
