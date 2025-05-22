package melonystudios.themato.block.custom.cauldron;

import melonystudios.themato.cauldron.CauldronInteraction;
import melonystudios.themato.item.MTItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Map;

@SuppressWarnings("deprecation")
public abstract class AbstractCauldronBlock extends Block {
    public static final VoxelShape INTERACTION_SHAPE = box(2, 4, 2, 14, 16, 14);
    public static final VoxelShape SHAPE = VoxelShapes.join(VoxelShapes.block(), VoxelShapes.or(
            box(0, 0, 4, 16, 3, 12),
            box(4, 0, 0, 12, 3, 16),
            box(2, 0, 2, 14, 3, 14), INTERACTION_SHAPE), IBooleanFunction.ONLY_FIRST);
    public final Map<Item, CauldronInteraction> interactionMap;

    public AbstractCauldronBlock(Properties properties, Map<Item, CauldronInteraction> interactionMap) {
        super(properties);
        this.interactionMap = interactionMap;
    }

    protected double getContentHeight(BlockState state) {
        return 0;
    }

    protected boolean isEntityInsideContent(BlockState state, BlockPos pos, Entity entity) {
        return entity.getY() < (double) pos.getY() + this.getContentHeight(state) && entity.getBoundingBox().maxY > (double) pos.getY() + 0.25D;
    }

    @Override
    @Nonnull
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hitResult) {
        ItemStack handStack = player.getItemInHand(hand);
        CauldronInteraction interaction = this.interactionMap.get(handStack.getItem());
        return interaction.interact(state, world, pos, player, hand, handStack);
    }

    @Override
    @Nonnull
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    @Nonnull
    public VoxelShape getInteractionShape(BlockState state, IBlockReader world, BlockPos pos) {
        return INTERACTION_SHAPE;
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public boolean isPathfindable(BlockState state, IBlockReader world, BlockPos pos, PathType pathType) {
        return false;
    }

    public abstract boolean isFull(BlockState state);

    @Override
    public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
        return new ItemStack(MTItems.CAULDRON.get());
    }
}
