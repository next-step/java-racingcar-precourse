package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.RacingGameImp;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new RacingGameController(new RacingGameImp()).run();
    }
}
