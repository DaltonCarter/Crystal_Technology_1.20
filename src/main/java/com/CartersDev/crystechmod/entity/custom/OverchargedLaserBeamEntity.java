package com.CartersDev.crystechmod.entity.custom;

import com.CartersDev.crystechmod.entity.ModEntities;
import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.List;

public class OverchargedLaserBeamEntity extends Projectile {

    private float baseDamage = 2.0F;

    private static final EntityDataAccessor<Boolean> HIT =
            SynchedEntityData.defineId(OverchargedLaserBeamEntity.class, EntityDataSerializers.BOOLEAN);

    private static boolean igniteTarget = false;
    private static boolean detonate = false;

    private static final EntityDataAccessor<Byte> PIERCE_LEVEL = SynchedEntityData.defineId(OverchargedLaserBeamEntity.class, EntityDataSerializers.BYTE);

    @Nullable
    private BlockState lastState;

    @Nullable
    private IntOpenHashSet piercingIgnoreEntityIds;
    @Nullable
    private List<Entity> piercedAndKilledEntities;

    private int counter = 0;

    public OverchargedLaserBeamEntity(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public OverchargedLaserBeamEntity(Level pLevel, Player player) {
        super(ModEntities.OVERCHARGED_LASER_BEAM.get(), pLevel);
        setOwner(player);
        BlockPos blockPos = player.blockPosition();
        Vec3 eyePos = player.getEyePosition(1.0F);

        double d0 = eyePos.x;
        double d1 = eyePos.y;
        double d2 = eyePos.z;
        this.moveTo(d0, d1, d2, this.getYRot(), this.getXRot());
    }



    @Override
    public void tick() {
        super.tick();
        if (this.entityData.get(HIT)) {
            if (this.tickCount >= counter) {
                this.discard();
            }
        }

        if (this.tickCount >= 300) {
            this.remove(RemovalReason.DISCARDED);
        }

        if (!this.level().isClientSide()) {
            if(this.getY() > 320) {
                this.discard();
            }
        }

        Vec3 vec3 = this.getDeltaMovement();


        HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
        if (hitresult.getType() != HitResult.Type.MISS && !ForgeEventFactory.onProjectileImpact(this, hitresult))
            this.onHit(hitresult);

        double d0 = this.getX() + vec3.x;
        double d1 = this.getY() + vec3.y;
        double d2 = this.getZ() + vec3.z;
        this.updateRotation();

        double d5 = vec3.x;
        double d6 = vec3.y;
        double d7 = vec3.z;
        double d3 = this.getZ() + d1;

//        for (int i = 1; i < 5; ++i) {
//            this.level().addParticle(ModParticles.VINIFERA_PARTICLES.get(), d0 - (d5 * 2), d1 - (d6 * 2), d2 - (d7 * 2),
//                    -d5, -d6 - 0.1D, -d7);
//
//
//        }

        BlockPos blockpos = this.blockPosition();
        BlockState blockstate = this.level().getBlockState(blockpos);
        if (!blockstate.isAir()) {
            VoxelShape voxelshape = blockstate.getCollisionShape(this.level(), blockpos);
            if (!voxelshape.isEmpty()) {
                Vec3 vec31 = this.position();

                for(AABB aabb : voxelshape.toAabbs()) {
                    if (aabb.move(blockpos).contains(vec31)) {
                        break;
                    }
                }
            }
        }else {
            this.setDeltaMovement(vec3.scale(3.0F));
            this.setPos(d0, d1, d2);
        }

         if (this.isInWaterOrBubble() || this.isInWater()) {
            this.remove(RemovalReason.DISCARDED);
            this.tickCount = 0;
        }


        this.checkInsideBlocks();
    }

@Override
    protected void onHitBlock(BlockHitResult pResult) {
        this.lastState = this.level().getBlockState(pResult.getBlockPos());
        super.onHitBlock(pResult);
        Vec3 vec3 = pResult.getLocation().subtract(this.getX(), this.getY(), this.getZ());
        this.setDeltaMovement(vec3);
        Vec3 vec31 = vec3.normalize().scale((double)0.05F);
        this.setPosRaw(this.getX() - vec31.x, this.getY() - vec31.y, this.getZ() - vec31.z);
        this.playSound(SoundEvents.ENDER_DRAGON_HURT, 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
        this.resetPiercedEntities();



    BlockPos partPos = pResult.getBlockPos();

    if(detonate){
        explodeLaser(partPos);
    }

    for(int x = 0; x < 18; ++x) {
        for(int y = 0; y < 18; ++y) {
            this.level().addParticle(ParticleTypes.FLAME, partPos.getX(), partPos.getY(), partPos.getZ(),
                    Math.cos(x*20) * 0.15d, Math.cos(y*20) * 0.15d, Math.sin(x*20) * 0.15d);
        }
    }

    }



    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity hitEntity = pResult.getEntity();
        Entity owner = this.getOwner();

        if(hitEntity == owner && this.level().isClientSide()) {
            return;
        }

        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENDER_DRAGON_HURT, SoundSource.NEUTRAL,
                2F, 1F);

        LivingEntity livingentity = owner instanceof LivingEntity ? (LivingEntity)owner : null;
        float damage = baseDamage;
        boolean hurt = hitEntity.hurt(this.damageSources().mobProjectile(this, livingentity), damage);
        if (hurt) {
            if(hitEntity instanceof LivingEntity livingHitEntity) {
                livingHitEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), owner);
            }
        }

        boolean igniteTarget = this.igniteTarget;
        boolean detonate = this.detonate;

        if(igniteTarget){
            hitEntity.setSecondsOnFire(5);
        }

        if(detonate){
            explodeLaser(hitEntity.blockPosition());
        }

        for(int x = 0; x < 18; ++x) {
            for (int y = 0; y < 18; ++y) {
                this.level().addParticle(ParticleTypes.FLAME, hitEntity.getX(), hitEntity.getY(), hitEntity.getZ(),
                        Math.cos(x * 20) * 0.15d, Math.cos(y * 20) * 0.15d, Math.sin(x * 20) * 0.15d);
            }
        }

        if (this.getPierceLevel() > 0) {
            if (this.piercingIgnoreEntityIds == null) {
                this.piercingIgnoreEntityIds = new IntOpenHashSet(5);
            }

            if (this.piercedAndKilledEntities == null) {
                this.piercedAndKilledEntities = Lists.newArrayListWithCapacity(5);
            }

            if (this.piercingIgnoreEntityIds.size() >= this.getPierceLevel() + 1) {
                this.discard();
                return;
            }

            this.piercingIgnoreEntityIds.add(hitEntity.getId());
        }

        if (!this.level().isClientSide && owner instanceof LivingEntity) {
            EnchantmentHelper.doPostHurtEffects(livingentity, owner);
            EnchantmentHelper.doPostDamageEffects((LivingEntity)owner, livingentity);
        }

        this.doPostHurtEffects(livingentity);
        if (owner != null && livingentity != owner && livingentity instanceof Player && owner instanceof ServerPlayer && !this.isSilent()) {
            ((ServerPlayer)owner).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.ARROW_HIT_PLAYER, 0.0F));
        }

        if (!hitEntity.isAlive() && this.piercedAndKilledEntities != null) {
            this.piercedAndKilledEntities.add(livingentity);
        }
    }

    protected void doPostHurtEffects(LivingEntity pTarget) {
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);

        if(this.level().isClientSide()) {
            return;
        }



        if(pResult.getType() == HitResult.Type.ENTITY && pResult instanceof EntityHitResult entityHitResult) {
            Entity hit = entityHitResult.getEntity();
            Entity owner = this.getOwner();
            if(owner != hit) {
                this.entityData.set(HIT, true);
                counter = this.tickCount + 5;
            }
        } else {
            this.entityData.set(HIT, true);
            counter = this.tickCount + 5;
        }

    }

    private void explodeLaser(BlockPos pos) {
        if (!this.level().isClientSide) {
            int explosionRadius = 3;
            this.level().explode(this, pos.getX(), pos.getY(), pos.getZ(), (float)explosionRadius * 2.5F, Level.ExplosionInteraction.MOB);
            this.discard();
            this.spawnLingeringCloud(pos);
        }

    }


    private void spawnLingeringCloud(BlockPos pos) {

        AreaEffectCloud areaeffectcloud = new AreaEffectCloud(this.level(), pos.getX(), pos.getY(), pos.getZ());
        areaeffectcloud.setRadius(2.5F);
        areaeffectcloud.setRadiusOnUse(-0.5F);
        areaeffectcloud.setWaitTime(10);
        areaeffectcloud.setDuration(areaeffectcloud.getDuration() / 2);
        areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float)areaeffectcloud.getDuration());
        this.level().addFreshEntity(areaeffectcloud);


    }

    protected boolean canHitEntity(Entity p_36743_) {
        return super.canHitEntity(p_36743_) && (this.piercingIgnoreEntityIds == null || !this.piercingIgnoreEntityIds.contains(p_36743_.getId()));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        if (this.lastState != null) {
            pCompound.put("inBlockState", NbtUtils.writeBlockState(this.lastState));
        }

        pCompound.putFloat("damage", this.baseDamage);

        pCompound.putByte("PierceLevel", this.getPierceLevel());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);

        if (pCompound.contains("inBlockState", 10)) {
            this.lastState = NbtUtils.readBlockState(this.level().holderLookup(Registries.BLOCK), pCompound.getCompound("inBlockState"));
        }

        if (pCompound.contains("damage", 99)) {
            this.baseDamage = pCompound.getFloat("damage");
        }


        this.setPierceLevel(pCompound.getByte("PierceLevel"));
    }
    public void setBaseDamage(float pBaseDamage) {
        this.baseDamage = pBaseDamage;
    }

    public boolean setIgniteTarget(boolean ignite) {
        return this.igniteTarget = ignite;
    }

    public boolean setDetonate(boolean detonate) {
        return this.detonate = detonate;
    }

    public void setPierceLevel(byte pPierceLevel) {
        this.entityData.set(PIERCE_LEVEL, pPierceLevel);
    }

    public byte getPierceLevel() {
        return this.entityData.get(PIERCE_LEVEL);
    }



    private void resetPiercedEntities() {
        if (this.piercedAndKilledEntities != null) {
            this.piercedAndKilledEntities.clear();
        }

        if (this.piercingIgnoreEntityIds != null) {
            this.piercingIgnoreEntityIds.clear();
        }

    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(HIT, false);
        this.entityData.define(PIERCE_LEVEL, (byte)0);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
