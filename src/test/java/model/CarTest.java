package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 10, 6, 50})
    @DisplayName("자동차가 한칸 전진하거나 멈춰있는지 테스트")
    void Under1InputTest(int input) {
        Car car = new Car(input, "Test");
        car.tryIncreaseNumberOfMove();
        int expected1 = input+1;
        int expected2 = input;
        assertTrue(car.getNumberOfMove() == expected1 || car.getNumberOfMove() == expected2);
    }
}