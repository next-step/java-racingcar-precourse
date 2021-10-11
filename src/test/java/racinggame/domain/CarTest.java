package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @DisplayName("전달 받은 이름으로 자동차 이름을 가져올 수 있는지 테스트")
    @Test
    void getName_success() {
        assertThat(new Car(new Name("test")).getName()).isEqualTo(new Name("test"));
    }

    @DisplayName("자동차 이름 5글자 이하일 때 성공 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    void constructCar_successWhenNameLengthIs5OrLess(String name) {
        new Car(new Name(name));
    }

    @DisplayName("자동차 동작상태에 따라 전진 또는 멈추는지 테스트")
    @Test
    void moveForwardOrStop_success() {
        Car car = new Car(new Name("test"));
        car.moveForwardOrStop(MoveStatus.STOP);
        assertThat(car.getStep()).isEqualTo(new Step(0));
        car.moveForwardOrStop(MoveStatus.FORWARD);
        assertThat(car.getStep()).isEqualTo(new Step(1));
    }
}
