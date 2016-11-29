package stevesvehicles.common.blocks.tileentitys.detector.modulestate;

import stevesvehicles.common.modules.common.storage.tank.ModuleTank;
import stevesvehicles.common.vehicles.VehicleBase;

public class ModuleStateTank extends ModuleState {
	private Mode mode;

	public ModuleStateTank(String unlocalizedName, Mode mode) {
		super(unlocalizedName);
		this.mode = mode;
	}

	@Override
	public boolean isValid(VehicleBase vehicle) {
		boolean hasModule = false;
		for (ModuleTank tank : vehicle.getTanks()) {
			if (mode == Mode.FULL && !tank.isCompletelyFilled()) {
				return false;
			} else if (mode == Mode.EMPTY && !tank.isCompletelyEmpty()) {
				return false;
			}
			hasModule = mode != Mode.SPARE || tank.isCompletelyEmpty();
		}
		return hasModule;
	}

	public enum Mode {
		FULL, EMPTY, SPARE
	}
}