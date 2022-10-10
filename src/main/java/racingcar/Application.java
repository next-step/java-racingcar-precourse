package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.RacingWinnerMaxForwardStrategy;
import racingcar.view.RacingCarView;

public class Application {
    public static void main(String[] args) {
        RacingCarView view = new RacingCarView();
        RacingCarController controller = new RacingCarController(view, new RacingWinnerMaxForwardStrategy());
        controller.start();
    }
}
