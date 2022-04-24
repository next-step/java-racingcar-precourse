package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {

    private Car car;

    @BeforeEach
    void Car() {
        car = new Car(new CarName("shin"));
    }

    @Test
    void 자동차_전진_검증() {
        car.moveForward(CarStatus.GO);

        assertAll(
                () -> assertThat(car.getPosition()).isEqualTo("-"),
                () -> assertThat(car.getDistance()).isEqualTo(1)
        );
    }

    @Test
    void 자동차_이름_검증() {
        CarName carName = new CarName("shin");
        assertThat(car.getName()).isEqualTo(carName);
    }
}