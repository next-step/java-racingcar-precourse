package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarName;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @Test
    void 자동차_이름은_이름은_5자이하만_가능하다() {
        final String 올바른_이름 = "자동차이름";

        assertThatNoException().isThrownBy(() -> new CarName(올바른_이름));
    }

    @Test
    void 자동차_이름은_5자초과할_경우_예외를_던진다() {
        final String 올바르지_않은_이름 = "무효한 자동차이름";

        assertThatThrownBy(() -> new CarName(올바르지_않은_이름))
                .isInstanceOf(IllegalArgumentException.class);

    }

}