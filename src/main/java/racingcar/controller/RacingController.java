package racingcar.controller;

import racingcar.racing.Racing;
import racingcar.view.InputView;

public class RacingController {

    public void playRacingGame() {
        Racing racing = InputView.enterCarNames();
        InputView.enterPlayCount(racing);
    }
}
