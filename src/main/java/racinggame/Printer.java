package racinggame;

import java.util.List;

import nextstep.utils.Console;

public class Printer {
	private static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String DELIMITER = ",";
	private static final String ENTER_MOVE_COUNT = "시도할 횟수는 몇회인가요?";
	private static final String RACING_RECORD_HEADER = "실행 결과";
	private static final String RACING_RESULT_HEADER = "최종 우승자는 ";
	private static final String RACING_RESULT_FOOTER = " 입니다.";

	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static String[] enterCarNames() {
		Printer.printMessage(ENTER_CAR_NAMES);
		return Console.readLine().split(DELIMITER);
	}

	public static String enterMoveCount() {
		Printer.printMessage(ENTER_MOVE_COUNT);
		return Console.readLine();
	}

	public static void printRacingRecordHeader() {
		Printer.newLine();
		printMessage(RACING_RECORD_HEADER);
	}

	public static void printRacingRecord(List<String> distanceStringValues) {
		for (String distanceStringValue : distanceStringValues) {
			Printer.printMessage(distanceStringValue);
		}
		Printer.newLine();
	}

	private static void newLine() {
		System.out.println();
	}

	public static void printRacingGameWinners(List<String> winnerNames) {
		String winnerNameJoinValue = "";
		for (String winnerName : winnerNames) {
			winnerNameJoinValue += winnerName + ",";
		}
		winnerNameJoinValue = winnerNameJoinValue.substring(0, winnerNameJoinValue.length() - 1);
		Printer.printMessage(RACING_RESULT_HEADER + winnerNameJoinValue + RACING_RESULT_FOOTER);
	}
}

