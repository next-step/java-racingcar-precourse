package validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {
    @Test
    void testValidNameLength1() {
        // given
        String[] testCars = {"pobi", "jun", "eclipse"};

        // when // then
        assertThatThrownBy(() ->
                Validator.validNameLength(testCars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testValidRacingCount1() {
        // given
        long testLongCount = Integer.MAX_VALUE;
        testLongCount += 1;
        String testStringCount = testLongCount + "";
        // when // then
        assertThatIllegalArgumentException().isThrownBy(() ->
                Validator.validRacingCount(testStringCount));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "asdf"})
    void testValidRacingCount2(String candidate) {
        // given
        // when // then
        assertThatIllegalArgumentException().isThrownBy(() ->
                Validator.validRacingCount(candidate));
    }
}