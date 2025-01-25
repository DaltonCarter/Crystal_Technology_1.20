package com.CartersDev.crystechmod.sound;

import com.CartersDev.crystechmod.CrystalTech;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
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
    public static final RegistryObject<SoundEvent> VITRIC_AMBIENT = RegisterSoundEvents("vitric_ambient");


    //Music
    public static final RegistryObject<SoundEvent> STILL_ALONE = RegisterSoundEvents("still_alone");
    public static final RegistryObject<SoundEvent> HYOUHAKU_WANDERING = RegisterSoundEvents("hyouhaku_wandering");
    public static final RegistryObject<SoundEvent> CORRODED_VALVES = RegisterSoundEvents("corroded_valves");
    public static final RegistryObject<SoundEvent> DARK_MACHINATIONS = RegisterSoundEvents("dark_machinations");
    public static final RegistryObject<SoundEvent> DARK_VALLEY = RegisterSoundEvents("dark_valley");
    public static final RegistryObject<SoundEvent> EAGLES_DAWN = RegisterSoundEvents("eagles_dawn");
    public static final RegistryObject<SoundEvent> MANUFACTORY = RegisterSoundEvents("manufactory");
    public static final RegistryObject<SoundEvent> NECROFUNK = RegisterSoundEvents("necrofunk");
    public static final RegistryObject<SoundEvent> SCOUTING = RegisterSoundEvents("scouting");
    public static final RegistryObject<SoundEvent> PRODIGAL_SON = RegisterSoundEvents("prodigal_son");
    public static final RegistryObject<SoundEvent> PYROTEK = RegisterSoundEvents("pyrotek");
    public static final RegistryObject<SoundEvent> REPENTANCE = RegisterSoundEvents("repentance");
    public static final RegistryObject<SoundEvent> SPACE_ECHO = RegisterSoundEvents("space_echo");
    public static final RegistryObject<SoundEvent> TOMBS = RegisterSoundEvents("tombs");
    public static final RegistryObject<SoundEvent> UNYIELDING = RegisterSoundEvents("unyielding");
    public static final RegistryObject<SoundEvent> WIRES = RegisterSoundEvents("wires");
    public static final RegistryObject<SoundEvent> XENOPHILE = RegisterSoundEvents("xenophile");
    public static final RegistryObject<SoundEvent> APPROACH = RegisterSoundEvents("approach");
    public static final RegistryObject<SoundEvent> DUSK_HOUR = RegisterSoundEvents("dusk_hour");
    public static final RegistryObject<SoundEvent> TS_DUSK_HOUR = RegisterSoundEvents("ts_dusk_hour");
    public static final RegistryObject<SoundEvent> HEROISM = RegisterSoundEvents("heroism");
    public static final RegistryObject<SoundEvent> LONE_TROOPER = RegisterSoundEvents("lone_trooper");
    public static final RegistryObject<SoundEvent> PHAROTEK = RegisterSoundEvents("pharotek");
    public static final RegistryObject<SoundEvent> VALVES = RegisterSoundEvents("valves");
    public static final RegistryObject<SoundEvent> WHAT_LURKS = RegisterSoundEvents("what_lurks");
    public static final RegistryObject<SoundEvent> AIRSTRIKE = RegisterSoundEvents("airstrike");
    public static final RegistryObject<SoundEvent> HEROISM_2 = RegisterSoundEvents("heroism_2");
    public static final RegistryObject<SoundEvent> CREEPING_UPON = RegisterSoundEvents("creeping_upon");
    public static final RegistryObject<SoundEvent> DEPTH_CHARGE = RegisterSoundEvents("depth_charge");
    public static final RegistryObject<SoundEvent> DRONE = RegisterSoundEvents("drone");
    public static final RegistryObject<SoundEvent> ON_THE_PROWL = RegisterSoundEvents("on_the_prowl");
    public static final RegistryObject<SoundEvent> RAIN_IN_THE_NIGHT = RegisterSoundEvents("rain_in_the_night");
    public static final RegistryObject<SoundEvent> RECON = RegisterSoundEvents("recon");
    public static final RegistryObject<SoundEvent> AWAITING = RegisterSoundEvents("awaiting");
    public static final RegistryObject<SoundEvent> DENSE = RegisterSoundEvents("dense");
    public static final RegistryObject<SoundEvent> DERELICT = RegisterSoundEvents("derelict");
    public static final RegistryObject<SoundEvent> RUN = RegisterSoundEvents("run");
    public static final RegistryObject<SoundEvent> THE_SEARCH = RegisterSoundEvents("the_search");
    public static final RegistryObject<SoundEvent> TRENCHES = RegisterSoundEvents("trenches");
    public static final RegistryObject<SoundEvent> VECTOR = RegisterSoundEvents("vector");
    public static final RegistryObject<SoundEvent> VOICE_RHYTHM_2 = RegisterSoundEvents("voice_rhythm_2");


    public static final RegistryObject<SoundEvent> VITRIC_EXPANSE_MUSIC = RegisterSoundEvents("vitric_expanse_music");


//End of Music


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
