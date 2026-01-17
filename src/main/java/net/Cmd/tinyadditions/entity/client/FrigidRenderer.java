package net.Cmd.tinyadditions.entity.client;

import net.Cmd.tinyadditions.entity.custom.FrigidEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

public class FrigidRenderer extends MobEntityRenderer<FrigidEntity, ZombieEntityModel<FrigidEntity>> {

    public FrigidRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new ZombieEntityModel<>(ctx.getPart(EntityModelLayers.ZOMBIE)), 0.5f);
    }

    @Override
    public Identifier getTexture(FrigidEntity entity) {
        return Identifier.of("tinyadditions", "textures/entity/frigid.png");
    }
}

