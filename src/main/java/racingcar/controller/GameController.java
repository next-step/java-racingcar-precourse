package racingcar.controller;

import racingcar.domain.GameCount;
import racingcar.domain.RacingGame;
import racingcar.util.CarUtil;
import racingcar.view.GameView;

public class GameController {

    private final GameView gameView;
    private final RacingGame racingGame;

    private GameCount gameCount;

    public GameController(GameView gameView, RacingGame racingGame) {
        this.gameView = gameView;
        this.racingGame = racingGame;
    }

    public void start() {
        setCars();
        setGameCount();
        play();
        printWinner();
    }

    private void setCars() {
        try {
            gameView.printCarNameScript();
            String carNamesString = gameView.getInput();
            racingGame.createCars(CarUtil.createCarsOf(carNamesString));
        } catch (IllegalArgumentException exception) {
            gameView.printError(exception.getMessage());
            setCars();
        }
    }

    private void setGameCount() {
        gameView.printTryCountScript();
        try {
            this.gameCount = new GameCount(gameView.getInput());
        } catch (IllegalArgumentException exception) {
            gameView.printError(exception.getMessage());
            setGameCount();
        }
    }

    private void play() {
        for (int tryCount = 0; tryCount < gameCount.getGameCount(); tryCount++) {
            racingGame.moveCars();
            gameView.print(racingGame.getMoveResult());
        }
    }

    private void printWinner() {
        gameView.printWinner(racingGame.getWinnerText());
    }
}
