package com.CartersDev.crystechmod.item.custom.Weapons.Bows;


import com.CartersDev.crystechmod.enchantment.BeamCaster.EfficientCellsEnchantment;
import com.CartersDev.crystechmod.enchantment.ModEnchantments;
import com.CartersDev.crystechmod.entity.custom.*;
import com.CartersDev.crystechmod.item.FocusTypes;
import com.CartersDev.crystechmod.item.ModItems;
import com.CartersDev.crystechmod.item.custom.Util.FocusContainer;
import com.CartersDev.crystechmod.sound.ModSounds;
import com.CartersDev.crystechmod.util.NBTHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Locale;


   /*
    This class needs to have the Energy Capability and modifications to the bow logic. I.E If Energy > 10FE Has ammo == true.

    It would also need to handle the check for the Existence of the ACTUAL Upgrade items Like the Focus Lens in order to reduce the durability on use,
    Or multiply the energy capacity, attack damage, Bow Pull animation reduction ect...

    This is also the class where if a Focus Lens is present its effects will be applied to the "Arrow" just like the Enchantment check in the Vanilla bow class

    Obviously this is also where the traditional Bow logic would be located
     */

public class ThermalEnergyBow extends CrossbowItem implements FocusContainer {

    private static final String TAG_LASER_FOCUS = "LaserFocus";
    private static final Logger log = LogManager.getLogger(ThermalEnergyBow.class);


    public ThermalEnergyBow(Properties pProperties) {
        super(pProperties);

    }


    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.CROSSBOW;
    }

    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (!pLevel.isClientSide() && pEntityLiving instanceof Player player) {

            ItemStack weapon = player.getMainHandItem();

            ItemStack itemstack = player.getProjectile(pStack);
            int i = this.getUseDuration(pStack) - pTimeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(pStack, pLevel, player, i, itemstack.isEmpty());
            if (i < 0) return;


            float f = getPowerForTime(i, weapon);
            if (f >= 1.0F && !isCharged(pStack)) {
                setCharged(pStack, true);
                SoundSource soundsource = pEntityLiving instanceof Player ? SoundSource.PLAYERS : SoundSource.HOSTILE;
                pLevel.playSound((Player)null, pEntityLiving.getX(), pEntityLiving.getY(), pEntityLiving.getZ(), SoundEvents.CROSSBOW_LOADING_END, soundsource, 1.0F, 1.0F / (pLevel.getRandom().nextFloat() * 0.5F + 1.0F) + 0.2F);
            }

        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        boolean flag = pPlayer.getItemInHand(pHand).isEmpty();
        if(!pLevel.isClientSide()) {


            if (!isLoaded(itemstack)) {
                ItemStack focus = findAmmo(pPlayer);
                if (focus != ItemStack.EMPTY) {
                    if (focus.is(ModItems.LASER_FOCUS.get())) {
                        tryToLoadWeapon(itemstack, FocusTypes.BASIC);
                        focus.shrink(1);
                        return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);

                    } else if (focus.is(ModItems.IMPROVED_LASER_FOCUS.get())) {
                        tryToLoadWeapon(itemstack, FocusTypes.IMPROVED);
                        focus.shrink(1);
                        return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);

                    }else if (focus.is(ModItems.ADVANCED_LASER_FOCUS.get())) {
                        tryToLoadWeapon(itemstack, FocusTypes.ADVANCED);
                        focus.shrink(1);
                        return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);

                    }else if (focus.is(ModItems.OVERCHARGED_LASER_FOCUS.get())) {
                        tryToLoadWeapon(itemstack, FocusTypes.OVERCHARGED);
                        focus.shrink(1);
                        return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);

                    }else if (focus.is(ModItems.LASER_FOCUS_PROTOCULTURE.get())) {
                        tryToLoadWeapon(itemstack, FocusTypes.PROTOCULTURE);
                        focus.shrink(1);
                        return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);

                    }else if (focus.is(ModItems.LASER_FOCUS_POISON.get())) {
                        tryToLoadWeapon(itemstack, FocusTypes.POISON);
                        focus.shrink(1);
                        return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
                    }

                }

            } else {
                if(isCharged(itemstack)) {
                    int currentCharge = getCharge(itemstack);
                    System.out.println(currentCharge);
                    int i = EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.EFFICIENT_CELLS.get(), itemstack);
                    int a = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MULTISHOT, itemstack);

                    if(EfficientCellsEnchantment.shouldIgnoreChargeDrop(itemstack, i, RandomSource.create())) {
                        if (a == 1) {
                            dischargeWeapon(pLevel, pPlayer, pHand, itemstack, 3.15F, 1.0F, 0.0F);
                            dischargeWeapon(pLevel, pPlayer, pHand, itemstack, 3.15F, 1.0F, -10.0F);
                            dischargeWeapon(pLevel, pPlayer, pHand, itemstack, 3.15F, 1.0F, 10.0F);
                        }else {
                            dischargeWeapon(pLevel, pPlayer, pHand, itemstack, 3.15F, 1.0F, 0.0F);
                        }
                        setCharged(itemstack, false);
                    }else {
                        if (currentCharge - 10 <= 0) {
                            if (a == 1) {
                                dischargeWeapon(pLevel, pPlayer, pHand, itemstack, 3.15F, 1.0F, 0.0F);
                                dischargeWeapon(pLevel, pPlayer, pHand, itemstack, 3.15F, 1.0F, -10.0F);
                                dischargeWeapon(pLevel, pPlayer, pHand, itemstack, 3.15F, 1.0F, 10.0F);
                            }else {
                                dischargeWeapon(pLevel, pPlayer, pHand, itemstack, 3.15F, 1.0F, 0.0F);
                            }
                            setCharged(itemstack, false);
                            tryToUnloadWeapon(itemstack);
                            spawnEmptyFocus(pPlayer);


                        } else {
                            if (a == 1) {
                                dischargeWeapon(pLevel, pPlayer, pHand, itemstack, 3.15F, 1.0F, 0.0F);
                                dischargeWeapon(pLevel, pPlayer, pHand, itemstack, 3.15F, 1.0F, -10.0F);
                                dischargeWeapon(pLevel, pPlayer, pHand, itemstack, 3.15F, 1.0F, 10.0F);
                            }else {
                                dischargeWeapon(pLevel, pPlayer, pHand, itemstack, 3.15F, 1.0F, 0.0F);
                            }
                            setCharged(itemstack, false);
                            setCharge(itemstack, currentCharge - 10);

                        }
                    }

                    System.out.println(currentCharge);

                    return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
                } else if (!isCharged(itemstack)) {
                    pPlayer.startUsingItem(pHand);
                    return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
                }
                System.out.println(isLoaded(itemstack));



            }
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }




    private static float getPowerForTime(int pUseTime, ItemStack beamCaster) {
        float f = (float)pUseTime / (float)getChargeDuration(beamCaster);
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    public static ItemStack findAmmo(Player player)
    {
        for(int i = 0; i < player.getInventory().getContainerSize(); i++)
        {
            ItemStack itemstack = player.getInventory().getItem(i);
            if(isAmmo(itemstack))
            {
                return itemstack;
            }
        }
        return ItemStack.EMPTY;

    }


    public static boolean isAmmo(ItemStack stack)
    {
        if(stack.isEmpty()) {
            return false;
        }

        return stack.is(ModItems.LASER_FOCUS.get()) || stack.is(ModItems.IMPROVED_LASER_FOCUS.get()) || stack.is(ModItems.ADVANCED_LASER_FOCUS.get()) || stack.is(ModItems.LASER_FOCUS_POISON.get()) ||stack.is(ModItems.OVERCHARGED_LASER_FOCUS.get()) || stack.is(ModItems.LASER_FOCUS_PROTOCULTURE.get());

    }

    public static void dischargeWeapon (Level pLevel, Player player, InteractionHand pHand, ItemStack beamCaster, float pVelocity, float pInaccuracy, float pProjectileAngle){
        if (net.minecraftforge.event.ForgeEventFactory.onArrowLoose(beamCaster, player.level(), player, 1, true) < 0) return;
        if (!pLevel.isClientSide) {
            boolean basicLaser = getFocusInUse(beamCaster).equals("BASIC");
            boolean improvedLaser = getFocusInUse(beamCaster).equals("IMPROVED");
            boolean advancedLaser = getFocusInUse(beamCaster).equals("ADVANCED");
            boolean overchargedLaser = getFocusInUse(beamCaster).equals("OVERCHARGED");
            boolean protocultureLaser = getFocusInUse(beamCaster).equals("PROTOCULTURE");
            boolean poisonLaser = getFocusInUse(beamCaster).equals("POISON");

            int j = EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.BEAM_INTENSITY.get(), beamCaster);
            int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PIERCING, beamCaster);

            if(basicLaser) {
                LaserBeamEntity laserProjectile = new LaserBeamEntity(pLevel, player);
                //Piercing:
                if (i > 0) {
                    laserProjectile.setPierceLevel((byte)i);
                }

                //Damage Buff from Intensity:
                if (j > 0) {
                    laserProjectile.setBaseDamage(getDamageModifier(beamCaster) + (j * 0.5F + 0.5F));
                }else {
                    laserProjectile.setBaseDamage(getDamageModifier(beamCaster));
                }

                //Searing Laser:
                laserProjectile.setIgniteTarget(EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.SEARING_LASER.get(), beamCaster) > 0);

                //Volatile Laser:
                laserProjectile.setDetonate(EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.VOLATILE_LASER.get(), beamCaster) > 0);


                laserProjectile.shoot(player.getLookAngle().x, player.getLookAngle().y, player.getLookAngle().z, pVelocity, pProjectileAngle);
                pLevel.addFreshEntity(laserProjectile);
                pLevel.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.LASER.get(), SoundSource.NEUTRAL,
                        1.5F, 1F);
            }

            if(improvedLaser) {
                ImprovedLaserBeamEntity laserProjectile = new ImprovedLaserBeamEntity(pLevel, player);
                //Piercing:
                if (i > 0) {
                    laserProjectile.setPierceLevel((byte)i);
                }

                //Damage Buff from Intensity:
                if (j > 0) {
                    laserProjectile.setBaseDamage(getDamageModifier(beamCaster) + (j * 0.5F + 0.5F));
                }else {
                    laserProjectile.setBaseDamage(getDamageModifier(beamCaster));
                }

                //Searing Laser:
                laserProjectile.setIgniteTarget(EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.SEARING_LASER.get(), beamCaster) > 0);

                //Volatile Laser:
                laserProjectile.setDetonate(EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.VOLATILE_LASER.get(), beamCaster) > 0);


                laserProjectile.shoot(player.getLookAngle().x, player.getLookAngle().y, player.getLookAngle().z, pVelocity, pProjectileAngle);
                pLevel.addFreshEntity(laserProjectile);
                pLevel.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.LASER.get(), SoundSource.NEUTRAL,
                        1.5F, 1F);
            }

            if(advancedLaser) {
                AdvancedLaserBeamEntity laserProjectile = new AdvancedLaserBeamEntity(pLevel, player);
                //Piercing:
                if (i > 0) {
                    laserProjectile.setPierceLevel((byte)i);
                }

                //Damage Buff from Intensity:
                if (j > 0) {
                    laserProjectile.setBaseDamage(getDamageModifier(beamCaster) + (j * 0.5F + 0.5F));
                }else {
                    laserProjectile.setBaseDamage(getDamageModifier(beamCaster));
                }

                //Searing Laser:
                laserProjectile.setIgniteTarget(EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.SEARING_LASER.get(), beamCaster) > 0);

                //Volatile Laser:
                laserProjectile.setDetonate(EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.VOLATILE_LASER.get(), beamCaster) > 0);


                laserProjectile.shoot(player.getLookAngle().x, player.getLookAngle().y, player.getLookAngle().z, pVelocity, pProjectileAngle);
                pLevel.addFreshEntity(laserProjectile);
                pLevel.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.LASER.get(), SoundSource.NEUTRAL,
                        1.5F, 1F);
            }

            if(overchargedLaser) {
                OverchargedLaserBeamEntity laserProjectile = new OverchargedLaserBeamEntity(pLevel, player);
                //Piercing:
                if (i > 0) {
                    laserProjectile.setPierceLevel((byte)i);
                }

                //Damage Buff from Intensity:
                if (j > 0) {
                    laserProjectile.setBaseDamage(getDamageModifier(beamCaster) + (j * 0.5F + 0.5F));
                }else {
                    laserProjectile.setBaseDamage(getDamageModifier(beamCaster));
                }

                //Searing Laser:
                laserProjectile.setIgniteTarget(EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.SEARING_LASER.get(), beamCaster) > 0);

                //Volatile Laser:
                laserProjectile.setDetonate(EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.VOLATILE_LASER.get(), beamCaster) > 0);


                laserProjectile.shoot(player.getLookAngle().x, player.getLookAngle().y, player.getLookAngle().z, pVelocity, pProjectileAngle);
                pLevel.addFreshEntity(laserProjectile);
                pLevel.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.LASER.get(), SoundSource.NEUTRAL,
                        1.5F, 1F);
            }

            if(protocultureLaser) {
                ProtocultureLaserBeamEntity laserProjectile = new ProtocultureLaserBeamEntity(pLevel, player);
                //Piercing:
                if (i > 0) {
                    laserProjectile.setPierceLevel((byte)i);
                }

                //Damage Buff from Intensity:
                if (j > 0) {
                    laserProjectile.setBaseDamage(getDamageModifier(beamCaster) + (j * 0.5F + 0.5F));
                }else {
                    laserProjectile.setBaseDamage(getDamageModifier(beamCaster));
                }

                //Searing Laser:
                laserProjectile.setIgniteTarget(EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.SEARING_LASER.get(), beamCaster) > 0);

                //Volatile Laser:
                laserProjectile.setDetonate(EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.VOLATILE_LASER.get(), beamCaster) > 0);


                laserProjectile.shoot(player.getLookAngle().x, player.getLookAngle().y, player.getLookAngle().z, pVelocity, pProjectileAngle);
                pLevel.addFreshEntity(laserProjectile);
                pLevel.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.LASER.get(), SoundSource.NEUTRAL,
                        1.5F, 1F);
            }

            if(poisonLaser) {
                PoisonLaserBeamEntity laserProjectile = new PoisonLaserBeamEntity(pLevel, player);
                //Piercing:
                if (i > 0) {
                    laserProjectile.setPierceLevel((byte)i);
                }

                //Damage Buff from Intensity:
                if (j > 0) {
                    laserProjectile.setBaseDamage(getDamageModifier(beamCaster) + (j * 0.5F + 0.5F));
                }else {
                    laserProjectile.setBaseDamage(getDamageModifier(beamCaster));
                }

                //Searing Laser:
                laserProjectile.setIgniteTarget(EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.SEARING_LASER.get(), beamCaster) > 0);

                //Volatile Laser:
                laserProjectile.setDetonate(EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.VOLATILE_LASER.get(), beamCaster) > 0);

                laserProjectile.shoot(player.getLookAngle().x, player.getLookAngle().y, player.getLookAngle().z, pVelocity, pProjectileAngle);
                pLevel.addFreshEntity(laserProjectile);
                pLevel.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.LASER.get(), SoundSource.NEUTRAL,
                        1.5F, 1F);
            }

        }
    }

    public void tryToLoadWeapon(ItemStack beamCaster, FocusTypes focusType) {
        try {
            addFocus(beamCaster, focusType);
            setCharge(beamCaster, focusType.getDurability());
            setMaxCharge(beamCaster, focusType.getMaxDurability());
            setDamageModifier(beamCaster, focusType.getBaseDamage());
            setFocusInUse(beamCaster, focusType.name());
            setLoaded(beamCaster, true);
        }catch (Exception e) {
            log.error("Failed to load Beam Caster: ", e);
        }


    }

    public void tryToUnloadWeapon (ItemStack beamCaster) {
        try {
            removeFocus(beamCaster);
            setLoaded(beamCaster, false);
            setCharge(beamCaster, 0);
            setMaxCharge(beamCaster, 0);
            setDamageModifier(beamCaster, 0);
            setFocusInUse(beamCaster, "");
        }catch (Exception e) {
            log.error("Failed to unload Beam Caster: ", e);
        }
    }

    @Override
    public boolean isEnchantable(ItemStack pStack) {
        return super.isEnchantable(pStack);
    }

    @Override
    public int getEnchantmentValue() {
        return 20;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if(enchantment == Enchantments.UNBREAKING ||  enchantment == Enchantments.MENDING) {
            return false;
        }

        return super.canApplyAtEnchantingTable(stack, enchantment);

    }



    //Required for Focus implementation
    @Override
    public int getDurabilityforFocus(FocusTypes focus) {
        return focus.ordinal();
    }

    @Override
    public int getBaseDamageforFocus(FocusTypes focus) {
        return focus.ordinal();
    }

    @Override
    public String getNameforFocus(FocusTypes focus) {
        return focus.name().toLowerCase(Locale.ROOT);
    }


//NBT Handling
    @Override
    public void addFocus(ItemStack stack, FocusTypes focus) {
        NBTHelper.setBoolean(stack, TAG_LASER_FOCUS + "_" + focus.name().toLowerCase(Locale.ROOT), true);

    }

    @Override
    public boolean hasFocus(ItemStack stack, FocusTypes focus) {
        return hasFocus_(stack, focus);
    }

    private static boolean hasFocus_(ItemStack stack, FocusTypes focus) {
        return NBTHelper.getBoolean(stack, TAG_LASER_FOCUS + "_" + focus.name().toLowerCase(Locale.ROOT), false);
    }

    @Override
    public void removeFocus(ItemStack stack) {
        NBTHelper.setBoolean(stack, TAG_LASER_FOCUS, false);
    }


    private void spawnEmptyFocus(Player player) {
        ItemStack emptyFocus = new ItemStack(ModItems.EMPTY_FOCUS.get());
        if (!player.getInventory().add(emptyFocus)) {
            player.spawnAtLocation(emptyFocus, 0.1F);
        }
    }



//NBT Setters:
    public static void setLoaded(ItemStack beamCaster, boolean isLoaded) {
        CompoundTag compoundtag = beamCaster.getOrCreateTag();
        compoundtag.putBoolean("Loaded", isLoaded);
    }

    public static void setCharge(ItemStack beamCaster, int charge) {
        CompoundTag compoundtag = beamCaster.getOrCreateTag();
        compoundtag.putInt("Charge", charge);
    }

    public static void setMaxCharge(ItemStack beamCaster, int maxCharge) {
        CompoundTag compoundtag = beamCaster.getOrCreateTag();
        compoundtag.putInt("Max Charge", maxCharge);
    }

    public static void setDamageModifier(ItemStack beamCaster, float damage) {
        CompoundTag compoundtag = beamCaster.getOrCreateTag();
        compoundtag.putFloat("Damage Modifier", damage);
    }

    public static void setFocusInUse(ItemStack beamCaster, String name) {
        CompoundTag compoundtag = beamCaster.getOrCreateTag();
        compoundtag.putString("Loaded Focus", name);
    }

    public static void setCharged(ItemStack pCrossbowStack, boolean pIsCharged) {
        CompoundTag compoundtag = pCrossbowStack.getOrCreateTag();
        compoundtag.putBoolean("Charged", pIsCharged);
    }


    //NBT Getters:
    public static boolean isLoaded(ItemStack beamCaster) {
        CompoundTag compoundtag = beamCaster.getTag();
        return compoundtag != null && compoundtag.getBoolean("Loaded");
    }

    public static int getCharge(ItemStack beamCaster) {
        CompoundTag compoundtag = beamCaster.getOrCreateTag();
        return compoundtag.getInt("Charge");

    }

    public static int getMaxCharge(ItemStack beamCaster) {
        CompoundTag compoundtag = beamCaster.getOrCreateTag();
        return compoundtag.getInt("Max Charge");
    }

    public static float getDamageModifier(ItemStack beamCaster) {
        CompoundTag compoundtag = beamCaster.getOrCreateTag();
        return compoundtag.getFloat("Damage Modifier");
    }

    public static String getFocusInUse(ItemStack beamCaster) {
        CompoundTag compoundtag = beamCaster.getOrCreateTag();
        return compoundtag.getString("Loaded Focus");
    }

    public static boolean isCharged(ItemStack pCrossbowStack) {
        CompoundTag compoundtag = pCrossbowStack.getTag();
        return compoundtag != null && compoundtag.getBoolean("Charged");
    }

    public static boolean isOverchargedOrProtoculture(ItemStack beamCaster) {

        return getFocusInUse(beamCaster).equals("OVERCHARGED") || getFocusInUse(beamCaster).equals("PROTOCULTURE");
    }


    @Override
    public int getBarColor(ItemStack pStack)
    {

        return Mth.hsvToRgb(Math.max(0.0F, getBarWidth(pStack)/(float)MAX_BAR_WIDTH)/3.0F, 1.0F, 1.0F);
    }

    @Override
    public int getBarWidth(@Nonnull ItemStack stack)
    {
        int charge = getCharge(stack);
        int maxCharge = getMaxCharge(stack);
        return Math.round(MAX_BAR_WIDTH*((float)charge/(float)maxCharge));
    }

    @Override
    public boolean isBarVisible(@Nonnull ItemStack stack)
    {

        return isLoaded(stack);
    }

    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        int j = EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.BEAM_INTENSITY.get(), pStack);


            if (!isLoaded(pStack)) {
                pTooltip.add(Component.literal("Focus: " + "None" ).withStyle(ChatFormatting.GRAY));
                pTooltip.add(Component.literal("Damage: " + "How hard can you punch?").withStyle(ChatFormatting.GRAY));
                pTooltip.add(Component.literal("Charge: " + "0/0").withStyle(ChatFormatting.GRAY));
            }else {
                pTooltip.add(Component.literal("Crystal Technology Tools and Equipment ").withStyle(ChatFormatting.BLUE));
                pTooltip.add(Component.literal("Focus: " + getFocusInUse(pStack)).withStyle(ChatFormatting.LIGHT_PURPLE));

                if (j > 0) {
                    float dmg = getDamageModifier(pStack);
                    float enchDmg = j * 0.5F + 0.5F;
                    float total = dmg + enchDmg;

                    pTooltip.add(Component.literal("Damage: " + total).withStyle(ChatFormatting.RED));

                }else {
                    pTooltip.add(Component.literal("Damage: " + getDamageModifier(pStack)).withStyle(ChatFormatting.RED));
                }


                pTooltip.add(Component.literal("Charge: " + getCharge(pStack) + "/" + getMaxCharge(pStack)).withStyle(ChatFormatting.AQUA));
            }



    }

}



