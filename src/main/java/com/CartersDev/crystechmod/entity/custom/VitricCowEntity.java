package com.CartersDev.crystechmod.entity.custom;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.entity.ModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class VitricCowEntity extends Cow {

    public VitricCowEntity(EntityType<? extends Cow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    @Nullable
    public com.CartersDev.crystechmod.entity.custom.VitricCowEntity getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        if(!(pOtherParent instanceof VitricCowEntity otherParent)){
            CrystalTech.LOGGER.error("WARNING: Genetic instability detected! CANCELING!");
            return null;
        }
        VitricCowEntity baby = ModEntities.VITRIC_COW.get().create(pLevel);

        return baby;
    }
}
