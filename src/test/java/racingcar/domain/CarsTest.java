package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    void 자동차_1대_입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> Cars.checkCarsSize(1));
    }

    @Test
    void 우승자_위치_조회() {
        Car car = new Car("aaaa");
        car.moveForward();
        List<Car> carList = Arrays.asList(car, new Car("bbb"), new Car("ccc"));
        Cars cars = new Cars(carList);
        assertThat(cars.getWinnerPosition()).isEqualTo(1);
    }
}