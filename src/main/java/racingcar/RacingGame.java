package racingcar;

import java.util.Arrays;

import sun.security.validator.ValidatorException;

public class RacingGame {

	public static final String DELIMITER = ",";
	public static final String WINNER_COMMENT = "가 최종 우승했습니다.";

	public void run() {
		String carNames = UserInput.inputCarNames();
		int moveCounts = UserInput.inputMoveCount();

		try {
			RacingCar racingCar = new RacingCar(Arrays.asList(carNames.split(DELIMITER)));
			System.out.println(this.getPlayResult(racingCar, moveCounts) + WINNER_COMMENT);
		} catch (ValidatorException e) {
			System.err.println(e.getMessage());
		}
	}

	public String getPlayResult(RacingCar racingCar, int moveCounts) {
		for (int i = 0; i < moveCounts; i++) {
			racingCar.playAndPrintResult();
		}
		return racingCar.getWinners();
	}

	public static void main(String[] args) {
		RacingGame racingGame = new RacingGame();
		racingGame.run();
	}
}
