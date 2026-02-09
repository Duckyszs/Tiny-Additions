package net.Cmd.tinyadditions;

import net.Cmd.tinyadditions.entity.ModEntities;
import net.Cmd.tinyadditions.entity.client.FrigidPolarBearRenderer;
import net.Cmd.tinyadditions.entity.client.FrigidRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class TinyAdditionsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.FRIGID, FrigidRenderer::new);
        EntityRendererRegistry.register(ModEntities.FRIGID_POLAR_BEAR, FrigidPolarBearRenderer::new);
    }
}
