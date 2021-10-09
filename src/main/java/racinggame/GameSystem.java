package racinggame;

import nextstep.utils.Console;

public class GameSystem {
    int count;
    Cars cars;
    RacingGame racingGame;

    public void gamePlay() {
        Display.enterName();
        enterCarNames();
        initRacingGame();

        Display.enterTryCount();
        enterTryCount();

        Display.executeText();
        gameplay();

    }

    private void initRacingGame() {
        racingGame = new RacingGame(cars);
    }

    private void gameplay() {
        for (int i = 0; i < count; i++) {
            Display.gameResult(racingGame.play());
        }
    }

    private void enterTryCount() {
        count = Integer.parseInt(Console.readLine());
    }

    private void enterCarNames() {
        cars = new Cars();
        cars.enterName(Console.readLine());
    }
}
