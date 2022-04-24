package racingcar;

import racingcar.controller.RacingMachine;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        String[] names = InputView.inputNames();
        int round = InputView.inputRound();

        RacingMachine racingMachine = new RacingMachine();
        racingMachine.start(names, round);
    }
}
