package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.MoveStrategy;
import racingcar.domain.RandomMoveStrategy;
import racingcar.domain.TryCount;
import racingcar.view.RacingView;

public class RacingController {
	private static final MoveStrategy MOVE_STRATEGY = new RandomMoveStrategy();

	public void race() {
		Cars cars = getCars();
		TryCount tryCount = getTryCount();
		RacingView.showResultBelow();
		tryCount.run(() -> {
			cars.moveAll(MOVE_STRATEGY);
			RacingView.showCars(cars);
		});
		RacingView.showWinners(cars.winners());
	}

	private Cars getCars() {
		try {
			String names = RacingView.inputNames();
			return Cars.of(names.split(","));
		} catch (IllegalArgumentException e) {
			RacingView.showError(e.getMessage());
			return getCars();
		}
	}

	private TryCount getTryCount() {
		try {
			String input = RacingView.inputTryCount();
			return new TryCount(input);
		} catch (IllegalArgumentException e) {
			RacingView.showError(e.getMessage());
			return getTryCount();
		}
	}
}
