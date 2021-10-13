package racinggame;

import java.util.List;

import racinggame.domain.Cars;
import racinggame.domain.Round;
import racinggame.exception.InvalidInputException;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class RaceGame {

	private Round round;

	private Cars racingCars;

	private final InputView inputView;

	private final OutputView outputView;

	public RaceGame() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void run() {
		gameInit();

		outputView.showExecuteResultMessage();
		while (!this.round.isEnd()) {
			racingCars.move();
			outputView.showCurrentDrivenDistance(racingCars);
			round.nextRound();
		}

		outputView.showWinner(racingCars.announceWinners());
	}

	private void gameInit() {
		initRacingCars();
		initRound();
	}

	private void initRacingCars(){
		boolean carsReady = false;
		while(!carsReady) {
			List<String> carNames = inputView.inputCarNames();
			carsReady = carsRegistered(carNames);
		}
	}

	private boolean carsRegistered(List<String> names) {
		try {
			this.racingCars = new Cars(names);
		} catch (InvalidInputException e) {
			outputView.printErrorMessage(e.getMessage());
			return false;
		}

		return true;
	}

	private void initRound(){
		int inputRound = inputView.inputRound();
		this.round = new Round(inputRound);

	}
}
