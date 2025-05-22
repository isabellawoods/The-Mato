package melonystudios.themato.item.custom;

import melonystudios.themato.item.MTItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class LiquidCactusBucketItem extends Item {
    public LiquidCactusBucketItem(Properties properties) {
        super(properties);
    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (player.isShiftKeyDown()) {
            ItemStack handStack = player.getItemInHand(hand);
            player.inventory.items.set(player.inventory.selected, new ItemStack(Items.BUCKET));
            player.inventory.add(new ItemStack(MTItems.CACTUS_CANDY.get()));
            player.playSound(SoundEvents.ITEM_PICKUP, 0.2F, ((random.nextFloat() - random.nextFloat()) * 0.7F + 1) * 2);
            player.awardStat(Stats.ITEM_USED.get(this));
            return ActionResult.success(handStack);
        }
        return super.use(world, player, hand);
    }
}
