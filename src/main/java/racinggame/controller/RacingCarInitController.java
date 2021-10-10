package racinggame.controller;

import java.util.ArrayList;
import java.util.List;

import racinggame.move.RandomMovingStrategy;
import racinggame.racingcar.RacingCar;
import racinggame.racingcar.RacingCars;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class RacingCarInitController {

	private RacingCarInitController() {
	}

	public static RacingCars init() {
		RacingCars racingCars = null;
		while (racingCars == null) {
			racingCars = createRacingCars();
		}

		return racingCars;
	}

	private static RacingCars createRacingCars() {
		OutputView.printForAskingRacingCarInput();
		final List<String> carNamesInput = InputView.getCarNamesInput();

		try {
			return createRacingCarsByCarName(carNamesInput);
		} catch (RuntimeException e) {
			OutputView.printErrorMessage(e);
			return null;
		}
	}

	private static RacingCars createRacingCarsByCarName(List<String> carNames) {
		final List<RacingCar> racingCars = new ArrayList<>();
		for (String carName : carNames) {
			racingCars.add(new RacingCar(carName, RandomMovingStrategy.getInstance()));
		}

		return new RacingCars(racingCars);
	}
}
