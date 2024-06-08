package controller;

import model.RacingGame;
import model.Validaition;
import view.InputView;
import view.ResultView;

import java.util.Arrays;
import java.util.List;

public class RacingGameController {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        List<String> carNames = getCarNames();
        int trials = getTrials();

        RacingGame racingGame = new RacingGame(carNames);
        racingGame.race(trials);

        List<String> winners = racingGame.getWinners();
        resultView.printWinners(winners);
    }

    private List<String> getCarNames() {
        while (true) {
            try {
                String input = inputView.getCarNames();
                Validaition.validateInputCarNames(input);
                return Arrays.asList(input.split(","));
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private int getTrials() {
        while (true) {
            try {
                int trial = inputView.getTrials();
                Validaition.validateTrialCount(trial);
                return trial;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
