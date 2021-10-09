package racinggame;

import nextstep.utils.Console;

public class GameSystem {
    Cars cars;
    RacingGame racingGame;

    public void gamePlay() {
        Display.enterName();
        enterCarNames();

        Display.enterTryCount();
        enterTryCount();

        Display.executeText();
        gameplay();

    }

    private void gameplay() {
        racingGame.play();
    }

    private void enterTryCount() {
        int count = Integer.parseInt(Console.readLine());
        racingGame = new RacingGame(cars, count);
    }

    private void enterCarNames() {
        cars = new Cars();
        cars.enterName(Console.readLine());
    }
}
