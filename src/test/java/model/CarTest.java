package model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @ParameterizedTest
    @DisplayName("distance of car is 0 when car is created")
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void testCarInitialDistance(String carName) {
        Car car = new Car(carName);
        assertTrue(car.getDistance() == 0);
    }

    @ParameterizedTest
    @DisplayName("name of car is same as input")
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void testCarInitialName(String carName) {
        Car car = new Car(carName);
        assertTrue(car.getName().equals(carName));
    }
}
