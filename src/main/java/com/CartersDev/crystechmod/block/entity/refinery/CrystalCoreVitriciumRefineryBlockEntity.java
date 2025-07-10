package com.CartersDev.crystechmod.block.entity.refinery;


import com.CartersDev.crystechmod.block.custom.VitriciumRefineryBlock;
import com.CartersDev.crystechmod.block.entity.ModBlockEntities;
import com.CartersDev.crystechmod.recipe.VitriciumRefineryRecipe;
import com.CartersDev.crystechmod.screen.vitriciumRefineryMenu.CrystalCoreVitriciumRefineryMenu;
import com.CartersDev.crystechmod.screen.vitriciumRefineryMenu.VitriciumRefineryMenu;
import com.CartersDev.crystechmod.util.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

import static com.CartersDev.crystechmod.block.custom.VitriciumRefineryBlock.WORKING;


public class CrystalCoreVitriciumRefineryBlockEntity extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 5);
            }
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case 0 -> true;
                case 1 -> stack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).isPresent();
                case 2 -> stack.getItem() == Items.REDSTONE;
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private static final int INPUT_SLOT = 0;
    private static final int FLUID_SLOT = 1;
    private static final int POWER_SLOT = 2;


private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();


private final Map<Direction, LazyOptional<WrappedHandler>> directioWrappedHandlerMap =
        new InventoryDirectionWrapper(itemHandler,
                new InventoryDirectionEntry(Direction.DOWN, POWER_SLOT, true),
                new InventoryDirectionEntry(Direction.UP, INPUT_SLOT, true),
                new InventoryDirectionEntry(Direction.NORTH, INPUT_SLOT, true),
                new InventoryDirectionEntry(Direction.SOUTH, POWER_SLOT, true),
                new InventoryDirectionEntry(Direction.EAST, FLUID_SLOT, true),
                new InventoryDirectionEntry(Direction.WEST, INPUT_SLOT, true)).directionsMap;

private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();
private LazyOptional<IFluidHandler> lazyFluidHandler = LazyOptional.empty();
private LazyOptional<IFluidHandler> lazyOutputFluidHandler = LazyOptional.empty();

protected final ContainerData data;
private int progress = 0;
private int maxProgress = 0;
private final int DEFAULT_MAX_PROGRESS = 100;

    private int energyAmount = 0;
    private final int DEFAULT_ENERGY_AMOUNT = 100;

    private FluidStack neededFluidStack = FluidStack.EMPTY;
    private FluidStack outputFluidStack = FluidStack.EMPTY;

private final ModEnergyStorage ENERGY_STORAGE = createEnergyStorage();
private final FluidTank FLUID_TANK = createFluidTank();
private final FluidTank OUTPUT_FLUID_TANK = createOutputFluidTank();


    private FluidTank createFluidTank() {
        return new FluidTank(64000) {

            @Override
            protected void onContentsChanged() {
                setChanged();
                if(!level.isClientSide()) {
                    level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                }
            }

            @Override
            public boolean isFluidValid(FluidStack stack) {
                return stack.getFluid().is(ModTags.Fluids.REFINERY_INPUT);
            }
        };

    }

    private FluidTank createOutputFluidTank() {
        return new FluidTank(64000) {

            @Override
            protected void onContentsChanged() {
                setChanged();
                if(!level.isClientSide()) {
                    level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                }
            }

            @Override
            public boolean isFluidValid(FluidStack stack) {
                return stack.getFluid().is(ModTags.Fluids.REFINERY_OUTPUT);
            }
        };

    }

    private ModEnergyStorage createEnergyStorage() {
        return new ModEnergyStorage(360000, 10000) {
            @Override
            public void onEnergyChanged() {
                setChanged();
                getLevel().sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        };
    }

//    public ItemStack getRenderStack() {
//        ItemStack stack = itemHandler.getStackInSlot(OUTPUT_SLOT);
//
//        if(stack.isEmpty()) {
//            stack = itemHandler.getStackInSlot(INPUT_SLOT);
//        }
//        return stack;
//    }


    public CrystalCoreVitriciumRefineryBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.CRYSTAL_CORE_VITRICIUM_REFINERY_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch(pIndex){
                    case 0 -> CrystalCoreVitriciumRefineryBlockEntity.this.progress;
                    case 1 -> CrystalCoreVitriciumRefineryBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch(pIndex){
                    case 0 -> CrystalCoreVitriciumRefineryBlockEntity.this.progress = pValue;
                    case 1 -> CrystalCoreVitriciumRefineryBlockEntity.this.maxProgress = pValue;
                };

            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    public IEnergyStorage getEnergyStorage() {
        return this.ENERGY_STORAGE;
    }

    public FluidStack getFluid() {
        return FLUID_TANK.getFluid();
    }

    public FluidStack getOutputFluid() {
        return OUTPUT_FLUID_TANK.getFluid();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Refinery");
    }


    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new CrystalCoreVitriciumRefineryMenu(pContainerId, pPlayerInventory, this, this.data);

    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {

        if(cap == ForgeCapabilities.ENERGY){
            return lazyEnergyHandler.cast();
        }

        if(cap == ForgeCapabilities.FLUID_HANDLER){
            if(this.getBlockState().getValue(VitriciumRefineryBlock.FACING).getClockWise() == side){
                return lazyFluidHandler.cast();
            }

            if(this.getBlockState().getValue(VitriciumRefineryBlock.FACING).getCounterClockWise() == side){
                return lazyOutputFluidHandler.cast();
            }

        }

        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            if(side == null) {
                return lazyItemHandler.cast();
            }

            if(directioWrappedHandlerMap.containsKey(side)){
                Direction localDirection = this.getBlockState().getValue(VitriciumRefineryBlock.FACING);

                if(side == Direction.DOWN || side == Direction.UP){
                    return directioWrappedHandlerMap.get(side).cast();
                }

                return switch (localDirection) {
                  default -> directioWrappedHandlerMap.get(side.getOpposite()).cast();
                  case EAST -> directioWrappedHandlerMap.get(side.getClockWise()).cast();
                  case SOUTH -> directioWrappedHandlerMap.get(side).cast();
                  case WEST -> directioWrappedHandlerMap.get(side.getCounterClockWise()).cast();
                };

            }
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();

        lazyItemHandler = LazyOptional.of(() -> itemHandler);
        lazyEnergyHandler = LazyOptional.of(() -> ENERGY_STORAGE);
        lazyFluidHandler = LazyOptional.of(() -> FLUID_TANK);
        lazyOutputFluidHandler = LazyOptional.of(() -> OUTPUT_FLUID_TANK);

    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        lazyEnergyHandler.invalidate();
        lazyFluidHandler.invalidate();
        lazyOutputFluidHandler.invalidate();

    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {

        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("crystal_core_vitricium_refinery.progress", progress);
        pTag.putInt("crystal_core_vitricium_refinery.max_progress", maxProgress);
        pTag.putInt("crystal_core_vitricium_refinery.energy_amount", energyAmount);

        neededFluidStack.writeToNBT(pTag);

        pTag.putInt("energy", ENERGY_STORAGE.getEnergyStored());
        pTag = FLUID_TANK.writeToNBT(pTag);
        CompoundTag fluidTag = new CompoundTag();
        fluidTag = OUTPUT_FLUID_TANK.writeToNBT(fluidTag);
        pTag.put("outputFluidType", fluidTag);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("crystal_core_vitricium_refinery.progress");
        maxProgress = pTag.getInt("crystal_core_vitricium_refinery.max_progress");
        energyAmount = pTag.getInt("crystal_core_vitricium_refinery.energy_amount");
        neededFluidStack = FluidStack.loadFluidStackFromNBT(pTag);
        ENERGY_STORAGE.setEnergy(pTag.getInt("energy"));
        FLUID_TANK.readFromNBT(pTag);
        OUTPUT_FLUID_TANK.readFromNBT(pTag.getCompound("outputFluidType"));
    }


    public void tick(Level level, BlockPos pPos, BlockState pState) {
        fillEnergy();  //<------Place Holder for getting energy through wires etc...
        fillFluid();  //<-------Also a placeholder.

        
        if (isOutputSlotEmptyOrReceivable() && hasRecipe()) {
            level.setBlockAndUpdate(pPos, getBlockState().setValue(WORKING, true));
            increaseCraftingProcess();
            extractEnergy();
            setChanged(level, pPos, pState);

            if (hasProgressFinished()) {
                craftItem();
                extractFluid();
                resetProgress();
            }
        } else {
            resetProgress();
            level.setBlockAndUpdate(pPos, getBlockState().setValue(WORKING, false));
        }
    }

    private void extractFluid() {
        this.FLUID_TANK.drain(neededFluidStack.getAmount(), IFluidHandler.FluidAction.EXECUTE);
    }



    private void fillFluid() {
        if(hasFluidSourceInSlot(FLUID_SLOT)) {
            transferitemFluidToTank(FLUID_SLOT);
        }
    }



    private void transferitemFluidToTank(int fluidSlot) {
        this.itemHandler.getStackInSlot(fluidSlot).getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).ifPresent(iFluidHandlerItem -> {
            int drainAmount = Math.min(this.FLUID_TANK.getSpace(), 1000);

            FluidStack stack = iFluidHandlerItem.drain(drainAmount, IFluidHandler.FluidAction.SIMULATE);
            if(stack.getFluid().is(ModTags.Fluids.REFINERY_INPUT)) {
                stack = iFluidHandlerItem.drain(drainAmount, IFluidHandler.FluidAction.EXECUTE);
                fillTankWithWater(stack, iFluidHandlerItem.getContainer());
            }
        });
    }



    private void fillTankWithWater(FluidStack stack, @NotNull ItemStack container) {
        if(this.FLUID_TANK.isEmpty() || this.FLUID_TANK.getFluid().isFluidEqual(stack)){
        this.FLUID_TANK.fill(new FluidStack(stack.getFluid(), stack.getAmount()), IFluidHandler.FluidAction.EXECUTE);

        this.itemHandler.extractItem(FLUID_SLOT, 1, false);
        this.itemHandler.insertItem(FLUID_SLOT, container, false);
        }
    }

    private void fillTankWithOutput(FluidStack stack) {
        if(this.OUTPUT_FLUID_TANK.isEmpty() || this.OUTPUT_FLUID_TANK.getFluid().isFluidEqual(stack)){
            this.OUTPUT_FLUID_TANK.fill(new FluidStack(stack.getFluid(), stack.getAmount()), IFluidHandler.FluidAction.EXECUTE);

        }
    }


    private boolean hasFluidSourceInSlot(int fluidSlot) {
        return this.itemHandler.getStackInSlot(fluidSlot).getCount() > 0 &&
                this.itemHandler.getStackInSlot(fluidSlot).getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).isPresent();
    }

    private void extractEnergy() {
        this.ENERGY_STORAGE.extractEnergy(energyAmount, false);

    }

    private void fillEnergy() {
        if(hasEnergyItemInSlot(POWER_SLOT) && ENERGY_STORAGE.getEnergyStored() < ENERGY_STORAGE.getMaxEnergyStored() - 4000 ) {
            for(int i = 0; i < 40; i++) {
                this.ENERGY_STORAGE.receiveEnergy(100, false);
            }
            consumeFuel();


        }
    }

    private void consumeFuel(){
        this.itemHandler.getStackInSlot(POWER_SLOT).shrink(1);
    }

    private boolean hasEnergyItemInSlot(int powerSlot) {
        return !this.itemHandler.getStackInSlot(powerSlot).isEmpty() &&
                this.itemHandler.getStackInSlot(powerSlot).getItem() == Items.REDSTONE;
    }


    private void craftItem() {
        Optional<VitriciumRefineryRecipe> recipe = getCurrentRecipe();
        ItemStack resultItem = recipe.get().getResultItem(getLevel().registryAccess());
        FluidStack resultFluid = recipe.get().getOutputFluidStack();

        this.itemHandler.extractItem(INPUT_SLOT, 1, false);
        fillTankWithOutput(resultFluid);
    }



    private void resetProgress() {
        this.progress = 0;
    }

    private boolean hasProgressFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProcess() {
        this.progress++;
    }


    private boolean hasRecipe() {
        Optional<VitriciumRefineryRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()){
            return false;
        }
        maxProgress = recipe.get().getCraftTime() / 4;

        energyAmount = recipe.get().getEnergyAmount();
        neededFluidStack = recipe.get().getFluidStack();
        outputFluidStack = recipe.get().getOutputFluidStack();


        ItemStack resultItem = recipe.get().getResultItem(getLevel().registryAccess());

        return canInsertAmountIntoOutputSlot()
                && canInsertItemIntoOutputSlot(outputFluidStack) &&
                hasEnoughEnergyToCraft() && isCorrectRecipeFluid() && hasEnoughFluidToCraft();
    }

    private boolean isCorrectRecipeFluid(){
        FluidStack fluidStack = FLUID_TANK.getFluid();
        Optional<VitriciumRefineryRecipe> recipe = getCurrentRecipe();
        FluidStack requiredFluid = recipe.get().getFluidStack();

        return fluidStack.containsFluid(requiredFluid);

    }

    private boolean hasEnoughFluidToCraft() {
        return this.FLUID_TANK.getFluidAmount() >= neededFluidStack.getAmount();
    }

    private boolean hasEnoughEnergyToCraft() {
        return this.ENERGY_STORAGE.getEnergyStored() >= energyAmount * maxProgress;
    }

    private Optional<VitriciumRefineryRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
        for(int i = 0; i < this.itemHandler.getSlots(); i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        return this.level.getRecipeManager().getRecipeFor(VitriciumRefineryRecipe.Type.INSTANCE, inventory, level);
    }


    private boolean canInsertItemIntoOutputSlot(@NotNull FluidStack fluid) {
        return this.OUTPUT_FLUID_TANK.isEmpty() || this.OUTPUT_FLUID_TANK.isFluidValid(2, fluid)
                || this.OUTPUT_FLUID_TANK.getFluid() == outputFluidStack;
    }

    private boolean canInsertAmountIntoOutputSlot() {
        return outputFluidStack.getAmount() <=
                this.OUTPUT_FLUID_TANK.getSpace();
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.OUTPUT_FLUID_TANK.isEmpty() ||
                outputFluidStack.getAmount() <= this.OUTPUT_FLUID_TANK.getSpace();
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        super.onDataPacket(net, pkt);
    }


}
