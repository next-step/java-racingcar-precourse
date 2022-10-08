package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.domain.MovableStrategy;
import racingcar.domain.RandomMovableStrategy;

public class Application {
    public static void main(String[] args) {
        MovableStrategy movableStrategy = new RandomMovableStrategy();
        RacingCarGameController controller = new RacingCarGameController(movableStrategy);
        controller.run();
    }
}
