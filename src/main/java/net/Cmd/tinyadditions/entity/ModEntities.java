package net.Cmd.tinyadditions.entity;

import net.Cmd.tinyadditions.TinyAdditionsMod;
import net.Cmd.tinyadditions.entity.custom.FrigidEntity;
import net.minecraft.entity.EntityType;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<FrigidEntity> FRIGID = Registry.register
            (Registries.ENTITY_TYPE, Identifier.of(TinyAdditionsMod.MOD_ID,
                    "frigid"), EntityType.Builder.create(FrigidEntity::new,
                    SpawnGroup.CREATURE).dimensions(0.6f, 1.95f).build());

    public static void registerModEntities() {
        TinyAdditionsMod.LOGGER.info("Registering Mod Entities for " +
                TinyAdditionsMod.MOD_ID);
    }
}
