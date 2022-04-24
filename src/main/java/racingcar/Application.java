package racingcar;

import racingcar.controller.GameController;
import racingcar.view.GameView;

public class Application {
    public static void main(String[] args) {
        GameController controller = new GameController(new GameView());
        controller.start();
    }
}
