package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingUtilsTest {

    List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();

    }

    private Car makeCarForTest(String carName, int numberOfGoForward, int numberOfStay) {
        Car car = new Car(carName);
        makePath(car, numberOfGoForward, numberOfStay);
        return car;
    }

    private void makePath(Car car, int numberOfGoForward, int numberOfStay) {
        for (int i = 0; i < numberOfGoForward; i++) {
            car.move(4);
        }
        for (int i = 0; i < numberOfStay; i++) {
            car.move(0);
        }
    }

    @Test
    void getWinnersTest() {
        cars.add(makeCarForTest("pobi", 3, 2));
        cars.add(makeCarForTest("woni", 4, 1));
        cars.add(makeCarForTest("jun", 4, 1));
        assertThat(RacingUtils.getWinners(cars)).containsOnly("woni","jun");
    }
}