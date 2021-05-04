package com.racingcar;

import com.racingcar.domain.MovingCondition;
import com.racingcar.service.RacingCarGame;
import com.racingcar.util.RacingCarRandomGenerator;
import com.racingcar.util.RandomGenerator;

public class Launcher {

    public static void main(String[] args) {
        RandomGenerator<MovingCondition> randomGenerator = new RacingCarRandomGenerator();
        RacingCarGame racingCarGame = new RacingCarGame(randomGenerator);

        racingCarGame.playRacingCarGame();
    }
}
