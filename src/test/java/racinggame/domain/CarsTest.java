package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    private Car shinCar = new Car(new CarName("shin"));
    private Car hanCar = new Car(new CarName("han"));
    private Cars cars;

    @BeforeEach
    void Cars() {
        cars = new Cars(Arrays.asList(shinCar, hanCar));
    }

    @Test
    @DisplayName("자동차 일급 컬렉션을 생성할 수 있다")
    void create() {
        assertThat(cars.getCars().get(0).getName()).isEqualTo(new CarName("shin"));
        assertThat(cars.getCars().get(1).getName()).isEqualTo(new CarName("han"));
    }

    @Test
    @DisplayName("각 자동차는 4 이상의 값이면 전진, 3 이하의 값이면 멈춘다")
    void go() {
        RacingResult racingResult = cars.moveCars(Arrays.asList(5, 2));
        List<Car> testCars = cars.getCars();

        assertThat(testCars.get(0).getDistance()).isEqualTo(1);
        assertThat(testCars.get(1).getDistance()).isEqualTo(0);
    }
}
