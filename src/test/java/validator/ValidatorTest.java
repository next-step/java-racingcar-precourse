package validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    void testValidNameLength() {
        // given
        String[] testCars = {"pobi", "jun", "eclipse"};

        // when // then
        assertThrows(IllegalArgumentException.class, () ->
                Validator.validNameLength(testCars));
    }

    @Test
    void testValidRacingCount1() {
        // given
        long testLongCount = Integer.MAX_VALUE;
        testLongCount += 1;
        String testStringCount = testLongCount + "";
        // when // then
        assertThrows(IllegalArgumentException.class, () ->
                Validator.validRacingCount(testStringCount));
    }

    @Test
    void testValidRacingCount2() {
        // given
        String testStringCount = "-1";
        // when // then
        assertThrows(IllegalArgumentException.class, () ->
                Validator.validRacingCount(testStringCount));
    }
}