package racinggame;

import racinggame.domain.Cars;
import racinggame.view.ConsoleInputView;

public class Application {

    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        ConsoleInputView inputView = new ConsoleInputView();
        String names = inputView.enterNames();
        Cars cars = new Cars(names);

        int attempts = inputView.enterAttempts();

        RacingGame racingGame = new RacingGame(() -> true, cars);

        for (int i = 0; i < attempts; i++) {
            Cars next = racingGame.next();
        }


    }

}
