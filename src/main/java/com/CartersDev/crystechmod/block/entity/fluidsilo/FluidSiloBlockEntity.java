package com.CartersDev.crystechmod.block.entity.fluidsilo;

import com.CartersDev.crystechmod.block.custom.machines.FluidSiloBlock;
import com.CartersDev.crystechmod.block.entity.ModBlockEntities;
import com.CartersDev.crystechmod.screen.FluidSilo.fluidSiloMenu.FluidSiloMenu;
import com.CartersDev.crystechmod.util.ModBlockstateProperties;
import com.CartersDev.crystechmod.util.ModTags;
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

public class FluidSiloBlockEntity extends BlockEntity implements MenuProvider {

    public static final ModelProperty<FluidStack> RENDER_FLUID = new ModelProperty<>();

    private final ItemStackHandler itemHandler = new ItemStackHandler(3) {

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
                case 2 -> true;
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private static final int FLUID_INTAKE_SLOT = 0;
    private static final int FLUID_OUTPUT_SLOT = 1;
    private static final int RETURN_SLOT = 2;
    private final FluidTank FLUID_TANK;
    private final int machineCoreLvl;
    private final int capacity;
    protected final ContainerData data;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private LazyOptional<IFluidHandler> lazyFluidHandler = LazyOptional.empty();

    private final Map<Direction, LazyOptional<WrappedHandler>> directioWrappedHandlerMap =
            new InventoryDirectionWrapper(itemHandler,
                    new InventoryDirectionEntry(Direction.DOWN, RETURN_SLOT, false),
                    new InventoryDirectionEntry(Direction.UP, FLUID_INTAKE_SLOT, true),
                    new InventoryDirectionEntry(Direction.NORTH, FLUID_INTAKE_SLOT, true),
                    new InventoryDirectionEntry(Direction.SOUTH, RETURN_SLOT, false),
                    new InventoryDirectionEntry(Direction.EAST, RETURN_SLOT, false),
                    new InventoryDirectionEntry(Direction.WEST, FLUID_OUTPUT_SLOT, true)).directionsMap;


    public FluidSiloBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.FLUID_SILO_BE.get(), pPos, pBlockState);

        this.machineCoreLvl = pBlockState.getValue(MACHINE_CORE_LVL);

        this.capacity = switch (machineCoreLvl) {
            case 1 -> 16000;
            case 2 -> 32000;
            case 3 -> 64000;
            case 4 -> 128000;
            default -> 16000;
        };

        FLUID_TANK = createFluidTank(capacity);

        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch(pIndex){
                    case 0 -> FluidSiloBlockEntity.this.FLUID_TANK.getFluidAmount();
                    case 1 -> FluidSiloBlockEntity.this.FLUID_TANK.getCapacity();
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

    private FluidTank createFluidTank(int capacity) {

        return new FluidTank(capacity) {

            @Override
            protected void onContentsChanged() {
                setChanged();
                if(!level.isClientSide()) {
                    level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                    requestModelDataUpdate();
                }
            }

            @Override
            public boolean isFluidValid(FluidStack stack) {
                return true;
            }
        };
    }

    public FluidStack getFluid() {
        return FLUID_TANK.getFluid();
    }

    public void tick(Level level, BlockPos pPos, BlockState pState) {
        if (level.isClientSide()) {
            return;
        }

        fillFluidTank();
        fillFluidItem();

    }


    private void fillFluidTank() {
        if(hasFluidSourceInSlot(FLUID_INTAKE_SLOT)) {
            transferitemFluidToTank(FLUID_INTAKE_SLOT);
        }
    }

    private void transferitemFluidToTank(int fluidSlot) {
        this.getCapability(ForgeCapabilities.FLUID_HANDLER, null).ifPresent(siloFluidHandler -> {

            this.itemHandler.getStackInSlot(fluidSlot).getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).ifPresent(iFluidHandlerItem -> {

                int tankSpace = siloFluidHandler.getTankCapacity(0) - siloFluidHandler.getFluidInTank(0).getAmount();
                int drainAmount = Math.min(tankSpace, 1000);
                if (drainAmount <= 0) return;

                FluidStack stack = iFluidHandlerItem.drain(drainAmount, IFluidHandler.FluidAction.SIMULATE);
                if (!stack.isEmpty()) {

                    int acceptedBySilo = siloFluidHandler.fill(stack, IFluidHandler.FluidAction.SIMULATE);

                    if (acceptedBySilo > 0) {

                        stack = iFluidHandlerItem.drain(acceptedBySilo, IFluidHandler.FluidAction.EXECUTE);

                        fillTankWithFluid(stack, iFluidHandlerItem);
                    }
                }
            });
        });
    }

    private void fillTankWithFluid(FluidStack stack, @NotNull IFluidHandlerItem fluidItem) {
        if(this.FLUID_TANK.isEmpty() || this.FLUID_TANK.getFluid().isFluidEqual(stack)){
            this.FLUID_TANK.fill(new FluidStack(stack.getFluid(), stack.getAmount()), IFluidHandler.FluidAction.EXECUTE);

            FluidStack container = fluidItem.getFluidInTank(0);

            if (container.isEmpty() || container.getAmount() <= 0) {
                this.itemHandler.extractItem(FLUID_INTAKE_SLOT, 1, false);
                containerOutput(fluidItem.getContainer());
            }
        }
    }

    private boolean hasFluidSourceInSlot(int fluidSlot) {
        return this.itemHandler.getStackInSlot(fluidSlot).getCount() > 0 &&
                this.itemHandler.getStackInSlot(fluidSlot).getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).isPresent();
    }

    private void fillFluidItem() {
        if (hasFluidSourceInSlot(FLUID_OUTPUT_SLOT) && !this.FLUID_TANK.isEmpty()) {
            transferTankFluidToItem(FLUID_OUTPUT_SLOT);
        }
    }

    private void transferTankFluidToItem(int fluidSlot) {
        this.itemHandler.getStackInSlot(fluidSlot).getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).ifPresent(iFluidHandlerItem -> {
            int containerCapacity = iFluidHandlerItem.getTankCapacity(0);
            int currentFluidInItem = iFluidHandlerItem.getFluidInTank(0).getAmount();
            int containerSpace = containerCapacity - currentFluidInItem;

            int fillAmount = Math.min(Math.min(this.FLUID_TANK.getFluidAmount(), containerSpace), 1000);

            if (fillAmount <= 0) {
                if (currentFluidInItem > 0 && this.FLUID_TANK.isEmpty()) {
                    this.itemHandler.extractItem(FLUID_OUTPUT_SLOT, 1, false);
                    containerOutput(iFluidHandlerItem.getContainer());
                    setChanged();
                }
                return;
            }

            FluidStack textFluid = new FluidStack(this.FLUID_TANK.getFluid().getFluid(), fillAmount);
            int accepted = iFluidHandlerItem.fill(textFluid, IFluidHandler.FluidAction.EXECUTE);

            if (accepted > 0) {
                this.FLUID_TANK.drain(accepted, IFluidHandler.FluidAction.EXECUTE);
                setChanged();

                int postFluidAmountInItem = iFluidHandlerItem.getFluidInTank(0).getAmount();

                if (postFluidAmountInItem >= containerCapacity || this.FLUID_TANK.isEmpty()) {
                    this.itemHandler.extractItem(FLUID_OUTPUT_SLOT, 1, false);
                    containerOutput(iFluidHandlerItem.getContainer());
                }
            }
        });
    }

    private void containerOutput(ItemStack vessel) {
        if (vessel.isEmpty()) return;
        ItemStack output = this.itemHandler.insertItem(RETURN_SLOT, vessel, false);

        if (!output.isEmpty() && this.level != null) {
            Containers.dropItemStack(this.level,
                    this.worldPosition.getX() + 0.5, this.worldPosition.getY() + 0.5, this.worldPosition.getZ() + 0.5,
                    output);
        }
    }


    public ItemStackHandler getItemHandler() {
        return this.itemHandler;
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Fluid Silo");
    }

    @Override
    public @NotNull ModelData getModelData() {
        return ModelData.builder().with(RENDER_FLUID, this.FLUID_TANK.getFluid()).build();
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new FluidSiloMenu(pContainerId, pPlayerInventory, this, this.data, this.machineCoreLvl);
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
        lazyFluidHandler.invalidate();
        directioWrappedHandlerMap.values().forEach(LazyOptional::invalidate);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("Inventory", itemHandler.serializeNBT());
        CompoundTag tank = new CompoundTag();
        FLUID_TANK.writeToNBT(tank);
        pTag.put("SiloTank", tank);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("Inventory"));
        FLUID_TANK.readFromNBT(pTag.getCompound("SiloTank"));

    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {

        if(cap == ForgeCapabilities.FLUID_HANDLER){
            return lazyFluidHandler.cast();
        }

        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            if(side == null) {
                return lazyItemHandler.cast();
            }

            if(directioWrappedHandlerMap.containsKey(side)){
                Direction localDirection = this.getBlockState().getValue(FluidSiloBlock.FACING);

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
