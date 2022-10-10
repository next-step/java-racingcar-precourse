package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.RacingGameView;

public class RacingGameController {
    public void start() {
        RacingGame racingGame = getInputRacers();
        int tryCount = getInputTryCount();

        for (int i = 0; i < tryCount; i++) {
            RacingGameView.printRacers(racingGame.start());
        }
        RacingGameView.printWinner(racingGame);
    }

    private static RacingGame getInputRacers() {
        try {
            return new RacingGame(RacingGameView.inputCars());
        } catch (IllegalArgumentException e) {
            RacingGameView.printError(e.getMessage());
            return getInputRacers();
        }
    }

    private static int getInputTryCount() {
        try {
            return RacingGameView.inputTryCount();
        } catch (Exception e) {
            RacingGameView.printError(e.getMessage());
            return getInputTryCount();
        }
    }
}
