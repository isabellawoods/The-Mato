package melonystudios.themato.biome;

import melonystudios.themato.TheMato;
import melonystudios.themato.config.MTConfigs;
import melonystudios.themato.sound.MTSounds;
import melonystudios.themato.world.surface.MTSurfaceBuilders;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static melonystudios.themato.biome.MTDefaultBiomeFeatures.*;
import static net.minecraft.world.biome.DefaultBiomeFeatures.*;

public class MTBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, TheMato.MOD_ID);

    public static final RegistryObject<Biome> IPE_FOREST = BIOMES.register("ipe_forest", MTBiomes::ipeForest);
    public static final RegistryObject<Biome> THE_WOODS = BIOMES.register("the_woods", MTBiomes::theWoods);

    // 1.18 Biomes
    public static final RegistryObject<Biome> MEADOW = BIOMES.register("meadow", MTBiomes::meadow);
    public static final RegistryObject<Biome> GROVE = BIOMES.register("grove", MTBiomes::grove);
    public static final RegistryObject<Biome> FROZEN_PEAKS = BIOMES.register("frozen_peaks", MTBiomes::frozenPeaks);
    public static final RegistryObject<Biome> SNOWY_SLOPES = BIOMES.register("snowy_slopes", MTBiomes::snowySlopes);
    public static final RegistryObject<Biome> JAGGED_PEAKS = BIOMES.register("jagged_peaks", MTBiomes::jaggedPeaks);
    public static final RegistryObject<Biome> STONY_PEAKS = BIOMES.register("stony_peaks", MTBiomes::stonyPeaks);

    private static Biome ipeForest() {
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);

        addIpeTrees(settings);
        if (!MTConfigs.COMMON_CONFIGS.removeWaterLakes.get()) addWaterLakes(settings);

        addDefaultUndergroundVariety(settings);
        addJungleGrass(settings);
        addDefaultOres(settings);
        addDefaultCarvers(settings);
        addDefaultSoftDisks(settings);
        addDefaultSprings(settings);
        addDefaultFlowers(settings);
        addDefaultMonsterRoom(settings);
        addSurfaceFreezing(settings);
        addDefaultOverworldLandStructures(settings);

        commonSpawns(spawns);
        farmAnimals(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.1F).scale(0.2F).temperature(0.7F).downfall(0.8F).specialEffects(
                new BiomeAmbience.Builder().waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(0x82A8FF).ambientMoodSound(
                        MoodSoundAmbience.LEGACY_CAVE_SETTINGS).backgroundMusic(BackgroundMusicTracks.createGameMusic(MTSounds.FOREST_MUSIC.get())).grassColorOverride(0x3B9444).build())
                .mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }

    private static Biome theWoods() {
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder();
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);

        addDefaultUndergroundVariety(settings);
        addJuniumTrees(settings);
        addJungleGrass(settings);
        addDefaultOres(settings);
        addDefaultCarvers(settings);
        addDefaultSoftDisks(settings);
        addDefaultSprings(settings);
        addForestFlowers(settings);
        addDefaultMonsterRoom(settings);
        addSurfaceFreezing(settings);
        if (!MTConfigs.COMMON_CONFIGS.removeWaterLakes.get()) addWaterLakes(settings);
        addDefaultOverworldLandStructures(settings);
        settings.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);

        commonSpawns(spawns);
        farmAnimals(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(0.1F).scale(0.2F).temperature(0.7F).downfall(0.8F).specialEffects(
                new BiomeAmbience.Builder().waterColor(0x24E2FF).waterFogColor(0x17E5E0).fogColor(12638463).skyColor(0x82A8FF).ambientMoodSound(
                        MoodSoundAmbience.LEGACY_CAVE_SETTINGS).backgroundMusic(BackgroundMusicTracks.createGameMusic(MTSounds.FOREST_MUSIC.get())).grassColorOverride(0x2DB171).build())
                .mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }

    private static Biome meadow() {
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);

        settings.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
        settings.addStructureStart(StructureFeatures.VILLAGE_PLAINS);
        MTDefaultBiomeFeatures.globalOverworldGeneration(settings, true);
        DefaultBiomeFeatures.addPlainGrass(settings);
        DefaultBiomeFeatures.addDefaultOres(settings);
        DefaultBiomeFeatures.addDefaultSoftDisks(settings);
        DefaultBiomeFeatures.addExtraEmeralds(settings);
        MTDefaultBiomeFeatures.addMeadowVegetation(settings);
        DefaultBiomeFeatures.addInfestedStone(settings);

        spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.DONKEY, 1, 1, 2)).addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.RABBIT,
                2, 2, 6)).addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SHEEP, 2, 2, 4));
        commonSpawns(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.EXTREME_HILLS).depth(1.5F).scale(0.1F).temperature(0.5F).downfall(0.8F).specialEffects(
                new BiomeAmbience.Builder().waterColor(937679).waterFogColor(329011).fogColor(12638463).skyColor(MTDefaultBiomeFeatures.calculateSkyColor(0.8F)).ambientMoodSound(
                        MoodSoundAmbience.LEGACY_CAVE_SETTINGS).backgroundMusic(BackgroundMusicTracks.createGameMusic(MTSounds.MEADOW_MUSIC.get())).build()).mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }

    private static Biome grove() {
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(MTSurfaceBuilders.GROVE);

        settings.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
        MTDefaultBiomeFeatures.globalOverworldGeneration(settings, true);
        MTDefaultBiomeFeatures.addCavesAndCliffsMountainOres(settings);
        MTDefaultBiomeFeatures.addGroveTrees(settings);
        MTDefaultBiomeFeatures.addPowderSnow(settings);
        DefaultBiomeFeatures.addDefaultOres(settings);
        DefaultBiomeFeatures.addDefaultSoftDisks(settings);
        DefaultBiomeFeatures.addDefaultExtraVegetation(settings);
        DefaultBiomeFeatures.addInfestedStone(settings);

        spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.WOLF, 8, 4, 4)).addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.RABBIT, 4,
                2, 3)).addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.FOX, 8, 2, 4));
        commonSpawns(spawns);
        // Removed in 24w10a.

        return new Biome.Builder().precipitation(Biome.RainType.SNOW).biomeCategory(Biome.Category.FOREST).depth(1.5F).scale(0.7F).temperature(-0.2F).downfall(0.8F).specialEffects(
                new BiomeAmbience.Builder().waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(-0.2F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(BackgroundMusicTracks.createGameMusic(MTSounds.GROVE_MUSIC.get())).build()).mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }

    private static Biome frozenPeaks() {
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(MTSurfaceBuilders.FROZEN_PEAKS);

        settings.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
        MTDefaultBiomeFeatures.globalOverworldGeneration(settings, true);
        MTDefaultBiomeFeatures.addCavesAndCliffsMountainOres(settings);
        MTDefaultBiomeFeatures.addPowderSnow(settings);
        // Todo: Fix this later.
        // MTDefaultBiomeFeatures.addFrozenSprings(settings);
        DefaultBiomeFeatures.addDefaultOres(settings);
        DefaultBiomeFeatures.addDefaultSoftDisks(settings);
        DefaultBiomeFeatures.addInfestedStone(settings);

        commonSpawns(spawns);

        return new Biome.Builder().precipitation(Biome.RainType.SNOW).biomeCategory(Biome.Category.EXTREME_HILLS).depth(3).scale(1).temperature(-0.7F).downfall(0.9F).specialEffects(
                new BiomeAmbience.Builder().waterColor(4159204).waterFogColor(329011).fogColor(12638463).grassColorOverride(0x80B497).foliageColorOverride(0x60A17B).skyColor(
                        MTDefaultBiomeFeatures.calculateSkyColor(0.9F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).backgroundMusic(BackgroundMusicTracks.createGameMusic(MTSounds.FROZEN_PEAKS_MUSIC.get())).build())
                .mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }

    private static Biome snowySlopes() {
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(MTSurfaceBuilders.SNOWY_SLOPES);

        settings.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
        settings.addStructureStart(StructureFeatures.RUINED_PORTAL_MOUNTAIN);
        settings.addStructureStart(StructureFeatures.IGLOO);
        MTDefaultBiomeFeatures.globalOverworldGeneration(settings, true);
        MTDefaultBiomeFeatures.addCavesAndCliffsMountainOres(settings);
        MTDefaultBiomeFeatures.addPowderSnow(settings);
        DefaultBiomeFeatures.addDefaultOres(settings);
        DefaultBiomeFeatures.addDefaultSoftDisks(settings);
        DefaultBiomeFeatures.addInfestedStone(settings);

        commonSpawns(spawns);
        spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.RABBIT, 4, 2, 3));

        return new Biome.Builder().precipitation(Biome.RainType.SNOW).biomeCategory(Biome.Category.EXTREME_HILLS).depth(3).scale(0.5F).temperature(0.3F).downfall(0.9F).specialEffects(
                new BiomeAmbience.Builder().waterColor(4159204).waterFogColor(329011).fogColor(12638463).grassColorOverride(0x80B497).foliageColorOverride(0x60A17B).skyColor(
                        MTDefaultBiomeFeatures.calculateSkyColor(0.9F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).backgroundMusic(BackgroundMusicTracks.createGameMusic(MTSounds.SNOWY_SLOPES_MUSIC.get())).build())
                .mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }

    private static Biome jaggedPeaks() {
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(MTSurfaceBuilders.JAGGED_PEAKS);

        settings.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
        MTDefaultBiomeFeatures.globalOverworldGeneration(settings, true);
        MTDefaultBiomeFeatures.addCavesAndCliffsMountainOres(settings);
        MTDefaultBiomeFeatures.addPowderSnow(settings);
        DefaultBiomeFeatures.addDefaultOres(settings);
        DefaultBiomeFeatures.addDefaultSoftDisks(settings);
        DefaultBiomeFeatures.addInfestedStone(settings);

        return new Biome.Builder().precipitation(Biome.RainType.SNOW).biomeCategory(Biome.Category.EXTREME_HILLS).depth(4).scale(1.5F).temperature(-0.7F).downfall(0.9F).specialEffects(
                new BiomeAmbience.Builder().waterColor(4159204).waterFogColor(329011).fogColor(12638463).grassColorOverride(0x80B497).foliageColorOverride(0x60A17B).skyColor(
                        MTDefaultBiomeFeatures.calculateSkyColor(0.9F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).backgroundMusic(BackgroundMusicTracks.createGameMusic(MTSounds.JAGGED_PEAKS_MUSIC.get())).build())
                .mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }

    private static Biome stonyPeaks() {
        MobSpawnInfo.Builder spawns = new MobSpawnInfo.Builder();
        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(MTSurfaceBuilders.STONY_PEAKS);

        settings.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
        MTDefaultBiomeFeatures.globalOverworldGeneration(settings, false);
        MTDefaultBiomeFeatures.addCavesAndCliffsMountainOres(settings);
        MTDefaultBiomeFeatures.addStonyPeaksVeins(settings);
        DefaultBiomeFeatures.addDefaultOres(settings);
        DefaultBiomeFeatures.addDefaultSoftDisks(settings);
        DefaultBiomeFeatures.addInfestedStone(settings);

        return new Biome.Builder().precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.EXTREME_HILLS).depth(3.5F).scale(2).temperature(1).downfall(0.3F).specialEffects(
                        new BiomeAmbience.Builder().waterColor(4159204).waterFogColor(329011).fogColor(12638463).grassColorOverride(0x9ABE4B).foliageColorOverride(0x82AC1E).skyColor(
                                MTDefaultBiomeFeatures.calculateSkyColor(0.3F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).backgroundMusic(BackgroundMusicTracks.createGameMusic(MTSounds.STONY_PEAKS_MUSIC.get())).build())
                .mobSpawnSettings(spawns.build()).generationSettings(settings.build()).build();
    }
}
