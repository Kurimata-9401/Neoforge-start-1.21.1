package net.nittoria.projectone.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nittoria.projectone.ProjectOne;
import net.nittoria.projectone.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProjectOne.MOD_ID);

    public static final Supplier<CreativeModeTab> AMETHYST_BEE_QUEEN_TAB = CREATIVE_MODE_TAB.register("amethyst_queen_bee_tab",
            () -> CreativeModeTab.builder()
                    .icon(()-> new ItemStack(ModItems.AMETHYST_DUST.get()))
                    .title(Component.translatable("creativetab.projectone.amethyst_queen_bee_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAPS);
                    }).build());

    public static final Supplier<CreativeModeTab> PROJECT_ONE_BLOCKS_TAB = CREATIVE_MODE_TAB.register("project_one_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(()-> new ItemStack(ModBlocks.AMETHYST_SAND.get()))
                    .title(Component.translatable("creativetab.projectone.project_one_blocks"))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ProjectOne.MOD_ID, "amethyst_queen_bee_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.AMETHYST_SAND);
                        output.accept(ModItems.AMETHYST_DUST);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
