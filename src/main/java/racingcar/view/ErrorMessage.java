package racingcar.view;

import racingcar.utils.ErrorMsgEnum;

public class ErrorMessage {

    public static final String ERROR_PREFIX = "[ERROR] ";

    public static void checkError(boolean b, ErrorMsgEnum s) {
        if (b) {
            throw new IllegalArgumentException(ERROR_PREFIX + s.getValue());
        }
    }
}
