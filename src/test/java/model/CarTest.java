package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    @Test
    void testMoveForward1() {
        // given
        Car car = new Car("temp");

        // when
        int number = 4;
        car.moveForward(number);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }
    @Test
    void testMoveForward2() {
        // given
        Car car = new Car("temp");

        // when
        int number = 3;
        car.moveForward(number);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}