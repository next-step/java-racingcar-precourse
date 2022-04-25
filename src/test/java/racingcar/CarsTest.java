package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private String carNames;

    @BeforeEach
    void setUp() {
        carNames = "test1,test2,tset3";
    }

    @Test
    void carListInitTest() {

        Cars cars = Cars.of(carNames, () -> true);
        for (int i = 0; i < cars.carCount(); i++) {
            assertThat(cars.getCars().get(i).getCarName()).isEqualTo(carNames.split(",")[i]);
        }

        cars.moveCars();

        for (Car car : cars.getCars()) {
            assertThat(car.matchPosition(1)).isTrue();
        }
    }
}