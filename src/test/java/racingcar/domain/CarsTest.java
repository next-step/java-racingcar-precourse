package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void Cars_생성() {
        Cars cars = new Cars();

        assertThat(cars).isInstanceOf(Cars.class);
    }

    @Test
    void 참가자동차_추가() {
        Cars cars = new Cars(Arrays.asList("a","b","c"));

        assertThat(cars).isEqualTo(new Cars(Arrays.asList("a","b","c")));
    }

    @Test
    @DisplayName("한라운드_시작")
    void race() {
        Cars cars = new Cars(Arrays.asList("a","b"));
        cars.raceOneRound(new int[] {1,9});

        Cars comparison = new Cars();
        comparison.addCar(new Car("a", 0));
        comparison.addCar(new Car("b", 1));

        assertThat(cars).isEqualTo(comparison);
    }

    @Test
    @DisplayName("우승자_찾기")
    void findWinners() {
        Cars cars = new Cars(Arrays.asList("a","b","c"));
        cars.raceOneRound(new int[] {1,9,5});
        cars.raceOneRound(new int[] {0,9,6});
        cars.raceOneRound(new int[] {3,8,7});

        assertThat(cars.findWinners()).isEqualTo(Arrays.asList(new Car("b",3), new Car("c", 3)));
    }


}