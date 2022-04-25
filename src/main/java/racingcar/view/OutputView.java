package racingcar.view;

public class OutputView {

    private static final String RUN_RESULT = "실행 결과";
    private static final String MOVING = "-";
    private static final String WINNER_RESULT = "최종 우승자: ";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR]";

    public static void printRunResultMessage() {
        System.out.println(RUN_RESULT);
    }

    public static void printCarRacing(String carName, int movingNum) {
        String message = carName+" : ";

        for (int i = 0; i < movingNum; i++) {
            message = message.concat(MOVING);
        }

        System.out.println(message);
    }

    public static void printWinner(String winners) {
        System.out.println(WINNER_RESULT+winners);
    }

    public static void printErrorMsg(String message) {
        System.out.println(ERROR_MESSAGE_PREFIX+message);
    }
}
