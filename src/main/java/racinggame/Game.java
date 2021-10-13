package racinggame;

import racinggame.view.InputView;
import racinggame.view.OutputView;

public class Game {

	public void play() {
		Cars cars = makeRacingCars();
		race(cars);
		announceWinners(cars);
	}

	private Cars makeRacingCars() {
		CarNames carNames = InputView.inputCarNames();
		return new Cars(carNames);
	}

	private void race(Cars cars) {
		PlayCount playCount = InputView.inputCount();
		OutputView.outputProgressLabel();
		for (int i = 0; i < playCount.get(); i++) {
			cars.race();
			OutputView.outputProgress(cars.getProgressBars());
		}
	}

	private void announceWinners(Cars cars) {
		CarNames winnerNames = cars.getWinnerNames();
		OutputView.outputResult(winnerNames);
	}
}
