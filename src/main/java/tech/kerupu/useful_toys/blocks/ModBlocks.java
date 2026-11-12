package tech.kerupu.useful_toys.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import tech.kerupu.useful_toys.UsefulToys;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(UsefulToys.MODID);

    public static final DeferredBlock<Block> TEST_BLOCK = BLOCKS.registerSimpleBlock(
            "test_block",
            () -> BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLUE)
                    .sound(SoundType.GLASS)
                    .strength(1.5F, 6.0F)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.TRUMPET_OXIDIZED)
                    .lightLevel(_ -> 12)
                    .jumpFactor(1.1f)
                    .bounceRestitution(1.1f)
                    .fallDistanceReduction(10.0f)
                    .friction(1.1f)
                    .speedFactor(1.1f)
    );
}
