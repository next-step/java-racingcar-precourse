package racingcar.common.validate;

public interface ValidateUtils {

    String SOURCE_NULL_MSG = "Source is null";
    String TOO_LONG_MSG_HOLDER = "Source [%s] Length too long";

    static void maxLength(String source, int maxLength) {
        if (source == null) {
            throw new IllegalArgumentException(SOURCE_NULL_MSG);
        }

        if (source.length() > maxLength) {
            throw new IllegalArgumentException(String.format(TOO_LONG_MSG_HOLDER, source));
        }
    }
}
