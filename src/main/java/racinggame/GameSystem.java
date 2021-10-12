package racinggame;

import nextstep.utils.Console;

import java.util.List;

public class GameSystem {
    Cars cars;
    RacingGame racingGame;

    public void gamePlay() {
        Display.enterName();
        enterCarNames();

        Display.enterTryCount();
        initRacingGame();

        Display.executeText();
        gameplay();

        Display.winner(winners());
    }

    private List<String> winners() {
        return racingGame.getWinners();
    }

    private void initRacingGame() {
        int count = Integer.parseInt(Console.readLine());
        racingGame = new RacingGame(cars, count);
    }

    private void gameplay() {
        for (int i = 0; i < racingGame.getCount(); i++) {
            Display.gameResult(racingGame.play());
        }
    }

    private void enterCarNames() {
        cars = new Cars();
        cars.enterName(Console.readLine());
    }
}
