package com.tjnam.racingcargame;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTimeTest {

    private static RacingTime racingTime;
    private static int racingTimeValue = 50;

    @BeforeAll
    public static void setUp(){
        racingTime = new RacingTime(racingTimeValue);
    }

    @Test
    public void initializedTest(){
        RacingTime racingTimeTester = new RacingTime(racingTimeValue);
        assertThat(racingTimeTester.getRemained()).isEqualTo(racingTimeValue);
    }

    @Test
    public void useTest(){
        RacingTime racingTimeTester = new RacingTime(racingTimeValue);
        racingTimeTester.use();
        assertThat(racingTimeTester.getRemained()).isEqualTo(racingTimeValue-1);
        racingTimeTester.use();
        assertThat(racingTimeTester.getRemained()).isEqualTo(racingTimeValue-2);
    }

    @Test
    public void getRemainedTest(){
        int three = 3;
        RacingTime racingTimeTester = new RacingTime(three);
        racingTimeTester.use();
        assertThat(racingTimeTester.getRemained()).isEqualTo(three-1);
        racingTimeTester.use();
        assertThat(racingTimeTester.getRemained()).isEqualTo(three-2);
        racingTimeTester.use();
        assertThat(racingTimeTester.getRemained()).isEqualTo(three-3);
    }

}
