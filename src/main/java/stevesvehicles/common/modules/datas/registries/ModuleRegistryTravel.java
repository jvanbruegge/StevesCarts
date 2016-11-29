package stevesvehicles.common.modules.datas.registries;

import static stevesvehicles.common.items.ComponentTypes.SIMPLE_PCB;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevesvehicles.client.localization.entry.info.LocalizationGroup;
import stevesvehicles.client.rendering.models.common.ModelCage;
import stevesvehicles.client.rendering.models.common.ModelSeat;
import stevesvehicles.common.modules.common.attachment.ModuleArcade;
import stevesvehicles.common.modules.common.attachment.ModuleCage;
import stevesvehicles.common.modules.common.attachment.ModuleSeat;
import stevesvehicles.common.modules.datas.ModuleData;
import stevesvehicles.common.modules.datas.ModuleDataGroup;
import stevesvehicles.common.modules.datas.ModuleSide;
import stevesvehicles.common.vehicles.VehicleRegistry;

public class ModuleRegistryTravel extends ModuleRegistry {
	public static final String SEAT_KEY = "Seats";
	public static final String CAGE_KEY = "Cages";

	public ModuleRegistryTravel() {
		super("common.travel");
		ModuleDataGroup seats = ModuleDataGroup.createGroup(SEAT_KEY, LocalizationGroup.SEAT);
		ModuleDataGroup cages = ModuleDataGroup.createGroup(CAGE_KEY, LocalizationGroup.CAGE);
		ModuleData seat = new ModuleData("seat", ModuleSeat.class, 3) {
			@Override
			@SideOnly(Side.CLIENT)
			public void loadModels() {
				removeModel("Top");
				addModel("Chair", new ModelSeat());
			}
		};
		seat.addShapedRecipeWithSize(2, 3, null, "plankWood", null, "plankWood", "slabWood", "plankWood");
		seat.addVehicles(VehicleRegistry.CART, VehicleRegistry.BOAT);
		seat.addSides(ModuleSide.CENTER, ModuleSide.TOP);
		seats.add(seat);
		register(seat);
		ModuleData arcade = new ModuleData("steves_arcade", ModuleArcade.class, 10);
		arcade.addShapedRecipe(null, Blocks.GLASS_PANE, null, "plankWood", SIMPLE_PCB, "plankWood", Items.REDSTONE, "plankWood", Items.REDSTONE);
		arcade.addVehicles(VehicleRegistry.CART, VehicleRegistry.BOAT);
		arcade.addRequirement(seats);
		register(arcade);
		ModuleData cage = new ModuleData("cage", ModuleCage.class, 7) {
			@Override
			@SideOnly(Side.CLIENT)
			public void loadModels() {
				removeModel("Top");
				addModel("Cage", new ModelCage(false), false);
				addModel("Cage", new ModelCage(true), true);
				setModelMultiplier(0.65F);
			}
		};
		cage.addShapedRecipe(Blocks.IRON_BARS, Blocks.IRON_BARS, Blocks.IRON_BARS, Blocks.IRON_BARS, SIMPLE_PCB, Blocks.IRON_BARS, Blocks.IRON_BARS, Blocks.IRON_BARS, Blocks.IRON_BARS);
		cage.addVehicles(VehicleRegistry.CART, VehicleRegistry.BOAT);
		cage.addSides(ModuleSide.CENTER, ModuleSide.TOP);
		cages.add(cage);
		register(cage);
	}
}