package melonystudios.themato.mixin.blockentity;

import melonystudios.themato.block.MTBlocks;
import melonystudios.themato.item.MTItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.NonNullList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(AbstractFurnaceTileEntity.class)
public abstract class MTAbstractFurnaceTileEntityMixin {
    @Shadow
    protected abstract boolean canBurn(@Nullable IRecipe<?> recipe);
    @Shadow
    protected NonNullList<ItemStack> items;

    @Inject(method = "burn", at = @At("HEAD"))
    private void burn(IRecipe<?> recipe, CallbackInfo callback) {
        if (recipe != null && canBurn(recipe)) {
            ItemStack result = this.items.get(0);

            if (result.getItem() == MTBlocks.STRIPPED_CACTUS.get().asItem() && !this.items.get(1).isEmpty() && this.items.get(1).getItem() == Items.BUCKET) {
                this.items.set(1, new ItemStack(MTItems.LIQUID_CACTUS_BUCKET.get()));
            }
        }
    }
}
