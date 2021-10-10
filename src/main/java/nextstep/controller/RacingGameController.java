package nextstep.controller;

import java.util.ArrayList;
import java.util.List;

import nextstep.move.RandomMovingStrategy;
import nextstep.racingcar.RacingCar;
import nextstep.racingcar.RacingCars;
import nextstep.trycount.TryCount;
import nextstep.view.InputView;
import nextstep.view.OutputView;

public class RacingGameController {

	public static void play() {
		final RacingCars racingCars = getRacingCars();
		final TryCount tryCount = getTryCount();
	}

	private static TryCount getTryCount() {
		TryCount tryCount = null;
		while (tryCount == null) {
			tryCount = createTryCount();
		}

		return tryCount;
	}

	private static TryCount createTryCount() {
		try {
			OutputView.printForAskingTryCountInput();
			return createTryCountByTryCount(InputView.getTryCountInput());
		} catch (RuntimeException e) {
			OutputView.printErrorMessage(e);
			return null;
		}
	}

	private static TryCount createTryCountByTryCount(int tryCountInput) {
		return new TryCount(tryCountInput);
	}

	private static RacingCars getRacingCars() {
		RacingCars racingCars = null;
		while (racingCars == null) {
			racingCars = createRacingCars();
		}

		return racingCars;
	}

	private static RacingCars createRacingCars() {
		try {
			OutputView.printForAskingRacingCarInput();
			return createRacingCarsByCarName(InputView.getCarNamesInput());
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
