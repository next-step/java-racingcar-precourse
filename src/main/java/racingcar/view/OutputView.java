package racingcar.view;

import java.util.List;

import racingcar.dto.CarStatus;
import racingcar.dto.GameResult;

public class OutputView {
	private static final String GAME_RESULT = "실행 결과";
	private static final String ONE_STEP = "-";
	private static final String FINAL_WINNERS = "최종 우승자";

	public static void printInitResult() {
		System.out.println("");
		System.out.println(GAME_RESULT);
	}

	public static void printCarStatues(GameResult result) {
		for(CarStatus car: result.getCars()) {
			System.out.printf("%s : %s%n", car.getName(), getLine(car));
		}
		System.out.println("");
	}

	public static void printWinners(GameResult result) {
		List<String> names = result.getNames();
		String winners = String.join(",", names);

		System.out.printf("%s: %s%n", FINAL_WINNERS, winners);
	}

	public static void printErrorMessage(String message) {
		System.out.println(message);
	}

	private static String getLine(CarStatus car) {
		StringBuilder builder = new StringBuilder();
		int position = car.getPosition();

		for(int i = 0; i < position; i += 1) {
			builder.append(ONE_STEP);
		}
		return builder.toString();
	}
}
