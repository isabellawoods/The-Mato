package melonystudios.themato.item.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.Constants;

public interface DyeableItem {
    default boolean hasCustomColor(ItemStack stack) {
        CompoundNBT displayTag = stack.getTagElement("display");
        return displayTag != null && displayTag.contains("color", Constants.NBT.TAG_ANY_NUMERIC);
    }

    default int getColor(ItemStack stack) {
        CompoundNBT displayTag = stack.getTagElement("display");
        return displayTag != null && displayTag.contains("color", Constants.NBT.TAG_ANY_NUMERIC) ? displayTag.getInt("color") : 0xFFFFFF;
    }

    default void clearColor(ItemStack stack) {
        CompoundNBT displayTag = stack.getTagElement("display");
        if (displayTag != null && displayTag.contains("color")) displayTag.remove("color");
    }

    default void setColor(ItemStack stack, int color) {
        stack.getOrCreateTagElement("display").putInt("color", color);
    }
}
