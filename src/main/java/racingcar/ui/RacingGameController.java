package racingcar.ui;

import racingcar.domain.AttemptCount;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.Winners;

import java.util.Objects;

public class RacingGameController {

    private final RacingGame racingGame;

    public RacingGameController() {
        racingGame = new RacingGame(getCars(), getAttemptCount());
    }

    public void run() {
        ConsoleView.newLine();
        ConsoleView.printMessage(ConsoleMessage.RESULT_HEADER);
        Winners winners = racingGame.run();
        winners.printResult();
    }

    private Cars getCars() {
        Cars cars = null;
        while (Objects.isNull(cars)) {
            cars = inputCars();
        }
        return cars;
    }

    private Cars inputCars() {
        try {
            String carNames = ConsoleView.input(ConsoleMessage.CAR_NAMES_INPUT);
            return new Cars(carNames);
        } catch (IllegalArgumentException e) {
            ConsoleView.printErrorMessage(e);
        }
        return null;
    }

    private AttemptCount getAttemptCount() {
        AttemptCount attemptCount = null;
        while (Objects.isNull(attemptCount)) {
            attemptCount = inputAttemptCount();
        }
        return attemptCount;
    }

    private AttemptCount inputAttemptCount() {
        try {
            String count = ConsoleView.input(ConsoleMessage.ATTEMPT_COUNT_INPUT);
            checkNumber(count);
            return new AttemptCount(Integer.parseInt(count));
        } catch (IllegalArgumentException e) {
            ConsoleView.printErrorMessage(e);
        }
        return null;
    }

    private void checkNumber(String count) {
        if (isNotPositiveNumber(count)) {
            throw new IllegalArgumentException(ConsoleMessage.ATTEMPT_COUNT_ERROR.getMessage());
        }
    }

    private boolean isNotPositiveNumber(String count) {
        return !count.matches("[0-9]+");
    }
}
