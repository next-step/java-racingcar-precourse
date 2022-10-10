package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class VictoryCars {
    private static final String SEPARATOR = ", ";

    private final List<Car> victoryCars = new ArrayList<>();

    public VictoryCars(Cars cars) {
        victory(cars, findMaxMovingForward(cars));
    }

    public int findMaxMovingForward(Cars cars) {
        int max = 0;
        for (Car car : cars.getCars()) {
            max = getMax(max, car.getMovingCount());
        }
        return max;
    }

    private int getMax(int max, int movingCount) {
        if (max < movingCount) {
            max = movingCount;
        }
        return max;
    }

    private void victory(Cars cars, int maxMovingForward) {
        for (Car car : cars.getCars()) {
            addVictoryCars(maxMovingForward, car);
        }
    }

    private void addVictoryCars(int maxMovingForward, Car car) {
        if (car.getMovingCount() == maxMovingForward) {
            this.victoryCars.add(car);
        }
    }

    public List<Car> getVictoryCars() {
        return this.victoryCars;
    }

    @Override
    public String toString() {
        StringBuilder victory = new StringBuilder();
        for (Car car : this.victoryCars) {
            victory.append(car.getName());
            victory.append(SEPARATOR);
        }
        victory.deleteCharAt(victory.lastIndexOf(SEPARATOR));
        return victory.toString();
    }
}
