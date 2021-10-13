package racinggame.machine.config;

import racinggame.circuit.Lap;
import racinggame.exception.InvalidNumberException;
import racinggame.machine.InputDevice;
import racinggame.machine.OutputDevice;

public final class LapConfig {
	private final InputDevice inputDevice;
	private final OutputDevice outputDevice;

	protected LapConfig(InputDevice inputDevice, OutputDevice outputDevice) {
		this.inputDevice = inputDevice;
		this.outputDevice = outputDevice;
	}

	/**
	 * 서킷을 반복할 랩 수를 입력받는다.
	 *
	 * @return {@link Lap}
	 * @throws {@link InvalidNumberException} 0 이하 음수를 입력하면 발생한다.
	 * @throws {@link NumberFormatException} 문자를 입력하면 발생한다.
	 */
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
		} catch (InvalidNumberException | NumberFormatException error) {
			outputDevice.print(error.getMessage());
			return null;
		}
	}
}
