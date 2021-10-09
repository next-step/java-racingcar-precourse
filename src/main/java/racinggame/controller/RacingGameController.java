package racinggame.controller;

import racinggame.exception.InvalidCarNameException;
import racinggame.model.Cars;
import racinggame.model.Round;
import racinggame.strategy.RandomMoveStrategy;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class RacingGameController {

	private final InputView inputView;
	private final OutputView outputView;

	public RacingGameController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void play() {
		final Cars cars = createCars();
		final int countOfRound = inputGameRoundCount();
		Round round = new Round(cars, countOfRound);

		this.outputView.printEmptyLine();
		this.outputView.printExecuteMessage();

		while (!round.isFinishRound()) {
			round = round.play();
			this.outputView.printRoundResult(round);
			this.outputView.printEmptyLine();
		}

		this.outputView.printWinners(round.findWinners());
	}

	private int inputGameRoundCount() {
		try {
			this.outputView.printInputCount();
			return this.inputView.inputNumber();
		} catch (NumberFormatException e) {
			this.outputView.printUserInputError("잘못된 숫자 입력");
			return inputGameRoundCount();
		}
	}

	private Cars createCars() {
		try {
			this.outputView.printInputName();
			return Cars.of(new RandomMoveStrategy(), this.inputView.inputNames());
		} catch (InvalidCarNameException e) {
			this.outputView.printUserInputError(e.getMessage());
			return createCars();
		}
	}
}
