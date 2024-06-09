package racingcar;

import main.java.racingcar.domain.Car;
import main.java.racingcar.domain.CarName;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingTest {

    @DisplayName("움직이지 않으면 위치는 0이다.")
    @Test
    void moveFailTest() {
        Car car = new Car(new CarName("car"));
        assertThat(car.isSamePosition(0)).isTrue();
    }

    @DisplayName("자동차가 1회 움직이면 위치는 1이다.")
    @Test
    void moveSuccessTest() {
        Car car = new Car(new CarName("car"));
        car.moveForwardIfTrue(true);
        assertThat(car.isSamePosition(1)).isTrue();
    }

    @DisplayName("자동차와 위치가 다른 경우 isSamePosition은 false이다.")
    @Test
    void moveSamePositionFailTest() {
        Car car = new Car(new CarName("car"));
        car.moveForwardIfTrue(true);
        car.moveForwardIfTrue(true);
        assertThat(car.isSamePosition(1)).isFalse();
    }
}
