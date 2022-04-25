package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.dto.Car;
import racingcar.dto.CarName;
import racingcar.dto.CarStatus;
import racingcar.dto.Cars;
import racingcar.dto.RaceResult;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new CarName("car1"));
    }

    @Test
    void RUN_OR_STOP() {
        assertThat(car.operate(9)).isEqualTo(CarStatus.MOVING_FORWARD);
        assertThat(car.operate(4)).isEqualTo(CarStatus.MOVING_FORWARD);
        assertThat(car.operate(3)).isEqualTo(CarStatus.STOP);
        assertThat(car.operate(0)).isEqualTo(CarStatus.STOP);
    }

    @Test
    void RUN_RESULT() {
        car.operate(9);
        car.operate(7);
        car.operate(0);

        assertThat(car.getRun()).isEqualTo(2);
        assertThat(car.getStop()).isEqualTo(1);
    }

    @Test
    void RACE() {
        String joinCars = "carA,carB,carC";
        Cars cars = new Cars();
        cars.ready(joinCars);

        RaceResult result = new RaceResult("5");
        result.start(cars);
    }
}
