package model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @ParameterizedTest
    @DisplayName("is car created with name and distance 0?")
    @ValueSource(strings = { "pobi", "woni", "jun", "aabbcc" })
    void testCarCreate(String carName) {
        Car car = new Car(carName);
        assertTrue(carName.equals(car.getName()));
        assertTrue(car.getDistance() == 0);
    }

    static Stream<Arguments> provideTryCountAndCar() {
        return Stream.of(Arguments.of(1, new Car("pobi")), Arguments.of(2, new Car("woni")),
                Arguments.of(3, new Car("jun")), Arguments.of(4, new Car("aabbcc")));
    }

    @ParameterizedTest
    @DisplayName("distance of car is increased by 1 when car moves")
    @MethodSource("provideTryCountAndCar")
    void testCarMove(Integer tryCount, Car car) {
        for (int i = 0; i < tryCount; i++) {
            car.move();
        }
        assertTrue(car.getDistance() == tryCount);
    }
}
