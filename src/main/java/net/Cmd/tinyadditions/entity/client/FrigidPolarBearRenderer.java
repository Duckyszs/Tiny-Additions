package net.Cmd.tinyadditions.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.PolarBearEntityRenderer;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.util.Identifier;


public class FrigidPolarBearRenderer extends PolarBearEntityRenderer {

    private static final Identifier TEXTURE =
            Identifier.of("tinyadditions", "textures/entity/frigid_polar_bear.png");

    public FrigidPolarBearRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(PolarBearEntity entity) {
        return TEXTURE;
    }
}
