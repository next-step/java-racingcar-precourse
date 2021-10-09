package racinggame.view;

import racinggame.model.MoveResults;
import racinggame.model.enums.Error;

public class OutputView {

    public static void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printResult(MoveResults results) {
        System.out.println(results.getOutput());
    }

    public static void printWinners(String winners) {
        System.out.println("최종 우승자는 " + winners + " 입니다.");
    }

    public static void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printNumberFormatError() {
        System.out.println(Error.WRONG_NUMBER_FORMAT.message());
    }
}
