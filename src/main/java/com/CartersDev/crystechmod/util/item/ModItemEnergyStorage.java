package com.CartersDev.crystechmod.util.item;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.energy.EnergyStorage;

public class ModItemEnergyStorage extends EnergyStorage {

    private final ItemStack stack;

    public ModItemEnergyStorage(ItemStack stack, int capacity, int maxTransfer) {
        super(capacity, maxTransfer, maxTransfer);
        this.stack = stack;

        if (stack.hasTag() && stack.getTag().contains("Energy")) {
            this.energy = stack.getTag().getInt("Energy");
        }
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        int incoming = super.receiveEnergy(maxReceive, simulate);

        if (!simulate && incoming > 0) {
            stack.getOrCreateTag().putInt("Energy", this.energy);
        }
        return incoming;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        int outgoing = super.extractEnergy(maxExtract, simulate);

        if (!simulate && outgoing > 0) {
            stack.getOrCreateTag().putInt("Energy", this.energy);
        }
        return outgoing;
    }
}
