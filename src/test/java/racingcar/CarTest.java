package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    String inputName = "poly";
    CarName carName = CarName.createCarName(inputName);

    @Test
    @DisplayName("차가 전진하면 이동거리가 1 증가한다")
    void forwardTest() {
        // given
        Car car = Car.createCar(carName);

        // when
        car.goForward();

        // then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("주어진 값이 4 이상이면 전진, 3 이하면 멈춘다")
    void goOrNotTest() {
        // given
        Car car = Car.createCar(carName);

        // when
        car.goOrNot(4);
        car.goOrNot(3);

        // then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("차는 주어진 값으로 이름을 갖고 생성된다.")
    void carHasNameWhenCreated() {
        // given
        String testerName = "morph";
        CarName carTestName = CarName.createCarName(testerName);

        // when
        Car car = Car.createCar(carTestName);

        // then
        assertThat(car.getCarNameString()).isEqualTo(testerName);
    }
}
