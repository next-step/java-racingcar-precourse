package racinggame.machine.config;

import racinggame.circuit.RacingCars;
import racinggame.common.RacingCarName;
import racinggame.exception.InvalidNameException;
import racinggame.racingcar.RacingCar;
import racinggame.racinggame.RacingCarNames;
import racinggame.machine.InputDevice;
import racinggame.machine.OutputDevice;

public final class RacingCarsConfig {
	private final InputDevice inputDevice;
	private final OutputDevice outputDevice;

	protected RacingCarsConfig(final InputDevice inputDevice, final OutputDevice outputDevice) {
		this.inputDevice = inputDevice;
		this.outputDevice = outputDevice;
	}

	/**
	 * String 을 입력받아 {@link RacingCar}의 {@link RacingCarName} 을 설정한다.
	 *
	 * @return {@link RacingCars}
	 * @throws InvalidNameException : 레이싱카의 이름을 잘못 입력하면 발생하는 Exception
	 */

	protected RacingCars getRacingCars() {
		RacingCars racingCars = new RacingCars();

		carNames().getNames()
			.forEach(name -> racingCars.add(new RacingCar(name)));

		return racingCars;
	}

	private RacingCarNames carNames() {
		RacingCarNames racingCarNames = null;

		while (racingCarNames == null) {
			outputDevice.print("경주할 자동차 이름을 입력하세요.");
			racingCarNames = input();
		}

		return racingCarNames;
	}

	private RacingCarNames input() {
		RacingCarNames racingCarNames;
		try {
			racingCarNames = makeRacingCarNames();
			return racingCarNames;
		} catch (InvalidNameException e) {
			outputDevice.print(e.getMessage());
			return null;
		}
	}

	private RacingCarNames makeRacingCarNames() {
		RacingCarNames racingCarNames = new RacingCarNames();

		String[] namesChunk = splitInputNames();

		for (String nameChunk : namesChunk) {
			racingCarNames.add(new RacingCarName(nameChunk));
		}
		return racingCarNames;
	}

	private String[] splitInputNames() {
		String[] namesChunk = inputDevice.input()
			.replace(" ", "")
			.split(",");

		if (namesChunk.length == 0) {
			throw new InvalidNameException("[ERROR] 이름을 1자 이상 5자 이하로 입력하세요");
		}

		return namesChunk;
	}
}
