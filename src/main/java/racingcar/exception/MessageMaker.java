package racingcar.exception;

public class MessageMaker {

    private static final String PREFIX = "[ERROR]";

    public static String getMessage(String message) {
        return PREFIX.concat(" ").concat(message);
    }
}
