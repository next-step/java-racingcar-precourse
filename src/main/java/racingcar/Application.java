package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.InputConsoleService;
import racingcar.service.InputService;

public class Application {
    public static void main(String[] args) {
        //InputService inputService = new InputTestCaseService(TestCase.CASE1);
        InputService inputService = new InputConsoleService();

        new RacingController().run(inputService);
    }
}
