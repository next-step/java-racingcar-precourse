package racinggame;

import racinggame.domain.Cars;
import racinggame.domain.RacingGame;
import racinggame.domain.strategy.RandomMoveStrategy;
import racinggame.view.ConsoleInputView;
import racinggame.view.ConsoleOutputView;

public class Application {

    public static void main(String[] args) {
        ConsoleInputView inputView = new ConsoleInputView();

        String names = inputView.enterNames();
        Cars cars = new Cars(names);

        int attempts = inputView.enterAttempts();

        ConsoleOutputView outputView = new ConsoleOutputView();

        RacingGame racingGame = new RacingGame(cars);
        RandomMoveStrategy moveStrategy = new RandomMoveStrategy();

        for (int i = 0; i < attempts; i++) {
            outputView.print(racingGame.next(moveStrategy, attempts - 1 == i));
        }
    }
}
