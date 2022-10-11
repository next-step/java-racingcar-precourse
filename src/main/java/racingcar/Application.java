package racingcar;

import racingcar.common.util.Output;
import racingcar.race.RacingCarGame;

public class Application {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();

        racingCarGame.start();
    }
}
