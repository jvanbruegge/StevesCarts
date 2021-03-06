package vswe.stevescarts.containers.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import reborncore.common.util.FluidUtils;
import vswe.stevescarts.helpers.storages.SCTank;

import javax.annotation.Nonnull;

public class SlotLiquidInput extends SlotBase {
	private SCTank tank;
	private int maxsize;

	public SlotLiquidInput(final IInventory iinventory, final SCTank tank, final int maxsize, final int i, final int j, final int k) {
		super(iinventory, i, j, k);
		this.tank = tank;
		this.maxsize = maxsize;
	}

	@Override
	public int getSlotStackLimit() {
		if (maxsize != -1) {
			return maxsize;
		}
		return Math.min(8, tank.getCapacity() / 1000);
	}

	@Override
	public boolean isItemValid(
		@Nonnull
			ItemStack itemstack) {
		return (FluidUtils.getFluidStackInContainer(itemstack) != null && tank.getFluid() != null) || (FluidUtils.getFluidStackInContainer(itemstack) != null && (tank.getFluid() == null || tank.getFluid().isFluidEqual(FluidUtils.getFluidStackInContainer(itemstack))));
	}
}
