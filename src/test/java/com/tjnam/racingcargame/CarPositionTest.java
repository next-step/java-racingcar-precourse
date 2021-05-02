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

    @Test
    public void positionMoveTest(){
        int expectedPosition = 100;
        for (int i=0 ; i<100 ; i++){
            position.move();
        }
        assertThat(position.getPosition()).isEqualTo(100);
    }
}
