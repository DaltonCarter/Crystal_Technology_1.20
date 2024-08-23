package com.CartersDev.crystechmod.sound;

import com.CartersDev.crystechmod.CrystalTech;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CrystalTech.MOD_ID);

    public static final RegistryObject<SoundEvent> CHIME = RegisterSoundEvents("chime");
    public static final RegistryObject<SoundEvent> SOUND_BLOCK_BREAK = RegisterSoundEvents("sound_block_break");
    public static final RegistryObject<SoundEvent> SOUND_BLOCK_STEP = RegisterSoundEvents("sound_block_step");
    public static final RegistryObject<SoundEvent> SOUND_BLOCK_FALL = RegisterSoundEvents("sound_block_fall");
    public static final RegistryObject<SoundEvent> SOUND_BLOCK_PLACE = RegisterSoundEvents("sound_block_place");
    public static final RegistryObject<SoundEvent> SOUND_BLOCK_HIT = RegisterSoundEvents("sound_block_hit");


    public static final RegistryObject<SoundEvent> STILL_ALONE = RegisterSoundEvents("still_alone");







    public static final ForgeSoundType SOUND_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.SOUND_BLOCK_BREAK, ModSounds.SOUND_BLOCK_STEP, ModSounds.SOUND_BLOCK_PLACE,
            ModSounds.SOUND_BLOCK_HIT, ModSounds.SOUND_BLOCK_FALL);


    private static RegistryObject<SoundEvent> RegisterSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(CrystalTech.MOD_ID, name)));
    }


    public static void register (IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

}
