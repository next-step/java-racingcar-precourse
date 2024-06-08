package game.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {

    @ParameterizedTest(name = "{0}의 최대 위치는 {1} 입니다")
    @MethodSource("getCarAndMaxPosition")
    void getMaxPosition(Cars cars, int maxPosition) {
        assertThat(cars.getMaxPosition()).isEqualTo(maxPosition);
    }

    private static Stream<Arguments> getCarAndMaxPosition() {
        int maxPosition = 5;

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("enzo", maxPosition));
        carList.add(new Car("gusto", 3));
        carList.add(new Car("james", 1));

        return Stream.of(
            Arguments.arguments(new Cars(carList), maxPosition)
        );
    }

    @ParameterizedTest(name = "{0}의 경주 결과 승자는 {1}입니다")
    @MethodSource("getCarListAndWinner")
    void findWinner(Cars cars, Cars winners) {
        assertThat(cars.findWinners()).isEqualTo(winners);
    }

    private static Stream<Arguments> getCarListAndWinner() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("enzo", 5));
        carList.add(new Car("gusto", 5));
        carList.add(new Car("james", 1));

        List<Car> winners = new ArrayList<>();
        winners.add(new Car("enzo", 5));
        winners.add(new Car("gusto", 5));

        return Stream.of(
            Arguments.arguments(new Cars(carList), new Cars(winners))
        );
    }

}