package tech.kerupu.useful_toys;

import java.util.List;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import tech.kerupu.useful_toys.blocks.ModBlocks;

@EventBusSubscriber(modid = UsefulToys.MODID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void registerBlockTints(RegisterColorHandlersEvent.BlockTintSources event) {
        event.register(
                List.of(state -> 0xFF3F76E4),
                ModBlocks.TEST_BLOCK.get()
        );
    }
}
