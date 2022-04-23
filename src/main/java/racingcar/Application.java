package racingcar;

import racingcar.common.aop.RacingGameViewProxy;
import racingcar.controller.RacingGameController;
import racingcar.view.RacingGameView;
import racingcar.view.impl.ErrorMessageViewImpl;
import racingcar.view.impl.RacingGameViewImpl;

public class Application {
    public static void main(String[] args) {
        RacingGameView racingGameView = new RacingGameViewProxy(new RacingGameViewImpl(), new ErrorMessageViewImpl());
        new RacingGameController(racingGameView).start();
    }
}
