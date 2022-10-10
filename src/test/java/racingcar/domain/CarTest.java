package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차는 4 이상 일때 전진 할 수 있다.")
    void moveCar() {
        Car car = new Car("yb");
        String carText = car.move(4);

        assertThat(carText).isEqualTo("yb : -");
    }

    @Test
    @DisplayName("자동차는 3 이하 일때 전진 할 수 없다.")
    void stopCar() {
        Car car = new Car("yb");
        String carText = car.move(3);

        assertThat(carText).isEqualTo("yb : ");
    }
}