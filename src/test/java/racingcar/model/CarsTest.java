package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.CarFactory;

public class CarsTest {

    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";

    private Car always50MoveCar;
    private Car always10MoveCar;
    private Car alwaysNonMovableCar;
    private Car alwaysStopCar;

    @BeforeEach
    void setUp() {
        always50MoveCar = CarFactory.getCar("giant", () -> Distance.from(50), () -> true);
        always10MoveCar = CarFactory.getCar("big", () -> Distance.from(10), () -> true);
        alwaysNonMovableCar = CarFactory.getCar("non", () -> Distance.from(10), () -> false);
        alwaysStopCar = CarFactory.getCar("stop", () -> Distance.ZERO, () -> true);
    }

    @Test
    void nullCarNames() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> CarFactory.getDefaultCars((String) null))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @Test
    void emptyCarNames() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> CarFactory.getDefaultCars(""))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @Test
    void containsInvalidCarName() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> CarFactory.getDefaultCars("with, null, beth, , foo, foobar"))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void move(final int count) {
        final Cars cars = CarFactory.getCars(
            Arrays.asList(always50MoveCar, always10MoveCar, alwaysNonMovableCar, alwaysStopCar));

        for (int i = 0; i < count; i++) {

            Distance prevAlways50MoveCarDistance = always50MoveCar.getDistance();
            Distance prevAlways10MoveCarDistance = always10MoveCar.getDistance();

            cars.move();

            assertThat(always50MoveCar.getDistance()).
                isEqualTo(prevAlways50MoveCarDistance.plus(Distance.from(50)));
            assertThat(always10MoveCar.getDistance())
                .isEqualTo(prevAlways10MoveCarDistance.plus(Distance.from(10)));

            assertThat(alwaysNonMovableCar.getDistance())
                .isEqualTo(Distance.ZERO);
            assertThat(alwaysStopCar.getDistance())
                .isEqualTo(Distance.ZERO);

            prevAlways50MoveCarDistance = always50MoveCar.getDistance();
            prevAlways10MoveCarDistance = always10MoveCar.getDistance();
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void getFarthestMoved_singleCar_zeroDistance(final int count) {
        final Cars cars = CarFactory.getCars(Collections.singletonList(alwaysStopCar));
        for (int i = 0; i < count; i++) {
            cars.move();
        }
        assertThat(cars.getFarthestMovedCars().size()).isEqualTo(1);
        assertThat(cars.getFarthestMovedCars()).containsOnly(alwaysStopCar);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void getFarthestMoved_singleCar_nonZeroDistance(final int count) {
        final Cars cars = CarFactory.getCars(Collections.singletonList(always50MoveCar));
        for (int i = 0; i < count; i++) {
            cars.move();
        }
        assertThat(cars.getFarthestMovedCars().size()).isEqualTo(1);
        assertThat(cars.getFarthestMovedCars()).containsOnly(always50MoveCar);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void getFarthestMoved_sameDistanceCars(final int count) {
        final Car otherAlways50MoveCar = CarFactory.getCar("fifty",
            () -> Distance.from(50), () -> true);
        final Cars cars = CarFactory.getCars(Arrays.asList(always50MoveCar, otherAlways50MoveCar));
        for (int i = 0; i < count; i++) {
            cars.move();
        }
        assertThat(cars.getFarthestMovedCars().size()).isEqualTo(2);
        assertThat(cars.getFarthestMovedCars()).containsOnly(always50MoveCar, otherAlways50MoveCar);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void getFarthestMoved_differentDistanceCars(final int count) {
        final Cars cars = CarFactory.getCars(
            Arrays.asList(alwaysNonMovableCar, always50MoveCar, always10MoveCar));
        for (int i = 0; i < count; i++) {
            cars.move();
        }
        assertThat(cars.getFarthestMovedCars().size()).isEqualTo(1);
        assertThat(cars.getFarthestMovedCars()).containsOnly(always50MoveCar);
    }

}
