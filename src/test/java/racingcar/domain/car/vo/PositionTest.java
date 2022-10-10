package racingcar.domain.car.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void 인스턴스가_생성된다() {
        assertThatCode(() -> new Position(1))
            .doesNotThrowAnyException();
    }

    @Test
    void 음수가_들어올_경우_예외가_발생한다() {
        assertThatCode(() -> new Position(-1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] Position의 값은 음수가 될 수 없습니다.");
    }

    @Test
    void 위치가_1_증가한다() {
        final Position zeroPosition = Position.zero();

        final Position onePosition = zeroPosition.increase();
        assertThat(onePosition).isEqualTo(new Position(1));
    }
}
