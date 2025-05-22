package melonystudios.themato.world;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import melonystudios.themato.block.MTBlocks;
import melonystudios.themato.util.MTTags;
import melonystudios.themato.util.MTUtils;
import melonystudios.themato.world.stateprovider.custom.MatoFlowerBlockStateProvider;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.DarkOakFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.trunkplacer.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.OptionalInt;
import java.util.function.Supplier;

public class MTFeatures {
    // Configs
    public static final LiquidsConfig FROZEN_LAVA_SPRING_CONFIG = new LiquidsConfig(Fluids.LAVA.defaultFluidState(), true, 4, 1, ImmutableSet.of(Blocks.SNOW_BLOCK, Blocks.PACKED_ICE));
    public static final RuleTest POWDER_SNOW_REPLACEABLES = new TagMatchRuleTest(MTTags.Blocks.POWDER_SNOW_CAN_REPLACE);

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PINK_IPE_TREE = register("pink_ipe_tree",
            Feature.TREE.configured(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(MTBlocks.PINK_IPE_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(MTBlocks.PINK_IPE_LEAVES.get().defaultBlockState()),
                    new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))
                    .ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PURPLE_IPE_TREE = register("purple_ipe_tree",
            Feature.TREE.configured(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(MTBlocks.PURPLE_IPE_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(MTBlocks.PURPLE_IPE_LEAVES.get().defaultBlockState()),
                    new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))
                    .ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> RED_IPE_TREE = register("red_ipe_tree",
            Feature.TREE.configured(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(MTBlocks.RED_IPE_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(MTBlocks.RED_IPE_LEAVES.get().defaultBlockState()),
                    new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))
                    .ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> YELLOW_IPE_TREE = register("yellow_ipe_tree",
            Feature.TREE.configured(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(MTBlocks.YELLOW_IPE_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(MTBlocks.YELLOW_IPE_LEAVES.get().defaultBlockState()),
                    new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))
                    .ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    public static final ConfiguredFeature<?, ?> IPE_TREES = register("ipe_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(
                    PINK_IPE_TREE.weighted(0.25F), PURPLE_IPE_TREE.weighted(0.25F), RED_IPE_TREE.weighted(0.25F)), YELLOW_IPE_TREE)).decorated(
                            Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(7, 0.3F, 2))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JUNIUM_TREE = register("junium_tree",
            Feature.TREE.configured(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(MTBlocks.JUNIUM_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(MTBlocks.JUNIUM_LEAVES.get().defaultBlockState()),
                    new DarkOakFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
                    new DarkOakTrunkPlacer(6, 2, 1),
                    new ThreeLayerFeature(1, 1, 0, 1, 2, OptionalInt.empty()))
                    .maxWaterDepth(Integer.MAX_VALUE).ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    public static final ConfiguredFeature<?, ?> JUNIUM_TREES = register("junium_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(
            JUNIUM_TREE.weighted(0.667F)), JUNIUM_TREE)).decorated(
            Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(7, 0.3F, 2))));

    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> MATO_FLOWERS_LIST = ImmutableList.of(
            () -> Feature.RANDOM_PATCH.configured(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MTBlocks.ROSE.get().defaultBlockState()), new SimpleBlockPlacer()).tries(64).noProjection().build()),
            () -> Feature.RANDOM_PATCH.configured(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MTBlocks.CYAN_ROSE.get().defaultBlockState()),new SimpleBlockPlacer()).tries(64).noProjection().build()),
            () -> Feature.RANDOM_PATCH.configured(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MTBlocks.PAEONIA.get().defaultBlockState()),new SimpleBlockPlacer()).tries(64).noProjection().build()));

    public static final ConfiguredFeature<?, ?> MATO_FLOWERS_MOD = register("mato_flowers_mod", Feature.SIMPLE_RANDOM_SELECTOR.configured(
                    new SingleRandomFeature(MATO_FLOWERS_LIST)).count(FeatureSpread.of(-3, 4)).decorated(Features.Placements.ADD_32)
            .decorated(Features.Placements.HEIGHTMAP_SQUARE).count(5));

    public static final ConfiguredFeature<?, ?> MATO_FLOWERS_VANILLA = register("mato_flowers_vanilla", Feature.FLOWER.configured(new BlockClusterFeatureConfig.Builder(MatoFlowerBlockStateProvider.INSTANCE, SimpleBlockPlacer.INSTANCE)
            .tries(64).build()));
    public static final ConfiguredFeature<?, ?> DECORATED_MATO_FLOWERS = register("decorated_mato_flowers", MATO_FLOWERS_VANILLA.decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP).squared().decorated(
            Placement.COUNT_NOISE.configured(new NoiseDependant(-0.8D, 15, 4))));

    // TODO: 1.18 GENERATION
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> TALL_BIRCH_WITH_BEES = register("tall_birch_with_bees",
            Feature.TREE.configured(new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(Blocks.BIRCH_LOG.defaultBlockState()),
                    new SimpleBlockStateProvider(Blocks.BIRCH_LEAVES.defaultBlockState()),
                    new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
                    new StraightTrunkPlacer(5, 2, 6),
                    new TwoLayerFeature(1, 0, 1))
                    .ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(1))).build()));

    public static final ConfiguredFeature<?, ?> MEADOW_TREES = register("meadow_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(
            Features.FANCY_OAK_BEES_005.weighted(0.5F)), TALL_BIRCH_WITH_BEES)).decorated(
            Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(0, 0.1F, 1)))); // Emulates the 1 in 100 that the original has.

    public static final ConfiguredFeature<?, ?> GROVE_TREES = register("grove_trees", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(
            Features.PINE.weighted(0.33333334F)), Features.SPRUCE)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

    private static final ImmutableList<Supplier<ConfiguredFeature<?, ?>>> MEADOW_FLOWER_FEATURES = ImmutableList.of(
            () -> Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.ALLIUM.defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(96).noProjection().build()),
            () -> Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.POPPY.defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(96).noProjection().build()),
            () -> Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.AZURE_BLUET.defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(96).noProjection().build()),
            () -> Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.DANDELION.defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(96).noProjection().build()),
            () -> Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.CORNFLOWER.defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(96).noProjection().build()),
            () -> Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.OXEYE_DAISY.defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(96).noProjection().build()),
            () -> Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MTBlocks.ROSE.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(96).noProjection().build()),
            () -> Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MTBlocks.CYAN_ROSE.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(96).noProjection().build()),
            () -> Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MTBlocks.PAEONIA.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(96).noProjection().build()),
            () -> Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.GRASS.defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(96).build()));

    public static final ConfiguredFeature<?, ?> MEADOW_FLOWERS = register("meadow_flowers", Feature.SIMPLE_RANDOM_SELECTOR.configured(new SingleRandomFeature(MEADOW_FLOWER_FEATURES)).count(FeatureSpread.of(-1, 9))
            .decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE).count(15));

    public static final ConfiguredFeature<?, ?> FROZEN_LAVA_SPRING = register("frozen_lava_spring", Feature.SPRING.configured(FROZEN_LAVA_SPRING_CONFIG).decorated(Placement.RANGE_VERY_BIASED.configured(
            new TopSolidRangeConfig(1, 8, 224))).squared().count(20));

    public static final ConfiguredFeature<?, ?> CAC_IRON_ORE = register("cac_iron_ore", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.IRON_ORE.defaultBlockState(), 9))
            .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(70, 0, 175))).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(1, 8, 224))
                    .squared().count(20)));

    public static final ConfiguredFeature<?, ?> CAC_COAL_ORE = register("cac_coal_ore", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.COAL_ORE.defaultBlockState(), 17))
            .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(70, 0, 175))).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(1, 8, 224))
                    .squared().count(20)));

    public static final ConfiguredFeature<?, ?> CAC_EMERALD_ORE = register("cac_emerald_ore", Feature.EMERALD_ORE.configured(new ReplaceBlockConfig(Blocks.STONE.defaultBlockState(), Blocks.EMERALD_ORE.defaultBlockState()))
            .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(80, 0, 175))).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(1, 8, 224))
                    .squared().count(20)));

    public static final ConfiguredFeature<?, ?> POWDER_SNOW_VEIN = register("powder_snow_vein", Feature.ORE.configured(new OreFeatureConfig(POWDER_SNOW_REPLACEABLES, MTBlocks.POWDER_SNOW.get().defaultBlockState(), 33))
            .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(80, 0, 160))).squared().count(10));

    public static final ConfiguredFeature<?, ?> CALCITE_VEIN = register("calcite_vein", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, MTBlocks.CALCITE.get().defaultBlockState(), 33))
            .range(256).squared().count(30));

    public static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, MTUtils.theMato(name), configuredFeature);
    }
}
