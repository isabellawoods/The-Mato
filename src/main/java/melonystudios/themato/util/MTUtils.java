package melonystudios.themato.util;

import melonystudios.themato.TheMato;
import net.minecraft.client.audio.BackgroundMusicSelector;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.GameRules;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Random;
import java.util.function.Predicate;

public class MTUtils {
    public static final GameRules.RuleKey<GameRules.BooleanValue> FREEZE_DAMAGE = GameRules.register("freezeDamage", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));

    public static void init() {}

    public static void setItemInHand(PlayerEntity player, Hand hand, ItemStack stack) {
        player.inventory.items.set(hand == Hand.OFF_HAND ? 0 : player.inventory.selected, stack);
    }

    public static ResourceLocation theMato(String name) {
        return new ResourceLocation(TheMato.MOD_ID, name);
    }

    public static ResourceLocation backMath(String name) {
        return new ResourceLocation("backmath", name);
    }

    public static ResourceLocation revaried(String name) {
        return new ResourceLocation("variants", name);
    }

    public static float randomBetween(Random rand, float a, float b) {
        return rand.nextFloat() * (b - a) + a;
    }

    public static boolean hasAnyMatching(Iterable<ItemStack> armorSlots, Predicate<ItemStack> stack) {
        for (ItemStack invStack : armorSlots) {
            if (stack.test(invStack)) return true;
        }
        return false;
    }

    public static void replaceBiomeMusic(RegistryKey<Biome> biome, SoundEvent music, BiomeLoadingEvent event) {
        if (event.getName() != null && event.getName().equals(biome.getRegistryName())) {
            event.setEffects(copyFromWithMusic(event.getEffects(), BackgroundMusicTracks.createGameMusic(music)));
        }
    }

    private static BiomeAmbience copyFromWithMusic(BiomeAmbience effects, BackgroundMusicSelector musicSelector) {
        BiomeAmbience.Builder builder = new BiomeAmbience.Builder();
        builder.fogColor(effects.getFogColor());
        builder.waterColor(effects.getWaterColor());
        builder.waterFogColor(effects.getWaterFogColor());
        builder.skyColor(effects.getSkyColor());
        builder.grassColorModifier(effects.getGrassColorModifier());
        if (effects.getFoliageColorOverride().isPresent()) builder.foliageColorOverride(effects.getFoliageColorOverride().get());
        if (effects.getGrassColorOverride().isPresent()) builder.grassColorOverride(effects.getGrassColorOverride().get());
        if (effects.getAmbientParticleSettings().isPresent()) builder.ambientParticle(effects.getAmbientParticleSettings().get());
        if (effects.getAmbientLoopSoundEvent().isPresent()) builder.ambientLoopSound(effects.getAmbientLoopSoundEvent().get());
        if (effects.getAmbientAdditionsSettings().isPresent()) builder.ambientAdditionsSound(effects.getAmbientAdditionsSettings().get());
        builder.backgroundMusic(musicSelector);
        return builder.build();
    }

    public static ItemStack createFilledResult(ItemStack filledStack, PlayerEntity player, ItemStack emptyStack, boolean preventDuplicates) {
        boolean flag = player.abilities.instabuild;
        if (preventDuplicates && flag) {
            if (!player.inventory.contains(emptyStack)) {
                player.inventory.add(emptyStack);
            }

            return filledStack;
        } else {
            if (!flag) {
                filledStack.shrink(1);
            }

            if (filledStack.isEmpty()) {
                return emptyStack;
            } else {
                if (!player.inventory.add(emptyStack)) {
                    player.drop(emptyStack, false);
                }

                return filledStack;
            }
        }
    }

    public static ItemStack createFilledResult(ItemStack filledStack, PlayerEntity player, ItemStack emptyStack) {
        return createFilledResult(filledStack, player, emptyStack, true);
    }
}
