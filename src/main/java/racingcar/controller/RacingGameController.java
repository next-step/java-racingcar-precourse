package racingcar.controller;

import racingcar.domain.*;

import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.view.RacingGameView.*;

public class RacingGameController {

    public void start() {
        Cars cars = setCars();
        LabCount labCount = setLabCount();
        execute(cars, labCount);
    }

    private Cars setCars() {
        Cars cars = null;
        while(Objects.isNull(cars)) {
            cars = generateCar(cars);
        }
        return cars;
    }

    private LabCount setLabCount() {
        LabCount labCount = null;
        while(Objects.isNull(labCount)) {
            labCount = generateLabCount(labCount);
        }
        return labCount;
    }

    private Cars generateCar(Cars cars) {
        try {
            printStartRacing();
            String carNames = readLine();
            cars = Cars.release(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return cars;
    }

    private LabCount generateLabCount(LabCount labCount) {
        try {
            printRacingCount();
            String raceCount = readLine();
            labCount = new LabCount(raceCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            return labCount;
        }
    }

    public void execute(Cars cars, LabCount labCount) {
        printGameResultTitle();
        int tryCount = 0;
        while (labCount.getCount() >= tryCount) {
            tryCount += 1;
            race(cars);
        }
        finishGame(cars);
    }

    private void race(Cars cars) {
        Coordinates coordinates = Coordinates.generate();
        coordinates.setCoordinates(cars.getCars().size());

        cars.move(coordinates);

        printGameResult(cars);
    }

    private void finishGame(Cars cars) {
        Ranking ranking = new Ranking(cars);
        Winners winners = new Winners(ranking);

        printWinners(winners);
    }
}
