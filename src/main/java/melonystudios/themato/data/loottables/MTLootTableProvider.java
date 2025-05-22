package melonystudios.themato.data.loottables;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MTLootTableProvider extends LootTableProvider {
    public MTLootTableProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    @Nonnull
    public String getName() {
        return "The Mato - Loot Tables";
    }

    @Override
    @Nonnull
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(Pair.of(MTBlockLootTableProvider::new, LootParameterSets.BLOCK));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker tracker) {
        map.forEach((id, table) -> LootTableManager.validate(tracker, id, table));
    }
}
