package racinggame.ui.config;

import racinggame.circuit.Lap;
import racinggame.exception.InvalidNameException;
import racinggame.ui.InputDevice;
import racinggame.ui.OutputDevice;

public final class LapConfig {
	private final InputDevice inputDevice;
	private final OutputDevice outputDevice;

	protected LapConfig(InputDevice inputDevice, OutputDevice outputDevice) {
		this.inputDevice = inputDevice;
		this.outputDevice = outputDevice;
	}

	protected Lap getLaps (){
		Lap lap = null;

		while(lap == null){
			outputDevice.print("시도할 횟수는 몇회인가요?");
			lap = getLaps(inputDevice.input());
		}

		return lap;
	}

	private Lap getLaps(String labString) {
		try {
			return new Lap(labString);
		} catch (InvalidNameException | NumberFormatException error) {
			outputDevice.print(error.getMessage());
			return null;
		}
	}
}
