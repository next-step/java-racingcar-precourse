package racinggame.controller;

import racinggame.model.Cars;
import racinggame.model.RacingGame;
import racinggame.model.TryCount;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class Controller {

	public void run() {

		Cars cars = new Cars(InputView.inputCarNames());
		TryCount tryCount = new TryCount(InputView.inputRaceTryCount());

		RacingGame racingGame = new RacingGame(cars, tryCount);

		OutputView.printResult();
		while (racingGame.isNotFinish()) {
			OutputView.printResultByRound(racingGame.racing());
		}

	}

}
