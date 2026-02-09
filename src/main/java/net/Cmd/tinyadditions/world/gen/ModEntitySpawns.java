package net.Cmd.tinyadditions.world.gen;

import net.Cmd.tinyadditions.entity.ModEntities;
import net.Cmd.tinyadditions.entity.custom.FrigidEntity;
import net.Cmd.tinyadditions.entity.custom.FrigidPolarBearEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawns {
    public static void addSpawns() {
    //Frigid
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
                BiomeKeys.SNOWY_TAIGA,
                BiomeKeys.SNOWY_BEACH,
                BiomeKeys.SNOWY_PLAINS,
                BiomeKeys.SNOWY_SLOPES,
                BiomeKeys.ICE_SPIKES,
                BiomeKeys.JAGGED_PEAKS),
                SpawnGroup.MONSTER, ModEntities.FRIGID, 200, 4, 4);

        SpawnRestriction.register(ModEntities.FRIGID, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FrigidEntity::canSpawn);

        //Frigid Polar Bear
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
                BiomeKeys.FROZEN_OCEAN,
                BiomeKeys.DEEP_FROZEN_OCEAN,
                BiomeKeys.SNOWY_PLAINS,
                BiomeKeys.ICE_SPIKES),
                SpawnGroup.CREATURE, ModEntities.FRIGID_POLAR_BEAR, 100, 1, 2);

        SpawnRestriction.register(ModEntities.FRIGID_POLAR_BEAR, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FrigidPolarBearEntity::canSpawn);
    }
}
