package racingcar.domain.car.vo;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class RoundTest {

    @Test
    void 인스턴스가_생성된다() {
        assertThatCode(() -> new Round(1))
            .doesNotThrowAnyException();
    }

    @Test
    void 음수일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Round(-1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 최소 1회차는 진행해야 합니다.");
    }
}
