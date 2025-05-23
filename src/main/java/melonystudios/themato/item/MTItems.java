package melonystudios.themato.item;

import melonystudios.themato.TheMato;
import melonystudios.themato.block.MTBlocks;
import melonystudios.themato.item.custom.BlockBucketItem;
import melonystudios.themato.item.custom.DyedWaterBucketItem;
import melonystudios.themato.item.custom.LiquidCactusBucketItem;
import melonystudios.themato.item.custom.MTFoods;
import melonystudios.themato.sound.MTSounds;
import melonystudios.themato.util.MTTab;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MTItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheMato.MOD_ID);

    // Pink Ipe
    public static final RegistryObject<Item> PINK_IPE_LOG = ITEMS.register("pink_ipe_log", () -> new BlockItem(MTBlocks.PINK_IPE_LOG.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PINK_IPE_WOOD = ITEMS.register("pink_ipe_wood", () -> new BlockItem(MTBlocks.PINK_IPE_WOOD.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> STRIPPED_PINK_IPE_LOG = ITEMS.register("stripped_pink_ipe_log", () -> new BlockItem(MTBlocks.STRIPPED_PINK_IPE_LOG.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> STRIPPED_PINK_IPE_WOOD = ITEMS.register("stripped_pink_ipe_wood", () -> new BlockItem(MTBlocks.STRIPPED_PINK_IPE_WOOD.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PINK_IPE_LEAVES = ITEMS.register("pink_ipe_leaves", () -> new BlockItem(MTBlocks.PINK_IPE_LEAVES.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PINK_IPE_SAPLING = ITEMS.register("pink_ipe_sapling", () -> new BlockItem(MTBlocks.PINK_IPE_SAPLING.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PINK_IPE_PLANKS = ITEMS.register("pink_ipe_planks", () -> new BlockItem(MTBlocks.PINK_IPE_PLANKS.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PINK_IPE_STAIRS = ITEMS.register("pink_ipe_stairs", () -> new BlockItem(MTBlocks.PINK_IPE_STAIRS.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PINK_IPE_SLAB = ITEMS.register("pink_ipe_slab", () -> new BlockItem(MTBlocks.PINK_IPE_SLAB.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PINK_IPE_FENCE = ITEMS.register("pink_ipe_fence", () -> new BlockItem(MTBlocks.PINK_IPE_FENCE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PINK_IPE_FENCE_GATE = ITEMS.register("pink_ipe_fence_gate", () -> new BlockItem(MTBlocks.PINK_IPE_FENCE_GATE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PINK_IPE_PRESSURE_PLATE = ITEMS.register("pink_ipe_pressure_plate", () -> new BlockItem(MTBlocks.PINK_IPE_PRESSURE_PLATE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PINK_IPE_BUTTON = ITEMS.register("pink_ipe_button", () -> new BlockItem(MTBlocks.PINK_IPE_BUTTON.get(), new Item.Properties().tab(MTTab.TAB)));

    // Purple Ipe
    public static final RegistryObject<Item> PURPLE_IPE_LOG = ITEMS.register("purple_ipe_log", () -> new BlockItem(MTBlocks.PURPLE_IPE_LOG.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PURPLE_IPE_WOOD = ITEMS.register("purple_ipe_wood", () -> new BlockItem(MTBlocks.PURPLE_IPE_WOOD.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> STRIPPED_PURPLE_IPE_LOG = ITEMS.register("stripped_purple_ipe_log", () -> new BlockItem(MTBlocks.STRIPPED_PURPLE_IPE_LOG.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> STRIPPED_PURPLE_IPE_WOOD = ITEMS.register("stripped_purple_ipe_wood", () -> new BlockItem(MTBlocks.STRIPPED_PURPLE_IPE_WOOD.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PURPLE_IPE_LEAVES = ITEMS.register("purple_ipe_leaves", () -> new BlockItem(MTBlocks.PURPLE_IPE_LEAVES.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PURPLE_IPE_SAPLING = ITEMS.register("purple_ipe_sapling", () -> new BlockItem(MTBlocks.PURPLE_IPE_SAPLING.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PURPLE_IPE_PLANKS = ITEMS.register("purple_ipe_planks", () -> new BlockItem(MTBlocks.PURPLE_IPE_PLANKS.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PURPLE_IPE_STAIRS = ITEMS.register("purple_ipe_stairs", () -> new BlockItem(MTBlocks.PURPLE_IPE_STAIRS.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PURPLE_IPE_SLAB = ITEMS.register("purple_ipe_slab", () -> new BlockItem(MTBlocks.PURPLE_IPE_SLAB.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PURPLE_IPE_FENCE = ITEMS.register("purple_ipe_fence", () -> new BlockItem(MTBlocks.PURPLE_IPE_FENCE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PURPLE_IPE_FENCE_GATE = ITEMS.register("purple_ipe_fence_gate", () -> new BlockItem(MTBlocks.PURPLE_IPE_FENCE_GATE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PURPLE_IPE_PRESSURE_PLATE = ITEMS.register("purple_ipe_pressure_plate", () -> new BlockItem(MTBlocks.PURPLE_IPE_PRESSURE_PLATE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PURPLE_IPE_BUTTON = ITEMS.register("purple_ipe_button", () -> new BlockItem(MTBlocks.PURPLE_IPE_BUTTON.get(), new Item.Properties().tab(MTTab.TAB)));

    // Red Ipe
    public static final RegistryObject<Item> RED_IPE_LOG = ITEMS.register("red_ipe_log", () -> new BlockItem(MTBlocks.RED_IPE_LOG.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> RED_IPE_WOOD = ITEMS.register("red_ipe_wood", () -> new BlockItem(MTBlocks.RED_IPE_WOOD.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> STRIPPED_RED_IPE_LOG = ITEMS.register("stripped_red_ipe_log", () -> new BlockItem(MTBlocks.STRIPPED_RED_IPE_LOG.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> STRIPPED_RED_IPE_WOOD = ITEMS.register("stripped_red_ipe_wood", () -> new BlockItem(MTBlocks.STRIPPED_RED_IPE_WOOD.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> RED_IPE_LEAVES = ITEMS.register("red_ipe_leaves", () -> new BlockItem(MTBlocks.RED_IPE_LEAVES.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> RED_IPE_SAPLING = ITEMS.register("red_ipe_sapling", () -> new BlockItem(MTBlocks.RED_IPE_SAPLING.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> RED_IPE_PLANKS = ITEMS.register("red_ipe_planks", () -> new BlockItem(MTBlocks.RED_IPE_PLANKS.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> RED_IPE_STAIRS = ITEMS.register("red_ipe_stairs", () -> new BlockItem(MTBlocks.RED_IPE_STAIRS.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> RED_IPE_SLAB = ITEMS.register("red_ipe_slab", () -> new BlockItem(MTBlocks.RED_IPE_SLAB.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> RED_IPE_FENCE = ITEMS.register("red_ipe_fence", () -> new BlockItem(MTBlocks.RED_IPE_FENCE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> RED_IPE_FENCE_GATE = ITEMS.register("red_ipe_fence_gate", () -> new BlockItem(MTBlocks.RED_IPE_FENCE_GATE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> RED_IPE_PRESSURE_PLATE = ITEMS.register("red_ipe_pressure_plate", () -> new BlockItem(MTBlocks.RED_IPE_PRESSURE_PLATE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> RED_IPE_BUTTON = ITEMS.register("red_ipe_button", () -> new BlockItem(MTBlocks.RED_IPE_BUTTON.get(), new Item.Properties().tab(MTTab.TAB)));

    // Yellow Ipe
    public static final RegistryObject<Item> YELLOW_IPE_LOG = ITEMS.register("yellow_ipe_log", () -> new BlockItem(MTBlocks.YELLOW_IPE_LOG.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> YELLOW_IPE_WOOD = ITEMS.register("yellow_ipe_wood", () -> new BlockItem(MTBlocks.YELLOW_IPE_WOOD.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> STRIPPED_YELLOW_IPE_LOG = ITEMS.register("stripped_yellow_ipe_log", () -> new BlockItem(MTBlocks.STRIPPED_YELLOW_IPE_LOG.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> STRIPPED_YELLOW_IPE_WOOD = ITEMS.register("stripped_yellow_ipe_wood", () -> new BlockItem(MTBlocks.STRIPPED_YELLOW_IPE_WOOD.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> YELLOW_IPE_LEAVES = ITEMS.register("yellow_ipe_leaves", () -> new BlockItem(MTBlocks.YELLOW_IPE_LEAVES.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> YELLOW_IPE_SAPLING = ITEMS.register("yellow_ipe_sapling", () -> new BlockItem(MTBlocks.YELLOW_IPE_SAPLING.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> YELLOW_IPE_PLANKS = ITEMS.register("yellow_ipe_planks", () -> new BlockItem(MTBlocks.YELLOW_IPE_PLANKS.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> YELLOW_IPE_STAIRS = ITEMS.register("yellow_ipe_stairs", () -> new BlockItem(MTBlocks.YELLOW_IPE_STAIRS.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> YELLOW_IPE_SLAB = ITEMS.register("yellow_ipe_slab", () -> new BlockItem(MTBlocks.YELLOW_IPE_SLAB.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> YELLOW_IPE_FENCE = ITEMS.register("yellow_ipe_fence", () -> new BlockItem(MTBlocks.YELLOW_IPE_FENCE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> YELLOW_IPE_FENCE_GATE = ITEMS.register("yellow_ipe_fence_gate", () -> new BlockItem(MTBlocks.YELLOW_IPE_FENCE_GATE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> YELLOW_IPE_PRESSURE_PLATE = ITEMS.register("yellow_ipe_pressure_plate", () -> new BlockItem(MTBlocks.YELLOW_IPE_PRESSURE_PLATE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> YELLOW_IPE_BUTTON = ITEMS.register("yellow_ipe_button", () -> new BlockItem(MTBlocks.YELLOW_IPE_BUTTON.get(), new Item.Properties().tab(MTTab.TAB)));

    // Junium
    public static final RegistryObject<Item> JUNIUM_LOG = ITEMS.register("junium_log", () -> new BlockItem(MTBlocks.JUNIUM_LOG.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> JUNIUM_WOOD = ITEMS.register("junium_wood", () -> new BlockItem(MTBlocks.JUNIUM_WOOD.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> STRIPPED_JUNIUM_LOG = ITEMS.register("stripped_junium_log", () -> new BlockItem(MTBlocks.STRIPPED_JUNIUM_LOG.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> STRIPPED_JUNIUM_WOOD = ITEMS.register("stripped_junium_wood", () -> new BlockItem(MTBlocks.STRIPPED_JUNIUM_WOOD.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> JUNIUM_LEAVES = ITEMS.register("junium_leaves", () -> new BlockItem(MTBlocks.JUNIUM_LEAVES.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> JUNIUM_SAPLING = ITEMS.register("junium_sapling", () -> new BlockItem(MTBlocks.JUNIUM_SAPLING.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> JUNIUM_PLANKS = ITEMS.register("junium_planks", () -> new BlockItem(MTBlocks.JUNIUM_PLANKS.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> JUNIUM_STAIRS = ITEMS.register("junium_stairs", () -> new BlockItem(MTBlocks.JUNIUM_STAIRS.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> JUNIUM_SLAB = ITEMS.register("junium_slab", () -> new BlockItem(MTBlocks.JUNIUM_SLAB.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> JUNIUM_FENCE = ITEMS.register("junium_fence", () -> new BlockItem(MTBlocks.JUNIUM_FENCE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> JUNIUM_FENCE_GATE = ITEMS.register("junium_fence_gate", () -> new BlockItem(MTBlocks.JUNIUM_FENCE_GATE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> JUNIUM_PRESSURE_PLATE = ITEMS.register("junium_pressure_plate", () -> new BlockItem(MTBlocks.JUNIUM_PRESSURE_PLATE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> JUNIUM_BUTTON = ITEMS.register("junium_button", () -> new BlockItem(MTBlocks.JUNIUM_BUTTON.get(), new Item.Properties().tab(MTTab.TAB)));

    // Cactus Wood
    public static final RegistryObject<Item> STRIPPED_CACTUS = ITEMS.register("stripped_cactus", () -> new BlockItem(MTBlocks.STRIPPED_CACTUS.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> CACTUS_PLANKS = ITEMS.register("cactus_planks", () -> new BlockItem(MTBlocks.CACTUS_PLANKS.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> CACTUS_STAIRS = ITEMS.register("cactus_stairs", () -> new BlockItem(MTBlocks.CACTUS_STAIRS.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> CACTUS_SLAB = ITEMS.register("cactus_slab", () -> new BlockItem(MTBlocks.CACTUS_SLAB.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> CACTUS_FENCE = ITEMS.register("cactus_fence", () -> new BlockItem(MTBlocks.CACTUS_FENCE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> CACTUS_FENCE_GATE = ITEMS.register("cactus_fence_gate", () -> new BlockItem(MTBlocks.CACTUS_FENCE_GATE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> CACTUS_PRESSURE_PLATE = ITEMS.register("cactus_pressure_plate", () -> new BlockItem(MTBlocks.CACTUS_PRESSURE_PLATE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> CACTUS_BUTTON = ITEMS.register("cactus_button", () -> new BlockItem(MTBlocks.CACTUS_BUTTON.get(), new Item.Properties().tab(MTTab.TAB)));

    // Miscellaneous Blocks
    public static final RegistryObject<Item> CALCITE = ITEMS.register("calcite", () -> new BlockItem(MTBlocks.CALCITE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> CAULDRON = ITEMS.register("cauldron", () -> new BlockItem(MTBlocks.CAULDRON.get(), new Item.Properties().tab(MTTab.TAB)));

    public static final RegistryObject<Item> PINK_IPE_SIGN = ITEMS.register("pink_ipe_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(MTTab.TAB), MTBlocks.PINK_IPE_SIGN.get(), MTBlocks.PINK_IPE_WALL_SIGN.get()));
    public static final RegistryObject<Item> PURPLE_IPE_SIGN = ITEMS.register("purple_ipe_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(MTTab.TAB), MTBlocks.PURPLE_IPE_SIGN.get(), MTBlocks.PURPLE_IPE_WALL_SIGN.get()));
    public static final RegistryObject<Item> RED_IPE_SIGN = ITEMS.register("red_ipe_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(MTTab.TAB), MTBlocks.RED_IPE_SIGN.get(), MTBlocks.RED_IPE_WALL_SIGN.get()));
    public static final RegistryObject<Item> YELLOW_IPE_SIGN = ITEMS.register("yellow_ipe_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(MTTab.TAB), MTBlocks.YELLOW_IPE_SIGN.get(), MTBlocks.YELLOW_IPE_WALL_SIGN.get()));
    public static final RegistryObject<Item> JUNIUM_SIGN = ITEMS.register("junium_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(MTTab.TAB), MTBlocks.JUNIUM_SIGN.get(), MTBlocks.JUNIUM_WALL_SIGN.get()));
    public static final RegistryObject<Item> CACTUS_SIGN = ITEMS.register("cactus_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(MTTab.TAB), MTBlocks.CACTUS_SIGN.get(), MTBlocks.CACTUS_WALL_SIGN.get()));
    public static final RegistryObject<Item> ROSE = ITEMS.register("rose", () -> new BlockItem(MTBlocks.ROSE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> CYAN_ROSE = ITEMS.register("cyan_rose", () -> new BlockItem(MTBlocks.CYAN_ROSE.get(), new Item.Properties().tab(MTTab.TAB)));
    public static final RegistryObject<Item> PAEONIA = ITEMS.register("paeonia", () -> new BlockItem(MTBlocks.PAEONIA.get(), new Item.Properties().tab(MTTab.TAB)));

    // Actual Items
    public static final RegistryObject<Item> POWDER_SNOW_BUCKET = ITEMS.register("powder_snow_bucket", () -> new BlockBucketItem(MTSounds.POWDER_SNOW_BUCKET_EMPTY, MTBlocks.POWDER_SNOW.get(), new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET).tab(MTTab.TAB)));
    public static final RegistryObject<Item> DYED_WATER_BUCKET = ITEMS.register("dyed_water_bucket", () -> new DyedWaterBucketItem(new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET).tab(MTTab.TAB)));
    public static final RegistryObject<Item> LIQUID_CACTUS_BUCKET = ITEMS.register("liquid_cactus_bucket", () -> new LiquidCactusBucketItem(new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET).tab(MTTab.TAB)));
    public static final RegistryObject<Item> CACTUS_CANDY = ITEMS.register("cactus_candy", () -> new Item(new Item.Properties().food(MTFoods.CACTUS_CANDY).tab(MTTab.TAB)));
    public static final RegistryObject<Item> MUSIC_DISC_ADVENTURE_AWAITS = ITEMS.register("music_disc_adventure_awaits", () -> new MusicDiscItem(8, MTSounds.MUSIC_DISC_ADVENTURE_AWAITS, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).tab(MTTab.TAB)));
    public static final RegistryObject<Item> MUSIC_DISC_WELCOME_TO_THE_MATO = ITEMS.register("music_disc_welcome_to_the_mato", () -> new MusicDiscItem(9, MTSounds.MUSIC_DISC_WELCOME_TO_THE_MATO, new Item.Properties().stacksTo(1).rarity(Rarity.RARE).tab(MTTab.TAB)));
}
