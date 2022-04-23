package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> cars;

    public Winners(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {
        final List<Car> winners = new ArrayList<>();
        final int maxDistance = maxDistance(cars);

        for (Car car : cars) {
            addWinner(winners, car, maxDistance);
        }

        return winners;
    }

    private void addWinner(final List<Car> winners, final Car car, final int maxDistance) {
        if (car.getDistance() == maxDistance) {
            winners.add(car);
        }
    }

    private int maxDistance(final List<Car> cars) {
        int max = Integer.MIN_VALUE;

        for (Car car : cars) {
            max = Math.max(max, car.getDistance());
        }

        return max;
    }
}
