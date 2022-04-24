package racingcar.model;

import racingcar.ui.Input;

public class Prepare {
    private final Exception exception;
    private final Cars cars;

    public Prepare() {
        exception = new Exception();
        cars = new Cars();
    }

    public Cars requestCarName() {
        do {
            cars.clear();
        } while (!setCarName(Input.receiveCarNameListInput()));
        return cars;
    }

    public int requestAttempt() {
        String attempt = Input.receiveAttemptInput();
        if (exception.prepareAttemptException(attempt)) {
            return Integer.parseInt(attempt);
        }
        return 0;
    }

    private boolean setCarName(String[] carNameList) {
        boolean result = exception.nameDuplicationException(carNameList);

        for (String carName : carNameList) {
            result = result && possibleToAdd(carName);
        }
        return result;
    }

    private boolean possibleToAdd(String carName) {
        if (exception.nameLengthException(carName)) {
            cars.add(new Car(carName.trim()));
            return true;
        }
        return false;
    }
}
