package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Car에 대해 테스트 한다.")
class CarTest {

    @DisplayName("Car를 생성하는데 성공한다.")
    @Test
    void creatingCar() {
        final Car car = Car.of("car");
        assertThat(car.name()).isEqualTo("car");
        assertThat(car.position()).isEqualTo(0);
    }

    @DisplayName("Car를 이동하면 이동한 횟수만큼 이동한다. moveCount={0}")


    @ParameterizedTest(name = "Car는 움직인 만큼 이동한다. loopCount={0}")
    @ValueSource(ints = {0, 1, 2, 10, 100})
    void increment(int loopCount) {
        final Car car = movedCar(loopCount);
        assertThat(car.position()).isEqualTo(loopCount);
    }

    @DisplayName("Car는 오름차순으로 정렬된다.")
    @Test
    void sortedByPosition() {
        final List<Car> cars = Arrays.asList(movedCar(1), movedCar(100),
                                             movedCar(10), movedCar(3),
                                             movedCar(50), movedCar(0));

        Collections.sort(cars);

        assertThat(cars).extracting("position.value")
                        .containsExactly(100, 50, 10, 3, 1, 0);
    }

    private static Car movedCar(int loopCount) {
        final Car car = Car.of(String.valueOf(loopCount));
        for (int i = 0; i < loopCount; i++) {
            car.move();
        }
        return car;
    }
}
