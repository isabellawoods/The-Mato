package melonystudios.themato.data.tags;

import melonystudios.themato.TheMato;
import melonystudios.themato.util.MTTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.EntityTypeTagsProvider;
import net.minecraft.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MTEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public MTEntityTypeTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper fileHelper) {
        super(generator, TheMato.MOD_ID, fileHelper);
    }

    @Override
    @Nonnull
    public String getName() {
        return "The Mato - Entity Type Tags";
    }

    @Override
    protected void addTags() {
        // The Mato's Tags
        this.tag(MTTags.Entities.FREEZE_IMMUNE_ENTITY_TYPES).add(EntityType.STRAY, EntityType.POLAR_BEAR, EntityType.SNOW_GOLEM, EntityType.WITHER);
        this.tag(MTTags.Entities.POWDER_SNOW_WALKABLE_MOBS).add(EntityType.FOX, EntityType.RABBIT, EntityType.SHULKER, EntityType.VEX, EntityType.SILVERFISH, EntityType.ENDERMITE);
        this.tag(MTTags.Entities.FREEZE_HURTS_EXTRA_TYPES).add(EntityType.STRIDER, EntityType.MAGMA_CUBE, EntityType.BLAZE);

        // Melony Tags
        this.tag(MTTags.Entities.CAN_SPAWN_ON_LEAVES).add(EntityType.OCELOT, EntityType.PARROT);
    }
}
