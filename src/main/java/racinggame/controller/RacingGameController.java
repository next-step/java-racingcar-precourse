package racinggame.controller;

import java.util.List;

import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.RaceCount;
import racinggame.domain.Round;
import racinggame.domain.Winner;
import racinggame.view.ResultView;

public final class RacingGameController {
	private RacingGameController() {
	}

	public static void run(Cars cars, RaceCount raceCount) {
		Round round = new Round(cars, raceCount);

		statGame(round);
	}

	private static void statGame(Round round) {
		ResultView.printGameStart();
		while (round.isRemainingCount()) {
			round = round.startRacingCars();
			ResultView.printRoundResult(round);
		}

		List<Car> cars = round.getCars();
		ResultView.printWinnerNames(Winner.createNew(cars));
	}
}
