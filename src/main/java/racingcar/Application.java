package racingcar;

import racingcar.application.RacingGameService;
import racingcar.presentation.RacingGameController;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController(new RacingGameService());
        racingGameController.startGame();
    }
}
