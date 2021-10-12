package racinggame.view;

import java.util.List;

import racinggame.domain.Car;
import racinggame.domain.Name;
import racinggame.domain.Position;
import racinggame.domain.Round;
import racinggame.domain.Winner;

public final class ResultView {
	private static final String MESSAGE_OF_GAME_START = "실행 결과";
	private static final String MESSAGE_OF_EXECUTE_RESULT_FORMAT = "%s : %s\n";
	private static final String STRING_OF_POSITION = "-";
	private static final String MESSAGE_OF_GAME_END_FORMAT = "최종 우승자는 %s 입니다.\n";

	private ResultView() {
	}

	public static void printGameStart() {
		System.out.println(MESSAGE_OF_GAME_START);
	}

	public static void printRoundResult(Round round) {
		List<Car> cars = round.getCars();
		for (Car car : cars) {
			String name = toNameString(car.getName());
			String position = toPositionString(car.getPosition());

			System.out.format(MESSAGE_OF_EXECUTE_RESULT_FORMAT, name, position);
		}
		System.out.println();
	}

	private static String toNameString(Name name) {
		return name.getValue();
	}

	private static String toPositionString(Position position) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < position.getValue(); i++) {
			sb.append(STRING_OF_POSITION);
		}

		return sb.toString();
	}

	public static void printWinnerNames(Winner winner) {
		System.out.format(MESSAGE_OF_GAME_END_FORMAT, winner.getNames());
	}
}
