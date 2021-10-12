package racinggame.ui.config;

import racinggame.circuit.RacingCars;
import racinggame.common.RacingCarName;
import racinggame.exception.InvalidNameException;
import racinggame.racingcar.RacingCar;
import racinggame.racinggame.RacingCarNames;
import racinggame.ui.InputDevice;
import racinggame.ui.OutputDevice;

public final class RacingCarsConfig {
	private final InputDevice inputDevice;
	private final OutputDevice outputDevice;

	protected RacingCarsConfig(InputDevice inputDevice, OutputDevice outputDevice) {
		this.inputDevice = inputDevice;
		this.outputDevice = outputDevice;
	}

	protected RacingCars getRacingCars (){
		RacingCars racingCars = new RacingCars();

		inputCarNames().getNames()
			.forEach(name -> racingCars.add(new RacingCar(name)));

		return racingCars;
	}

	private RacingCarNames inputCarNames() {
		RacingCarNames racingCarNames = null;

		while(racingCarNames == null){
			outputDevice.print("경주할 자동차 이름을 입력하세요.");
			racingCarNames = inputRacingCarNames();
		}

		return racingCarNames;
	}

	private RacingCarNames inputRacingCarNames() {
		RacingCarNames racingCarNames;
		try {
			racingCarNames = inputNames();
			return racingCarNames;
		} catch (InvalidNameException e) {
			outputDevice.print(e.getMessage());
			return null;
		}
	}

	private RacingCarNames inputNames() {
		RacingCarNames racingCarNames = new RacingCarNames();

		String namesChunk = inputDevice.input();
		for (String nameChunk : namesChunk.split(",")) {
			racingCarNames.add(new RacingCarName(nameChunk));
		}

		return racingCarNames;
	}
}
