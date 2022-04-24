package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.ConsoleView;

public class Application {

    public static void main(String[] args) {
        RacingController controller = new RacingController(new ConsoleView());
        controller.start();
    }
}
