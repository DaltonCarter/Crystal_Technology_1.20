package com.CartersDev.crystechmod.block.entity.powermatricies;

import com.CartersDev.crystechmod.block.custom.machines.CrystalCoreMatrixBlock;
import com.CartersDev.crystechmod.block.custom.machines.PowerMatrixBlock;
import com.CartersDev.crystechmod.block.entity.ModBlockEntities;
import com.CartersDev.crystechmod.recipe.CrystalCoreMatrixRecipe;
import com.CartersDev.crystechmod.screen.CrystalCoreMatrix.crystalCoreMatrixMenu.CrystalCoreMatrixMenu;
import com.CartersDev.crystechmod.util.CoreCrystals;
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
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CrystalCoreMatrixBlockEntity extends BlockEntity implements MenuProvider {
    private static final int INPUT_SLOT = 0;
    private static final int CHARGE_SLOT = 1;
    private static final int STOCKPILE_SLOT = 2;

    private int durabilityRemaining = 0;
    private int durability = 0;
    private int generationRate = 0;
    private boolean isPerfectedCrystal = false;
    private String currentCrystal = "";

    protected final ContainerData data;

    ItemStackHandler itemHandler = new ItemStackHandler(3) {
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
                case 0, 2 -> isRecipeIngredientOrMaster(stack);
                case 1 -> stack.getCapability(ForgeCapabilities.ENERGY).isPresent();
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private ModEnergyStorage createEnergyStorage() {
        return new ModEnergyStorage(4000000, 20000) {
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
                    new InventoryDirectionEntry(Direction.DOWN, STOCKPILE_SLOT, false),
                    new InventoryDirectionEntry(Direction.UP, STOCKPILE_SLOT, true),
                    new InventoryDirectionEntry(Direction.NORTH, STOCKPILE_SLOT, true),
                    new InventoryDirectionEntry(Direction.SOUTH, STOCKPILE_SLOT, false),
                    new InventoryDirectionEntry(Direction.EAST, STOCKPILE_SLOT, false),
                    new InventoryDirectionEntry(Direction.WEST, STOCKPILE_SLOT, true)).directionsMap;

    public CrystalCoreMatrixBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.CRYSTAL_CORE_MATRIX_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> ENERGY_STORAGE.getEnergyStored();
                    case 1 -> ENERGY_STORAGE.getMaxEnergyStored();
                    case 2 -> durabilityRemaining;
                    case 3 -> durability;
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

    private boolean isRecipeIngredientOrMaster(ItemStack stack) {
        if (level == null || stack.isEmpty()) return false;

        if (ForgeRegistries.ITEMS.getKey(stack.getItem()).getPath().contains("stable_red_core_crystal")) {
            return true;
        }

        List<CrystalCoreMatrixRecipe> allRecipes = level.getRecipeManager().getAllRecipesFor(CrystalCoreMatrixRecipe.Type.INSTANCE);

        for (CrystalCoreMatrixRecipe recipe : allRecipes) {
            if (recipe.getCoreCrystal().get(0).test(stack)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Crystal Core Matrix");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new CrystalCoreMatrixMenu(pContainerId, pPlayerInventory, this, this.data);
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
                Direction localDirection = this.getBlockState().getValue(CrystalCoreMatrixBlock.FACING);

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
        this.lazyItemHandler.invalidate();
        this.lazyEnergyHandler.invalidate();
        this.directioWrappedHandlerMap.values().forEach(LazyOptional::invalidate);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("energy", ENERGY_STORAGE.getEnergyStored());
        pTag.putInt("durabilityRemaining", durabilityRemaining);
        pTag.putInt("totalDurability", durability);
        pTag.putInt("rate", generationRate);
        pTag.putBoolean("infinity_mode", isPerfectedCrystal);
        pTag.putString("current_crystal", this.currentCrystal);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        ENERGY_STORAGE.setEnergy(pTag.getInt("energy"));
        durabilityRemaining = pTag.getInt("durabilityRemaining");
        durability = pTag.getInt("totalDurability");
        generationRate = pTag.getInt("rate");
        isPerfectedCrystal = pTag.getBoolean("infinity_mode");
        currentCrystal = pTag.getString("current_crystal");
    }


    public void tick(Level level, BlockPos pPos, BlockState pState) {

        if (level.getGameTime() < 10) return;

        if (level.isClientSide()) return;

        manageStockpile();
        chargeItem();
        distributeEnergy();

        if (!isPerfectedCrystal && durabilityRemaining <= 0) {
            nextCrystal();
        }

        if (isPerfectedCrystal) {
            ItemStack activeSlot = itemHandler.getStackInSlot(INPUT_SLOT);
            if (!activeSlot.isEmpty() && ForgeRegistries.ITEMS.getKey(activeSlot.getItem()).getPath().contains("stable_red_core_crystal")) {

                durabilityRemaining = 2;
                durability = 100;
                generationRate = 4000;

                if (ENERGY_STORAGE.getEnergyStored() + generationRate <= ENERGY_STORAGE.getMaxEnergyStored()) {
                    ENERGY_STORAGE.modify(generationRate);
                    level.sendBlockUpdated(pPos, pState, pState, 3);
                }
                setChanged();
            } else {
                isPerfectedCrystal = false;
                durabilityRemaining = 0;
                durability = 0;
                generationRate = 0;
                setChanged();
            }
        } else if (durabilityRemaining > 0) {

            if (ENERGY_STORAGE.getEnergyStored() + generationRate <= ENERGY_STORAGE.getMaxEnergyStored()) {
                durabilityRemaining--;
                ENERGY_STORAGE.modify(generationRate);
                level.sendBlockUpdated(pPos, pState, pState, 3);
            }
            setChanged();
        }
        CoreCrystals targetEnumState = getCurrentCrystal();
        BlockState liveState = level.getBlockState(pPos);

        if (liveState.hasProperty(CrystalCoreMatrixBlock.CORE_CRYSTAL)
                && liveState.getValue(CrystalCoreMatrixBlock.CORE_CRYSTAL) != targetEnumState) {

            BlockState updatedState = liveState.setValue(CrystalCoreMatrixBlock.CORE_CRYSTAL, targetEnumState);
            level.setBlock(pPos, updatedState, 3);
            level.sendBlockUpdated(pPos, liveState, updatedState, 3);
            setChanged();
        }
    }

    private void manageStockpile() {
        ItemStack activeStack = this.itemHandler.getStackInSlot(INPUT_SLOT);
        ItemStack stockpileStack = this.itemHandler.getStackInSlot(STOCKPILE_SLOT);

        if (activeStack.isEmpty() && !stockpileStack.isEmpty()) {

            ItemStack singleCrystal = this.itemHandler.extractItem(STOCKPILE_SLOT, 1, true);

            if (!singleCrystal.isEmpty()) {

                ItemStack remainder = this.itemHandler.insertItem(INPUT_SLOT, singleCrystal, false);

                if (remainder.isEmpty()) {
                    this.itemHandler.extractItem(STOCKPILE_SLOT, 1, false);
                    setChanged();
                }
            }
        }
    }

    private void nextCrystal() {
        if (level == null || this.durabilityRemaining > 0) return;

        ItemStack crystal = this.itemHandler.getStackInSlot(INPUT_SLOT);
        if (crystal.isEmpty()) return;

        String itemPath = ForgeRegistries.ITEMS.getKey(crystal.getItem()).getPath();


        if (itemPath.contains("stable_red_core_crystal")) {
            this.isPerfectedCrystal = true;
            this.durabilityRemaining = 2;
            this.durability = 100;
            this.generationRate = 4000;
            setChanged();
            return;
        }

        List<CrystalCoreMatrixRecipe> allRecipes = level.getRecipeManager()
                .getAllRecipesFor(CrystalCoreMatrixRecipe.Type.INSTANCE);

        for (CrystalCoreMatrixRecipe recipe : allRecipes) {
            if (recipe.getCoreCrystal().get(0).test(crystal)) {

                int tickFE = recipe.getEnergyAmount() / recipe.getCoreDurability();

                this.durabilityRemaining = recipe.getCoreDurability();
                this.durability = recipe.getCoreDurability();
                this.generationRate = tickFE;
                this.isPerfectedCrystal = false;
                this.currentCrystal = ForgeRegistries.ITEMS.getKey(crystal.getItem()).getPath();
                this.itemHandler.extractItem(INPUT_SLOT, 1, false);

                setChanged();
                return;
            }
        }
    }

    private CoreCrystals getCurrentCrystal() {
        ItemStack stack = this.itemHandler.getStackInSlot(INPUT_SLOT);

        if (!stack.isEmpty() && ForgeRegistries.ITEMS.getKey(stack.getItem()).getPath().contains("stable_red_core_crystal")) {
            return CoreCrystals.PERFECTED;
        }
        if (durabilityRemaining > 0 && !currentCrystal.isEmpty()) {

            if (currentCrystal.contains("green_core_crystal")) return CoreCrystals.GREEN;
            if (currentCrystal.contains("blue_core_crystal")) return CoreCrystals.BLUE;
            if (currentCrystal.contains("yellow_core_crystal")) return CoreCrystals.YELLOW;
            if (currentCrystal.contains("orange_core_crystal")) return CoreCrystals.ORANGE;
            if (currentCrystal.contains("red_core_crystal")) return CoreCrystals.RED;
            if (currentCrystal.contains("purple_core_crystal")) return CoreCrystals.PURPLE;
            if (currentCrystal.contains("stable_red_core_crystal")) return CoreCrystals.PERFECTED;
        }
        return CoreCrystals.NONE;
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
