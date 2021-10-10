package racinggame.controller;

import racinggame.racingcar.RacingCars;
import racinggame.racingcar.Winners;
import racinggame.trycount.TryCount;
import racinggame.view.OutputView;

public class RacingGameController {

	public static void play() {
		RacingCars racingCars = RacingCarInitController.init();
		TryCount tryCount = TryCountInitController.init();

		racingCars = move(racingCars, tryCount);
		exit(racingCars);
	}

	private static void exit(RacingCars racingCars) {
		OutputView.printWinners(Winners.getWinners(racingCars).toString());
	}

	private static RacingCars move(RacingCars racingCars, TryCount tryCount) {
		OutputView.printExecutionResult();

		while (!tryCount.finish()) {
			racingCars = racingCars.move();
			OutputView.printRacingCarsStatus(racingCars.toString());
			tryCount = tryCount.decrease();
		}

		return racingCars;
	}

}
