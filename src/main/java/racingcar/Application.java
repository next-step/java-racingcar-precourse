package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomMovingStrategy;
import racingcar.view.GameView;

public class Application {
    public static void main(String[] args) {
        new GameController(new GameView(), new RacingGame(new RandomMovingStrategy())).start();
    }
}
