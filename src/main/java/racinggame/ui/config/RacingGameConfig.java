package racinggame.ui.config;

import racinggame.circuit.Lap;
import racinggame.circuit.RacingCars;
import racinggame.ui.InputDevice;
import racinggame.ui.OutputDevice;
import racinggame.ui.Settings;

public final class RacingGameConfig {
	private final InputDevice inputDevice;
	private final OutputDevice outputDevice;

	public RacingGameConfig(InputDevice inputDevice, OutputDevice outputDevice) {
		this.inputDevice = inputDevice;
		this.outputDevice = outputDevice;
	}

	public Settings configGame() {
		return new Settings(configRacingCars(), configLap());
	}

	private RacingCars configRacingCars() {
		return new RacingCarsConfig(inputDevice, outputDevice)
			.getRacingCars();
	}

	private Lap configLap() {
		return new LapConfig(inputDevice, outputDevice).getLaps();
	}
}
