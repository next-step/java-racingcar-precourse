package racingcar.controller;

import racingcar.model.Game;
import racingcar.view.View;

import static racingcar.utils.Rules.carNamingRule;
import static racingcar.utils.Rules.gameTryCountRule;

public class GameController {

    public void run() {
        String names = handleNamingView();
        String numberOfGames = handleTryCountView();

        Game game = new Game(names, numberOfGames);
        while (!game.gameOver()) {
            View.printCars(game.gameStart());
        }
        View.printWinnerNames(game.getWinnersNames());
    }

    private String handleNamingView() {
        String names = View.getNameString();
        while (!isValidNamingRule(names)) {
            names = View.getNameString();
        }
        return names;
    }

    private String handleTryCountView() {
        String tryCount = View.getNumberOfGames();
        while (!isValidTryCountRule(tryCount)) {
            tryCount = View.getNumberOfGames();
        }
        return tryCount;
    }

    private boolean isValidNamingRule(String names) {
        try {
            carNamingRule(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private boolean isValidTryCountRule(String tryCount) {
        try {
            gameTryCountRule(tryCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
