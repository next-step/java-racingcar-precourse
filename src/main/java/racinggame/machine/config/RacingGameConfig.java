package racinggame.machine.config;

import racinggame.circuit.Lap;
import racinggame.circuit.RacingCars;
import racinggame.machine.InputDevice;
import racinggame.machine.OutputDevice;
import racinggame.machine.Settings;

public final class RacingGameConfig {
	private final InputDevice inputDevice;
	private final OutputDevice outputDevice;

	public RacingGameConfig(final InputDevice inputDevice, final OutputDevice outputDevice) {
		this.inputDevice = inputDevice;
		this.outputDevice = outputDevice;
	}

	/**
	 * 게임설정을 진행한다.
	 * 레이싱카와 랩수를 설정한다.
	 *
	 * @return {@link Settings}
	 */
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
