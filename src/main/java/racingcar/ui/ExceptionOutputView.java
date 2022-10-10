package racingcar.ui;

public class ExceptionOutputView {
    private static final String PREFIX = "[ERROR] ";

    public static void printMessage(RuntimeException e) {
        System.out.println(PREFIX + e.getMessage());
    }
}
