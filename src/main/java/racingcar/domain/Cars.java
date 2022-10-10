package racingcar.domain;

import racingcar.view.ConsolePrinter;
import racingcar.view.Messages;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final int MAX_NAME_LEN = 5;
    private static final int MIN_CAR_NAME_INPUT = 2;

    private final List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void enrollRacing(List<String> carNames) {
        validateCarNum(carNames);
        for (String carName : carNames) {
            validateCarNameLen(carName);
            validateDuplicate(carName);
            cars.add(new Car(carName));
        }
    }

    private void validateCarNameLen(String carName) {
        if (carName.length() > MAX_NAME_LEN) {
            ConsolePrinter.printConsoleMsg(Messages.ERROR_CAR_NAME_LEN);
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(String carName) {
        if (findDuplicateCar(carName)) {
            ConsolePrinter.printConsoleMsg(Messages.ERROR_DUPLICATE_CAR_NAME);
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNum(List<String> carNames) {
        if (cars.size() == 0 && carNames.size() < MIN_CAR_NAME_INPUT) {
            ConsolePrinter.printConsoleMsg(Messages.ERROR_MIN_CAR_COUNT);
            throw new IllegalArgumentException();
        }
    }

    private boolean findDuplicateCar(String carName) {
        for (Car car : cars) {
            if (carName.equals(car.getName())) {
                return true;
            }
        }
        return false;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.moveForward(new RandomNum().getRandomNum());
        }
    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        int maxPosition = findMaxPosition();
        for (Car car : cars) {
            addWinnerName(car, maxPosition, winnerNames);
        }
        return winnerNames;
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.getPosition() > maxPosition ? car.getPosition() : maxPosition;
        }
        return maxPosition;
    }

    private void addWinnerName(Car car, int maxPosition, List<String> winnerNames) {
        if (car.getPosition() == maxPosition) {
            winnerNames.add(car.getName());
        }
    }
}
