package racingcar;

import domain.CarNames;
import domain.Laps;
import view.InputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarNames carNames = InputView.getCarNames();
        Laps laps = InputView.getLaps();
    }
}
