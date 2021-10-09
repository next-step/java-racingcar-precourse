package racinggame.controller;

import racinggame.model.MoveResults;
import racinggame.model.RacingGame;
import racinggame.model.util.RandomNumberGenerator;
import racinggame.view.InputView;
import racinggame.view.OutputView;

import java.util.List;

public class GameController {

    private final RacingGame game;

    public GameController() {
        this.game = constructGame();
        setCount();
    }

    private RacingGame constructGame() {
        RacingGame game = null;

        while (game == null) {
            game = inputGame();
        }

        return game;
    }

    private RacingGame inputGame() {
        try {
            String names = InputView.inputCarNames();
            return new RacingGame(names);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
        return null;
    }

    private void setCount() {
        while (game.canNotPlay()) {
            inputCount();
        }
    }

    private void inputCount() {
        try {
            int tryCount = InputView.inputTryCount();
            game.setCount(tryCount);
        } catch (NumberFormatException e) {
            OutputView.printNumberFormatError();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }

    public void playGame() {
        OutputView.printResult();

        while (game.canPlay()) {
            int numberOfCars = game.getNumberOfCars();
            List<Integer> randomNumbers = RandomNumberGenerator.generate(numberOfCars);
            MoveResults results = game.moveOnce(randomNumbers);
            OutputView.printResult(results);
        }
    }

    public void showWinners() {
        String winners = game.getWinners();
        OutputView.printWinners(winners);
    }
}
