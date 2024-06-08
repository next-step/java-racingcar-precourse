package game.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarTest {

    @ParameterizedTest(name = "{0}은 난수 {1} 일 때 전진합니다")
    @MethodSource("getMovableCar")
    void movableCar(Car car, int movementValue) {
        assertThat(car.getPosition()).isEqualTo(0);
        assertThat(car.move(movementValue)).isEqualTo(1);
    }

    @ParameterizedTest(name = "{0}은 난수 {1} 일 때 전진하지 않습니다")
    @MethodSource("getUnmovableCar")
    void unmovableCar(Car car, int movementValue) {
        assertThat(car.getPosition()).isEqualTo(0);
        assertThat(car.move(movementValue)).isEqualTo(0);
    }

    static Stream<Arguments> getMovableCar() {
        return Stream.of(
            Arguments.arguments(new Car("enzo"), 4),
            Arguments.arguments(new Car("enzo"), 5),
            Arguments.arguments(new Car("enzo"), 6),
            Arguments.arguments(new Car("enzo"), 7),
            Arguments.arguments(new Car("enzo"), 8),
            Arguments.arguments(new Car("enzo"), 9)
        );
    }

    static Stream<Arguments> getUnmovableCar() {
        return Stream.of(
            Arguments.arguments(new Car("enzo"), 0),
            Arguments.arguments(new Car("enzo"), 1),
            Arguments.arguments(new Car("enzo"), 2),
            Arguments.arguments(new Car("enzo"), 3)
        );
    }



}