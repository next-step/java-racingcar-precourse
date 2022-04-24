package racingcar.domain.model;

import org.junit.jupiter.api.Test;
import racingcar.core.common.error.CarErrorCode;
import racingcar.core.common.error.CommonErrorCode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarNameTest {

    @Test
    void 이름이_null일_때() {
        //given
        String inputCarName = null;

        //when
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    new CarName(inputCarName);
                });

        // then
        assertEquals(CommonErrorCode.NOT_ALLOW_NULL.getErrorMessage(),
                exception.getMessage());
    }

    @Test
    void 이름이_empty일_때() {
        //given
        String inputCarName = "       ";

        //when
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    new CarName(inputCarName);
                });

        // then
        assertEquals(CommonErrorCode.NOT_ALLOW_EMPTY.getErrorMessage(),
                exception.getMessage());
    }

    @Test
    void 이름_길이가_6자_이상() {
        //given
        String inputCarName = "123456";

        //when
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    new CarName(inputCarName);
                });

        // then
        assertEquals(CarErrorCode.CAR_NAME_OVER_MAX_LENGTH.getErrorMessage(),
                exception.getMessage());
    }
}