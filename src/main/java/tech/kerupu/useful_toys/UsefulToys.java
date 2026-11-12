package tech.kerupu.useful_toys;

import com.mojang.logging.LogUtils;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CookingFuel;
import net.minecraft.world.level.storage.loot.providers.number.floats.ContextFloatProviders;
import net.minecraft.world.level.storage.loot.providers.number.floats.ResolvableFloat;
import net.minecraft.world.level.storage.loot.providers.number.ints.ResolvableInt;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;
import tech.kerupu.useful_toys.blocks.ModBlocks;
import tech.kerupu.useful_toys.items.ModItems;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(UsefulToys.MODID)
public class UsefulToys {
    public static final String MODID = "useful_toys";
    private static final Logger LOGGER = LogUtils.getLogger();

    public UsefulToys(IEventBus modEventBus, ModContainer modContainer) {
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        modEventBus.addListener(UsefulToys::addCreative);
        modEventBus.addListener(UsefulToys::modifyComponents);

        LOGGER.info("\u001b[31mC\u001b[33mO\u001b[32mL\u001b[34mO\u001b[35mR \u001b[31mT\u001b[33mE\u001b[32mS\u001b[34mT");
        LOGGER.info("Useless toys loaded");
    }

    private static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModItems.TEST_BLOCK_ITEM);
        }
    }

    private static void modifyComponents(ModifyDefaultComponentsEvent event) {
        event.modify(Items.DIAMOND, (builder, _, _) ->
                builder.set(DataComponents.COOKING_FUEL, new CookingFuel(
                        new ResolvableInt.Constant(1600),
                        ResolvableFloat.fromKey(ContextFloatProviders.COOKING_DEFAULT_SPEED_MULTIPLIER)
                        )
                )
        );
        event.modify(Items.DIRT, (builder, _, _) ->
                builder.set(DataComponents.COOKING_FUEL, new CookingFuel(
                        new ResolvableInt.Constant(1),
                        ResolvableFloat.fromKey(ContextFloatProviders.COOKING_DEFAULT_SPEED_MULTIPLIER)
                        )
                )
        );
    }
}
