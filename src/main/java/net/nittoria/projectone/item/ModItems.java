package net.nittoria.projectone.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nittoria.projectone.ProjectOne;
import net.nittoria.projectone.item.custom.RoyalAmethystPoisonSack;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ProjectOne.MOD_ID);

    public static final DeferredItem<Item> AMETHYST_DUST = ITEMS.register("amethyst_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAPS = ITEMS.register("royal_amethyst_poison_sack",
            () -> new RoyalAmethystPoisonSack(new Item.Properties().durability(8)));

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
