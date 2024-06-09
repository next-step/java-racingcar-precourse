package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {
    public void run(){
        String[] carNames = InputView.getCarNames();
        int numberOfAttempts = InputView.getNumberOfAttempts();

        Race race = new Race(carNames);
        OutputView.printOutput();
        for (int i = 0; i < numberOfAttempts; i++) {
            race.race();
            OutputView.printRace(race.getCars());
        }

        List<String> winners = race.getWinners();
        OutputView.printWinners(winners);

    }
}
