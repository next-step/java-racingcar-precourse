package racinggame.view;

import java.util.List;

import nextstep.utils.Console;
import racinggame.domain.RacingCarDto;

public class ConsoleView {
	private static final String POSITION_SHAPE = "-";
	private static final String INPUT_POSITION_FORMAT = "%s : %s";
	private static final String WINNER_MESSAGE_FORMAT = "최종 우승자는 %s 입니다.";
	private static final String CARNAME_REQUEST_MESSAGE = "경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)";
	private static final String GAMEROUND_REQUEST_MESSAGE = "시도할회수는몇회인가요?";
	private static final String GAME_RESULT_MESSAGE = "실행 결과";
	private static final String EXCEPTION_PREFIX_FORMAT = "[ERROR] %s";

	public static String readRacingCarNames() {
		Output.printMessage(CARNAME_REQUEST_MESSAGE);
		return Console.readLine();
	}

	public static String readGameRound() {
		Output.printMessage(GAMEROUND_REQUEST_MESSAGE);
		return Console.readLine();
	}

	public static void printGameResult() {
		Output.printNewLine();
		Output.printMessage(GAME_RESULT_MESSAGE);
	}

	public static void printWinners(String names) {
		Output.printMessage(convertString(WINNER_MESSAGE_FORMAT, names));
	}

	public static void printExceptionMessage(final String message) {
		Output.printMessage(convertString(EXCEPTION_PREFIX_FORMAT, message));
	}

	public static void printPosition(List<RacingCarDto> cars) {
		for (RacingCarDto car : cars) {
			Output.printMessage(convertString(INPUT_POSITION_FORMAT, car.getName(), printShape(car)));
		}
		Output.printNewLine();
	}

	private static String printShape(RacingCarDto car) {
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