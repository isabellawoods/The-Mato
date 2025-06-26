package melonystudios.themato.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class MTCommonConfigs {
    // Biomes
    public final BooleanValue ipeForestGeneration;
    public final BooleanValue theWoodsGeneration;

    // Miscellaneous
    public final BooleanValue matoFlowersGeneration;
    public final BooleanValue removeWaterLakes;
    public final BooleanValue replaceBiomeMusic;
    public final IntValue overworldRiverAmount;

    public MTCommonConfigs(ForgeConfigSpec.Builder builder) {
        builder.comment("Welcome to the Mato's config files. This will be used to turn on or off features from the mod, mainly related to world generation.");

        builder.push("worldGeneration");
        this.ipeForestGeneration = builder.comment("Allow Ipe Forests to generate?").translation("config.themato.ipe_forest_generation").define("ipeForestGeneration", true);
        this.theWoodsGeneration = builder.comment("Allow The Woods (biome) to generate?").translation("config.themato.the_woods_generation").define("theWoodsGeneration", true);
        this.matoFlowersGeneration = builder.comment("Allow flowers added by The Mato (roses, cyan roses and paeonias) to generate?").translation("config.themato.the_mato_flowers_generation").define("theMatoFlowersGeneration", true);
        this.removeWaterLakes = builder.comment("Whether to remove water lakes from natural world generation.").translation("config.themato.remove_water_lakes").define("removeWaterLakes", true);
        this.overworldRiverAmount = builder.comment("What the size of rivers in the Overworld should be. This isn't the width, but the amount of rivers that generate.").comment("Larger value = less rivers.").translation("config.themato.overworld_river_amount").defineInRange("overworldRiverAmount", 4, 0, 10);
        builder.pop();

        builder.push("miscellaneous");
        this.replaceBiomeMusic = builder.comment("Whether to replace the music in various biomes with their updated sound events.").translation("config.themato.replace_biome_music").define("replaceBiomeMusic", true);
        builder.pop();
    }
}
