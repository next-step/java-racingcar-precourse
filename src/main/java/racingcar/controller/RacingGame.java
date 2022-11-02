package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.GameRound;
import racingcar.model.PlayResult;
import racingcar.model.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private Cars cars;
    private GameRound gameRound;

    public void run() {
        setParticipateCars();
        setGameRound();
        play();
    }

    private void setParticipateCars() {
        do {
            cars = inputCars();
        } while (cars == null);
    }

    private void setGameRound() {
        do {
            gameRound = inputGameRound();
        } while (gameRound == null);
    }

    private void play() {
        for (int i = 0; i < gameRound.getRound(); i++) {
            PlayResult roundResult = cars.playRound(new RandomMovingStrategy());
            OutputView.print(roundResult.getRoundResult());
        }
        PlayResult gameResult = cars.finishGame();
        OutputView.print(gameResult.getGameResult());
    }

    private static Cars inputCars() {
        Cars cars = null;
        try {
            cars = new Cars(InputView.inputCarNames());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
        return cars;
    }

    private static GameRound inputGameRound() {
        GameRound gameRound = null;
        try {
            gameRound = new GameRound(InputView.inputRoundCount());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
        return gameRound;
    }
}
