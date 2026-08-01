package com.CartersDev.crystechmod.util;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.sound.ModSounds;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class ModBlockSetTypes {
    public static BlockSetType AUTO_DOOR = BlockSetType.register(new BlockSetType(
           new ResourceLocation(CrystalTech.MOD_ID, "auto_door").toString(),
            true,
            SoundType.METAL,
            ModSounds.AUTO_DOOR_CLOSE.get(),
            ModSounds.AUTO_DOOR_OPEN.get(),
            SoundEvents.WOODEN_TRAPDOOR_CLOSE,
            SoundEvents.WOODEN_TRAPDOOR_OPEN,
            SoundEvents.STONE_BUTTON_CLICK_OFF,
            SoundEvents.STONE_BUTTON_CLICK_ON,
            SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF,
            SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON

    ));
}
