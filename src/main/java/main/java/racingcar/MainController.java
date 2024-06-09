package main.java.racingcar;

import main.java.racingcar.domain.Car;
import main.java.racingcar.domain.Cars;
import main.java.racingcar.domain.TrialCount;
import main.java.racingcar.message.ViewMessage;
import main.java.racingcar.view.InputView;
import main.java.racingcar.view.OutputView;

import java.util.List;

public class MainController {

    public void run() {
        Cars cars = this.initCars();
        TrialCount trialCount = this.initTrialCount();
        this.proceedGame(cars, trialCount);
        this.endGame(cars);
    }

    private Cars initCars() {
        String inputValue = InputView.inputString(ViewMessage.INPUT_CAR_NAME);
        return Cars.createByString(inputValue);
    }

    private TrialCount initTrialCount() {
        int count = InputView.inputInteger(ViewMessage.INPUT_TRIAL_COUNT);
        return new TrialCount(count);
    }

    private void proceedGame(Cars cars, TrialCount trialCount) {
        int moveCount = 0;
        OutputView.printMessage(ViewMessage.GAME_RESULT);
        while(trialCount.isMoreThan(moveCount)) {
            cars.commandAllCarsToMove();
            OutputView.printMovingResult(cars);
            moveCount++;
        }
    }

    private void endGame(Cars cars) {
        List<Car> winner = cars.getWinnerList();
        OutputView.printWinner(winner);
    }
}
