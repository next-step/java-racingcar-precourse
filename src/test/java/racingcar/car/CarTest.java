package racingcar.car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void CarName을_받아_인스턴스를_생성할_수_있다() {
        assertDoesNotThrow(() -> Car.of(CarName.of("car")));
    }

    @Test
    void CarName이_같다면_동등하다() {
        Car left = Car.of(CarName.of("car"));
        Car right = Car.of(CarName.of("car"));

        assertEquals(left, right);
    }

}