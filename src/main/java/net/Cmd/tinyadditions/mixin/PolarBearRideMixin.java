package net.Cmd.tinyadditions.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PolarBearEntity.class)
public abstract class PolarBearRideMixin extends AnimalEntity {

    private boolean hasSaddle = false;

    protected PolarBearRideMixin(EntityType<? extends AnimalEntity> type, World world) {
        super(type, world);
    }

    /* =========================
       🖱️ INTERAÇÃO (MONTAR / SELA)
       ========================= */
    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        // Colocar sela
        if (stack.isOf(Items.SADDLE) && !hasSaddle) {
            if (!player.getAbilities().creativeMode) {
                stack.decrement(1);
            }
            hasSaddle = true;
            return ActionResult.SUCCESS;
        }

        // Montar
        if (!this.getWorld().isClient) {
            player.startRiding(this);
        }

        return ActionResult.SUCCESS;
    }

    /* =========================
       🪑 PERMITIR PASSAGEIRO
       ========================= */
    @Override
    protected boolean canAddPassenger(Entity passenger) {
        return passenger instanceof PlayerEntity;
    }

    /* =========================
       🧍 POSIÇÃO DO JOGADOR
       ========================= */
    @Override
    public Vec3d getPassengerRidingPos(Entity passenger) {
        return this.getPos().add(0.0D, this.getHeight() * 0.85D, 0.0D);
    }

    /* =========================
       🎮 CONTROLE (SÓ COM SELA)
       ========================= */
    @Override
    public void travel(Vec3d movementInput) {
        Entity passenger = this.getControllingPassenger();

        if (passenger instanceof PlayerEntity player && hasSaddle) {

            this.setYaw(player.getYaw());
            this.prevYaw = this.getYaw();
            this.setPitch(player.getPitch() * 0.5F);

            this.setMovementSpeed(0.22F);

            super.travel(new Vec3d(0.0D, 0.0D, player.forwardSpeed));
            return;
        }

        super.travel(movementInput);
    }

    @Override
    @Nullable
    public LivingEntity getControllingPassenger() {
        return hasSaddle && this.getFirstPassenger() instanceof LivingEntity living
                ? living
                : null;
    }


    /* =========================
       💾 SALVAR SELA (NBT)
       ========================= */
    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    private void tinyadditions$writeNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putBoolean("HasSaddle", this.hasSaddle);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    private void tinyadditions$readNbt(NbtCompound nbt, CallbackInfo ci) {
        this.hasSaddle = nbt.getBoolean("HasSaddle");
    }


    /* =========================
       🪓 DROP DA SELA AO MORRER
       ========================= */
    @Override
    public void onDeath(net.minecraft.entity.damage.DamageSource source) {
        super.onDeath(source);

        if (!this.getWorld().isClient && hasSaddle) {
            this.dropItem(Items.SADDLE);
        }
    }
}
