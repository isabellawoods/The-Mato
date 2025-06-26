package melonystudios.themato.sound;

import melonystudios.themato.TheMato;
import melonystudios.themato.util.MTUtils;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MTSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TheMato.MOD_ID);

    // Biome Music
    public static final RegistryObject<SoundEvent> MEADOW_MUSIC = SOUNDS.register("music.overworld.meadow", () -> new SoundEvent(MTUtils.theMato("music.overworld.meadow")));
    public static final RegistryObject<SoundEvent> FROZEN_PEAKS_MUSIC = SOUNDS.register("music.overworld.frozen_peaks", () -> new SoundEvent(MTUtils.theMato("music.overworld.frozen_peaks")));
    public static final RegistryObject<SoundEvent> SNOWY_SLOPES_MUSIC = SOUNDS.register("music.overworld.snowy_slopes", () -> new SoundEvent(MTUtils.theMato("music.overworld.snowy_slopes")));
    public static final RegistryObject<SoundEvent> JAGGED_PEAKS_MUSIC = SOUNDS.register("music.overworld.jagged_peaks", () -> new SoundEvent(MTUtils.theMato("music.overworld.jagged_peaks")));
    public static final RegistryObject<SoundEvent> STONY_PEAKS_MUSIC = SOUNDS.register("music.overworld.stony_peaks", () -> new SoundEvent(MTUtils.theMato("music.overworld.stony_peaks")));
    public static final RegistryObject<SoundEvent> GROVE_MUSIC = SOUNDS.register("music.overworld.grove", () -> new SoundEvent(MTUtils.theMato("music.overworld.grove")));

    // Vanilla Biome Music
    public static final RegistryObject<SoundEvent> BADLANDS_MUSIC = SOUNDS.register("music.overworld.badlands", () -> new SoundEvent(MTUtils.theMato("music.overworld.badlands")));
    public static final RegistryObject<SoundEvent> BAMBOO_JUNGLE_MUSIC = SOUNDS.register("music.overworld.bamboo_jungle", () -> new SoundEvent(MTUtils.theMato("music.overworld.bamboo_jungle")));
    public static final RegistryObject<SoundEvent> DESERT_MUSIC = SOUNDS.register("music.overworld.desert", () -> new SoundEvent(MTUtils.theMato("music.overworld.desert")));
    public static final RegistryObject<SoundEvent> FLOWER_FOREST_MUSIC = SOUNDS.register("music.overworld.flower_forest", () -> new SoundEvent(MTUtils.theMato("music.overworld.flower_forest")));
    public static final RegistryObject<SoundEvent> FOREST_MUSIC = SOUNDS.register("music.overworld.forest", () -> new SoundEvent(MTUtils.theMato("music.overworld.forest")));
    public static final RegistryObject<SoundEvent> JUNGLE_MUSIC = SOUNDS.register("music.overworld.jungle", () -> new SoundEvent(MTUtils.theMato("music.overworld.jungle")));
    public static final RegistryObject<SoundEvent> OLD_GROWTH_TAIGA_MUSIC = SOUNDS.register("music.overworld.old_growth_taiga", () -> new SoundEvent(MTUtils.theMato("music.overworld.old_growth_taiga")));
    public static final RegistryObject<SoundEvent> SPARSE_JUNGLE_MUSIC = SOUNDS.register("music.overworld.sparse_jungle", () -> new SoundEvent(MTUtils.theMato("music.overworld.sparse_jungle")));
    public static final RegistryObject<SoundEvent> SWAMP_MUSIC = SOUNDS.register("music.overworld.swamp", () -> new SoundEvent(MTUtils.theMato("music.overworld.swamp")));

    // Music Discs
    public static final RegistryObject<SoundEvent> MUSIC_DISC_ADVENTURE_AWAITS = SOUNDS.register("music_disc.adventure_awaits", () -> new SoundEvent(MTUtils.theMato("music_disc.adventure_awaits")));
    public static final RegistryObject<SoundEvent> MUSIC_DISC_WELCOME_TO_THE_MATO = SOUNDS.register("music_disc.welcome_to_the_mato", () -> new SoundEvent(MTUtils.theMato("music_disc.welcome_to_the_mato")));

    // Blocks
    public static final RegistryObject<SoundEvent> POWDER_SNOW_BREAK = SOUNDS.register("block.powder_snow.break", () -> new SoundEvent(MTUtils.theMato("block.powder_snow.break")));
    public static final RegistryObject<SoundEvent> POWDER_SNOW_FALL = SOUNDS.register("block.powder_snow.fall", () -> new SoundEvent(MTUtils.theMato("block.powder_snow.fall")));
    public static final RegistryObject<SoundEvent> POWDER_SNOW_HIT = SOUNDS.register("block.powder_snow.hit", () -> new SoundEvent(MTUtils.theMato("block.powder_snow.hit")));
    public static final RegistryObject<SoundEvent> POWDER_SNOW_PLACE = SOUNDS.register("block.powder_snow.place", () -> new SoundEvent(MTUtils.theMato("block.powder_snow.place")));
    public static final RegistryObject<SoundEvent> POWDER_SNOW_STEP = SOUNDS.register("block.powder_snow.step", () -> new SoundEvent(MTUtils.theMato("block.powder_snow.step")));
    public static final RegistryObject<SoundEvent> CALCITE_BREAK = SOUNDS.register("block.calcite.break", () -> new SoundEvent(MTUtils.theMato("block.calcite.break")));
    public static final RegistryObject<SoundEvent> CALCITE_FALL = SOUNDS.register("block.calcite.fall", () -> new SoundEvent(MTUtils.theMato("block.calcite.fall")));
    public static final RegistryObject<SoundEvent> CALCITE_HIT = SOUNDS.register("block.calcite.hit", () -> new SoundEvent(MTUtils.theMato("block.calcite.hit")));
    public static final RegistryObject<SoundEvent> CALCITE_PLACE = SOUNDS.register("block.calcite.place", () -> new SoundEvent(MTUtils.theMato("block.calcite.place")));
    public static final RegistryObject<SoundEvent> CALCITE_STEP = SOUNDS.register("block.calcite.step", () -> new SoundEvent(MTUtils.theMato("block.calcite.step")));

    // Items
    public static final RegistryObject<SoundEvent> POWDER_SNOW_BUCKET_EMPTY = SOUNDS.register("item.powder_snow_bucket.empty", () -> new SoundEvent(MTUtils.theMato("item.powder_snow_bucket.empty")));
    public static final RegistryObject<SoundEvent> POWDER_SNOW_BUCKET_FILL = SOUNDS.register("item.powder_snow_bucket.fill", () -> new SoundEvent(MTUtils.theMato("item.powder_snow_bucket.fill")));
}
