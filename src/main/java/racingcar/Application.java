package racingcar;

import racingcar.domain.Cars;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;


public class Application {

    public static void main(String[] args) {
        Cars initCars = InputView.racing();
        OutputView.finishRacing(initCars);
    }
}
