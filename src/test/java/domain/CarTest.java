package domain;

import domain.strategy.RacingCarStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @ParameterizedTest
    @DisplayName("자동차 이름이 5자리수 이하인지 테스트")
    @ValueSource(strings = {"hiImCar"})
    void 자동차_이름_자리수_검증(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름에 space 값이 들어오는 경우 예외처리 확인")
    @ValueSource(strings = {" ", "  hi"})
    void 자동차_이름_스페이스값_검증(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("레이싱 카가 더이상 움직일 수 없는 경우 예외 처리확인")
    void 레이싱카_움직임_범위_제한() {
        Moving car = new Car("test");
        assertThatThrownBy(() ->
                car.setMovableStrategy(new RacingCarStrategy(Integer.MAX_VALUE))
        ).isInstanceOf(IndexOutOfBoundsException.class);

    }

    @Test
    @DisplayName("이동시 주어지는 숫자가 올바른 범위(0-9)가 아니라면 예외 발생 테스트")
    void 이동_숫자_범위_검증() {
        Moving car = new Car("test");
        car.setMovableStrategy(new RacingCarStrategy());
        assertThatThrownBy(() -> car.move(100))
                .isInstanceOf(IllegalArgumentException.class);

    }


}
