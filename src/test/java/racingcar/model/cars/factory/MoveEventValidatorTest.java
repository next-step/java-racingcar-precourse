package racingcar.model.cars.factory;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MoveEventValidatorTest {
    @Test
    void 인식_숫자() {
        int[] values = new int[]{0, 1, 9};
        this.assertAcceptable(values);
    }

    @Test
    void 인식_예외_숫자_범위_벗어남() {
        int[] values = new int[]{-1, 10};
        this.assertNotAcceptableThrowException(values);
    }

    private void assertAcceptable(int[] numbers) {
        for (int n : numbers) {
            this.assertAcceptableString(n);
        }
    }

    private void assertAcceptableString(int n) {
        try {
            MoveEventValidator.assertValid(n);
            assertTrue(Boolean.TRUE);
        } catch (IllegalArgumentException e) {
            fail("Illegal value error occurred.");
        }
    }

    private void assertNotAcceptableThrowException(int[] errorNumbers) {
        for (int errorNumber : errorNumbers) {
            assertThatThrownBy(() -> MoveEventValidator.assertValid(errorNumber)).isInstanceOf(
                    IllegalArgumentException.class);
        }
    }
}
