package racingcar;

import controller.RacingContoller;
import domain.CarNames;
import domain.Laps;
import domain.RaceResult;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarNames carNames = InputView.getCarNames();
        Laps laps = InputView.getLaps();

        RacingContoller racingContoller = new RacingContoller();
        RaceResult raceResult = racingContoller.startRace(carNames, laps);

        OutputView.announceWinner(raceResult);
    }
}
