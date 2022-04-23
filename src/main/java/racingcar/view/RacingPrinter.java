package racingcar.view;

import racingcar.domain.Car;

public class RacingPrinter {
    private static final String CAR_NAME_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_GUIDE = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String LAST_WINNER = "최종 우승자: ";

    public static void printCarNameGuide() {
        System.out.println(CAR_NAME_GUIDE);
    }

    public static void printRoundGuide() {
        System.out.println(ROUND_GUIDE);
    }

    public static void printExecutionResult() {
        System.out.println(EXECUTION_RESULT);
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void exceptionGuide(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }

    public static void printWinner(String winnerName) {
        System.out.println(LAST_WINNER + winnerName);
    }
}
