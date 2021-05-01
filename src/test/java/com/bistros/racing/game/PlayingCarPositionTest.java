package com.bistros.racing.game;

import com.bistros.racing.domain.PlayingCarPosition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayingCarPositionTest {

    @Test
    void testPosition() {
        PlayingCarPosition position1 = new PlayingCarPosition();
        position1.increasePosition();
        position1.increasePosition();
        assertThat(position1.getPosition()).isEqualTo(2);
    }

    @Test
    void testPositionCompare() {
        PlayingCarPosition position1 = new PlayingCarPosition();
        position1.increasePosition();
        position1.increasePosition();

        PlayingCarPosition position2 = new PlayingCarPosition();
        position2.increasePosition();
        assertThat(position1.compareTo(position2)).isEqualTo(1);
    }

}