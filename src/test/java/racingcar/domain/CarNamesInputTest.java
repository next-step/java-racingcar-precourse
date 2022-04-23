package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarNamesInputTest {
    private static final String TEST_VALUE_NORMAL = "mars,earth,moon,pluto";
    private static final String TEST_NAME_EMPTY = " ";

    @Test
    void 자동차명_입력값_정상() {
        CarNamesInput carNamesInput = new CarNamesInput(TEST_VALUE_NORMAL);
        assertThat(carNamesInput.getNames()).isEqualTo(TEST_VALUE_NORMAL);
    }

    @Test
    void 자동차명_입력값_빈값() {
        assertThatThrownBy(() -> new CarNamesInput(TEST_NAME_EMPTY))
                .isInstanceOf(IllegalArgumentException.class);
    }
}