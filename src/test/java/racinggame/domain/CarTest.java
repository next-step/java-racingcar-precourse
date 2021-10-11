package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {

    private Car car;

    @BeforeEach
    void Car() {
        car = new Car(new CarName("shin"));
    }

    @Test
    @DisplayName("자동차는 전진할 수 있다")
    void go() {
        car.moveForward(CarStatus.GO);

        assertAll(
                () -> assertThat(car.getPosition()).isEqualTo("-"),
                () -> assertThat(car.getDistance()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("각 자동차는 이름을 가질 수 있다")
    void create_car_name() {
        CarName carName = new CarName("shin");
        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    @DisplayName("자동차 이름과 바가 같이 출력한다")
    void name_with_bars_print() {
        car.moveForward(CarStatus.GO);
    }
}