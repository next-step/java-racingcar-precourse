package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 경주_최고점수_테스트() {
        Car car1 = new Car("a", 3);
        Car car2 = new Car("b", 4);
        Car car3 = new Car("c", 7);
        Car car4 = new Car("d", 3);

        Cars cars = new Cars();
        cars.addCar(car1);
        cars.addCar(car2);
        cars.addCar(car3);
        cars.addCar(car4);

        assertThat(cars.getWinnersDistance()).isEqualTo(7);
    }
}
