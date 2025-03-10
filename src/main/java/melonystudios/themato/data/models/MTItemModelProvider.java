package melonystudios.themato.data.models;

import melonystudios.themato.TheMato;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;

public class MTItemModelProvider extends ItemModelProvider {
    public MTItemModelProvider(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, TheMato.MOD_ID, fileHelper);
    }

    @Nonnull
    @Override
    public String getName() {
        return "The Mato - Item Models";
    }

    @Override
    protected void registerModels() {
        ModelFile generated = getExistingFile(mcLoc("item/generated"));
        ModelFile handheld = getExistingFile(mcLoc("item/handheld"));

        block("pink_ipe_log");
        block("pink_ipe_wood");
        block("stripped_pink_ipe_log");
        block("stripped_pink_ipe_wood");
        block("pink_ipe_leaves");
        block("pink_ipe_planks");
        block("pink_ipe_stairs");
        block("pink_ipe_slab");
        block("pink_ipe_fence", "_inventory");
        block("pink_ipe_fence_gate");
        block("pink_ipe_pressure_plate");
        block("pink_ipe_button", "_inventory");

        block("purple_ipe_log");
        block("purple_ipe_wood");
        block("stripped_purple_ipe_log");
        block("stripped_purple_ipe_wood");
        block("purple_ipe_leaves");
        block("purple_ipe_planks");
        block("purple_ipe_stairs");
        block("purple_ipe_slab");
        block("purple_ipe_fence", "_inventory");
        block("purple_ipe_fence_gate");
        block("purple_ipe_pressure_plate");
        block("purple_ipe_button", "_inventory");

        block("red_ipe_log");
        block("red_ipe_wood");
        block("stripped_red_ipe_log");
        block("stripped_red_ipe_wood");
        block("red_ipe_leaves");
        block("red_ipe_planks");
        block("red_ipe_stairs");
        block("red_ipe_slab");
        block("red_ipe_fence", "_inventory");
        block("red_ipe_fence_gate");
        block("red_ipe_pressure_plate");
        block("red_ipe_button", "_inventory");

        block("yellow_ipe_log");
        block("yellow_ipe_wood");
        block("stripped_yellow_ipe_log");
        block("stripped_yellow_ipe_wood");
        block("yellow_ipe_leaves");
        block("yellow_ipe_planks");
        block("yellow_ipe_stairs");
        block("yellow_ipe_slab");
        block("yellow_ipe_fence", "_inventory");
        block("yellow_ipe_fence_gate");
        block("yellow_ipe_pressure_plate");
        block("yellow_ipe_button", "_inventory");

        block("junium_log");
        block("junium_wood");
        block("stripped_junium_log");
        block("stripped_junium_wood");
        block("junium_leaves");
        block("junium_planks");
        block("junium_stairs");
        block("junium_slab");
        block("junium_fence", "_inventory");
        block("junium_fence_gate");
        block("junium_pressure_plate");
        block("junium_button", "_inventory");

        block("stripped_cactus");
        block("cactus_planks");
        block("cactus_stairs");
        block("cactus_slab");
        block("cactus_fence", "_inventory");
        block("cactus_fence_gate");
        block("cactus_pressure_plate");
        block("cactus_button", "_inventory");

        block("calcite");

        getBuilder("cauldron").parent(generated).texture("layer0", mcLoc("item/cauldron"));
        standard(generated, "pink_ipe_sign");
        standard(generated, "purple_ipe_sign");
        standard(generated, "red_ipe_sign");
        standard(generated, "yellow_ipe_sign");
        standard(generated, "junium_sign");
        standard(generated, "cactus_sign");
        standard(generated, "yellow_ipe_boat");
        standard(generated, "powder_snow_bucket");
        getBuilder("dyed_water_bucket").parent(generated).texture("layer0", modLoc("item/dyed_water_bucket_overlay")).texture("layer1", modLoc("item/dyed_water_bucket"));
        standard(generated, "liquid_cactus_bucket");
        standard(generated, "cactus_candy");

        blockItem(generated, "pink_ipe_sapling");
        blockItem(generated, "purple_ipe_sapling");
        blockItem(generated, "red_ipe_sapling");
        blockItem(generated, "yellow_ipe_sapling");
        blockItem(generated, "junium_sapling");
        blockItem(generated, "rose");
        blockItem(generated, "cyan_rose");
        blockItem(generated, "paeonia");
    }

    public void standard(ModelFile parent, String name) {
        getBuilder(name).parent(parent).texture("layer0", "item/" + name);
    }

    public void blockItem(ModelFile parent, String name) {
        getBuilder(name).parent(parent).texture("layer0", "block/" + name);
    }

    public void block(String name) {
        withExistingParent(name, modLoc("block/" + name));
    }

    public ItemModelBuilder block(String name, String extras) {
        return withExistingParent(name, modLoc("block/" + name + extras));
    }
}
