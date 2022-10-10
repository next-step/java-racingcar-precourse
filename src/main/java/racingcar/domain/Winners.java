package racingcar.domain;

import racingcar.ui.ConsoleMessage;
import racingcar.ui.ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private static final String DELIMITER = ",";

    private final List<Car> cars;

    public Winners(List<Car> candidateCars) {
        this.cars = new ArrayList<>();
        findWinners(candidateCars);
    }

    Car getCar(int index) {
        return cars.get(index);
    }

    public int getCarCount() {
        return cars.size();
    }

    public int getPosition() {
        return cars.get(0).getCarPosition();
    }

    public void printResult() {
        ConsoleView.printMessage(ConsoleMessage.WINNERS_RESULT.getMessage(), getNames());
    }

    private void findWinners(List<Car> candidateCars) {
        for (Car candidateCar : candidateCars) {
            addCandidate(candidateCar);
        }
    }

    private void addCandidate(Car candidateCar) {
        if (cars.isEmpty()) {
            cars.add(candidateCar);
            return;
        }
        if (candidateCar.isBehindPosition(this)) {
            return;
        }

        clearWhenAheadPosition(candidateCar);
        cars.add(candidateCar);
    }

    private void clearWhenAheadPosition(Car candidateCar) {
        if (candidateCar.isAheadPosition(this)) {
            cars.clear();
        }
    }

    private String getNames() {
        StringBuilder names = new StringBuilder();
        for (Car car : cars) {
            names.append(car.getCarName()).append(DELIMITER);
        }
        return removeLastDelimiter(names);
    }

    private String removeLastDelimiter(StringBuilder names) {
        return names.substring(0, names.length() - 1);
    }
}
