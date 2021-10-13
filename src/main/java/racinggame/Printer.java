package racinggame;

import java.util.List;

import nextstep.utils.Console;
import racinggame.common.CommonCode;
import racinggame.common.CommonMessage;

public class Printer {

	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static String[] enterCarNames() {
		Printer.printMessage(CommonMessage.PRINT_MESSAGE_ENTER_CAR_NAMES);
		return Console.readLine().split(CommonCode.COMMA);
	}

	public static String enterMoveCount() {
		Printer.printMessage(CommonMessage.PRINT_MESSAGE_ENTER_MOVE_COUNT);
		return Console.readLine();
	}

	public static void printRacingRecordHeader() {
		Printer.newLine();
		printMessage(CommonMessage.PRINT_MESSAGE_RACING_RECORD_HEADER);
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
			winnerNameJoinValue += winnerName + CommonCode.COMMA;
		}
		winnerNameJoinValue = winnerNameJoinValue.substring(0, winnerNameJoinValue.length() - 1);
		Printer.printMessage(CommonMessage.PRINT_MESSAGE_RACING_RESULT_HEADER + winnerNameJoinValue
			+ CommonMessage.PRINT_MESSAGE_RACING_RESULT_FOOTER);
	}
}
