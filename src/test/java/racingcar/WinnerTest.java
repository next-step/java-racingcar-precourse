package racingcar;

import main.java.racingcar.domain.Car;
import main.java.racingcar.domain.CarName;
import main.java.racingcar.domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {
    @DisplayName("우승자가 1명만 있는 경우 리스트에는 한 명만 있다.")
    @Test
    void getSingleWinnerTest() {
        Car car1 = new Car(new CarName("car1"));
        Car car2 = new Car(new CarName("car2"));
        Car car3 = new Car(new CarName("car3"));

        Cars cars = new Cars(List.of(car1, car2, car3));

        car1.moveForwardIfTrue(true);
        car2.moveForwardIfTrue(false);
        car3.moveForwardIfTrue(false);

        List<Car> winner = cars.getWinnerList();

        assertThat(winner).containsExactly(car1);
    }

    @DisplayName("우승자가 1명만 있는 경우 리스트에는 한 명만 있다.")
    @Test
    void getDoubleWinnerTest() {
        Car car1 = new Car(new CarName("car1"));
        Car car2 = new Car(new CarName("car2"));
        Car car3 = new Car(new CarName("car3"));

        Cars cars = new Cars(List.of(car1, car2, car3));

        car1.moveForwardIfTrue(true);
        car2.moveForwardIfTrue(true);
        car3.moveForwardIfTrue(false);

        List<Car> winner = cars.getWinnerList();

        assertThat(winner).containsExactly(car1, car2);
    }

    @DisplayName("우승자가 1명만 있는 경우 리스트에는 한 명만 있다.")
    @Test
    void getTripleWinnerTest() {
        Car car1 = new Car(new CarName("car1"));
        Car car2 = new Car(new CarName("car2"));
        Car car3 = new Car(new CarName("car3"));

        Cars cars = new Cars(List.of(car1, car2, car3));

        car1.moveForwardIfTrue(true);
        car2.moveForwardIfTrue(true);
        car3.moveForwardIfTrue(true);

        List<Car> winner = cars.getWinnerList();

        assertThat(winner).containsExactly(car1, car2, car3);
    }
}
