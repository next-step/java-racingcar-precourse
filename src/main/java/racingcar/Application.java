package racingcar;

import controller.RacingController;
import domain.CarNames;
import domain.Laps;
import domain.RaceResult;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        CarNames carNames = InputView.getCarNames();
        Laps laps = InputView.getLaps();

        RacingController racingController = new RacingController();
        RaceResult raceResult = racingController.startRace(carNames, laps);

        OutputView.announceWinner(raceResult);
    }
}
