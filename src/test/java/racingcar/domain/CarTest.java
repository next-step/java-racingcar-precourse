package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    private static final String TEST_NAME_NORMAL = "MARS";
    private static final String TEST_NAME_OVER = "NEPTUNE";
    private static final String TEST_NAME_EMPTY = "";

    @Test
    void 자동차명_정상길이() {
        CarName carName = new CarName(TEST_NAME_NORMAL);
        assertThat(carName.getName()).isEqualTo(TEST_NAME_NORMAL);
    }

    @Test
    void 자동차명_길이_6() {
        assertThatThrownBy(() -> new CarName(TEST_NAME_OVER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차명_길이_0() {
        assertThatThrownBy(() -> new CarName(TEST_NAME_EMPTY))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차명_NULL() {
        assertThatThrownBy(() -> new CarName(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

}