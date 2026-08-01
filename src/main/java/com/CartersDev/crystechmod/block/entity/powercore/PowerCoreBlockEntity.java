package com.CartersDev.crystechmod.block.entity.powercore;

import com.CartersDev.crystechmod.block.custom.machines.FluidSiloBlock;
import com.CartersDev.crystechmod.block.custom.machines.PowerCoreBlock;
import com.CartersDev.crystechmod.block.custom.machines.PowerMatrixBlock;
import com.CartersDev.crystechmod.block.entity.ModBlockEntities;
import com.CartersDev.crystechmod.screen.FluidSilo.fluidSiloMenu.FluidSiloMenu;
import com.CartersDev.crystechmod.screen.PowerCore.powerCoreMenu.PowerCoreMenu;
import com.CartersDev.crystechmod.util.ModEnergyStorage;
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
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.client.model.data.ModelProperty;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

import static com.CartersDev.crystechmod.block.custom.machines.FluidSiloBlock.MACHINE_CORE_LVL;
import static com.CartersDev.crystechmod.block.custom.machines.PowerCoreBlock.HAS_CHARGE;

public class PowerCoreBlockEntity extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemHandler = new ItemStackHandler(2) {

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
                case 0 -> stack.getCapability(ForgeCapabilities.ENERGY).isPresent();
                case 1 -> true;
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private static final int INTAKE_SLOT = 0;
    private static final int CHARGE_SLOT = 1;

    private final ModEnergyStorage ENERGY_STORAGE;

    private final int machineCoreLvl;
    private final int capacity;
    private final int maxTransfer;
    protected final ContainerData data;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();

    private final Map<Direction, LazyOptional<WrappedHandler>> directioWrappedHandlerMap =
            new InventoryDirectionWrapper(itemHandler,
                    new InventoryDirectionEntry(Direction.DOWN, CHARGE_SLOT, true),
                    new InventoryDirectionEntry(Direction.UP, INTAKE_SLOT, true),
                    new InventoryDirectionEntry(Direction.NORTH, INTAKE_SLOT, true),
                    new InventoryDirectionEntry(Direction.SOUTH, CHARGE_SLOT, true),
                    new InventoryDirectionEntry(Direction.EAST, INTAKE_SLOT, true),
                    new InventoryDirectionEntry(Direction.WEST, CHARGE_SLOT, true)).directionsMap;



    public PowerCoreBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.POWER_CORE_BE.get(), pPos, pBlockState);

        this.machineCoreLvl = pBlockState.getValue(MACHINE_CORE_LVL);

        this.capacity = switch (machineCoreLvl) {
            case 1 -> 1000000;
            case 2 -> 5000000;
            case 3 -> 10000000;
            case 4 -> 50000000;
            default -> 1000000;
        };

        this.maxTransfer = switch (machineCoreLvl) {
            case 1 -> 2000;
            case 2 -> 5000;
            case 3 -> 10000;
            case 4 -> 20000;
            default -> 2000;
        };

        ENERGY_STORAGE = createEnergyStorage(capacity);


        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch(pIndex){
                    case 0 -> ENERGY_STORAGE.getEnergyStored();
                    case 1 -> ENERGY_STORAGE.getMaxEnergyStored();
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {}

            @Override
            public int getCount() {
                return 2;
            }
        };

    }


    private ModEnergyStorage createEnergyStorage(int capacity) {
        return new ModEnergyStorage(capacity, maxTransfer) {
            @Override
            public void onEnergyChanged() {
                setChanged();
                getLevel().sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        };
    }


    public void tick(Level level, BlockPos pPos, BlockState pState) {
        if (level.isClientSide()) {
            return;
        }

        extractEnergy();
        chargeItem();
        distributeEnergy();

        boolean hasCharge = ENERGY_STORAGE.getEnergyStored() > 0;

        if (pState.getValue(HAS_CHARGE) != hasCharge) {
            level.setBlock(pPos, pState.setValue(HAS_CHARGE, hasCharge),3);
        }

    }




    public ItemStackHandler getItemHandler() {
        return this.itemHandler;
    }
    public IEnergyStorage getEnergyStorage() {
        return this.ENERGY_STORAGE;
    }

    private void chargeItem() {
        ItemStack powerCell = this.itemHandler.getStackInSlot(CHARGE_SLOT);

        if (powerCell.isEmpty()) {
            return;
        }

        powerCell.getCapability(ForgeCapabilities.ENERGY).ifPresent(cellEnergy -> {
            if (cellEnergy.canReceive()) {
                int currentMatrixEnergy = this.ENERGY_STORAGE.getEnergyStored();
                if (currentMatrixEnergy > 0) {
                    int acceptedEnergy = cellEnergy.receiveEnergy(currentMatrixEnergy, true);
                    int extractableFromBlock = this.ENERGY_STORAGE.extractEnergy(acceptedEnergy, true);
                    if (extractableFromBlock > 0) {
                        cellEnergy.receiveEnergy(extractableFromBlock, false);
                        ENERGY_STORAGE.modify(-extractableFromBlock);
                        level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
                    }
                }
            }
        });
    }

    private void extractEnergy() {
        ItemStack powerCell = this.itemHandler.getStackInSlot(INTAKE_SLOT);

        if (powerCell.isEmpty()) {
            return;
        }

        powerCell.getCapability(ForgeCapabilities.ENERGY).ifPresent(cellEnergy -> {
            if (cellEnergy.canExtract()) {
                int coreSpace = this.ENERGY_STORAGE.getMaxEnergyStored() - this.ENERGY_STORAGE.getEnergyStored();
                if (coreSpace > 0) {
                    int simulatedExtract = cellEnergy.extractEnergy(Math.min(coreSpace, maxTransfer), true);
                    if (simulatedExtract > 0) {
                        int extractedAmount = cellEnergy.extractEnergy(simulatedExtract, false);
                        this.ENERGY_STORAGE.modify(extractedAmount);
                        if (this.level != null) {
                            this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
                        }
                    }
                }
            }
        });
    }

    private void distributeEnergy() {
        int energyAvaliable = ENERGY_STORAGE.getEnergyStored();

        if (energyAvaliable <= 0) {
            return;
        }

        for (Direction direction : Direction.values()) {
            if (level == null) {
                continue;
            }

            BlockPos neighborPos = this.worldPosition.relative(direction);
            BlockEntity neighborBE = level.getBlockEntity(neighborPos);

            if (neighborBE != null) {

                if(neighborBE.getBlockState().getBlock() instanceof PowerMatrixBlock || neighborBE.getBlockState().getBlock() instanceof PowerCoreBlock){
                    continue;
                }

                neighborBE.getCapability(ForgeCapabilities.ENERGY, direction.getOpposite()).ifPresent(neighborEnergy -> {
                    if (neighborEnergy.canReceive()) {
                        int maxOutput = Math.min(ENERGY_STORAGE.getEnergyStored(), maxTransfer);

                        if (maxOutput > 0) {
                            int accepted = neighborEnergy.receiveEnergy(maxOutput, true);
                            int extractable = ENERGY_STORAGE.extractEnergy(accepted, true);

                            if (extractable > 0) {
                                neighborEnergy.receiveEnergy(extractable, false);
                                ENERGY_STORAGE.modify(-extractable);

                                setChanged();
                                level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
                            }
                        }
                    }
                });
            }

            if (ENERGY_STORAGE.getEnergyStored() <= 0) {
                break;
            }
        }
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Power Core");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new PowerCoreMenu(pContainerId, pPlayerInventory, this, this.data, this.machineCoreLvl);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public void onLoad() {
        super.onLoad();

        lazyItemHandler = LazyOptional.of(() -> itemHandler);
        lazyEnergyHandler = LazyOptional.of(() -> ENERGY_STORAGE);

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
        directioWrappedHandlerMap.values().forEach(LazyOptional::invalidate);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        CompoundTag tank = new CompoundTag();
        pTag.putInt("energy", ENERGY_STORAGE.getEnergyStored());
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        ENERGY_STORAGE.setEnergy(pTag.getInt("energy"));
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {

        if (cap == ForgeCapabilities.ENERGY) {
            return lazyEnergyHandler.cast();
        }

        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            if(side == null) {
                return lazyItemHandler.cast();
            }

            if(directioWrappedHandlerMap.containsKey(side)){
                Direction localDirection = this.getBlockState().getValue(PowerCoreBlock.FACING);

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
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        saveAdditional(tag);
        return tag;
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        super.onDataPacket(net, pkt);
    }

}
