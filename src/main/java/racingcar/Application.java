package racingcar;

import domain.CarNames;
import domain.Laps;
import view.InputView;

public class Application {

    public static void main(String[] args) {
        CarNames carNames = InputView.getCarNames();
        Laps laps = InputView.getLaps();
    }
}
