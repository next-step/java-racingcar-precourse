package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.view.RacingPrinter;
import racingcar.view.RacingScanner;

public class RacingController {
    public void start() {
        RacingPrinter.printCarNameGuide();
        Cars cars = participateCars();
        RacingPrinter.printRoundGuide();
        Round round = getScannedRound();
        this.processRacing(cars, round);
        RacingPrinter.printWinner(cars.getWinnerName());
    }

    private Cars participateCars() {
        try {
            String carNames = RacingScanner.scan();
            return Cars.addCarListByStringCarNames(carNames);
        } catch (IllegalArgumentException e) {
            RacingPrinter.exceptionGuide(e.getMessage());
            return participateCars();
        }
    }

    private Round getScannedRound() {
        try {
            return Round.valueOf(RacingScanner.scan());
        } catch (IllegalArgumentException e) {
            RacingPrinter.exceptionGuide(e.getMessage());
            return getScannedRound();
        }
    }

    private void processRacing(Cars cars, Round round) {
        RacingPrinter.printEmptyLine();
        RacingPrinter.printExecutionResult();
        for (int i = 0; i < round.getRound(); i++) {
            snapshotCars(cars.race());
        }
    }

    private void snapshotCars(List<Car> cars) {
        for (Car car : cars) {
            String snapshot = car.getSnapshot();
            RacingPrinter.printMessage(snapshot);
        }
        RacingPrinter.printEmptyLine();
    }
}
