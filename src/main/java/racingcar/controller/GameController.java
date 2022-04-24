package racingcar.controller;

import racingcar.model.GameRound;
import racingcar.model.RacingCar;
import racingcar.model.Winner;
import racingcar.view.GamePrinter;
import racingcar.view.GameScanner;


public class GameController {

    private RacingCar racingCar;
    private GameRound gameRound;
    private final Winner winner = new Winner();

    public void initGame() {
        GamePrinter.printInitMessage();
        try {
            racingCar = new RacingCar(GameScanner.scanCarNames());
            gameRound = new GameRound(GameScanner.scanGameRounds());
        } catch (IllegalArgumentException e) {
            initGame();
        }
    }

    public void processGame() {
        int rounds = gameRound.rounds;
        while (rounds > 0) {
            gameRound.playEachRound(racingCar);
            rounds -= 1;
        }
    }

    public void endGame() {
        winner.getWinner(racingCar);
    }
}
