package racingcar.domain.model;

import org.junit.jupiter.api.Test;
import racingcar.core.common.error.CommonErrorCode;
import racingcar.core.common.error.RoundErrorCode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoundTest {

    @Test
    void null_값_체크() {
        //given
        String inputRound = null;

        //when
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    new Round(inputRound);
                });

        // then
        assertEquals(CommonErrorCode.NOT_ALLOW_NULL.getErrorMessage(),
                exception.getMessage());
    }

    @Test
    void empty_값_체크() {
        //given
        String inputRound = "       ";

        //when
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    new Round(inputRound);
                });

        // then
        assertEquals(CommonErrorCode.NOT_ALLOW_EMPTY.getErrorMessage(),
                exception.getMessage());
    }

    @Test
    void 숫자가_아닌_문자() {
        //given
        String inputRound = "숫자가 아닌 문자";

        //when
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    new Round(inputRound);
                });

        // then
        assertEquals(RoundErrorCode.ONLY_NUMBER_ALLOW.getErrorMessage(),
                exception.getMessage());
    }

    @Test
    void 입력값이_0일때() {
        //given
        String inputRound = "0";

        //when
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    new Round(inputRound);
                });

        // then
        assertEquals(RoundErrorCode.NOT_ALLOW_ZERO.getErrorMessage(),
                exception.getMessage());
    }
}