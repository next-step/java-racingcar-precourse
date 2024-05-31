package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void testMoveForward1() {
        // given
        Car car = new Car("temp");

        // when
        int number = 4;
        car.moveForward(number);

        // then
        assertEquals(car.getPosition(), 1);
    }
    @Test
    void testMoveForward2() {
        // given
        Car car = new Car("temp");

        // when
        int number = 3;
        car.moveForward(number);

        // then
        assertEquals(car.getPosition(), 0);
    }
}