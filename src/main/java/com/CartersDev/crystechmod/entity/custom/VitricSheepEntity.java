package com.CartersDev.crystechmod.entity.custom;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;


import javax.annotation.Nullable;


public class VitricSheepEntity extends Sheep {

    public VitricSheepEntity(EntityType<? extends Sheep> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

        public ResourceLocation getDefaultLootTable() {
            if (this.isSheared()) {
                return this.getType().getDefaultLootTable();
            } else {
                ResourceLocation resourcelocation;
                switch (this.getColor()) {
                    case WHITE:
                        resourcelocation = new ResourceLocation(CrystalTech.MOD_ID,"entities/vitric_sheep/white");
                        break;
                    case ORANGE:
                        resourcelocation = new ResourceLocation(CrystalTech.MOD_ID,"entities/vitric_sheep/orange");
                        break;
                    case MAGENTA:
                        resourcelocation = new ResourceLocation(CrystalTech.MOD_ID,"entities/vitric_sheep/magenta");
                        break;
                    case LIGHT_BLUE:
                        resourcelocation = new ResourceLocation(CrystalTech.MOD_ID,"entities/vitric_sheep/light_blue");
                        break;
                    case YELLOW:
                        resourcelocation = new ResourceLocation(CrystalTech.MOD_ID,"entities/vitric_sheep/yellow");
                        break;
                    case LIME:
                        resourcelocation = new ResourceLocation(CrystalTech.MOD_ID,"entities/vitric_sheep/lime");
                        break;
                    case PINK:
                        resourcelocation = new ResourceLocation(CrystalTech.MOD_ID,"entities/vitric_sheep/pink");
                        break;
                    case GRAY:
                        resourcelocation = new ResourceLocation(CrystalTech.MOD_ID,"entities/vitric_sheep/gray");
                        break;
                    case LIGHT_GRAY:
                        resourcelocation = new ResourceLocation(CrystalTech.MOD_ID,"entities/vitric_sheep/light_gray");
                        break;
                    case CYAN:
                        resourcelocation = new ResourceLocation(CrystalTech.MOD_ID,"entities/vitric_sheep/cyan");
                        break;
                    case PURPLE:
                        resourcelocation = new ResourceLocation(CrystalTech.MOD_ID,"entities/vitric_sheep/purple");
                        break;
                    case BLUE:
                        resourcelocation = new ResourceLocation(CrystalTech.MOD_ID,"entities/vitric_sheep/blue");
                        break;
                    case BROWN:
                        resourcelocation = new ResourceLocation(CrystalTech.MOD_ID,"entities/vitric_sheep/brown");
                        break;
                    case GREEN:
                        resourcelocation = new ResourceLocation(CrystalTech.MOD_ID,"entities/vitric_sheep/green");
                        break;
                    case RED:
                        resourcelocation = new ResourceLocation(CrystalTech.MOD_ID,"entities/vitric_sheep/red");
                        break;
                    case BLACK:
                        resourcelocation = new ResourceLocation(CrystalTech.MOD_ID,"entities/vitric_sheep/black");
                        break;
                    default:
                        throw new IncompatibleClassChangeError();
                }

                return resourcelocation;
            }
        }


        protected SoundEvent getAmbientSound() {
            return SoundEvents.SHEEP_AMBIENT;
        }

        protected SoundEvent getHurtSound(DamageSource pDamageSource) {
            return SoundEvents.SHEEP_HURT;
        }

        protected SoundEvent getDeathSound() {
            return SoundEvents.SHEEP_DEATH;
        }

        protected void playStepSound(BlockPos pPos, BlockState pBlock) {
            this.playSound(SoundEvents.SHEEP_STEP, 0.15F, 1.0F);
        }



        public static DyeColor getRandomSheepColor(RandomSource pRandom) {
            int i = pRandom.nextInt(100);
            if (i < 5) {
                return DyeColor.BLACK;
            } else if (i < 10) {
                return DyeColor.GRAY;
            } else if (i < 15) {
                return DyeColor.LIGHT_GRAY;
            } else if (i < 18) {
                return DyeColor.BROWN;
            } else {
                return pRandom.nextInt(500) == 0 ? DyeColor.PINK : DyeColor.WHITE;
            }
        }

        @Nullable
        public com.CartersDev.crystechmod.entity.custom.VitricSheepEntity getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        if(!(pOtherParent instanceof VitricSheepEntity otherParent)){
            CrystalTech.LOGGER.error("WARNING: Genetic instability detected! CANCELING!");
            return null;
        }
        VitricSheepEntity baby = ModEntities.VITRIC_SHEEP.get().create(pLevel);
        baby.setColor(getOffspringColor(this, otherParent));
        return baby;
        }

        /**
         * Applies the benefits of growing back wool and faster growing up to the acting entity. This function is used in the
         * {@code EatBlockGoal}.
         */
        public void ate() {
            super.ate();
            this.setSheared(false);
            if (this.isBaby()) {
                this.ageUp(60);
            }

        }

        @Nullable
        public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
            this.setColor(getRandomSheepColor(pLevel.getRandom()));
            return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
        }





    }

