package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ErrorMessageUtilTest {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR]";

    @Test
    void 에러문구_포함확인() {
        Assertions.assertTrue(ErrorMessageUtil.getMessage("에러입니다~").contains(ERROR_MESSAGE_PREFIX));
    }
}
