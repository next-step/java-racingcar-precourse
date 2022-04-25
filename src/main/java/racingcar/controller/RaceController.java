package racingcar.controller;

import racingcar.Domain.CarNames;
import racingcar.Domain.Cars;
import racingcar.Domain.Laps;
import racingcar.view.InputView;
import racingcar.view.Outview;

public class RaceController {


    public void race() {
        CarNames carNames = InputView.askRacingCarName();
        Cars cars = new Cars(carNames);
        Laps laps = InputView.askLapsNumber();
        raceRun(laps, cars);
    }

    private void raceRun(Laps laps, Cars cars) {
        for (int i = 0; i < laps.getLapNumber(); i++) {
            cars.moveCars();
            Outview.printForEachOrder(cars);
        }
        Outview.printWinner(cars);
    }

}
