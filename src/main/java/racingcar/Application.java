package racingcar;

import racingcar.controller.Game;
import racingcar.controller.RacingCarGame;

public class Application {

    private static final Game game = RacingCarGame.getInstance();

    public static void main(String[] args) {
        game.run();
    }
}
