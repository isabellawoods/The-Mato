package melonystudios.themato.cauldron;

import melonystudios.themato.block.MTBlocks;
import melonystudios.themato.block.custom.cauldron.DyedWaterCauldronBlock;
import melonystudios.themato.block.custom.cauldron.LayeredCauldronBlock;
import melonystudios.themato.blockentity.custom.DyedWaterCauldronBlockEntity;
import melonystudios.themato.item.MTItems;
import melonystudios.themato.sound.MTSounds;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import melonystudios.themato.util.MTUtils;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

import java.util.Map;
import java.util.function.Predicate;

import static melonystudios.themato.cauldron.VanillaCauldronInteractions.*;

public interface CauldronInteraction {
    // Interaction Maps (vanilla)
    Map<Item, CauldronInteraction> EMPTY = newInteractionMap();
    Map<Item, CauldronInteraction> WATER = newInteractionMap();
    Map<Item, CauldronInteraction> LAVA = newInteractionMap();
    Map<Item, CauldronInteraction> MILK = newInteractionMap();
    Map<Item, CauldronInteraction> DYED_WATER = newInteractionMap();
    Map<Item, CauldronInteraction> POWDER_SNOW = newInteractionMap();

    // Fill with content
    CauldronInteraction FILL_WATER = (state, world, pos, player, hand, stack) -> emptyBucket(world, pos, player, hand, stack, MTBlocks.WATER_CAULDRON.get().defaultBlockState().setValue(LayeredCauldronBlock.LEVEL, 3), SoundEvents.BUCKET_EMPTY, state1 -> state1.is(MTBlocks.CAULDRON.get()));
    CauldronInteraction FILL_DYED_WATER = (state, world, pos, player, hand, stack) -> {
        DyedWaterCauldronBlock dyedWaterCauldron = (DyedWaterCauldronBlock) MTBlocks.DYED_WATER_CAULDRON.get();
        dyedWaterCauldron.createTileEntity(state, world);
        if (stack.getTag() != null && stack.getTag().contains("dyed_water_color", Constants.NBT.TAG_ANY_NUMERIC)) {
            dyedWaterCauldron.setDyedWaterColor(stack.getTag().getInt("dyed_water_color"));
        } else {
            dyedWaterCauldron.setDyedWaterColor(0x3F76E4);
        }
        return emptyBucket(world, pos, player, hand, stack, dyedWaterCauldron.defaultBlockState().setValue(LayeredCauldronBlock.LEVEL, 3), SoundEvents.BUCKET_EMPTY, state1 -> state1.is(MTBlocks.CAULDRON.get()));
    };
    CauldronInteraction FILL_LAVA = (state, world, pos, player, hand, stack) -> emptyBucket(world, pos, player, hand, stack, MTBlocks.LAVA_CAULDRON.get().defaultBlockState(), SoundEvents.BUCKET_EMPTY_LAVA, state1 -> state1.is(MTBlocks.CAULDRON.get()));
    CauldronInteraction FILL_POWDER_SNOW = (state, world, pos, player, hand, stack) -> emptyBucket(world, pos, player, hand, stack, MTBlocks.POWDER_SNOW_CAULDRON.get().defaultBlockState().setValue(LayeredCauldronBlock.LEVEL, 3), MTSounds.POWDER_SNOW_BUCKET_EMPTY.get(),
            state1 -> state1.is(MTBlocks.CAULDRON.get()));
    CauldronInteraction FILL_MILK = (state, world, pos, player, hand, stack) -> emptyBucket(world, pos, player, hand, stack, MTBlocks.MILK_CAULDRON.get().defaultBlockState().setValue(LayeredCauldronBlock.LEVEL, 3), SoundEvents.BUCKET_EMPTY, state1 -> state1.is(MTBlocks.CAULDRON.get()));

    static Object2ObjectOpenHashMap<Item, CauldronInteraction> newInteractionMap() {
        return Util.make(new Object2ObjectOpenHashMap<>(), interactionMap -> interactionMap.defaultReturnValue((state, world, pos, player, hand, stack) -> ActionResultType.PASS));
    }

    ActionResultType interact(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack);

    static void bootstrap() {
        // Empty
        EMPTY.put(Items.POTION, (state, world, pos, player, hand, stack) -> {
            if (PotionUtils.getPotion(stack) != Potions.WATER) {
                return ActionResultType.PASS;
            } else {
                if (!world.isClientSide) {
                    Item item = stack.getItem();
                    player.setItemInHand(hand, MTUtils.createFilledResult(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(item));
                    world.setBlockAndUpdate(pos, MTBlocks.WATER_CAULDRON.get().defaultBlockState().setValue(LayeredCauldronBlock.LEVEL, 1));
                    world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundCategory.BLOCKS, 1, 1);
                }

                return ActionResultType.sidedSuccess(world.isClientSide);
            }
        });
        addDefaultInteractions(EMPTY);

        // Water
        WATER.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> fillBucket(state, world, pos, player, hand, stack, new ItemStack(Items.WATER_BUCKET), state1 -> state1.getValue(LayeredCauldronBlock.LEVEL) == 3, SoundEvents.BUCKET_FILL));
        WATER.put(Items.GLASS_BOTTLE, (state, world, pos, player, hand, stack) -> {
            if (!world.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, MTUtils.createFilledResult(stack, player, PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                LayeredCauldronBlock.lowerFillLevel(state, world, pos);
                world.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundCategory.BLOCKS, 1, 1);
            }
            return ActionResultType.sidedSuccess(world.isClientSide);
        });
        WATER.put(Items.POTION, (state, world, pos, player, hand, stack) -> {
            if (state.getValue(LayeredCauldronBlock.LEVEL) != 3 && PotionUtils.getPotion(stack) == Potions.WATER) {
                if (!world.isClientSide) {
                    player.setItemInHand(hand, MTUtils.createFilledResult(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
                    world.setBlockAndUpdate(pos, state.cycle(LayeredCauldronBlock.LEVEL));
                    world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundCategory.BLOCKS, 1, 1);
                }
                return ActionResultType.sidedSuccess(world.isClientSide);
            } else {
                return ActionResultType.PASS;
            }
        });
        WATER.put(Items.LEATHER_BOOTS, CLEAN_DYED_ITEM);
        WATER.put(Items.LEATHER_LEGGINGS, CLEAN_DYED_ITEM);
        WATER.put(Items.LEATHER_CHESTPLATE, CLEAN_DYED_ITEM);
        WATER.put(Items.LEATHER_HELMET, CLEAN_DYED_ITEM);
        WATER.put(Items.LEATHER_HORSE_ARMOR, CLEAN_DYED_ITEM);
        WATER.put(Items.WHITE_BANNER, CLEAN_BANNER);
        WATER.put(Items.GRAY_BANNER, CLEAN_BANNER);
        WATER.put(Items.BLACK_BANNER, CLEAN_BANNER);
        WATER.put(Items.BLUE_BANNER, CLEAN_BANNER);
        WATER.put(Items.BROWN_BANNER, CLEAN_BANNER);
        WATER.put(Items.CYAN_BANNER, CLEAN_BANNER);
        WATER.put(Items.GREEN_BANNER, CLEAN_BANNER);
        WATER.put(Items.LIGHT_BLUE_BANNER, CLEAN_BANNER);
        WATER.put(Items.LIGHT_GRAY_BANNER, CLEAN_BANNER);
        WATER.put(Items.LIME_BANNER, CLEAN_BANNER);
        WATER.put(Items.MAGENTA_BANNER, CLEAN_BANNER);
        WATER.put(Items.ORANGE_BANNER, CLEAN_BANNER);
        WATER.put(Items.PINK_BANNER, CLEAN_BANNER);
        WATER.put(Items.PURPLE_BANNER, CLEAN_BANNER);
        WATER.put(Items.RED_BANNER, CLEAN_BANNER);
        WATER.put(Items.YELLOW_BANNER, CLEAN_BANNER);
        WATER.put(Items.WHITE_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER.put(Items.GRAY_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER.put(Items.BLACK_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER.put(Items.BLUE_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER.put(Items.BROWN_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER.put(Items.CYAN_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER.put(Items.GREEN_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER.put(Items.LIGHT_BLUE_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER.put(Items.LIGHT_GRAY_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER.put(Items.LIME_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER.put(Items.MAGENTA_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER.put(Items.ORANGE_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER.put(Items.PINK_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER.put(Items.PURPLE_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER.put(Items.RED_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER.put(Items.YELLOW_SHULKER_BOX, CLEAN_SHULKER_BOX);
        addDefaultInteractions(WATER);

        // Dyed Water
        DYED_WATER.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> {
            ItemStack dyedBucketStack = new ItemStack(MTItems.DYED_WATER_BUCKET.get());
            TileEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof DyedWaterCauldronBlockEntity) {
                DyedWaterCauldronBlockEntity cauldronBlockEntity = (DyedWaterCauldronBlockEntity) blockEntity;
                dyedBucketStack.getOrCreateTag().putInt("dyed_water_color", cauldronBlockEntity.getWaterColor());
            }
            return fillBucket(state, world, pos, player, hand, stack, dyedBucketStack, state1 -> true, SoundEvents.BUCKET_FILL);
        });
        addDefaultInteractions(DYED_WATER);

        // Lava
        LAVA.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> fillBucket(state, world, pos, player, hand, stack, new ItemStack(Items.LAVA_BUCKET), state1 -> true, SoundEvents.BUCKET_FILL_LAVA));
        addDefaultInteractions(LAVA);

        // Powder Snow
        POWDER_SNOW.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> fillBucket(state, world, pos, player, hand, stack, new ItemStack(MTItems.POWDER_SNOW_BUCKET.get()), state1 -> state1.getValue(LayeredCauldronBlock.LEVEL) == 3, MTSounds.POWDER_SNOW_BUCKET_EMPTY.get()));
        addDefaultInteractions(POWDER_SNOW);

        // Milk
        MILK.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> fillBucket(state, world, pos, player, hand, stack, new ItemStack(Items.MILK_BUCKET), state1 -> state1.getValue(LayeredCauldronBlock.LEVEL) == 3, SoundEvents.BUCKET_FILL));
        addDefaultInteractions(MILK);
    }

    static void addDefaultInteractions(Map<Item, CauldronInteraction> interactionMap) {
        interactionMap.put(Items.WATER_BUCKET, FILL_WATER);
        interactionMap.put(Items.LAVA_BUCKET, FILL_LAVA);
        interactionMap.put(Items.MILK_BUCKET, FILL_MILK);
        interactionMap.put(MTItems.DYED_WATER_BUCKET.get(), FILL_DYED_WATER);
        interactionMap.put(MTItems.POWDER_SNOW_BUCKET.get(), FILL_POWDER_SNOW);
    }

    static ActionResultType fillBucket(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack filledStack, ItemStack emptyStack, Predicate<BlockState> statePredicate, SoundEvent fillSound) {
        if (!statePredicate.test(state)) {
            return ActionResultType.PASS;
        } else {
            if (!world.isClientSide) {
                player.setItemInHand(hand, MTUtils.createFilledResult(filledStack, player, emptyStack));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(filledStack.getItem()));
                world.setBlockAndUpdate(pos, MTBlocks.CAULDRON.get().defaultBlockState());
                world.playSound(null, pos, fillSound, SoundCategory.BLOCKS, 1, 1);
            }
            return ActionResultType.sidedSuccess(world.isClientSide);
        }
    }

    // sometimes, trying to do something seemingly simple in code is way harder than it seems ~isa 22-5-25
    static ActionResultType emptyBucket(World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack, BlockState state, SoundEvent emptySound, Predicate<BlockState> statePredicate) {
        if (statePredicate.test(state)) {
            return ActionResultType.PASS;
        } else {
            if (!world.isClientSide) {
                player.setItemInHand(hand, MTUtils.createFilledResult(stack, player, stack.getContainerItem()));
                player.awardStat(Stats.FILL_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
                world.setBlockAndUpdate(pos, state);
                world.playSound(null, pos, emptySound, SoundCategory.BLOCKS, 1, 1);
            }
        }
        return ActionResultType.sidedSuccess(world.isClientSide);
    }
}
