package com.tjnam.racingcargame;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarPositionTest {

    private static CarPosition position;

    @BeforeAll
    public static void setUp(){
        position = new CarPosition();
    }

    @Test
    public void initialPositionTest() {
        assertThat(position.getPosition()).isEqualTo(0);
    }
}
