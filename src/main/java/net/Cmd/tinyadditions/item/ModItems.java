package net.Cmd.tinyadditions.item;

import net.Cmd.tinyadditions.TinyAdditionsMod;
import net.Cmd.tinyadditions.item.custom.FrigidPolarBearSpawnEggItem;
import net.Cmd.tinyadditions.item.custom.FrigidSpawnEggItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final  Item FRIGID_SPAWN_EGG = registerItem("frigid_spawn_egg",
            new FrigidSpawnEggItem(new Item.Settings()));

    public static final Item FRIGID_POLAR_BEAR_SPAWN_EGG = registerItem("frigid_polar_bear_spawn_egg",
            new FrigidPolarBearSpawnEggItem(new Item.Settings()));


//Criação da Method
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TinyAdditionsMod.MOD_ID, name), item);
    }

//Grupo do inventario criativo
    public static void registerModItems() {
        TinyAdditionsMod.LOGGER.info("Registering Mod Items for" + TinyAdditionsMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries ->
        {
            entries.add(FRIGID_SPAWN_EGG);
            entries.add(FRIGID_POLAR_BEAR_SPAWN_EGG);
        });
    }
}
