package racingcar;

import java.util.Arrays;

import sun.security.validator.ValidatorException;

public class RacingGame {
	public void run() {
		String carNames = UserInput.inputCarNames();
		int moveCounts = UserInput.inputMoveCount();

		try {
			RacingCar racingCar = new RacingCar(Arrays.asList(carNames.split(",")));
			System.out.println(this.getPlayResult(racingCar, moveCounts) + "가 최종 우승했습니다.");
		} catch (ValidatorException e) {
			System.err.println("자동차 이름은 5자 이하만 가능합니다!");
		}
	}

	public String getPlayResult(RacingCar racingCar, int moveCounts) {
		for (int i = 0; i < moveCounts; i++) {
			racingCar.play();
		}
		return racingCar.getWinners();
	}

	public static void main(String[] args) {
		RacingGame racingGame = new RacingGame();
		racingGame.run();
	}
}
