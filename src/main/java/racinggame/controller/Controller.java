package racinggame.controller;

import racinggame.model.Cars;
import racinggame.model.RacingGame;
import racinggame.model.TryCount;
import racinggame.validation.NameValidation;
import racinggame.validation.TryCountValidation;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class Controller {

	public void run() {

		Cars cars = new Cars(inputCarNames());
		TryCount tryCount = new TryCount(inputRaceTryCount());

		RacingGame racingGame = new RacingGame(cars, tryCount);

		OutputView.printResult();
		while (racingGame.isNotFinish()) {
			OutputView.printResultByRound(racingGame.racing());
		}

		OutputView.printWinnerCars(racingGame.findWinnerCars());
	}

	private String inputRaceTryCount() {
		String tryCount = InputView.inputRaceTryCount();
		TryCountValidation tryCountValidation = new TryCountValidation().checkInputStatus(tryCount);
		if (tryCountValidation.isProblem()) {
			OutputView.printErrorMessage(tryCountValidation.getErrorMessage());
			return inputRaceTryCount();
		}
		return tryCount;
	}

	private String inputCarNames() {
		String carNames = InputView.inputCarNames();
		NameValidation nameValidation = new NameValidation().checkInputStatus(carNames);
		if (nameValidation.isProblem()) {
			OutputView.printErrorMessage(nameValidation.getErrorMessage());
			return inputCarNames();
		}
		return carNames;
	}
}
