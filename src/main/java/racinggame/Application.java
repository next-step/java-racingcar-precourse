package racinggame;

import racinggame.domain.Cars;
import racinggame.domain.Racing;
import racinggame.ui.InputView;
import racinggame.ui.ResultView;

public class Application {
    public static void main(String[] args) {
        Cars cars = InputView.createCars();
        int attemptCount = InputView.inputAttemptCount();
        Racing playRacing = InputView.startRacing(cars,attemptCount);

        ResultView.finish(playRacing);
    }
}
