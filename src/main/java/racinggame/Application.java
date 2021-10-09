package racinggame;

import racinggame.domain.Cars;
import racinggame.domain.RacingGame;
import racinggame.domain.strategy.RandomMoveStrategy;
import racinggame.view.ConsoleInputView;
import racinggame.view.ConsoleOutputView;

public class Application {

    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        ConsoleInputView inputView = new ConsoleInputView();
        String names = inputView.enterNames();
        Cars cars = new Cars(names);

        int attempts = inputView.enterAttempts();

        RacingGame racingGame = new RacingGame(new RandomMoveStrategy(), cars);

        ConsoleOutputView outputView = new ConsoleOutputView();
        for (int i = 0; i < attempts; i++) {
            RacingGame next = racingGame.next();
            outputView.print(next);
        }
    }

}
