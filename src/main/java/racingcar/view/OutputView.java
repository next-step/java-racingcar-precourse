package racingcar.view;

public class OutputView {
    private static final String RESULT_MESSAGE = "최종 우승자: %s";
    private static final String EACH_STAGE_MESSAGE = "%s : %s";
    private static final String EMPTY = "";

    public static void printLine() {
        System.out.println(EMPTY);
    }

    public static void printResult(final String winner) {
        System.out.println(String.format(RESULT_MESSAGE, winner));
    }

    public static void printEachStage(final String name, final String dashDistance) {
        System.out.println(String.format(EACH_STAGE_MESSAGE, name, dashDistance));
    }

    public static void printErrorMessage(final String message) {
        System.out.println(message);
    }

}
