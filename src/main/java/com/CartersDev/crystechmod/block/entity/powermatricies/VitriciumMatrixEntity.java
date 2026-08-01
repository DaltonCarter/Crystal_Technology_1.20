package com.CartersDev.crystechmod.block.entity.powermatricies;

import com.CartersDev.crystechmod.block.custom.machines.PowerMatrixBlock;
import com.CartersDev.crystechmod.block.custom.machines.TiberiumInfuserBlock;
import com.CartersDev.crystechmod.block.custom.machines.VitriciumMatrixBlock;
import com.CartersDev.crystechmod.block.entity.ModBlockEntities;
import com.CartersDev.crystechmod.fluid.ModFluids;
import com.CartersDev.crystechmod.recipe.VitriciumMatrixRecipe;
import com.CartersDev.crystechmod.screen.VitriciumMatrix.vitriciumMatrixMenu.VitriciumMatrixMenu;
import com.CartersDev.crystechmod.util.ModEnergyStorage;
import com.CartersDev.crystechmod.util.ModTags;
import com.CartersDev.crystechmod.util.VitriciumMatrixFluids;
import com.CartersDev.crystechmod.util.WrappedHandler;
import com.CartersDev.crystechmod.util.inventory.InventoryDirectionEntry;
import com.CartersDev.crystechmod.util.inventory.InventoryDirectionWrapper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
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

import static com.CartersDev.crystechmod.block.custom.machines.PowerMatrixBlock.WORKING;

public class VitriciumMatrixEntity extends BlockEntity implements MenuProvider {

    private VitriciumMatrixRecipe cachedRecipe = null;
    private Fluid lastCheckedFluid = null;

    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case 0 -> stack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).isPresent();
                case 1 -> true;
                case 2 -> stack.getCapability(ForgeCapabilities.ENERGY).isPresent();
                default -> super.isItemValid(slot, stack);
            };
        }
    };


    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    private static final int CHARGE_SLOT = 2;


    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();


    private final Map<Direction, LazyOptional<WrappedHandler>> directioWrappedHandlerMap =
            new InventoryDirectionWrapper(itemHandler,
                    new InventoryDirectionEntry(Direction.DOWN, OUTPUT_SLOT, false),
                    new InventoryDirectionEntry(Direction.UP, INPUT_SLOT, true),
                    new InventoryDirectionEntry(Direction.NORTH, INPUT_SLOT, true),
                    new InventoryDirectionEntry(Direction.SOUTH, OUTPUT_SLOT, false),
                    new InventoryDirectionEntry(Direction.EAST, OUTPUT_SLOT, false),
                    new InventoryDirectionEntry(Direction.WEST, INPUT_SLOT, true)).directionsMap;

    private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();
    private LazyOptional<IFluidHandler> lazyFluidHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 0;
    private final int DEFAULT_MAX_PROGRESS = 100;

    private int stateCooldown = 0;

    private FluidStack neededFluidStack = FluidStack.EMPTY;

    private final ModEnergyStorage ENERGY_STORAGE = createEnergyStorage();
    private final FluidTank FLUID_TANK = createFluidTank();


    private FluidTank createFluidTank() {
        return new FluidTank(16000) {
            @Override
            protected void onContentsChanged() {
                setChanged();

            }

            @Override
            public boolean isFluidValid(FluidStack stack) {
                return stack.getFluid().is(ModTags.Fluids.INFUSER_FLUIDS);
            }
        };
    }

    private ModEnergyStorage createEnergyStorage() {
        return new ModEnergyStorage(200000, 2000) {
            @Override
            public void onEnergyChanged() {
                setChanged();
            }
        };
    }



    public VitriciumMatrixEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.VITRICIUM_MATRIX_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch(pIndex){
                    case 0 -> VitriciumMatrixEntity.this.progress;
                    case 1 -> VitriciumMatrixEntity.this.maxProgress;
                    case 2 -> VitriciumMatrixEntity.this.ENERGY_STORAGE.getEnergyStored();
                    case 3 -> VitriciumMatrixEntity.this.ENERGY_STORAGE.getMaxEnergyStored();
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch(pIndex){
                    case 0 -> VitriciumMatrixEntity.this.progress = pValue;
                    case 1 -> VitriciumMatrixEntity.this.maxProgress = pValue;
                    case 2 -> VitriciumMatrixEntity.this.ENERGY_STORAGE.setEnergy(pValue);
                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
    }

    public IEnergyStorage getEnergyStorage() {
        return this.ENERGY_STORAGE;
    }

    public FluidStack getFluid() {
        return FLUID_TANK.getFluid();
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
        return Component.literal("Vitricium Matrix");
    }


    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new VitriciumMatrixMenu(pContainerId, pPlayerInventory, this, this.data);

    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {

        if(cap == ForgeCapabilities.ENERGY){
            return lazyEnergyHandler.cast();
        }

        if(cap == ForgeCapabilities.FLUID_HANDLER){
            return lazyFluidHandler.cast();
        }

        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            if(side == null) {
                return lazyItemHandler.cast();
            }

            if(directioWrappedHandlerMap.containsKey(side)){
                Direction localDirection = this.getBlockState().getValue(TiberiumInfuserBlock.FACING);

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

        if (this.level != null && !this.level.isClientSide()) {
            for (Direction direction : Direction.values()) {
                BlockPos neighborPos = this.worldPosition.relative(direction);


                this.level.neighborChanged(neighborPos, this.getBlockState().getBlock(), this.worldPosition);
            }
        }
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        lazyEnergyHandler.invalidate();
        lazyFluidHandler.invalidate();

    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("vitricium_matrix.progress", progress);
        pTag.putInt("vitricium_matrix.max_progress", maxProgress);
        pTag.putInt("energy", ENERGY_STORAGE.getEnergyStored());

        if (this.cachedRecipe != null) {
            pTag.putString("CurrentRecipe", this.cachedRecipe.getId().toString());
        }

        CompoundTag fluidStackTag = new CompoundTag();
        neededFluidStack.writeToNBT(fluidStackTag);
        pTag.put("needed_fluid", fluidStackTag);


        CompoundTag tankTag = new CompoundTag();
        FLUID_TANK.writeToNBT(tankTag);
        pTag.put("fluid_tank", tankTag);

        super.saveAdditional(pTag);
    }

    private ResourceLocation recipeToLoad = null;

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("vitricium_matrix.progress");
        maxProgress = pTag.getInt("vitricium_matrix.max_progress");
        ENERGY_STORAGE.setEnergy(pTag.getInt("energy"));

        if (pTag.contains("CurrentRecipe")) {
            this.recipeToLoad = new ResourceLocation(pTag.getString("CurrentRecipe"));
        }

        if (pTag.contains("needed_fluid")) {
            neededFluidStack = FluidStack.loadFluidStackFromNBT(pTag.getCompound("needed_fluid"));
        }
        if (pTag.contains("fluid_tank")) {
            FLUID_TANK.readFromNBT(pTag.getCompound("fluid_tank"));
        }
    }



    public void tick(Level level, BlockPos pPos, BlockState pState) {

        if (recipeToLoad != null && level != null) {
            level.getRecipeManager().byKey(recipeToLoad).ifPresent(recipe -> {
                if (recipe instanceof VitriciumMatrixRecipe matrixRecipe) {
                    cachedRecipe = matrixRecipe;
                    lastCheckedFluid = matrixRecipe.getFluidStack().getFluid();
                }
            });
            recipeToLoad = null;
        }

        disperseEnergy();
        fillFluid();
        chargeItem();

        int originalFluidAmount = this.FLUID_TANK.getFluidAmount();

        if (this.FLUID_TANK.getFluidAmount() > originalFluidAmount && this.progress == 0) {
            setChanged(level, pPos, pState);
            level.sendBlockUpdated(pPos, pState, pState, 3);
            return;
        }

        if (level != null && !level.isClientSide) {
            updateFluidBlockState(pState);
        }

        if (cachedRecipe != null && !hasProgressFinished()) {
            int totalEnergy = cachedRecipe.getEnergyAmount();
            int energyPerTick = totalEnergy / maxProgress;

                if (ENERGY_STORAGE.getEnergyStored() + energyPerTick <= ENERGY_STORAGE.getMaxEnergyStored()) {
                    stateCooldown = 20;

                    if (!pState.getValue(WORKING)) {
                        BlockState currentState = pState;
                        if (currentState.hasProperty(WORKING) && !currentState.getValue(WORKING)) {
                            level.setBlock(pPos, currentState.setValue(WORKING, true), 3);
                        }
                    }
                    increaseCraftingProcess();

                    ENERGY_STORAGE.modify(energyPerTick);
                    setChanged(level, pPos, pState);
                    level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);

                    if (hasProgressFinished()) {
                        resetProgress();
                        maxProgress = 0;
                        cachedRecipe = null;
                        lastCheckedFluid = null;
                        handleWorkingStateShutdown(level, pPos, pState);
                    }
                }

        } else if (hasRecipe() && !isEnergyStorageFull()) {
            Optional<VitriciumMatrixRecipe> recipe = Optional.ofNullable(cachedRecipe);

            if (recipe.isPresent()) {
                VitriciumMatrixRecipe currentRecipe = recipe.get();

                FLUID_TANK.drain(currentRecipe.getFluidStack().getAmount(), IFluidHandler.FluidAction.EXECUTE);
                maxProgress = currentRecipe.getCraftTime();
                progress = 0;
                stateCooldown = 20;
                setChanged(level, pPos, pState);
                level.sendBlockUpdated(getBlockPos(), getBlockState(),getBlockState(), 3);
            }
        }else {
            handleWorkingStateShutdown(level, pPos, pState);
        }
    }

    private void handleWorkingStateShutdown(Level level, BlockPos pPos, BlockState pState) {
        if (pState.getValue(WORKING)) {

            if (this.stateCooldown > 0) {
                this.stateCooldown--;
            } else {
                resetProgress();
                BlockState liveState = level.getBlockState(pPos);
                if (liveState.hasProperty(WORKING) && liveState.getValue(WORKING)) {
                    resetProgress();
                    level.setBlock(pPos, liveState.setValue(WORKING, false), 3);
                }
            }
        }
    }

    private void updateFluidBlockState(BlockState state) {

        if (state.hasProperty(VitriciumMatrixBlock.FUEL)) {
            VitriciumMatrixFluids nextState = VitriciumMatrixFluids.EMPTY.EMPTY;
            Fluid fluidType = this.FLUID_TANK.getFluid().getFluid();

            if (!this.FLUID_TANK.isEmpty()) {
                if (fluidType == ModFluids.SOURCE_MOLTEN_TIBERIUM.get()) nextState = VitriciumMatrixFluids.VIRIDE;
                else if (fluidType == ModFluids.SOURCE_MOLTEN_BLUE_TIBERIUM.get()) nextState = VitriciumMatrixFluids.CAERULEUM;
                else if (fluidType == ModFluids.SOURCE_MOLTEN_RED_TIBERIUM.get()) nextState = VitriciumMatrixFluids.SANGUINEUM;
                else if (fluidType == ModFluids.SOURCE_MOLTEN_PURPLE_TIBERIUM.get()) nextState = VitriciumMatrixFluids.VIOLACEUM;
            }

            if (state.getValue(VitriciumMatrixBlock.FUEL) != nextState) {
                this.level.setBlock(this.worldPosition, state.setValue(VitriciumMatrixBlock.FUEL, nextState), 2);
            }
        }
    }


    private void fillFluid() {
        if (hasFluidSourceInSlot(INPUT_SLOT)) {
            transferitemFluidToTank(INPUT_SLOT);
        }
    }

    private void transferitemFluidToTank(int fluidSlot) {
        this.itemHandler.getStackInSlot(fluidSlot).getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).ifPresent(iFluidHandlerItem -> {
            int drainAmount = Math.min(this.FLUID_TANK.getSpace(), iFluidHandlerItem.getFluidInTank(0).getAmount());

            FluidStack stack = iFluidHandlerItem.drain(drainAmount, IFluidHandler.FluidAction.SIMULATE);
            if(stack.getFluid().is(ModTags.Fluids.INFUSER_FLUIDS)) {
                stack = iFluidHandlerItem.drain(drainAmount, IFluidHandler.FluidAction.EXECUTE);
                fillTankWithWater(stack, iFluidHandlerItem.getContainer());
            }
        });
    }

    private void fillTankWithWater(FluidStack stack, @NotNull ItemStack container) {
        if (this.FLUID_TANK.isEmpty() || this.FLUID_TANK.getFluid().isFluidEqual(stack)) {
            this.FLUID_TANK.fill(new FluidStack(stack.getFluid(), stack.getAmount()), IFluidHandler.FluidAction.EXECUTE);

            this.itemHandler.extractItem(INPUT_SLOT, 1, false);

            if (!container.isEmpty()) {
                ItemStack outputSlotStack = this.itemHandler.getStackInSlot(OUTPUT_SLOT);

                if (outputSlotStack.isEmpty()) {
                    this.itemHandler.insertItem(OUTPUT_SLOT, container, false);
                }

                else if (ItemStack.isSameItemSameTags(outputSlotStack, container)) {
                    outputSlotStack.grow(container.getCount());
                }

                else {
                    ItemStack remainder = this.itemHandler.insertItem(OUTPUT_SLOT, container, false);
                    if (!remainder.isEmpty()) {
                        Containers.dropItemStack(this.level, this.worldPosition.getX(), this.worldPosition.getY(), this.worldPosition.getZ(), remainder);
                    }
                }
            }
            setChanged();
        }
    }

    private boolean hasFluidSourceInSlot(int fluidSlot) {
        return !this.itemHandler.getStackInSlot(fluidSlot).isEmpty() &&
                this.itemHandler.getStackInSlot(fluidSlot).getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).isPresent();
    }

    private void chargeItem() {
        ItemStack powerCell = itemHandler.getStackInSlot(CHARGE_SLOT);
        if(powerCell.isEmpty()) {
            return;
        }

        powerCell.getCapability(ForgeCapabilities.ENERGY).ifPresent(cellEnergy -> {
            if (cellEnergy.canReceive()) {
                int storedEnergy = ENERGY_STORAGE.getEnergyStored();
                if (storedEnergy > 0) {
                    int maxEnergyItemCanAccept = cellEnergy.receiveEnergy(storedEnergy, true);
                    if (maxEnergyItemCanAccept > 0) {
                        cellEnergy.receiveEnergy(maxEnergyItemCanAccept, false);
                        ENERGY_STORAGE.modify(-maxEnergyItemCanAccept);
                        setChanged();
                    }
                }
            }
        });
    }

    private void disperseEnergy() {
        int maxPushRate = 2000;

        if (this.ENERGY_STORAGE.getEnergyStored() > 0) {
            for (Direction direction : Direction.values()) {
                BlockEntity adjacentMachine = level.getBlockEntity(worldPosition.relative(direction));
                if (adjacentMachine != null) {
                    if(adjacentMachine.getBlockState().getBlock() instanceof PowerMatrixBlock){
                        continue;
                    }
                    adjacentMachine.getCapability(ForgeCapabilities.ENERGY, direction.getOpposite()).ifPresent(neighborStorage -> {
                        if (neighborStorage.canReceive()) {
                            int maxTransfer = Math.min( maxPushRate, ENERGY_STORAGE.getEnergyStored());
                            int acceptedByNeighbor = neighborStorage.receiveEnergy(maxTransfer, true);

                             if (acceptedByNeighbor > 0) {
                                 neighborStorage.receiveEnergy(acceptedByNeighbor, false);
                                 ENERGY_STORAGE.modify(-acceptedByNeighbor);
                                 setChanged();
                                 level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                             }
                        }
                    });
                }
                if (ENERGY_STORAGE.getEnergyStored() <= 0) {
                    break;
                }
            }
        }
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
        Optional<VitriciumMatrixRecipe> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) {
            return false;
        }

        VitriciumMatrixRecipe activeRecipe = recipe.get();

        maxProgress = activeRecipe.getCraftTime();
        neededFluidStack = activeRecipe.getFluidStack();
        int energyPerTick = activeRecipe.getEnergyAmount() / Math.max(1, activeRecipe.getCraftTime());

        return canInsertAmountIntoEnergyStorage(energyPerTick) && hasEnoughFluidToCraft();
    }

    private boolean hasEnoughFluidToCraft() {
        return !this.FLUID_TANK.isEmpty() && neededFluidStack != null && this.FLUID_TANK.getFluidAmount() >= neededFluidStack.getAmount();
    }

    private Optional<VitriciumMatrixRecipe> getCurrentRecipe() {
        if (this.level == null) {
            return Optional.empty();
        }

        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
        for(int i = 0; i < this.itemHandler.getSlots(); i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        FluidStack tankFluid = this.FLUID_TANK.getFluid();

        if (tankFluid.isEmpty()) {
            this.cachedRecipe = null;
            this.lastCheckedFluid = null;
            return Optional.empty();
        }

        if (this.cachedRecipe != null && tankFluid.getFluid() == this.lastCheckedFluid) {
            return Optional.of(this.cachedRecipe);
        }

        Optional<VitriciumMatrixRecipe> matched = this.level.getRecipeManager().getAllRecipesFor(VitriciumMatrixRecipe.Type.INSTANCE)
                .stream()
                .map(recipe -> (VitriciumMatrixRecipe) recipe)
                .filter(recipe -> recipe.matches(inventory, level) && tankFluid.getFluid() == recipe.getFluidStack().getFluid())
                .findFirst();

        if (matched.isPresent()) {
            this.cachedRecipe = matched.get();
            this.lastCheckedFluid = tankFluid.getFluid();
        } else {
            this.cachedRecipe = null;
            this.lastCheckedFluid = null;
        }

        return matched;
    }

    private boolean canInsertAmountIntoEnergyStorage(int amount) {
        return this.ENERGY_STORAGE.getEnergyStored() + amount <= this.ENERGY_STORAGE.getMaxEnergyStored();
    }

    private boolean isEnergyStorageFull() {

        return this.ENERGY_STORAGE.getEnergyStored() == this.ENERGY_STORAGE.getMaxEnergyStored();
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