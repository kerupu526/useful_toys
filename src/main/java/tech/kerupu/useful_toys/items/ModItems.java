package tech.kerupu.useful_toys.items;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.component.CookingFuel;
import net.minecraft.world.level.storage.loot.providers.number.floats.ContextFloatProviders;
import net.minecraft.world.level.storage.loot.providers.number.floats.ResolvableFloat;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import net.minecraft.world.level.storage.loot.providers.number.ints.ResolvableInt;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import tech.kerupu.useful_toys.UsefulToys;
import tech.kerupu.useful_toys.blocks.ModBlocks;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UsefulToys.MODID);

    public static final DeferredItem<BlockItem> TEST_BLOCK_ITEM =
            ITEMS.registerSimpleBlockItem(ModBlocks.TEST_BLOCK,
                    p -> p.component(DataComponents.COOKING_FUEL, new CookingFuel(
                            new ResolvableInt.Constant(2000000),
                            ResolvableFloat.fromKey(ContextFloatProviders.COOKING_DEFAULT_SPEED_MULTIPLIER)
                            )
                    )
            );
}