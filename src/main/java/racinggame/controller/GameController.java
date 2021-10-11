package racinggame.controller;

import racinggame.model.Cars;
import racinggame.model.Round;
import racinggame.strategy.RandomMoveStrategy;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class GameController {
	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();
	private Cars cars;
	private Round round;

	public void run() {
		cars = new Cars(inputView.inputCarNames(), new RandomMoveStrategy());
		round = new Round(inputView.inputRound());
		playGame();
		finalWinners();
	}

	private void finalWinners() {
		outputView.printWinners(cars.getWinningCars());
	}

	private void playGame() {
		outputView.printResult();
		while (!round.isFinalRound()) {
			round.nextRound();
			cars.move();
			outputView.printCars(cars.getCars());
		}
	}
}
