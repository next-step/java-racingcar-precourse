package racingcar.controller;

import racingcar.model.RacingGame;

public class RacingGameController {

    private RacingGame game;

    public RacingGameController(RacingGame game) {
        this.game = game;
    }

    public void run() {
        game.init();
        game.run();
    }

}
