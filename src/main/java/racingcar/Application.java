package racingcar;

import controller.RacingController;
import domain.CarNames;
import domain.Laps;
import view.InputView;

public class Application {

    public static void main(String[] args) {
        CarNames carNames = InputView.getCarNames();
        Laps laps = InputView.getLaps();

        RacingController racingContoller = new RacingController();
        racingContoller.startRace(carNames, laps);
    }
}
