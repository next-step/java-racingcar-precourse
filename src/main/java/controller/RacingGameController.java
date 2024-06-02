package controller;

import java.util.List;
import model.RacingGame;
import view.InputView;
import view.ResultView;

public class RacingGameController {
    public void run() {
        InputView inputView = new InputView(new java.util.Scanner(System.in));

        try {
            String[] carNames = inputView.getCarNames();
            int attemptCount = inputView.getAttemptCount();

            RacingGame racingGame = new RacingGame(List.of(carNames), attemptCount);

            for (int i = 0; i < attemptCount; i++) {
                racingGame.raceOnce();
                ResultView.printRace(racingGame.getCars());
                System.out.println();
            }

            ResultView.printWinners(racingGame.getWinners());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
