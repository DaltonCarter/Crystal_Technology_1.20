package com.CartersDev.crystechmod.block.entity.macerator;


import com.CartersDev.crystechmod.block.custom.TiberiumMaceratorBlock;
import com.CartersDev.crystechmod.block.entity.ModBlockEntities;
import com.CartersDev.crystechmod.recipe.TiberiumMaceratorRecipe;
import com.CartersDev.crystechmod.screen.maceratorMenu.CrystalCoreTiberiumMaceratorMenu;
import com.CartersDev.crystechmod.screen.maceratorMenu.TiberiumMaceratorMenu;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

import static com.CartersDev.crystechmod.block.custom.TiberiumMaceratorBlock.WORKING;


public class CrystalCoreTiberiumMaceratorBlockEntity extends BlockEntity implements MenuProvider {

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
              case 0 -> stack.is(ModTags.Items.GRINDABLE);
              case 1 -> stack.getItem() == Items.REDSTONE;
              case 2 -> stack.is(ModTags.Items.GRINDING_RESULT);
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private static final int INPUT_SLOT = 0;
    private static final int ENERGY_ITEM_SLOT = 1;
    private static final int OUTPUT_SLOT = 2;


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

protected final ContainerData data;
private int progress = 0;
private int max_progress = 100;
private final int default_max_progress = 100;

private int energyAmount = 0;
private final int defaultEnergyAmount = 100;

private final ModEnergyStorage ENERGY_STORAGE = createEnergyStorage();


    private ModEnergyStorage createEnergyStorage() {
        return new ModEnergyStorage(360000, 10000) {
            @Override
            public void onEnergyChanged() {
                setChanged();
                getLevel().sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        };
    }

    public ItemStack getRenderStack() {
        ItemStack stack = itemHandler.getStackInSlot(OUTPUT_SLOT);

        if(stack.isEmpty()) {
            stack = itemHandler.getStackInSlot(INPUT_SLOT);
        }
        return stack;
    }

    public CrystalCoreTiberiumMaceratorBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.CRYSTAL_CORE_TIBERIUM_MACERATOR_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex){
                    case 0 -> CrystalCoreTiberiumMaceratorBlockEntity.this.progress;
                    case 1 -> CrystalCoreTiberiumMaceratorBlockEntity.this.max_progress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                 switch (pIndex){
                    case 0 -> CrystalCoreTiberiumMaceratorBlockEntity.this.progress = pValue;
                    case 1 -> CrystalCoreTiberiumMaceratorBlockEntity.this.max_progress = pValue;
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
        return Component.literal("Vitricium Macerator");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new CrystalCoreTiberiumMaceratorMenu(pContainerId, pPlayerInventory, this, this.data);
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
                Direction localDirection = this.getBlockState().getValue(TiberiumMaceratorBlock.FACING);

                if (side == Direction.DOWN || side == Direction.UP) {
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
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        lazyEnergyHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("tiberium_macerator.progress", progress);
        pTag.putInt("tiberium_macerator.max_progress", max_progress);
        pTag.putInt("tiberium_macerator.energyAmount", energyAmount);
        pTag.putInt("energy", ENERGY_STORAGE.getEnergyStored());
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("tiberium_macerator.progress");
        max_progress = pTag.getInt("tiberium_macerator.max_progress");
        energyAmount = pTag.getInt("tiberium_macerator.energyAmount");
        ENERGY_STORAGE.setEnergy(pTag.getInt("energy"));
    }

    public void tick(Level level, BlockPos pPos, BlockState pState) {
        fillEnergy();

        if (isOutputSlotEmptyorRecieveable() && hasRecipe()){
            level.setBlockAndUpdate(pPos, getBlockState().setValue(WORKING, true));
            increaseCraftingProcess();
            extractEnergy();
            setChanged(level, pPos, pState);

            if (hasProgressFinished()) {
                craftItem();
                resetProgress();
            }
            
        }else {
            resetProgress();
            level.setBlockAndUpdate(pPos, getBlockState().setValue(WORKING, false));
        }

    }

    private void extractEnergy() {
        this.ENERGY_STORAGE.extractEnergy(energyAmount, false);

    }

    private void fillEnergy() {
        if(hasEnergyItemInSlot(ENERGY_ITEM_SLOT) && ENERGY_STORAGE.getEnergyStored() < ENERGY_STORAGE.getMaxEnergyStored() - 4000 ) {
            for(int i = 0; i < 40; i++) {
                this.ENERGY_STORAGE.receiveEnergy(100, false);
            }
            consumeFuel();


        }
    }

    private void consumeFuel(){
        this.itemHandler.getStackInSlot(ENERGY_ITEM_SLOT).shrink(1);
    }

    private boolean hasEnergyItemInSlot(int powerSlot) {
        return !this.itemHandler.getStackInSlot(powerSlot).isEmpty() &&
                this.itemHandler.getStackInSlot(powerSlot).getItem() == Items.REDSTONE;
    }

    private void craftItem() {
        Optional<TiberiumMaceratorRecipe> recipe = getCurrentRecipe();

        ItemStack resultItem = recipe.get().getResultItem(getLevel().registryAccess());

        this.itemHandler.extractItem(INPUT_SLOT, 1, false);

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(resultItem.getItem(),
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + resultItem.getCount() + 3));

    }


    private void resetProgress() {
        this.progress = 0;
    }



    private boolean hasProgressFinished() {
        return this.progress >= this.max_progress;
    }

    private void increaseCraftingProcess() {
        this.progress++;
    }

    private boolean hasRecipe() {

        Optional<TiberiumMaceratorRecipe> recipe = getCurrentRecipe();


        if (recipe.isEmpty()) {
            return false;
        }

        max_progress = recipe.get().getCraftTime() / 4;
        energyAmount = recipe.get().getEnergyAmount();

        ItemStack resultItem = recipe.get().getResultItem(getLevel().registryAccess());

        return canInsertAmountIntoOutputSlot(resultItem.getCount())
                && canInsertItemIntoOutputSlot(resultItem.getItem())
                && hasEnoughEnergyToCraft();
    }

    private boolean hasEnoughEnergyToCraft() {
        return this.ENERGY_STORAGE.getEnergyStored() >= energyAmount * max_progress;

    }

    private Optional<TiberiumMaceratorRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
        for(int i = 0; i < this.itemHandler.getSlots(); i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }
        return this.level.getRecipeManager().getRecipeFor(TiberiumMaceratorRecipe.Type.INSTANCE, inventory, level);
    }


    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize() >=
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count + 3;
    }

    private boolean isOutputSlotEmptyorRecieveable() {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() ||
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
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
