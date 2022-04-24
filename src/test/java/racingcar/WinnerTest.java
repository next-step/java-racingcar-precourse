package racingcar;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerTest {
    @Test
    @DisplayName("제일 멀리간 위치값 구하기")
    void maxDistanceTest() {
        Cars cars = new Cars(Arrays.asList(new Car("test1", 10),
                new Car("test2", 8)));
        Assertions.assertThat(cars.winnerDistance()).isEqualTo(new Distance(10));
    }

    @Test
    @DisplayName("최대 거리에 해당하는 차들 구하기")
    void maxDistanceCarsSizeTest() {
        Cars cars = new Cars(Arrays.asList(
                new Car("test1", 10),
                new Car("test2", 8),
                new Car("test1", 10),
                new Car("test1", 9),
                new Car("test1", 5),
                new Car("test1", 8)
        ));

        Cars winnerCars = cars.winnerCars(new Distance(10));
        Assertions.assertThat(winnerCars.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("최대 거리에 해당하는 차들에 거리 최대값 차 포함 여부 확인")
    void maxDistanceCarsTest() {
        Car checkCar = new Car("test1", 10);
        Cars cars = new Cars(Arrays.asList(
                checkCar,
                new Car("test2", 8),
                new Car("test1", 10),
                new Car("test1", 9),
                new Car("test1", 5),
                new Car("test1", 8)
        ));
        Cars winnerCars = cars.winnerCars(new Distance(10));
        Assertions.assertThat(winnerCars.getCars()).contains(checkCar);
    }
}
