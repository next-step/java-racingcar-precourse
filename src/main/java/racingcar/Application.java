package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.input.Input;
import racingcar.view.output.Output;

public class Application {
    public static void main(String[] args) {
        RacingCarController controller = new RacingCarController(new Output(), new Input());

        controller.start();
    }
}
