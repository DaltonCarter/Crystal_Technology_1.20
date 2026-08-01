package com.CartersDev.crystechmod.block.entity.powermatricies;


import com.CartersDev.crystechmod.block.custom.machines.PowerMatrixBlock;
import com.CartersDev.crystechmod.block.custom.machines.ProtocultureMatrixBlock;
import com.CartersDev.crystechmod.block.entity.ModBlockEntities;
import com.CartersDev.crystechmod.screen.ProtocultureMatrix.protocultureMatrixMenu.ProtocultureMatrixMenu;
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
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


import java.util.Map;

public class ProtocultureMatrixBlockEntity extends BlockEntity implements MenuProvider {
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    private static final int CHARGING_SLOT = 2;
    private static final int STOCKPILE_SLOT = 3;


    private static final int GENERATION_RATE = 800;
    private int burnTimeRemaining = 0;
    private final int defaultBurnTime = 2500;
    protected final ContainerData data;

    ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }

        @Override
        public int getSlotLimit(int slot) {

            if (slot == INPUT_SLOT) return 1;
            return super.getSlotLimit(slot);
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case 0, 3 -> stack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).isPresent();
                case 1 -> true;
                case 2 -> stack.getCapability(ForgeCapabilities.ENERGY).isPresent();
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private ModEnergyStorage createEnergyStorage() {
        return new ModEnergyStorage(4000000, 5000) {
            @Override
            public void onEnergyChanged() {
                setChanged();
                getLevel().sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        };
    }


    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();

    private final ModEnergyStorage ENERGY_STORAGE = createEnergyStorage();

    private final Map<Direction, LazyOptional<WrappedHandler>> directioWrappedHandlerMap =
            new InventoryDirectionWrapper(itemHandler,
                    new InventoryDirectionEntry(Direction.DOWN, OUTPUT_SLOT, false),
                    new InventoryDirectionEntry(Direction.UP, STOCKPILE_SLOT, true),
                    new InventoryDirectionEntry(Direction.NORTH, STOCKPILE_SLOT, true),
                    new InventoryDirectionEntry(Direction.SOUTH, OUTPUT_SLOT, false),
                    new InventoryDirectionEntry(Direction.EAST, OUTPUT_SLOT, false),
                    new InventoryDirectionEntry(Direction.WEST, STOCKPILE_SLOT, true)).directionsMap;

    public ProtocultureMatrixBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.PROTOCULTURE_MATRIX_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> ENERGY_STORAGE.getEnergyStored();
                    case 1 -> ENERGY_STORAGE.getMaxEnergyStored();
                    case 2 -> burnTimeRemaining;
                    case 3 -> defaultBurnTime;
                    default -> 0;
                };
            }
            @Override public void set(int pIndex, int pValue) {}
            @Override public int getCount() { return 4; }
        };
    }

    public IEnergyStorage getEnergyStorage() {
        return this.ENERGY_STORAGE;
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
        return Component.literal("Protoculture Matrix");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new ProtocultureMatrixMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        this.lazyItemHandler = LazyOptional.of(() -> this.itemHandler);
        this.lazyEnergyHandler = LazyOptional.of(() -> this.ENERGY_STORAGE);

        if (this.level != null && !this.level.isClientSide()) {
            for (Direction direction : Direction.values()) {
                this.level.neighborChanged(this.worldPosition.relative(direction), this.getBlockState().getBlock(), this.worldPosition);
            }
        }
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.lazyItemHandler.invalidate();
        this.lazyEnergyHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("energy", ENERGY_STORAGE.getEnergyStored());
        pTag.putInt("burn", burnTimeRemaining);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        ENERGY_STORAGE.setEnergy(pTag.getInt("energy"));
        burnTimeRemaining = pTag.getInt("burn");
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {

        if (cap == ForgeCapabilities.ENERGY) {
            return lazyEnergyHandler.cast();
        }

        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            if (side == null) {
                return lazyItemHandler.cast();
            }

            if (directioWrappedHandlerMap.containsKey(side)) {
                Direction localDirection = this.getBlockState().getValue(ProtocultureMatrixBlock.FACING);

                if (side == Direction.DOWN || side == Direction.UP) {
                    return directioWrappedHandlerMap.get(side).cast();
                }

                return switch (localDirection) {
                    case EAST -> directioWrappedHandlerMap.get(side.getClockWise()).cast();
                    case SOUTH -> directioWrappedHandlerMap.get(side).cast();
                    case WEST -> directioWrappedHandlerMap.get(side.getCounterClockWise()).cast();
                    default -> directioWrappedHandlerMap.get(side.getOpposite()).cast();
                };

            }
        }
        return super.getCapability(cap, side);
    }


    public void tick(Level level, BlockPos pPos, BlockState pState) {
        if (level.isClientSide()) return;

        manageStockpile();

        swallowFluidFromCanister();
        chargeItem();
        distributeEnergy();

        if (burnTimeRemaining > 0) {

            if (ENERGY_STORAGE.getEnergyStored() + defaultBurnTime <= ENERGY_STORAGE.getMaxEnergyStored()) {
                burnTimeRemaining--;
                ENERGY_STORAGE.modify(GENERATION_RATE);
                level.sendBlockUpdated(pPos, pState, pState, 3);
            }
            setChanged();
        }

        boolean hasCanisterPresent = !itemHandler.getStackInSlot(INPUT_SLOT).isEmpty() || burnTimeRemaining > 0;

        if (pState.hasProperty(ProtocultureMatrixBlock.HAS_CANISTER)
                && pState.getValue(ProtocultureMatrixBlock.HAS_CANISTER) != hasCanisterPresent) {
            level.setBlock(pPos, pState.setValue(ProtocultureMatrixBlock.HAS_CANISTER, hasCanisterPresent), 3);
        }
    }

    private void manageStockpile() {
        ItemStack activeStack = this.itemHandler.getStackInSlot(INPUT_SLOT);
        ItemStack stockpileStack = this.itemHandler.getStackInSlot(STOCKPILE_SLOT);

        if (activeStack.isEmpty() && !stockpileStack.isEmpty()) {

            ItemStack singleCanister = this.itemHandler.extractItem(STOCKPILE_SLOT, 1, true);

            if (!singleCanister.isEmpty()) {

                ItemStack remainder = this.itemHandler.insertItem(INPUT_SLOT, singleCanister, false);

                if (remainder.isEmpty()) {
                    this.itemHandler.extractItem(STOCKPILE_SLOT, 1, false);
                    setChanged();
                }
            }
        }
    }

    private void swallowFluidFromCanister() {

        if (this.burnTimeRemaining > 0) {
            return;
        }

        ItemStack canister = this.itemHandler.getStackInSlot(INPUT_SLOT);
        if (canister.isEmpty()) return;

        canister.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).ifPresent(itemFluid -> {
            FluidStack contained = itemFluid.getFluidInTank(0);

            if (contained.isEmpty()) return;
            String fluidKey = net.minecraftforge.registries.ForgeRegistries.FLUIDS.getKey(contained.getFluid()).toString();

            if (!fluidKey.contains("crystechmod:liquid_protoculture_source")) {
                return;
            }

            if (contained.getAmount() >= 1000) {

                FluidStack drainedAmount = itemFluid.drain(1000, IFluidHandler.FluidAction.EXECUTE);

                if (!drainedAmount.isEmpty() && drainedAmount.getAmount() == 1000) {

                    this.burnTimeRemaining = 2500;
                    setChanged();

                    FluidStack checkRemaining = itemFluid.getFluidInTank(0);
                    if (checkRemaining.isEmpty() || checkRemaining.getAmount() <= 0) {
                        ItemStack emptyCanister = itemFluid.getContainer();

                        if (this.itemHandler.insertItem(OUTPUT_SLOT, emptyCanister, false).isEmpty()) {
                            this.itemHandler.extractItem(INPUT_SLOT, 1, false);
                        } else {
                            if (this.level != null) {
                                Containers.dropItemStack(level,
                                        worldPosition.getX() + 0.5, worldPosition.getY() + 0.5, worldPosition.getZ() + 0.5,
                                        emptyCanister);
                            }
                            this.itemHandler.extractItem(INPUT_SLOT, 1, false);
                        }
                    }
                }
            }
        });
    }

    private void chargeItem() {
        ItemStack powerCell = this.itemHandler.getStackInSlot(CHARGING_SLOT);

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

                if(neighborBE.getBlockState().getBlock() instanceof PowerMatrixBlock){
                    continue;
                }

                neighborBE.getCapability(ForgeCapabilities.ENERGY, direction.getOpposite()).ifPresent(neighborEnergy -> {
                    if (neighborEnergy.canReceive()) {
                        int maxOutput = Math.min(ENERGY_STORAGE.getEnergyStored(), 1000);

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
