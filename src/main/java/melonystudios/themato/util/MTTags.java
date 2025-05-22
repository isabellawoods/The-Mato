package melonystudios.themato.util;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class MTTags {
    public static class Blocks {
        // The Mato's Tags
        public static final ITag.INamedTag<Block> PINK_IPE_LOGS = theMato("pink_ipe_logs");
        public static final ITag.INamedTag<Block> PURPLE_IPE_LOGS = theMato("purple_ipe_logs");
        public static final ITag.INamedTag<Block> RED_IPE_LOGS = theMato("red_ipe_logs");
        public static final ITag.INamedTag<Block> YELLOW_IPE_LOGS = theMato("yellow_ipe_logs");
        public static final ITag.INamedTag<Block> JUNIUM_LOGS = theMato("junium_logs");
        public static final ITag.INamedTag<Block> CACTI = theMato("cacti");

        public static final ITag.INamedTag<Block> SNOWY_TREES_SPAWNABLE_ON = theMato("snowy_trees_spawnable_on");
        public static final ITag.INamedTag<Block> POWDER_SNOW_CAN_REPLACE = theMato("powder_snow_can_replace");
        public static final ITag.INamedTag<Block> USES_UPDATED_CULLING = theMato("uses_updated_culling");

        // Melony Tags
        public static final ITag.INamedTag<Block> FARMLAND = melony("farmland");
        public static final ITag.INamedTag<Block> USES_CALCITE_SOUNDS = melony("uses_sounds/calcite");
        public static final ITag.INamedTag<Block> USES_POWDER_SNOW_SOUNDS = melony("uses_sounds/powder_snow");

        // Minecraft Tags
        public static final ITag.INamedTag<Block> OVERWORLD_CARVER_REPLACEABLES = minecraft("overworld_carver_replaceables");
        public static final ITag.INamedTag<Block> TERRACOTTA = minecraft("terracotta");
        public static final ITag.INamedTag<Block> CAULDRONS = minecraft("cauldrons");

        public static ITag.INamedTag<Block> theMato(String name) {
            return BlockTags.bind(MTUtils.theMato(name).toString());
        }

        public static ITag.INamedTag<Block> melony(String name) {
            return BlockTags.bind(new ResourceLocation("melony", name).toString());
        }

        public static ITag.INamedTag<Block> minecraft(String name) {
            return BlockTags.bind(new ResourceLocation(name).toString());
        }
    }

    public static class Items {
        // The Mato's Tags
        public static final ITag.INamedTag<Item> PINK_IPE_LOGS = theMato("pink_ipe_logs");
        public static final ITag.INamedTag<Item> PURPLE_IPE_LOGS = theMato("purple_ipe_logs");
        public static final ITag.INamedTag<Item> RED_IPE_LOGS = theMato("red_ipe_logs");
        public static final ITag.INamedTag<Item> YELLOW_IPE_LOGS = theMato("yellow_ipe_logs");
        public static final ITag.INamedTag<Item> JUNIUM_LOGS = theMato("junium_logs");
        public static final ITag.INamedTag<Item> CACTI = theMato("cacti");

        public static final ITag.INamedTag<Item> POWDER_SNOW_PROOF_SHOES = theMato("powder_snow_proof_shoes");

        // Minecraft Tags
        public static final ITag.INamedTag<Item> TERRACOTTA = minecraft("terracotta");
        public static final ITag.INamedTag<Item> FREEZE_IMMUNE_WEARABLES = minecraft("freeze_immune_wearables");

        public static ITag.INamedTag<Item> theMato(String name) {
            return ItemTags.bind(MTUtils.theMato(name).toString());
        }

        public static ITag.INamedTag<Item> minecraft(String name) {
            return ItemTags.bind(new ResourceLocation(name).toString());
        }
    }

    public static class Entities {
        // Melony Tags
        public static final ITag.INamedTag<EntityType<?>> CAN_SPAWN_ON_LEAVES = melony("can_spawn_on_leaves");

        // Minecraft Tags
        public static final ITag.INamedTag<EntityType<?>> FREEZE_HURTS_EXTRA_TYPES = minecraft("freeze_hurts_extra_types");
        public static final ITag.INamedTag<EntityType<?>> FREEZE_IMMUNE_ENTITY_TYPES = minecraft("freeze_immune_entity_types");
        public static final ITag.INamedTag<EntityType<?>> POWDER_SNOW_WALKABLE_MOBS = minecraft("powder_snow_walkable_mobs");

        public static ITag.INamedTag<EntityType<?>> melony(String name) {
            return EntityTypeTags.bind(new ResourceLocation("melony", name).toString());
        }

        public static ITag.INamedTag<EntityType<?>> minecraft(String name) {
            return EntityTypeTags.bind(new ResourceLocation(name).toString());
        }
    }
}
