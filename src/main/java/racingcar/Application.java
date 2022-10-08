package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.RacingView;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController(new RacingView());
        racingCarController.doRacing();
    }
}
