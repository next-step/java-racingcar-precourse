package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.domain.CarPosition;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 위치")
class CarPositionTest {

    @DisplayName("자동차 위치의 초기값은 0이다.")
    @Test
    void createCarPosition() {
        CarPosition position = new CarPosition();
        assertThat(position).isEqualTo(new CarPosition(0));
    }

    @DisplayName("자동차 위치는 음수값을 가질 수 없다.")
    @Test
    void createNegativePosition() {
        assertThatThrownBy(() -> new CarPosition(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차의 위치는 음수일 수 없습니다.");
    }
}
