package melonystudios.themato.data.tags;

import melonystudios.themato.TheMato;
import melonystudios.themato.item.MTItems;
import melonystudios.themato.util.MTTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Items;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static melonystudios.themato.util.MTUtils.backMath;
import static melonystudios.themato.util.MTUtils.revaried;

public class MTItemTagsProvider extends ItemTagsProvider {
    public MTItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper fileHelper) {
        super(generator, blockTagsProvider, TheMato.MOD_ID, fileHelper);
    }

    @Override
    @Nonnull
    public String getName() {
        return "The Mato - Item Tags";
    }

    @Override
    protected void addTags() {
        // The Mato's Tags
        this.tag(MTTags.Items.PINK_IPE_LOGS).add(MTItems.PINK_IPE_LOG.get(), MTItems.PINK_IPE_WOOD.get(), MTItems.STRIPPED_PINK_IPE_LOG.get(), MTItems.STRIPPED_PINK_IPE_WOOD.get());
        this.tag(MTTags.Items.PURPLE_IPE_LOGS).add(MTItems.PURPLE_IPE_LOG.get(), MTItems.PURPLE_IPE_WOOD.get(), MTItems.STRIPPED_PURPLE_IPE_LOG.get(), MTItems.STRIPPED_PURPLE_IPE_WOOD.get());
        this.tag(MTTags.Items.RED_IPE_LOGS).add(MTItems.RED_IPE_LOG.get(), MTItems.RED_IPE_WOOD.get(), MTItems.STRIPPED_RED_IPE_LOG.get(), MTItems.STRIPPED_RED_IPE_WOOD.get());
        this.tag(MTTags.Items.YELLOW_IPE_LOGS).add(MTItems.YELLOW_IPE_LOG.get(), MTItems.YELLOW_IPE_WOOD.get(), MTItems.STRIPPED_YELLOW_IPE_LOG.get(), MTItems.STRIPPED_YELLOW_IPE_WOOD.get());
        this.tag(MTTags.Items.JUNIUM_LOGS).add(MTItems.JUNIUM_LOG.get(), MTItems.JUNIUM_WOOD.get(), MTItems.STRIPPED_JUNIUM_LOG.get(), MTItems.STRIPPED_JUNIUM_WOOD.get());
        this.tag(MTTags.Items.CACTI).add(Items.CACTUS, MTItems.STRIPPED_CACTUS.get());

        this.tag(MTTags.Items.POWDER_SNOW_PROOF_SHOES).add(Items.LEATHER_BOOTS);
        this.tag(MTTags.Items.FREEZE_IMMUNE_WEARABLES).add(Items.LEATHER_HELMET, Items.LEATHER_CHESTPLATE, Items.LEATHER_LEGGINGS, Items.LEATHER_BOOTS, Items.LEATHER_HORSE_ARMOR).addOptional(revaried("rabbit_hide_tunic"))
                .addOptional(revaried("phantom_membrane_tunic")).addOptional(revaried("wool_sweater"));

        // Forge Tags
        this.tag(Tags.Items.FENCE_GATES_WOODEN).add(MTItems.PINK_IPE_FENCE_GATE.get(), MTItems.PURPLE_IPE_FENCE_GATE.get(), MTItems.RED_IPE_FENCE_GATE.get(), MTItems.YELLOW_IPE_FENCE_GATE.get(), MTItems.JUNIUM_FENCE_GATE.get(), MTItems.CACTUS_FENCE_GATE.get());

        // Minecraft Tags
        // Wood Types
        this.tag(ItemTags.LOGS_THAT_BURN).addTag(MTTags.Items.PINK_IPE_LOGS).addTag(MTTags.Items.PURPLE_IPE_LOGS).addTag(MTTags.Items.RED_IPE_LOGS).addTag(MTTags.Items.YELLOW_IPE_LOGS).addTag(MTTags.Items.JUNIUM_LOGS);
        this.tag(ItemTags.LEAVES).add(MTItems.PINK_IPE_LEAVES.get(), MTItems.PURPLE_IPE_LEAVES.get(), MTItems.RED_IPE_LEAVES.get(), MTItems.YELLOW_IPE_LEAVES.get(), MTItems.JUNIUM_LEAVES.get());
        this.tag(ItemTags.SAPLINGS).add(MTItems.PINK_IPE_SAPLING.get(), MTItems.PURPLE_IPE_SAPLING.get(), MTItems.RED_IPE_SAPLING.get(), MTItems.YELLOW_IPE_SAPLING.get(), MTItems.JUNIUM_SAPLING.get());
        this.tag(ItemTags.PLANKS).add(MTItems.PINK_IPE_PLANKS.get(), MTItems.PURPLE_IPE_PLANKS.get(), MTItems.RED_IPE_PLANKS.get(), MTItems.YELLOW_IPE_PLANKS.get(), MTItems.JUNIUM_PLANKS.get(), MTItems.CACTUS_PLANKS.get());
        this.tag(ItemTags.WOODEN_STAIRS).add(MTItems.PINK_IPE_STAIRS.get(), MTItems.PURPLE_IPE_STAIRS.get(), MTItems.RED_IPE_STAIRS.get(), MTItems.YELLOW_IPE_STAIRS.get(), MTItems.JUNIUM_STAIRS.get(), MTItems.CACTUS_STAIRS.get());
        this.tag(ItemTags.WOODEN_SLABS).add(MTItems.PINK_IPE_SLAB.get(), MTItems.PURPLE_IPE_SLAB.get(), MTItems.RED_IPE_SLAB.get(), MTItems.YELLOW_IPE_SLAB.get(), MTItems.JUNIUM_SLAB.get(), MTItems.CACTUS_SLAB.get());
        this.tag(ItemTags.WOODEN_FENCES).add(MTItems.PINK_IPE_FENCE.get(), MTItems.PURPLE_IPE_FENCE.get(), MTItems.RED_IPE_FENCE.get(), MTItems.YELLOW_IPE_FENCE.get(), MTItems.JUNIUM_FENCE.get(), MTItems.CACTUS_FENCE.get());
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(MTItems.PINK_IPE_PRESSURE_PLATE.get(), MTItems.PURPLE_IPE_PRESSURE_PLATE.get(), MTItems.RED_IPE_PRESSURE_PLATE.get(), MTItems.YELLOW_IPE_PRESSURE_PLATE.get(), MTItems.JUNIUM_PRESSURE_PLATE.get(), MTItems.CACTUS_PRESSURE_PLATE.get());
        this.tag(ItemTags.WOODEN_BUTTONS).add(MTItems.PINK_IPE_BUTTON.get(), MTItems.PURPLE_IPE_BUTTON.get(), MTItems.RED_IPE_BUTTON.get(), MTItems.YELLOW_IPE_BUTTON.get(), MTItems.JUNIUM_BUTTON.get(), MTItems.CACTUS_BUTTON.get());
        this.tag(ItemTags.SIGNS).add(MTItems.PINK_IPE_SIGN.get(), MTItems.PURPLE_IPE_SIGN.get(), MTItems.RED_IPE_SIGN.get(), MTItems.YELLOW_IPE_SIGN.get(), MTItems.JUNIUM_SIGN.get(), MTItems.CACTUS_SIGN.get());

        // Miscellaneous
        this.tag(MTTags.Items.TERRACOTTA).add(Items.TERRACOTTA, Items.WHITE_TERRACOTTA, Items.LIGHT_GRAY_TERRACOTTA, Items.GRAY_TERRACOTTA, Items.BLACK_TERRACOTTA, Items.BROWN_TERRACOTTA, Items.RED_TERRACOTTA, Items.ORANGE_TERRACOTTA,
                        Items.YELLOW_TERRACOTTA, Items.LIME_TERRACOTTA, Items.GREEN_TERRACOTTA, Items.CYAN_TERRACOTTA, Items.LIGHT_BLUE_TERRACOTTA, Items.BLUE_TERRACOTTA, Items.PURPLE_TERRACOTTA, Items.MAGENTA_TERRACOTTA, Items.PINK_TERRACOTTA)
                .addOptional(backMath("devil_terracotta"));
        this.tag(ItemTags.SMALL_FLOWERS).add(MTItems.ROSE.get(), MTItems.CYAN_ROSE.get(), MTItems.PAEONIA.get());
        this.tag(ItemTags.MUSIC_DISCS).add(MTItems.MUSIC_DISC_ADVENTURE_AWAITS.get(), MTItems.MUSIC_DISC_WELCOME_TO_THE_MATO.get());
    }
}
