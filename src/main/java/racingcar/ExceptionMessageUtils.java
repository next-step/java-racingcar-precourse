package racingcar;

// TODO : Convert to Custom IllegalArgument Exception
public final class ExceptionMessageUtils {

    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";
    private static final String SPACE = " ";

    private ExceptionMessageUtils() {
    }

    public static String createExceptionMessage(final String message) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(EXCEPTION_MESSAGE_PREFIX);
        stringBuilder.append(SPACE);
        stringBuilder.append(message);
        return stringBuilder.toString();
    }

}
