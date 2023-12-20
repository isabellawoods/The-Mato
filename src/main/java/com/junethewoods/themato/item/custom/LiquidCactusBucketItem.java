package com.junethewoods.themato.item.custom;

import com.junethewoods.themato.item.MTItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class LiquidCactusBucketItem extends Item {
    public LiquidCactusBucketItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (player.isShiftKeyDown()) {
            ItemStack handStack = player.getItemInHand(hand);
            player.addItem(new ItemStack(Items.BUCKET));
            player.addItem(new ItemStack(MTItems.CACTUS_CANDY.get()));
            handStack.shrink(1);
        }
        return super.use(world, player, hand);
    }
}
