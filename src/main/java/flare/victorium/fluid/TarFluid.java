package flare.victorium.fluid;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.*;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import flare.victorium.fluid.FluidRegistry.*;

import static flare.victorium.fluid.FluidRegistry.*;

public abstract class TarFluid extends FluidAbstractViscous {
    @Override
    public Fluid getStill() {
        return TAR_FLUID_STILL;
    }

    @Override
    public Fluid getFlowing() {
        return TAR_FLUID_FLOWING;
    }

    @Override
    public Item getBucketItem() {
        return TAR_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        return TAR_FLUID.getDefaultState().with(Properties.LEVEL_15, method_15741(fluidState));
    }


    public static class Flowing extends TarFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }


    }

    public static class Still extends TarFluid
    {
        @Override
        public int getLevel(FluidState fluidState)
        {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }

    public static void registerItems() {

    }
}
