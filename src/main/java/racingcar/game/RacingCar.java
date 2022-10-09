package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.RacingGameIllegalArgumentException;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.ExecutionCount;

import static racingcar.view.RacingGameView.*;
import static racingcar.game.UserInputRequestStatus.*;

public final class RacingCar {

    private UserInputRequestStatus userInputRequestStatus;
    private Cars cars;
    private ExecutionCount executionCount;

    public RacingCar() {
        userInputRequestStatus = ON;
    }

    public void start() {
        while (userInputRequestStatus.isOn()) {
            requestCarNames();
        }
        userInputRequestStatus = ON;

        while (userInputRequestStatus.isOn()) {
            requestExecutionCount();
        }

        execute();
        printWinners(cars.winners());
    }

    private void turn() {
        executionCount.decrease();
        for (Car car : cars.get()) {
            car.play();
        }
    }

    private void requestCarNames() {
        try {
            printRequestCarNames();
            String input = Console.readLine();
            cars = Cars.of(input);
            userInputRequestStatus = OFF;
        } catch (RacingGameIllegalArgumentException e) {
            printError(e.getMessage());
        }
    }

    private void requestExecutionCount() {
        try {
            printRequestExecutionCount();
            String input = Console.readLine();
            executionCount = ExecutionCount.valueOf(input);
            userInputRequestStatus = OFF;
        } catch (RacingGameIllegalArgumentException e) {
            printError(e.getMessage());
        }
    }

    private void execute() {
        printExecutionResultInitialMessage();
        while (executionCount.get() > 0) {
            turn();
            printExecutionResult(cars);
        }
    }
}
