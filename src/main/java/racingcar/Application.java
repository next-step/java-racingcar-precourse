package racingcar;

import racingcar.configuration.AppConfig;
import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        startRace();
    }

    private static void startRace() {
        AppConfig appConfig = new AppConfig();
        RacingCarController controller = appConfig.racingCarController();

        controller.startRace();
    }
}
