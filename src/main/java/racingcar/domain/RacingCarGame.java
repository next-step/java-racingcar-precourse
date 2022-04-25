package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final List<Car> cars;
    private final Condition condition;

    public RacingCarGame(List<Car> cars, Condition condition) {
        this.cars = cars;
        this.condition = condition;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void play() {
        proceedCars();
    }

    public List<Car> findWinners() {
        int winningLocation = getWinningLocation(cars);

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinningLocation(winningLocation)) {
                winners.add(car);
            }
        }
        return winners;
    }

    private static int getWinningLocation(List<Car> cars) {
        int winningLocation = 0;
        for (Car car : cars) {
            if (car.getLocation() > winningLocation) {
                winningLocation = car.getLocation();
            }
        }
        return winningLocation;
    }

    private void proceedCars() {
        for (Car car : cars) {
            proceedCarByCondition(car, condition);
        }
    }

    private static void proceedCarByCondition(Car car, Condition condition) {
        if (condition.isSatisfied()) {
            car.proceed();
        }
    }

}
