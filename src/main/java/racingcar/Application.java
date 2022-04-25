package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.service.Service;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        racingController.run();
    }
}
