package com.bistros.racing.game;

import com.bistros.racing.domain.PlayingCar;
import com.bistros.racing.domain.PositionLead;
import com.bistros.racing.domain.TestCar;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PlayingCarTest {

    @Test
    void playingcar_diff_position() {
        PlayingCar testPlaying1 = new PlayingCar(new TestCar("test1"));
        testPlaying1.tryMove();
        testPlaying1.tryMove();

        PlayingCar testPlaying2 = new PlayingCar(new TestCar("test2"));
        testPlaying2.tryMove();

        PlayingCar testPlaying3 = new PlayingCar(new TestCar("test3"));
        testPlaying3.tryMove();
        testPlaying3.tryMove();

        assertAll(
            () -> assertThat(testPlaying1.status(testPlaying2)).isEqualTo(PositionLead.LEAD),
            () -> assertThat(testPlaying2.status(testPlaying1)).isEqualTo(PositionLead.BEHIND),

            () -> assertThat(testPlaying1.status(testPlaying3)).isEqualTo(PositionLead.TIE)
        );
    }


}