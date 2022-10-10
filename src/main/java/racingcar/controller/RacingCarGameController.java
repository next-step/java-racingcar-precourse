package racingcar.controller;

import racingcar.constants.RacingCarMessage;
import racingcar.domain.RacingCars;
import racingcar.util.RacingCarValidation;
import racingcar.view.RacingCarGameOut;
import racingcar.view.RacingCarPlayer;

public class RacingCarGameController {
	public static void start() {
		RacingCars cars = new RacingCars(readRacingCars());
		int attemptNum = readAttemptNum();
		playGame(cars, attemptNum);
		RacingCarGameOut.getGameResult(cars);
	}

	private static void playGame(RacingCars cars, int attemptNum) {
		RacingCarGameOut.printResult(cars);
		for(int i = 0; i < attemptNum; i++) {
			cars.play();
			RacingCarGameOut.printRoundResult(cars);
		}
	}

	private static String[] readRacingCars() {
		String carNames = RacingCarPlayer.readInputCarNames();
		boolean validCarName = checkValidCarName(carNames);
		while(!validCarName) {
			carNames = RacingCarPlayer.readInputCarNames();
			validCarName = checkValidCarName(carNames);
		}
		return carNames.split(RacingCarMessage.CAR_NAME_COMMA);
	}

	private static int readAttemptNum() {
		String attempNum = RacingCarPlayer.readInputAttemptNum();
		boolean validAttemptNum = checkValidAttemptNum(attempNum);
		while(!validAttemptNum) {
			attempNum = RacingCarPlayer.readInputAttemptNum();
			validAttemptNum = checkValidAttemptNum(attempNum);
		}
		return Integer.parseInt(attempNum);
	}

	private static boolean checkValidCarName(String carNames) {
		boolean validCarName = RacingCarValidation.validateCarName(carNames);
		if(validCarName) {
			return true;
		}
		return false;
	}

	private static boolean checkValidAttemptNum(String attempNum) {
		boolean validAttemptNum = RacingCarValidation.validateAttemptNum(attempNum);
		if(validAttemptNum) {
			return true;
		}
		return false;
	}

}
