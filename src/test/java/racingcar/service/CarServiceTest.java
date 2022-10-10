package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarServiceTest {

    @Test
    void 자동차_경주_전진() {
        //given
        Car car = Car.of("bmw");

        //when
        new CarService().move(car, 5);

        //then
        assertThat(car.getMove().getDistance()).isEqualTo(1);
    }

    @Test
    void 자동차_경주_멈춤() {
        //given
        Car car = Car.of("bmw");

        //when
        new CarService().move(car, 3);

        //then
        assertThat(car.getMove().getDistance()).isEqualTo(0);
    }
}
