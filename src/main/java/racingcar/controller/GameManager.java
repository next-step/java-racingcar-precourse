package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RandomNumber;
import racingcar.domain.Validator;
import racingcar.dto.GameResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameManager {
	private Cars cars;
	private int count;

	public void play() {
		setUpCars();
		setCount();

		OutputView.printInitResult();
		for(int idx = 0; idx < count; idx += 1) {
			cars.move(new RandomNumber());
			GameResult carStatus = cars.getGameResult();
			OutputView.printCarStatues(carStatus);
		}

		GameResult winners = cars.getWinners();
		OutputView.printWinners(winners);

	}
	private void setUpCars() {
		try {
			String inputNames = InputView.readCarNames();
			String[] names = inputNames.split(",");
			cars = new Cars(names);
		}catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			setUpCars();
		}
	}

	private void setCount() {
		try {
			String inputCount = InputView.readRoundCount();
			Validator.validNumber(inputCount);

			count = Integer.parseInt(inputCount);
		}catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			setCount();
		}
	}
}
