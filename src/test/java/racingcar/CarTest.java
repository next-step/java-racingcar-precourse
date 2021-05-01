package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @DisplayName("이름을 가지는 자동차를 생성할 수 있어야 한다.")
    @Test
    void create_car_object() {
        Car car = new Car("car");
    }

    @DisplayName("자동차 이름은 최소 1글자 최대 5자 여야한다.")
    @ValueSource(strings = {"123456", "", "   "})
    @ParameterizedTest
    void car_name_validation(String name) {
        assertThatThrownBy(() -> {
            new Car(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }

    @DisplayName("자동차의 전진 또는 멈춤 여부를 판단할 수 있어야 한다.")
    @CsvSource(value = {"1:false", "3:false", "4:true", "9:true"}, delimiter = ':')
    @ParameterizedTest
    void car_movable(int num, boolean expected) {
        Car car = new Car("car");
        assertThat(car.isMovable(num)).isEqualTo(expected);
    }

    @DisplayName("자동차가 전진할 때마다다 이동 거리를 가지고 있어야 한다.")
    @Test
    void car_position() {
        Car car = new Car("car");
        car.isMovable(5);
        car.isMovable(3);
        car.isMovable(4);
        assertThat(car.getPosition()).isEqualTo(2);
    }
}
