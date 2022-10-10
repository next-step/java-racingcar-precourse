package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void racing() {
        for (Car car : cars) {
            car.moveForward(new RandomMovingStrategy());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> extractWinner() {
        int maxMoveDistance = getMaxMoveDistance(cars);

        List<Car> list = new ArrayList<>();
        for (Car o : cars) {
            addWinner(maxMoveDistance, list, o);
        }
        return list;
    }

    private static void addWinner(int maxMoveDistance, List<Car> list, Car o) {
        if (o.getMoveDistance() == maxMoveDistance) {
            list.add(o);
        }
    }

    private int getMaxMoveDistance(List<Car> cars) {
        int maxMoveDistance = 0;
        for (Car car : cars) {
            maxMoveDistance = compareMoveDistance(maxMoveDistance, car);
        }
        return maxMoveDistance;
    }

    private int compareMoveDistance(int maxMoveDistance, Car car) {
        return Math.max(car.getMoveDistance(), maxMoveDistance);
    }
}
