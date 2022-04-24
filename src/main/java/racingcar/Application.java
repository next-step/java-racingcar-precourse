package racingcar;

import racingcar.domain.PlayCars;
import racingcar.controller.RaceManager;
import racingcar.domain.RaceCount;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        PlayCars playCars = RaceManager.generateCars();
        RaceCount raceCount = RaceManager.getPlayCount();

        RaceManager.start(playCars, raceCount);
        ResultView.printWinners(playCars);
    }
}
