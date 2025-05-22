package melonystudios.themato.effect.custom;

import melonystudios.themato.block.MTBlocks;
import melonystudios.themato.effect.MTEffects;
import melonystudios.themato.util.MTDamageSources;
import melonystudios.themato.util.MTTags;
import melonystudios.themato.util.MTUtils;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.StrayEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.world.World;

public class FreezingEffect extends Effect {
    public FreezingEffect() {
        super(EffectType.HARMFUL, 0x80E5EF);
    }

    @Override
    public void applyEffectTick(LivingEntity livEntity, int amplifier) {
        World world = livEntity.level;
        // Remove effect if not inside powder snow.
        if (!world.getBlockState(livEntity.blockPosition()).is(MTBlocks.POWDER_SNOW.get())) {
            livEntity.removeEffect(MTEffects.FREEZING.get());
        }

        // Damage the entity/convert a Skeleton to a Stray.
        if (!livEntity.getType().is(MTTags.Entities.FREEZE_IMMUNE_ENTITY_TYPES)) {
            if (livEntity instanceof SkeletonEntity && livEntity.getHealth() == 1) {
                SkeletonEntity skeleton = (SkeletonEntity) livEntity;
                StrayEntity stray = skeleton.convertTo(EntityType.STRAY, true);
                assert stray != null;
                stray.setHealth(skeleton.getMaxHealth());
            } else {
                if (world.getGameRules().getBoolean(MTUtils.FREEZE_DAMAGE)) {
                    livEntity.hurt(MTDamageSources.FREEZING, livEntity.getType().is(MTTags.Entities.FREEZE_HURTS_EXTRA_TYPES) ? 5 : 1);
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 40 == 0;
    }
}
