package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.core.infrastructure.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        RacingGameController controller = appConfig.racingGameController();

        controller.start();
    }
}
