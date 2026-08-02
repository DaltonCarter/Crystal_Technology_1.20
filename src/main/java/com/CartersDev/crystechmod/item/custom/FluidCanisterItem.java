package com.CartersDev.crystechmod.item.custom;

import com.CartersDev.crystechmod.fluid.ModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fluids.capability.templates.FluidHandlerItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FluidCanisterItem extends Item {

    private final int capacity;

    public FluidCanisterItem(Properties pProperties, int capacity) {
        super(pProperties.stacksTo(64));
        this.capacity = capacity;
    }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new FluidFilterHandler(stack, this.capacity);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);

        BlockHitResult hitResult = getPlayerPOVHitResult(pLevel, pPlayer, ClipContext.Fluid.SOURCE_ONLY);

        if(hitResult.getType() == HitResult.Type.MISS || pLevel.isClientSide) {
            return InteractionResultHolder.pass(stack);
        }

        BlockPos pos = hitResult.getBlockPos();
        BlockState state = pLevel.getBlockState(pos);

        return FluidUtil.getFluidHandler(stack).map(handler -> {
            FluidStack currentFluid = handler.getFluidInTank(0);
            if(currentFluid.isEmpty()) {
                if(state.getBlock() instanceof BucketPickup pickup){
                    FluidStack simulation = new FluidStack(state.getFluidState().getType(), 1000);

                    int amount = handler.fill(simulation, IFluidHandler.FluidAction.SIMULATE);

                    if(amount == 1000) {
                        ItemStack target = pickup.pickupBlock(pLevel, pos, state);

                        if(!target.isEmpty()) {
                            handler.fill(simulation, IFluidHandler.FluidAction.EXECUTE);
                            return InteractionResultHolder.sidedSuccess(stack, pLevel.isClientSide());
                        }
                    }
                }
            } else {
                BlockPos targetPos = pos.relative(hitResult.getDirection());
                BlockState targetBlock = pLevel.getBlockState(targetPos);

                if(targetBlock.getBlock() instanceof LiquidBlockContainer container){
                    if(container.canPlaceLiquid(pLevel, targetPos, targetBlock, currentFluid.getFluid())) {
                        int drained = handler.drain(1000, IFluidHandler.FluidAction.SIMULATE).getAmount();
                        if(drained == 1000) {
                            container.placeLiquid(pLevel, targetPos, targetBlock, currentFluid.getFluid().defaultFluidState());
                            handler.drain(1000, IFluidHandler.FluidAction.EXECUTE);
                            return InteractionResultHolder.sidedSuccess(stack, pLevel.isClientSide());
                        }
                    }
                }
            }
            return InteractionResultHolder.pass(stack);
        }).orElse(InteractionResultHolder.pass(stack));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        FluidUtil.getFluidHandler(pStack).ifPresent(handler -> {
            FluidStack fluid = handler.getFluidInTank(0);
            if(fluid.isEmpty()) {
                pTooltipComponents.add(Component.literal("§7Empty / " + this.capacity + " mB"));
            }else {
                String fluidName = fluid.getDisplayName().getString();
                pTooltipComponents.add(Component.literal("§9" + fluidName + ": §7" + fluid.getAmount() + " / " + this.capacity + " mB"));
            }
        });

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public static ItemStack getFilledVariant(Item item, Fluid fluid, int amount) {
        ItemStack itemStack = new ItemStack(item);

        LazyOptional<IFluidHandlerItem> cap =
              itemStack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM);
        cap.ifPresent(handler -> {
            handler.fill(new FluidStack(fluid, amount), IFluidHandler.FluidAction.EXECUTE);
        });
        return itemStack;
    }

}

class FluidFilterHandler extends FluidHandlerItemStack {

    public FluidFilterHandler(ItemStack container, int capacity) {
        super(container, capacity);
    }

    @Override
    public boolean canFillFluidType(net.minecraftforge.fluids.FluidStack fluidStack) {
        net.minecraft.world.level.material.Fluid fluid = fluidStack.getFluid();

        if (fluid == Fluids.WATER || fluid == Fluids.FLOWING_WATER || fluid == ModFluids.SOURCE_TIBERIUM_WATER.get()
                || fluid == ModFluids.FLOWING_TIBERIUM_WATER.get()) {
            return false;
        }

        return super.canFillFluidType(fluidStack);
    }

    @Override
    public boolean isFluidValid(int tank, @NotNull FluidStack stack) {

        net.minecraft.world.level.material.Fluid fluid = stack.getFluid();

        if (fluid == Fluids.WATER || fluid == Fluids.FLOWING_WATER || fluid == ModFluids.SOURCE_TIBERIUM_WATER.get()
        || fluid == ModFluids.FLOWING_TIBERIUM_WATER.get()) {
            return false;
        }

        return super.isFluidValid(tank, stack);
    }

}


