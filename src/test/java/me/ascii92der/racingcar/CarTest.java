package me.ascii92der.racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void carMove() {
        Car car = new Car("TEST");
        assertThat(car.moveCar(4)).isEqualTo(1);
        assertThat(car.moveCar(3)).isEqualTo(1);
    }

    @Test
    void carCanMove() {
        Car car = new Car("TEST");
        assertThat(car.canMove(4)).isTrue();
        assertThat(car.canMove(3)).isFalse();
    }
}
