package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void findWinnerCars() {
        List<Car>  initCars = new ArrayList<>();
        Car car1 = new Car(new Name("pobi"), new Position(2));
        Car car2 = new Car(new Name("june"), new Position(1));
        Car car3 = new Car(new Name("chang"), new Position(4));
        Car car4 = new Car(new Name("yang"), new Position(3));

        initCars.add(car1);
        initCars.add(car2);
        initCars.add(car3);
        initCars.add(car4);

        Cars cars = new Cars(initCars);

        assertThat(cars.findWinnerCars()).containsExactly(car3);
    }

    @Test
    void moveCars() {
        List<Car>  initCars = new ArrayList<>();
        Car car1 = new Car("pobi");
        Car car2 = new Car("june");
        Car car3 = new Car("chang");
        Car car4 = new Car("yang");

        initCars.add(car1);
        initCars.add(car2);
        initCars.add(car3);
        initCars.add(car4);

        Cars cars = new Cars(initCars);

        cars.moveCars();
    }
}