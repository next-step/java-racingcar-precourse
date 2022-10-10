package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        RacingCarController controller = AppConfig.racingCarController();
        controller.start();
        controller.play();
    }
}
