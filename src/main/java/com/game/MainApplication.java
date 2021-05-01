package com.game;

import com.game.racingcar.RacingCarGame;
import com.game.runner.GameRunner;

public class MainApplication {
    public static void main(String[] args) {
        GameRunner.run(new RacingCarGame());
    }
}
