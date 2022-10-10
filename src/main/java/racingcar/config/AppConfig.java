package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.service.RepeatService;

public class AppConfig {

    public static RepeatService repeatService() {
        return new RepeatService();
    }

    public static RacingCarService racingCarService() {
        return new RacingCarService();
    }

    public static RacingCarController racingCarController() {
        return new RacingCarController(repeatService(), racingCarService());
    }
}
