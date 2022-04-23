package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class AttemptsNumberTest {
    private static final String TEST_VALUE_NORMAL = "5";
    private static final String TEST_VALUE_EMPTY = "";
    private static final String TEST_VALUE_MINUS = "-10";
    private static final String TEST_VALUE_NOT_NUMERIC = "A30";

    private static final int TEST_RESULT_NORMAL = 5;

    @Test
    void 시도회수_정상값() {
        AttemptsNumber number = new AttemptsNumber(TEST_VALUE_NORMAL);
        assertThat(number.getAttemptsNumber()).isEqualTo(TEST_RESULT_NORMAL);
    }

    @Test
    void 시도회수_빈값() {
        assertThatThrownBy(() -> new AttemptsNumber(TEST_VALUE_EMPTY))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도회수_음수() {
        assertThatThrownBy(() -> new AttemptsNumber(TEST_VALUE_MINUS))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도회수_문자입력() {
        assertThatThrownBy(() -> new AttemptsNumber(TEST_VALUE_NOT_NUMERIC))
                .isInstanceOf(IllegalArgumentException.class);
    }

}