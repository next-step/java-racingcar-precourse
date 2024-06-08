package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 자동차_전진() {
        Car car = new Car("jiho");
        car.moveCurPosition();
        assertEquals(1, car.getCurPosition());
    }
}