package racingcar.controller;

import racingcar.domain.*;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.view.RacingGameView.*;

public class RacingGameController {

    public void start() {
        printStartRacing();
        String carNames = readLine();
        try {
            Cars cars = Cars.release(carNames);
            printRacingCount();
            String raceCount = readLine();
            LabCount labCount = new LabCount(raceCount);
            execute(cars, labCount);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
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
