package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    private Car shinCar = new Car(new CarName("shin"));
    private Car hanCar = new Car(new CarName("han"));
    private Car studyCar = new Car(new CarName("study"));

    @Test
    @DisplayName("가장 멀리간 차들을 찾는다")
    void find_farthest_distance() {
        Cars cars = new Cars(Arrays.asList(shinCar, hanCar, studyCar));
        cars.moveCars(Arrays.asList(5, 3, 6));
        cars.moveCars(Arrays.asList(5, 2, 7));
        cars.moveCars(Arrays.asList(5, 8, 8));

        Winner winner = new Winner(cars.getCars());
        assertThat(winner.findWinningCars()).containsAll(Arrays.asList(new CarName("shin"), new CarName("study")));
    }
}