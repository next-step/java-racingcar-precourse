package racinggame.controller;

import racinggame.model.Cars;
import racinggame.strategy.RandomMoveStrategy;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class GameController {
	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();
	private Cars cars;
	private Integer count;

	public void run() {
		cars = new Cars(inputView.inputCarNames(), new RandomMoveStrategy());
		count = inputView.inputRound();
		playGame();
		finalWinners();
	}

	private void finalWinners() {
		outputView.printWinners(cars.getWinningCars());
	}

	private void playGame() {
		outputView.printResult();
		for (int i = 0; i < count; i++) {
			cars.move();
			outputView.printCars(cars.getCars());
		}
	}
}
