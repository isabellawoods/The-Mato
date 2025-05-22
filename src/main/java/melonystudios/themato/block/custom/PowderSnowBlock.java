package melonystudios.themato.block.custom;

import melonystudios.themato.effect.MTEffects;
import melonystudios.themato.item.MTItems;
import melonystudios.themato.sound.MTSounds;
import melonystudios.themato.util.MTTags;
import melonystudios.themato.util.MTUtils;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.pathfinding.PathType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.EntitySelectionContext;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

@SuppressWarnings("deprecation")
public class PowderSnowBlock extends Block {
    private static final VoxelShape FALLING_COLLISION_SHAPE = VoxelShapes.box(0, 0, 0, 1, 0.9F, 1);

    public PowderSnowBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean skipRendering(BlockState state, BlockState adjacentState, Direction direction) {
        return adjacentState.is(this) || super.skipRendering(state, adjacentState, direction);
    }

    @Override
    @Nonnull
    public VoxelShape getOcclusionShape(BlockState state, IBlockReader world, BlockPos pos) {
        return VoxelShapes.empty();
    }

    @Override
    @Nonnull
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hitResult) {
        ItemStack handStack = player.getItemInHand(hand);
        if (handStack.getItem() == Items.BUCKET) {
            player.playSound(MTSounds.POWDER_SNOW_BUCKET_FILL.get(), 1, 1);
            ItemStack powderSnowBucket = new ItemStack(MTItems.POWDER_SNOW_BUCKET.get());
            ItemStack exchangedStack = MTUtils.createFilledResult(handStack, player, powderSnowBucket, true);
            MTUtils.setItemInHand(player, hand, exchangedStack);
            if (!world.isClientSide) CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayerEntity) player, powderSnowBucket);
            world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
            return ActionResultType.sidedSuccess(world.isClientSide);
        } else {
            return super.use(state, world, pos, player, hand, hitResult);
        }
    }

    @Override
    public void entityInside(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!(entity instanceof LivingEntity) || ((LivingEntity) entity).getFeetBlockState().is(this)) {
            entity.makeStuckInBlock(state, new Vector3d(0.9F, 1.5D, 0.9F));
            if (world.isClientSide) {
                Random rand = world.getRandom();
                boolean flag = entity.xOld != entity.getX() || entity.zOld != entity.getZ();
                if (flag && rand.nextBoolean()) {
                    world.addParticle(ParticleTypes.ITEM_SNOWBALL, entity.getX(), pos.getY() + 1, entity.getZ(), (MTUtils.randomBetween(rand, -1, 1) * 0.083333336F), 0.05F, (MTUtils.randomBetween(rand, -1, 1) * 0.083333336F));
                }
            }
            if (entity instanceof LivingEntity && !world.isClientSide) {
                LivingEntity livEntity = (LivingEntity) entity;
                if (!livEntity.getType().is(MTTags.Entities.FREEZE_IMMUNE_ENTITY_TYPES) && !livEntity.hasEffect(MTEffects.FREEZING.get()) && world.getGameRules().getBoolean(MTUtils.FREEZE_DAMAGE)) {
                    if (MTUtils.hasAnyMatching(livEntity.getArmorSlots(), stack -> !stack.getItem().is(MTTags.Items.FREEZE_IMMUNE_WEARABLES))) {
                        livEntity.addEffect(new EffectInstance(MTEffects.FREEZING.get(), 200, 0, false, false, false));
                    }
                }
            }
        }
        if (!world.isClientSide) {
            if (entity.isOnFire() && (world.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) || entity instanceof PlayerEntity)) {
                world.destroyBlock(pos, false);
            }
        }
    }

    @Override
    public void fallOn(World world, BlockPos pos, Entity entity, float distance) {
        if (!(distance < 4) && entity instanceof LivingEntity) {
            SoundEvent fallSound = distance < 7 ? SoundEvents.GENERIC_BIG_FALL : SoundEvents.GENERIC_SMALL_FALL;
            entity.playSound(fallSound, 1, 1);
        }
    }

    @Override
    @Nonnull
    public VoxelShape getCollisionShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        if (context instanceof EntitySelectionContext) {
            EntitySelectionContext entitySelectionContext = (EntitySelectionContext) context;
            Entity entity = entitySelectionContext.getEntity();
            if (entity != null) {
                if (entity.fallDistance > 2.5F) {
                    return FALLING_COLLISION_SHAPE;
                }

                boolean isFallingBlock = entity instanceof FallingBlockEntity;
                if (isFallingBlock || canEntityWalkOnPowderSnow(entity) && context.isAbove(VoxelShapes.block(), pos, false) && !context.isDescending()) {
                    return super.getCollisionShape(state, world, pos, context);
                }
            }
        }

        return VoxelShapes.empty();
    }

    @Override
    @Nonnull
    public VoxelShape getVisualShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        return VoxelShapes.empty();
    }

    public static boolean canEntityWalkOnPowderSnow(Entity entity) {
        if (entity.getType().is(MTTags.Entities.POWDER_SNOW_WALKABLE_MOBS)) {
            return true;
        } else {
            return entity instanceof LivingEntity && ((LivingEntity) entity).getItemBySlot(EquipmentSlotType.FEET).getItem().is(MTTags.Items.POWDER_SNOW_PROOF_SHOES);
        }
    }

    @Override
    public boolean isPathfindable(BlockState state, IBlockReader world, BlockPos pos, PathType type) {
        return true;
    }

    @Override
    @Nullable
    public PathNodeType getAiPathNodeType(BlockState state, IBlockReader world, BlockPos pos, @Nullable MobEntity entity) {
        return PathNodeType.WALKABLE;
    }
}
