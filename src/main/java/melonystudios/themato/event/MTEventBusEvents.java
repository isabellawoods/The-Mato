package melonystudios.themato.event;

import melonystudios.themato.TheMato;
import melonystudios.themato.block.MTBlocks;
import melonystudios.themato.blockentity.custom.DyedWaterCauldronBlockEntity;
import melonystudios.themato.data.lang.MTEnglishLanguageProvider;
import melonystudios.themato.data.loottables.MTLootTableProvider;
import melonystudios.themato.data.models.MTBlockStateProvider;
import melonystudios.themato.data.models.MTItemModelProvider;
import melonystudios.themato.data.tags.MTBlockTagsProvider;
import melonystudios.themato.data.tags.MTEntityTypeTagsProvider;
import melonystudios.themato.data.tags.MTItemTagsProvider;
import melonystudios.themato.item.MTItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

import static melonystudios.themato.item.custom.DyedWaterBucketItem.DEFAULT_WATER_COLOR;

@Mod.EventBusSubscriber(modid = TheMato.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MTEventBusEvents {
    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        // Models
        generator.addProvider(new MTBlockStateProvider(generator, fileHelper));
        generator.addProvider(new MTItemModelProvider(generator, fileHelper));

        // Tags
        MTBlockTagsProvider blockTagsProvider = new MTBlockTagsProvider(generator, fileHelper);
        generator.addProvider(blockTagsProvider);
        generator.addProvider(new MTItemTagsProvider(generator, blockTagsProvider, fileHelper));
        generator.addProvider(new MTEntityTypeTagsProvider(generator, fileHelper));

        // Loot Tables
        generator.addProvider(new MTLootTableProvider(generator));

        // Translations
        generator.addProvider(new MTEnglishLanguageProvider(generator));
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerBlockColorHandlers(final ColorHandlerEvent.Block event) {
        event.getBlockColors().register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageWaterColor(world, pos) : DEFAULT_WATER_COLOR, MTBlocks.WATER_CAULDRON.get());

        event.getBlockColors().register((state, world, pos, tintIndex) -> {
            TileEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof DyedWaterCauldronBlockEntity) {
                DyedWaterCauldronBlockEntity dyedWaterCauldron = (DyedWaterCauldronBlockEntity) blockEntity;
                return dyedWaterCauldron.getWaterColor();
            } else {
                return 0x5DB7EF; // Cherry grove water color (for testing)
            }
        }, MTBlocks.DYED_WATER_CAULDRON.get());
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerItemColorHandlers(final ColorHandlerEvent.Item event) {
        event.getItemColors().register((stack, tintIndex) -> tintIndex > 0 ? -1 : getDyedWaterColor(stack), MTItems.DYED_WATER_BUCKET.get());
    }

    private static int getDyedWaterColor(ItemStack stack) {
        CompoundNBT tag = stack.getOrCreateTag();
        if (tag.contains("dyed_water_color", Constants.NBT.TAG_ANY_NUMERIC)) {
            return tag.getInt("dyed_water_color");
        } else {
            return DEFAULT_WATER_COLOR;
        }
    }
}
