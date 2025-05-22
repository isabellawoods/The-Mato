package melonystudios.themato.data.tags;

import melonystudios.themato.TheMato;
import melonystudios.themato.block.MTBlocks;
import melonystudios.themato.util.MTTags;
import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

import static melonystudios.themato.util.MTUtils.backMath;

public class MTBlockTagsProvider extends BlockTagsProvider {
    public MTBlockTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper fileHelper) {
        super(generator, TheMato.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags() {
        // The Mato's Tags
        this.tag(MTTags.Blocks.PINK_IPE_LOGS).add(MTBlocks.PINK_IPE_LOG.get(), MTBlocks.PINK_IPE_WOOD.get(), MTBlocks.STRIPPED_PINK_IPE_LOG.get(), MTBlocks.STRIPPED_PINK_IPE_WOOD.get());
        this.tag(MTTags.Blocks.PURPLE_IPE_LOGS).add(MTBlocks.PURPLE_IPE_LOG.get(), MTBlocks.PURPLE_IPE_WOOD.get(), MTBlocks.STRIPPED_PURPLE_IPE_LOG.get(), MTBlocks.STRIPPED_PURPLE_IPE_WOOD.get());
        this.tag(MTTags.Blocks.RED_IPE_LOGS).add(MTBlocks.RED_IPE_LOG.get(), MTBlocks.RED_IPE_WOOD.get(), MTBlocks.STRIPPED_RED_IPE_LOG.get(), MTBlocks.STRIPPED_RED_IPE_WOOD.get());
        this.tag(MTTags.Blocks.YELLOW_IPE_LOGS).add(MTBlocks.YELLOW_IPE_LOG.get(), MTBlocks.YELLOW_IPE_WOOD.get(), MTBlocks.STRIPPED_YELLOW_IPE_LOG.get(), MTBlocks.STRIPPED_YELLOW_IPE_WOOD.get());
        this.tag(MTTags.Blocks.JUNIUM_LOGS).add(MTBlocks.JUNIUM_LOG.get(), MTBlocks.JUNIUM_WOOD.get(), MTBlocks.STRIPPED_JUNIUM_LOG.get(), MTBlocks.STRIPPED_JUNIUM_WOOD.get());
        this.tag(MTTags.Blocks.CACTI).add(Blocks.CACTUS, MTBlocks.STRIPPED_CACTUS.get());

        this.tag(MTTags.Blocks.SNOWY_TREES_SPAWNABLE_ON).addTag(MTTags.Blocks.FARMLAND).add(Blocks.SNOW_BLOCK);
        this.tag(MTTags.Blocks.POWDER_SNOW_CAN_REPLACE).add(Blocks.SNOW_BLOCK, Blocks.DIRT);
        this.tag(MTTags.Blocks.USES_UPDATED_CULLING).add(MTBlocks.POWDER_SNOW.get());

        // Melony Tags
        this.tag(MTTags.Blocks.FARMLAND).add(Blocks.FARMLAND);
        this.tag(MTTags.Blocks.USES_CALCITE_SOUNDS).add(MTBlocks.CALCITE.get());
        this.tag(MTTags.Blocks.USES_POWDER_SNOW_SOUNDS).add(MTBlocks.POWDER_SNOW.get());

        // Forge Tags
        this.tag(Tags.Blocks.STONE).add(MTBlocks.CALCITE.get());
        this.tag(Tags.Blocks.FENCE_GATES_WOODEN).add(MTBlocks.PINK_IPE_FENCE_GATE.get(), MTBlocks.PURPLE_IPE_FENCE_GATE.get(), MTBlocks.RED_IPE_FENCE_GATE.get(), MTBlocks.YELLOW_IPE_FENCE_GATE.get(), MTBlocks.JUNIUM_FENCE_GATE.get(), MTBlocks.CACTUS_FENCE_GATE.get());

        // Minecraft Tags
        // Wood Types
        this.tag(BlockTags.LOGS_THAT_BURN).addTag(MTTags.Blocks.PINK_IPE_LOGS).addTag(MTTags.Blocks.PURPLE_IPE_LOGS).addTag(MTTags.Blocks.RED_IPE_LOGS).addTag(MTTags.Blocks.YELLOW_IPE_LOGS).addTag(MTTags.Blocks.JUNIUM_LOGS);
        this.tag(BlockTags.LEAVES).add(MTBlocks.PINK_IPE_LEAVES.get(), MTBlocks.PURPLE_IPE_LEAVES.get(), MTBlocks.RED_IPE_LEAVES.get(), MTBlocks.YELLOW_IPE_LEAVES.get(), MTBlocks.JUNIUM_LEAVES.get());
        this.tag(BlockTags.SAPLINGS).add(MTBlocks.PINK_IPE_SAPLING.get(), MTBlocks.PURPLE_IPE_SAPLING.get(), MTBlocks.RED_IPE_SAPLING.get(), MTBlocks.YELLOW_IPE_SAPLING.get(), MTBlocks.JUNIUM_SAPLING.get());
        this.tag(BlockTags.PLANKS).add(MTBlocks.PINK_IPE_PLANKS.get(), MTBlocks.PURPLE_IPE_PLANKS.get(), MTBlocks.RED_IPE_PLANKS.get(), MTBlocks.YELLOW_IPE_PLANKS.get(), MTBlocks.JUNIUM_PLANKS.get(), MTBlocks.CACTUS_PLANKS.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(MTBlocks.PINK_IPE_STAIRS.get(), MTBlocks.PURPLE_IPE_STAIRS.get(), MTBlocks.RED_IPE_STAIRS.get(), MTBlocks.YELLOW_IPE_STAIRS.get(), MTBlocks.JUNIUM_STAIRS.get(), MTBlocks.CACTUS_STAIRS.get());
        this.tag(BlockTags.WOODEN_SLABS).add(MTBlocks.PINK_IPE_SLAB.get(), MTBlocks.PURPLE_IPE_SLAB.get(), MTBlocks.RED_IPE_SLAB.get(), MTBlocks.YELLOW_IPE_SLAB.get(), MTBlocks.JUNIUM_SLAB.get(), MTBlocks.CACTUS_SLAB.get());
        this.tag(BlockTags.WOODEN_FENCES).add(MTBlocks.PINK_IPE_FENCE.get(), MTBlocks.PURPLE_IPE_FENCE.get(), MTBlocks.RED_IPE_FENCE.get(), MTBlocks.YELLOW_IPE_FENCE.get(), MTBlocks.JUNIUM_FENCE.get(), MTBlocks.CACTUS_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(MTBlocks.PINK_IPE_FENCE_GATE.get(), MTBlocks.PURPLE_IPE_FENCE_GATE.get(), MTBlocks.RED_IPE_FENCE_GATE.get(), MTBlocks.YELLOW_IPE_FENCE_GATE.get(), MTBlocks.JUNIUM_FENCE_GATE.get(), MTBlocks.CACTUS_FENCE_GATE.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(MTBlocks.PINK_IPE_PRESSURE_PLATE.get(), MTBlocks.PURPLE_IPE_PRESSURE_PLATE.get(), MTBlocks.RED_IPE_PRESSURE_PLATE.get(), MTBlocks.YELLOW_IPE_PRESSURE_PLATE.get(), MTBlocks.JUNIUM_PRESSURE_PLATE.get(), MTBlocks.CACTUS_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(MTBlocks.PINK_IPE_BUTTON.get(), MTBlocks.PURPLE_IPE_BUTTON.get(), MTBlocks.RED_IPE_BUTTON.get(), MTBlocks.YELLOW_IPE_BUTTON.get(), MTBlocks.JUNIUM_BUTTON.get(), MTBlocks.CACTUS_BUTTON.get());
        this.tag(BlockTags.STANDING_SIGNS).add(MTBlocks.PINK_IPE_SIGN.get(), MTBlocks.PURPLE_IPE_SIGN.get(), MTBlocks.RED_IPE_SIGN.get(), MTBlocks.YELLOW_IPE_SIGN.get(), MTBlocks.JUNIUM_SIGN.get(), MTBlocks.CACTUS_SIGN.get());
        this.tag(BlockTags.WALL_SIGNS).add(MTBlocks.PINK_IPE_WALL_SIGN.get(), MTBlocks.PURPLE_IPE_WALL_SIGN.get(), MTBlocks.RED_IPE_WALL_SIGN.get(), MTBlocks.YELLOW_IPE_WALL_SIGN.get(), MTBlocks.JUNIUM_WALL_SIGN.get(), MTBlocks.CACTUS_WALL_SIGN.get());

        // Miscellaneous
        this.tag(BlockTags.BASE_STONE_OVERWORLD).add(MTBlocks.CALCITE.get());
        this.tag(MTTags.Blocks.CAULDRONS).add(Blocks.CAULDRON, MTBlocks.CAULDRON.get(), MTBlocks.WATER_CAULDRON.get(), MTBlocks.LAVA_CAULDRON.get(), MTBlocks.MILK_CAULDRON.get(), MTBlocks.POWDER_SNOW_CAULDRON.get());
        this.tag(BlockTags.ENDERMAN_HOLDABLE).add(MTBlocks.STRIPPED_CACTUS.get());
        this.tag(BlockTags.FLOWER_POTS).add(MTBlocks.POTTED_PINK_IPE_SAPLING.get(), MTBlocks.POTTED_PURPLE_IPE_SAPLING.get(), MTBlocks.POTTED_RED_IPE_SAPLING.get(), MTBlocks.POTTED_YELLOW_IPE_SAPLING.get(), MTBlocks.POTTED_JUNIUM_SAPLING.get(), MTBlocks.POTTED_ROSE.get(), MTBlocks.POTTED_CYAN_ROSE.get(), MTBlocks.POTTED_PAEONIA.get());
        this.tag(MTTags.Blocks.TERRACOTTA).add(Blocks.TERRACOTTA, Blocks.WHITE_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.GRAY_TERRACOTTA, Blocks.BLACK_TERRACOTTA, Blocks.BROWN_TERRACOTTA, Blocks.RED_TERRACOTTA, Blocks.ORANGE_TERRACOTTA,
                Blocks.YELLOW_TERRACOTTA, Blocks.LIME_TERRACOTTA, Blocks.GREEN_TERRACOTTA, Blocks.CYAN_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.BLUE_TERRACOTTA, Blocks.PURPLE_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA, Blocks.PINK_TERRACOTTA)
                .addOptional(backMath("devil_terracotta"));
        this.tag(MTTags.Blocks.OVERWORLD_CARVER_REPLACEABLES).addTag(BlockTags.BASE_STONE_OVERWORLD).addTag(MTTags.Blocks.TERRACOTTA).addTag(Tags.Blocks.DIRT).addTag(Tags.Blocks.SAND).addTag(Tags.Blocks.SANDSTONE).add(Blocks.WATER, Blocks.GRAVEL, Blocks.SNOW, Blocks.PACKED_ICE);
        this.tag(BlockTags.SMALL_FLOWERS).add(MTBlocks.ROSE.get(), MTBlocks.CYAN_ROSE.get(), MTBlocks.PAEONIA.get());
    }
}
