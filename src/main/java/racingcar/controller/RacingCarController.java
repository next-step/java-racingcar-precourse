package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.PlayingCount;
import racingcar.domain.Ranking;
import racingcar.domain.WinnerCars;
import racingcar.view.InputProvider;
import racingcar.view.OutputProvider;

public class RacingCarController {
    public void start() {
        Cars cars = getCars();
        playRace(cars);
    }

    private void playRace(Cars cars) {
        Integer count = null;
        while (count == null) {
            count = getInputCount();
        }
        OutputProvider.printResultTitle();
        for (int i = 0; i < count; i++) {
            cars.moveCars();
            OutputProvider.printExecuteResult(cars);
        }
        raceResult(cars);
    }

    private void raceResult(Cars cars) {
        Ranking ranking = new Ranking(cars);
        WinnerCars winnerCars = new WinnerCars(ranking);
        OutputProvider.printFinalWinners(winnerCars);
    }

    private Integer getInputCount() {
        Integer count = null;
        try {
            String inputCount = InputProvider.inputPlayingCount();
            PlayingCount playingCount = new PlayingCount(inputCount);
            count = playingCount.getCount();
        } catch (IllegalArgumentException e) {
            OutputProvider.printExceptionMessage(e);
        }
        return count;
    }

    private Cars getCars() {
        Cars cars = null;
        while (isEmptyCars(cars)) {
            cars = createCars(cars);
        }
        return cars;
    }

    private Cars createCars(Cars cars) {
        try {
            String carNames = InputProvider.inputCarNames();
            cars = new Cars(carNames);
        } catch (IllegalArgumentException e) {
            OutputProvider.printExceptionMessage(e);
        }
        return cars;
    }

    private boolean isEmptyCars(Cars cars) {
        return cars == null || cars.isEmpty();
    }
}
