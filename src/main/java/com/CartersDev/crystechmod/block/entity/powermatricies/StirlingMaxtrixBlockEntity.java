package com.CartersDev.crystechmod.block.entity.powermatricies;


import com.CartersDev.crystechmod.block.custom.machines.PowerMatrixBlock;
import com.CartersDev.crystechmod.block.custom.machines.StirlingMatrixBlock;
import com.CartersDev.crystechmod.block.entity.ModBlockEntities;
import com.CartersDev.crystechmod.recipe.StirlingMatrixFuel;
import com.CartersDev.crystechmod.screen.StirlingMatrix.stirlingMatrixMenu.StirlingMatrixMenu;
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
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;

import static com.CartersDev.crystechmod.block.custom.machines.PowerMatrixBlock.WORKING;

public class StirlingMaxtrixBlockEntity extends BlockEntity implements MenuProvider {
    private static final Logger log = LoggerFactory.getLogger(StirlingMaxtrixBlockEntity.class);

    private static final int INPUT_SLOT = 0;
    private static final int CHARGING_SLOT = 1;

    private static final int GENERATION_RATE = 40;

    protected final ContainerData data;
    private int burnTimeRemaining = 0;
    private int maxBurnTime = 0;


    ItemStackHandler itemHandler = new ItemStackHandler(3) {
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
                case 0 -> ForgeHooks.getBurnTime(stack, null) > 0;
                case 1 -> stack.getCapability(ForgeCapabilities.ENERGY).isPresent();
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private ModEnergyStorage createEnergyStorage() {
        return new ModEnergyStorage(100000, 1000) {
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
                    new InventoryDirectionEntry(Direction.DOWN, INPUT_SLOT, false),
                    new InventoryDirectionEntry(Direction.UP, INPUT_SLOT, true),
                    new InventoryDirectionEntry(Direction.NORTH, INPUT_SLOT, true),
                    new InventoryDirectionEntry(Direction.SOUTH, INPUT_SLOT, false),
                    new InventoryDirectionEntry(Direction.EAST, INPUT_SLOT, false),
                    new InventoryDirectionEntry(Direction.WEST, INPUT_SLOT, true)).directionsMap;

    public StirlingMaxtrixBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.STIRLING_MATRIX_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex){
                    case 0 -> StirlingMaxtrixBlockEntity.this.burnTimeRemaining;
                    case 1 -> StirlingMaxtrixBlockEntity.this.maxBurnTime;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex){
                    case 0 -> StirlingMaxtrixBlockEntity.this.burnTimeRemaining = pValue;
                    case 1 -> StirlingMaxtrixBlockEntity.this.maxBurnTime = pValue;
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

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Stirling Matrix");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new StirlingMatrixMenu(pContainerId, pPlayerInventory, this, this.data);
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
                Direction localDirection = this.getBlockState().getValue(StirlingMatrixBlock.FACING);

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

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
        lazyEnergyHandler = LazyOptional.of(() -> ENERGY_STORAGE);
        if (this.level != null && !this.level.isClientSide()) {
            for (Direction direction : Direction.values()) {
                this.level.neighborChanged(this.worldPosition.relative(direction), this.getBlockState().getBlock(), this.worldPosition);
            }
        }

    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        lazyEnergyHandler.invalidate();
        this.directioWrappedHandlerMap.values().forEach(LazyOptional::invalidate);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("coal_matrix.burnTimeRemaining", burnTimeRemaining);
        pTag.putInt("coal_matrix.maxBurnTime", maxBurnTime);
        pTag.putInt("energy", ENERGY_STORAGE.getEnergyStored());
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        burnTimeRemaining = pTag.getInt("coal_matrix.burnTimeRemaining");
        maxBurnTime = pTag.getInt("coal_matrix.maxBurnTime");
        ENERGY_STORAGE.setEnergy(pTag.getInt("energy"));
    }

public void tick(Level plevel, BlockPos pPos, BlockState pState) {

    if (level.getGameTime() < 10) return;

    chargeItem();
    distributeEnergy();

    if(plevel.isClientSide()) {
        return;
    }

    boolean isGenerating = isGenerating();
    boolean stateChanged = false;

    if (burnTimeRemaining > 0) {
        if (ENERGY_STORAGE.getEnergyStored() + GENERATION_RATE <= ENERGY_STORAGE.getMaxEnergyStored()) {

            burnTimeRemaining--;
            ENERGY_STORAGE.modify(GENERATION_RATE);
            setChanged(level, pPos, pState);
            level.sendBlockUpdated(pPos, pState, pState, 3);
            stateChanged = true;
        }
    }

    if (burnTimeRemaining <= 0) {
        ItemStack fuel = itemHandler.getStackInSlot(INPUT_SLOT);
        if (!fuel.isEmpty() && ENERGY_STORAGE.getEnergyStored() + GENERATION_RATE <= ENERGY_STORAGE.getMaxEnergyStored()) {
          SimpleContainer container = new SimpleContainer(1);
          container.setItem(0, fuel);
          Optional<StirlingMatrixFuel> activeRecipe = level.getRecipeManager().getRecipeFor(StirlingMatrixFuel.Type.INSTANCE, container, level);

          if (activeRecipe.isPresent()) {
              StirlingMatrixFuel recipe = activeRecipe.get();

              maxBurnTime = recipe.getBurnTime();
              burnTimeRemaining = recipe.getBurnTime();

              fuel.shrink(1);
              setChanged();
              stateChanged = true;
          }

        }
    }

    if (isGenerating != isGenerating()) {
        stateChanged = true;
        plevel.setBlock(pPos, pState.setValue(WORKING, isGenerating()), 3);
    }

    if (stateChanged) {
        setChanged();
    }
}

    private boolean isGenerating() {
        return this.burnTimeRemaining > 0;
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
        CompoundTag tag = super.getUpdateTag();
        saveAdditional(tag);
        return tag;
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        super.onDataPacket(net, pkt);
        if (this.level != null && this.level.isClientSide) {
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

}
