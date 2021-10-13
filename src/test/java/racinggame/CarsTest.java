package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    public void get_winner_test() {
        Car firstCar = new Car("pobi", 3);
        Car secondCar = new Car("anrod", 2);
        Car thirdCar = new Car("sam", 1);

        List<Car> racingCars = Arrays.asList(firstCar, secondCar, thirdCar);
        Cars cars = new Cars(racingCars);
        assertThat(cars.getWinner()).containsExactly(firstCar);
    }
}
