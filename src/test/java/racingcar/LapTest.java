package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LapTest {

    @Test
    void winner_is_ram() {
        // given
        Car ramCar = new Car("ram");
        ramCar.drive(6);
        Car beanCar = new Car("bean");
        beanCar.drive(2);
        Car hancCar = new Car("hanc");
        hancCar.drive(2);

        Cars cars = new Cars(Arrays.asList(ramCar, beanCar, hancCar));
        Lap lap = new Lap(cars);

        // when
        List<Car> winners = lap.getWinners();

        // then
        assertEquals(1, winners.size());
        assertEquals(ramCar, winners.get(0));
    }

    @Test
    void winner_is_everyone() {
        // given
        Car ramCar = new Car("ram");
        ramCar.drive(6);
        Car beanCar = new Car("bean");
        beanCar.drive(7);
        Car hancCar = new Car("hanc");
        hancCar.drive(8);

        Cars cars = new Cars(Arrays.asList(ramCar, beanCar, hancCar));
        Lap lap = new Lap(cars);

        // when
        List<Car> winners = lap.getWinners();

        // then
        assertEquals(3, winners.size());
    }

}