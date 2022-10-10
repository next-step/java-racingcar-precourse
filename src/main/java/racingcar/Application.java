package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.service.RacingCarGameServiceImpl;

public class Application {
    public static void main(String[] args) {
        RacingCarGameController racingCarGameController = new RacingCarGameController(
                new RacingCarGameServiceImpl());
        racingCarGameController.start();
    }
}
