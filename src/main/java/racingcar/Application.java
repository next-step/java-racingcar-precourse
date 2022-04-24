package racingcar;

import racingcar.domain.Cars;
import racingcar.controller.RaceManager;
import racingcar.domain.RaceCount;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        Cars cars = RaceManager.generateCars();
        RaceCount raceCount = RaceManager.getPlayCount();

        RaceManager.start(cars, raceCount);
        ResultView.printWinners(cars);
    }
}
