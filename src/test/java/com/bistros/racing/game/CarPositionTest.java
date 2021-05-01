package com.bistros.racing.game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarPositionTest {

    @Test
    void testPosition() {
        CarPosition position1 = new CarPosition();
        position1.increasePosition();
        position1.increasePosition();
        assertThat(position1.getPosition()).isEqualTo(2);
    }

    @Test
    void testPositionCompare() {
        CarPosition position1 = new CarPosition();
        position1.increasePosition();
        position1.increasePosition();

        CarPosition position2 = new CarPosition();
        position2.increasePosition();
        assertThat(position1.compareTo(position2)).isEqualTo(1);
    }

}