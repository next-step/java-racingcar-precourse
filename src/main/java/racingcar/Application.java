package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.GameController.GameControllerBuilder;
import racingcar.model.Parser;
import racingcar.view.GameView;

public class Application {

    public static void main(String[] args) {

        GameController gameController = new GameControllerBuilder()
            .gameView(new GameView())
            .parser(new Parser())
            .build();

        gameController.init();

        gameController.run();
    }
}
