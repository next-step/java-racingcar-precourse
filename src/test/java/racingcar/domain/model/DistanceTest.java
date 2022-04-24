package racingcar.domain.model;

import org.junit.jupiter.api.Test;
import racingcar.core.common.error.DistanceErrorCode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DistanceTest {

    @Test
    void 음수값_체크() {
        //given
        int inputDistance = -1;

        //when
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    new Distance(inputDistance);
                });

        // then
        assertEquals(DistanceErrorCode.ONLY_ALLOW_POSITIVE_VALUE.getErrorMessage(),
                exception.getMessage());
    }
}