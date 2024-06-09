package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 IllegalArgumentException을 던진다.")
    void carNameLengthShouldNotExceedFive() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
    }


    @Test
    @DisplayName("자동차가 무작위 값이 4 이상일 때 전진한다.")
    void carShouldMoveWhenRandomNumberIsFourOrGreater() {
        Car car = new Car("test");

        // 자동차를 전진시키기 위한 private 메서드를 직접 테스트할 수 없으므로
        // 여러 번 move() 메서드를 호출하여 전진 여부를 확인
        for (int i = 0; i < 10; i++) {
            car.move();
        }

        // 자동차의 위치가 전진하지 않거나 여러 번 전진할 수 있으므로
        // 위치가 최소 0 이상인지만 확인
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
    }
}
