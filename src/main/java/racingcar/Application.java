package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.number.GameNumberGenerator;
import racingcar.view.PlayerInputView;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new PlayerInputView(),
                new ResultView(),
                new GameNumberGenerator());
        gameController.exec();
    }
}
