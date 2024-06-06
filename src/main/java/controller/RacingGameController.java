package controller;

import model.RacingGame;
import view.View;

import java.util.List;

public class RacingGameController {
    private final View view = new View();

    public void start() {
        List<String> carNames = view.getCarNames();
        int trialCount = view.getTrialCount();
        RacingGame racingGame = new RacingGame(carNames);

        for (int i = 0; i < trialCount; i++) {
            racingGame.race(1);
            view.displayRaceResult(racingGame.getCars());
            System.out.println();
        }

        view.displayWinners(racingGame.getWinners());
    }
}
