package com.tjnam.racingcargame;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    private static RacingGame racingGame;

    @BeforeAll
    public static void setUp(){
        racingGame = new RacingGame();
    }

    @Test
    public void startTest(){
        racingGame.start();
        return;
    }

}
