package racingcar.controller;

import racingcar.domain.CarNames;
import racingcar.domain.Cars;
import racingcar.domain.MovableStrategy;
import racingcar.domain.TryCount;
import racingcar.domain.Winners;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;

public class RacingCarGameController {
    private final MovableStrategy movableStrategy;

    public RacingCarGameController(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
    }

    public void run() {
        Cars participantCars = createParticipantCars();
        TryCount tryCount = readTryCountFromUser();
        play(participantCars, tryCount);
    }

    private Cars createParticipantCars() {
        CarNames carNames = readCarNamesFromUser();
        return new Cars(carNames);
    }

    public void play(Cars cars, TryCount tryCount) {
        for (int i = 0; i < tryCount.value(); i++) {
            cars.move(movableStrategy);
            ConsoleOutputView.printCarsAfterMoved(cars);
        }
        Winners winners = cars.findWinners();
        ConsoleOutputView.printWinners(winners);
    }

    private CarNames readCarNamesFromUser() {
        try {
            String names = ConsoleInputView.readCarNames();
            return new CarNames(names);
        } catch (IllegalArgumentException e) {
            ConsoleOutputView.println(e.getMessage());
            return readCarNamesFromUser();
        }
    }

    private TryCount readTryCountFromUser() {
        try {
            String moveCount = ConsoleInputView.readMoveCount();
            return new TryCount(moveCount);
        } catch (IllegalArgumentException e) {
            ConsoleOutputView.println(e.getMessage());
            return readTryCountFromUser();
        }
    }
}
