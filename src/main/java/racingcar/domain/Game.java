package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.GameView;

public class Game {
    private final GameView gameView;
    private Cars cars;
    private GameRound gameRound;

    public Game() {
        gameView = new GameView();
    }

    public void play() {
        initCars();
        initGameRound();

        playGame();

        gameOver();
    }

    private void gameOver() {
        gameView.printExecutionResult();
        Winners winners = new Winners(cars);
        gameView.printFinalWinners(winners);
    }

    private void playGame() {
        for (int i = 0; i < gameRound.getValue(); i++) {
            cars.allCarsMove(new RandomMoveStrategy());
            gameView.printGameRoundResult(cars);
        }
    }

    private void initGameRound() {
        do {
            gameView.printInputGameRound();

        } while (!isSuccessGameRound());

    }

    private boolean isSuccessGameRound() {
        try {
            gameRound = new GameRound(Console.readLine());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    private void initCars() {
        do {
            gameView.printInputCarNames();
        } while (!isSuccessCars());

    }

    private boolean isSuccessCars() {
        try {
            cars = new Cars(Console.readLine());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
