package model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
}
