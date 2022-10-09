package racingcar.model.laps;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LapsValidatorTest {
    @Test
    void 인식_문자열() {
        try {
            LapsValidator.assertValid("1");
            assertTrue(Boolean.TRUE);
        } catch (IllegalArgumentException e) {
            fail("Illegal number error occurred.");
        }
    }

    @Test
    void 인식_숫자() {
        try {
            LapsValidator.assertValid(1);
            assertTrue(Boolean.TRUE);
        } catch (IllegalArgumentException e) {
            fail("Illegal number error occurred.");
        }
    }

    @Test
    void 인식_예외_숫자_아님() {
        String[] errorStrings = new String[]{"a", "ㄱ", "+", "-"};
        this.assertNotAcceptableStringsThrowException(errorStrings, NumberFormatException.class);
    }

    @Test
    void 인식_예외_숫자_범위_벗어남() {
        String[] errorStrings = new String[]{"-1", "0",
                String.valueOf(Long.parseLong(String.valueOf(Integer.MAX_VALUE)) + 1)};
        this.assertNotAcceptableStringsThrowException(errorStrings, IllegalArgumentException.class);
    }

    private <T extends Exception> void assertNotAcceptableStringsThrowException(String[] errorStrings, Class<T> e) {
        for (String errorString : errorStrings) {
            assertThatThrownBy(() -> LapsValidator.assertValid(errorString)).isInstanceOf(e);
        }
    }
}
