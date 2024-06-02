package util;

import java.util.List;

public class ConsoleMessagePrinter {

    private ConsoleMessagePrinter() {}

    public static void printCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printAttemptNumberInputMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printLineBreak() {
        System.out.println();
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }

    public static void printExecutionResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printCarStatus(String carName, String carStatus) {
        System.out.printf("%s : %s%n", carName, carStatus);
    }

    public static void printWinnerNameList(List<String> winnerNameList) {
        System.out.print("최종 우승자 : " + String.join(", ", winnerNameList));
    }
}
