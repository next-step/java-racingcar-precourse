package nextstep.test.car;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.car.utils.CarsUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsUtilTest {
    @Test
    @DisplayName("자동차명_글자수_검증")
    void 자동차명_글자수_성공() {
        assertThat(CarsUtil.validationCarName("abcde")).isTrue();
    }

    @Test
    @DisplayName("자동차명_글자수_검증")
    void 자동차명_글자수_실패_1() {
        assertThat(CarsUtil.validationCarName("abcdef")).isFalse();
    }

    @Test
    @DisplayName("자동차명_글자수_검증")
    void 자동차명_글자수_실패_2() {
        assertThat(CarsUtil.validationCarName("")).isFalse();
    }
}
