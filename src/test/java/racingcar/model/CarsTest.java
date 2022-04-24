package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private Car shinCar = new Car(new CarName("shin"));
    private Car hanCar = new Car(new CarName("han"));
    private Cars cars;

    @BeforeEach
    void Cars() {
        cars = new Cars(Arrays.asList(shinCar, hanCar));
    }

    @Test
    void Cars_생성_검증() {
        assertThat(cars.getCars().get(0).getName()).isEqualTo(new CarName("shin"));
        assertThat(cars.getCars().get(1).getName()).isEqualTo(new CarName("han"));
    }

    @Test
    void 자동차_전진_스톱_검증() {
        RacingResult racingResult = cars.moveCars(Arrays.asList(5, 2));
        List<Car> testCars = cars.getCars();

        assertThat(testCars.get(0).getDistance()).isEqualTo(1);
        assertThat(testCars.get(1).getDistance()).isEqualTo(0);
    }
}
