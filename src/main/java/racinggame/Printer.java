package racinggame;

import java.util.List;

import nextstep.utils.Console;

public class Printer {
	private static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String DELIMITER = ",";
	private static final String ENTER_MOVE_COUNT = "시도할 횟수는 몇회인가요?";
	private static final String RACING_RECORD_HEADER = "실행 결과";

	public static String[] enterCarNames() {
		System.out.println(ENTER_CAR_NAMES);
		return Console.readLine().split(DELIMITER);
	}

	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static String enterMoveCount() {
		System.out.println(ENTER_MOVE_COUNT);
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
}

