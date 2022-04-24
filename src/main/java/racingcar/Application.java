package racingcar;

import racingcar.domain.Cars;
import racingcar.controller.Controller;
import racingcar.domain.PlayCount;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Cars cars = Controller.makeCars();
        PlayCount playCount = Controller.makePlayCount();

        Controller.start(cars, playCount);
        ResultView.printWinners(cars);
    }
}
