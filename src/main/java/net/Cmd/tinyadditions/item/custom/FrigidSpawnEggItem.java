package net.Cmd.tinyadditions.item.custom;

import net.Cmd.tinyadditions.entity.ModEntities;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;

public class FrigidSpawnEggItem extends Item {

    public FrigidSpawnEggItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!(context.getWorld() instanceof ServerWorld world)) return ActionResult.SUCCESS;

        var pos = context.getBlockPos().offset(context.getSide());

        ModEntities.FRIGID.spawn(world, pos, SpawnReason.SPAWN_EGG);

        context.getStack().decrement(1);
        return ActionResult.SUCCESS;
    }
}
