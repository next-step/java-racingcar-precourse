package racinggame.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceValidationTest {

    @Test
    void 숫자_확인() {
        boolean actual =  RaceValidation.isNumber("3");

        assertEquals(true, actual);
    }

    @Test
    void 시도_횟수_확인() {
        boolean actual =  RaceValidation.validTryCount("1");

        assertEquals(true, actual);
    }
}