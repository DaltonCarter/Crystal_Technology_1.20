package com.CartersDev.crystechmod.block.entity.infuser;

import com.CartersDev.crystechmod.block.custom.TiberiumInfuserBlock;
import com.CartersDev.crystechmod.block.entity.ModBlockEntities;
import com.CartersDev.crystechmod.recipe.TiberiumInfuserRecipe;
import com.CartersDev.crystechmod.screen.infuserMenu.TiberiumInfuserMenu;
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
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

import static com.CartersDev.crystechmod.block.custom.TiberiumInfuserBlock.WORKING;


/* For Multiple inputs:
You need to make a List<Ingredient> instead of just an Ingredient. The modification should be similar to the thing
we did in the ModArmorItem class. You change it to a NonNullList<Ingredient> and modify the serializeRecipeData method
as such:

            for (int i = 0; i < ingredients.size(); i++) {
                jsonarray.add(ingredients.get(i).toJson());
            }

Don't forget to change the type from Ingredient to NonNullList<Ingredient> in all the relevant places such as
constructors and whatnot and there you go. Should be everything :)


Well, you will need to change quite a few things in the class. Instead of it only saving one Ingredient, you probably
want to save all three, so just make three Ingredient fields (make sure they all have unique names of course!).
This needs to be done in the RecipeBuilder as well as the static Result class. You then want to add two more
ItemLike to both constructors to assign those new ingredient fields.
Then you want to simply output all the ingredients in the serializeRecipeData method. Basically just adding all
three of them to the jsonarray, so instead of just having
jsonarray.add(ingredient.toJson());

you'd call this once for each ingredient! In theory that should be it

*/


public class TiberiumInfuserBlockEntity extends BlockEntity implements MenuProvider {

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
                case 0 -> true;
                case 1 -> stack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).isPresent();
                case 2 -> false;
                case 3 -> stack.getItem() == Items.REDSTONE;
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private static final int INPUT_SLOT = 0;
    private static final int FLUID_SLOT = 1;
    private static final int OUTPUT_SLOT = 2;
    private static final int POWER_SLOT = 3;

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

    private int energyAmount = 0;
    private final int DEFAULT_ENERGY_AMOUNT = 100;

    private FluidStack neededFluidStack = FluidStack.EMPTY;

private final ModEnergyStorage ENERGY_STORAGE = createEnergyStorage();
private final FluidTank FLUID_TANK = createFluidTank();


    private FluidTank createFluidTank() {
        return new FluidTank(8000) {

            @Override
            protected void onContentsChanged() {
                setChanged();
                if(!level.isClientSide()) {
                    level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                }
            }

            @Override
            public boolean isFluidValid(FluidStack stack) {
                return stack.getFluid().is(ModTags.Fluids.INFUSER_FLUIDS);
            }
        };

    }

    private ModEnergyStorage createEnergyStorage() {
        return new ModEnergyStorage(90000, 1000) {
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


    public TiberiumInfuserBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.TIBERIUM_INFUSER_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch(pIndex){
                    case 0 -> TiberiumInfuserBlockEntity.this.progress;
                    case 1 -> TiberiumInfuserBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch(pIndex){
                    case 0 -> TiberiumInfuserBlockEntity.this.progress = pValue;
                    case 1 -> TiberiumInfuserBlockEntity.this.maxProgress = pValue;
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

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Tiberium Infuser");
    }


    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new TiberiumInfuserMenu(pContainerId, pPlayerInventory, this, this.data);

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
        pTag.putInt("tiberium_infuser.progress", progress);
        pTag.putInt("tiberium_infuser.max_progress", maxProgress);
        pTag.putInt("tiberium_infuser.energy_amount", energyAmount);

        neededFluidStack.writeToNBT(pTag);

        pTag.putInt("energy", ENERGY_STORAGE.getEnergyStored());
        pTag = FLUID_TANK.writeToNBT(pTag);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("tiberium_infuser.progress");
        maxProgress = pTag.getInt("tiberium_infuser.max_progress");
        energyAmount = pTag.getInt("tiberium_infuser.energy_amount");
        neededFluidStack = FluidStack.loadFluidStackFromNBT(pTag);
        ENERGY_STORAGE.setEnergy(pTag.getInt("energy"));
        FLUID_TANK.readFromNBT(pTag);
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
            if(stack.getFluid().is(ModTags.Fluids.INFUSER_FLUIDS)) {
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
        Optional<TiberiumInfuserRecipe> recipe = getCurrentRecipe();
        ItemStack resultItem = recipe.get().getResultItem(getLevel().registryAccess());

        this.itemHandler.extractItem(INPUT_SLOT, 1, false);
        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(resultItem.getItem(),
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + resultItem.getCount()));
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
        Optional<TiberiumInfuserRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()){
            return false;
        }
        maxProgress = recipe.get().getCraftTime();

        energyAmount = recipe.get().getEnergyAmount();
        neededFluidStack = recipe.get().getFluidStack();


        ItemStack resultItem = recipe.get().getResultItem(getLevel().registryAccess());

        return canInsertAmountIntoOutputSlot(resultItem.getCount())
                && canInsertItemIntoOutputSlot(resultItem.getItem()) &&
                hasEnoughEnergyToCraft() && isCorrectRecipeFluid() && hasEnoughFluidToCraft();
    }

    private boolean isCorrectRecipeFluid(){
        FluidStack fluidStack = FLUID_TANK.getFluid();
        Optional<TiberiumInfuserRecipe> recipe = getCurrentRecipe();
        FluidStack requiredFluid = recipe.get().getFluidStack();

        return fluidStack.containsFluid(requiredFluid);

    }

    private boolean hasEnoughFluidToCraft() {
        return this.FLUID_TANK.getFluidAmount() >= neededFluidStack.getAmount();
    }

    private boolean hasEnoughEnergyToCraft() {
        return this.ENERGY_STORAGE.getEnergyStored() >= energyAmount * maxProgress;
    }

    private Optional<TiberiumInfuserRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
        for(int i = 0; i < this.itemHandler.getSlots(); i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        return this.level.getRecipeManager().getRecipeFor(TiberiumInfuserRecipe.Type.INSTANCE, inventory, level);
    }


    private boolean canInsertItemIntoOutputSlot(@NotNull Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize() >=
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count;
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() ||
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT)
                        .getMaxStackSize();
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
