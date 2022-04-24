package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.wrapper.Racers;
import racingcar.domain.wrapper.RoundCount;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Racers racers = InputView.printStartMessage();
        RoundCount roundCount = InputView.printPlayCountMessage();

        RacingController.start(racers, roundCount);
    }
}
