package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class RacingView {
	private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";
	private static final String ERROR_PREFIX = "[ERROR] ";
	private static final String LINE_BREAK = "\n";
	private static final String RESULT_BELOW = "실행 결과";
	private static final String WINNERS = "최종 우승자: ";

	public static String inputNames() {
		System.out.println(INPUT_CAR_NAMES);
		return Console.readLine();
	}

	public static String inputTryCount() {
		System.out.println(INPUT_TRY_COUNT);
		return Console.readLine();
	}

	public static void showError(String message) {
		System.out.println(ERROR_PREFIX + message);
	}

	public static void showResultBelow() {
		System.out.println(LINE_BREAK + RESULT_BELOW);
	}

	public static void showCars(Cars cars) {
		System.out.println(cars);
	}

	public static void showWinners(Winners winners) {
		System.out.println(WINNERS + winners);
	}
}
