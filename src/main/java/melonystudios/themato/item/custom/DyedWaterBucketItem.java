package melonystudios.themato.item.custom;

import melonystudios.themato.TheMato;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;
import java.util.List;

public class DyedWaterBucketItem extends Item implements DyeableItem {
    public static final int DEFAULT_WATER_COLOR = 0x3F76E4;

    public DyedWaterBucketItem(Properties properties) {
        super(properties);
    }

    @Override
    public void fillItemCategory(ItemGroup tab, NonNullList<ItemStack> list) {
        if (this.allowdedIn(tab)) {
            ItemStack bucketStack = new ItemStack(this);
            bucketStack.getOrCreateTag().putInt("dyed_water_color", DEFAULT_WATER_COLOR);
            list.add(bucketStack);
        }
    }

    @Override
    public int getColor(ItemStack stack) {
        CompoundNBT tag = stack.getOrCreateTag();
        return tag.contains("dyed_water_color", Constants.NBT.TAG_ANY_NUMERIC) ? tag.getInt("dyed_water_color") : DEFAULT_WATER_COLOR;
    }

    @Override
    public void setColor(ItemStack stack, int color) {
        stack.getOrCreateTag().putInt("dyed_water_color", color);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        if (stack.getTag() != null && stack.getTag().contains("dyed_water_color", Constants.NBT.TAG_ANY_NUMERIC)) {
            Style style = Style.EMPTY.withColor(Color.fromRgb(stack.getTag().getInt("dyed_water_color")));
            tooltip.add(new TranslationTextComponent("tooltip." + TheMato.MOD_ID + ".dyed_water_color", new StringTextComponent(String.format("#%06X", stack.getTag().getInt("dyed_water_color"))).withStyle(style)).withStyle(TextFormatting.GRAY));
        }
    }
}
