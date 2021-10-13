package racinggame.controller;

import racinggame.domain.Cars;
import racinggame.view.UserConsole;

public class RacingGameController {

	public void start() {
		Cars racingCars = readCarNames();
		int trialNumber = readTrialNumber();
		racingCars.move(trialNumber);
		racingCars.printWinners();
	}

	private Cars readCarNames() {
		try {
			String[] carNames = UserConsole.readCarNames();
			return new Cars(carNames);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return readCarNames();
		}
	}

	private int readTrialNumber() {
		try {
			return UserConsole.readTrialNumber();
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			return readTrialNumber();
		}
	}
}
