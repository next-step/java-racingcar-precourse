package racinggame.view;

import java.util.List;

import nextstep.utils.Console;
import racinggame.domain.CarDto;

public class ConsoleView {
	public static final String POSITION_SHAPE = "-";
	public static final String POSITION_FORMAT = "%s : %s";
	public static final String WINNER_FORMAT = "최종 우승자는 %s 입니다.";
	public static final String CARNAME_INPUT_MESSAGE = "경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)";
	public static final String GAMEROUND_INPUT_MESSAGE = "시도할회수는몇회인가요?";
	public static final String GAME_RESULT_MESSAGE = "실행 결과";
	private static final String EXCEPTION_PREFIX = "[ERROR] %s";

	public static String readRacingCarNames() {
		Output.printMessage(CARNAME_INPUT_MESSAGE);
		return Console.readLine();
	}

	public static String readGameRound() {
		Output.printMessage(GAMEROUND_INPUT_MESSAGE);
		return Console.readLine();
	}

	public static void printGameResult() {
		Output.printNewLine();
		Output.printMessage(GAME_RESULT_MESSAGE);
	}

	public static void printWinners(String names) {
		Output.printMessage(convertString(WINNER_FORMAT, names));
	}

	public static void printExceptionMessage(final String message) {
		Output.printMessage(convertString(EXCEPTION_PREFIX, message));
	}

	public static void printPosition(List<CarDto> cars) {
		for (CarDto car : cars) {
			Output.printMessage(convertString(POSITION_FORMAT, car.getName(), printShape(car)));
		}
		Output.printNewLine();
	}

	private static String printShape(CarDto car) {
		StringBuffer buffer = new StringBuffer();
		for (int index = 0; index < car.getPosition(); index++) {
			buffer.append(POSITION_SHAPE);
		}
		return buffer.toString();
	}

	private static String convertString(String format, String... parameter) {
		return String.format(format, parameter);
	}
}
