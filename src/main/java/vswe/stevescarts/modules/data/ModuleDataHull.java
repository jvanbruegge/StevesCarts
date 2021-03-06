package vswe.stevescarts.modules.data;

import net.minecraft.util.text.TextFormatting;
import vswe.stevescarts.helpers.Localization;
import vswe.stevescarts.modules.ModuleBase;

import java.util.List;

public class ModuleDataHull extends ModuleData {
	private int modularCapacity;
	private int engineMaxCount;
	private int addonMaxCount;
	private int complexityMax;

	public ModuleDataHull(final int id, final String name, final Class<? extends ModuleBase> moduleClass) {
		super(id, name, moduleClass, 0);
	}

	public ModuleDataHull setCapacity(final int val) {
		modularCapacity = val;
		return this;
	}

	public ModuleDataHull setEngineMax(final int val) {
		engineMaxCount = val;
		return this;
	}

	public ModuleDataHull setAddonMax(final int val) {
		addonMaxCount = val;
		return this;
	}

	public ModuleDataHull setComplexityMax(final int val) {
		complexityMax = val;
		return this;
	}

	public int getEngineMax() {
		return engineMaxCount;
	}

	public int getAddonMax() {
		return addonMaxCount;
	}

	public int getCapacity() {
		return modularCapacity;
	}

	public int getComplexityMax() {
		return complexityMax;
	}

	@Override
	public void addSpecificInformation(final List list) {
		list.add(TextFormatting.YELLOW + Localization.MODULE_INFO.MODULAR_CAPACITY.translate(String.valueOf(modularCapacity)));
		list.add(TextFormatting.DARK_PURPLE + Localization.MODULE_INFO.COMPLEXITY_CAP.translate(String.valueOf(complexityMax)));
		list.add(TextFormatting.GOLD + Localization.MODULE_INFO.MAX_ENGINES.translate(String.valueOf(engineMaxCount)));
		list.add(TextFormatting.GREEN + Localization.MODULE_INFO.MAX_ADDONS.translate(String.valueOf(addonMaxCount)));
	}
}
