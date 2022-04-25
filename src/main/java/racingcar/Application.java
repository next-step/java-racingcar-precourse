package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.view.GameInput;
import racingcar.view.GameOutput;

public class Application {
    public static void main(String[] args) {
        RacingCarGameController gameController = new RacingCarGameController(new GameInput(), new GameOutput());
        gameController.startGame();
    }
}
