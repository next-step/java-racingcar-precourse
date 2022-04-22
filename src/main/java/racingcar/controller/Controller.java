package racingcar.controller;

import racingcar.config.Configuration;
import racingcar.model.Racing;
import racingcar.util.Validator;
import racingcar.view.View;

public class Controller {

    public Controller() {
    }

    public void run() {
        String carNames = inputCarNames();
        String count = inputCount();

        Racing racing = new Racing(carNames, count);

        while (racing.isRunning()) {
            View.printCars(racing.race());
        }

        View.printWinners(racing.getWinners());
    }

    private String inputCarNames() {
        String carNames = View.getCarNames();
        while (!checkCarNames(carNames)) {
            carNames = View.getCarNames();
        }
        return carNames;
    }

    private boolean checkCarNames(String carNames) {
        try {
            checkEachCarName(carNames);
        } catch (IllegalArgumentException e) {
            View.printExceptionMessage(e);
            return false;
        }

        return true;
    }

    private void checkEachCarName(String carNames) {
        String[] names = carNames.split(Configuration.CAR_NAME_DELIMITER);

        Validator.isEmptyArray(names);

        for (String name : names) {
            Validator.checkRegex(name);
        }
    }

    private String inputCount() {
        String count = View.getCount();
        while (!checkCount(count)) {
            count = View.getCount();
        }
        return count;
    }

    private boolean checkCount(String count) {
        try {
            Validator.isInteger(count);
            Validator.isGreaterThanZero(count);
        } catch (IllegalArgumentException e) {
            View.printExceptionMessage(e);
            return false;
        }

        return true;
    }
}
