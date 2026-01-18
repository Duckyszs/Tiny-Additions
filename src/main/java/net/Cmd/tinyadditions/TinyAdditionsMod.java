package net.Cmd.tinyadditions;

import net.Cmd.tinyadditions.entity.ModEntities;
import net.Cmd.tinyadditions.entity.custom.FrigidEntity;
import net.Cmd.tinyadditions.item.ModItems;
import net.Cmd.tinyadditions.world.gen.ModEntitySpawns;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TinyAdditionsMod implements ModInitializer {
	public static final String MOD_ID = "tinyadditions";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModEntities.registerModEntities();
		ModItems.registerModItems();
		ModEntitySpawns.addSpawns();
		FabricDefaultAttributeRegistry.register(ModEntities.FRIGID, FrigidEntity.createAtribute());
	}
}