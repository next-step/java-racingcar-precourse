package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final List<Car> cars;

    private Winners() {
        this.cars = new ArrayList<>();
    }

    public static Winners of(final List<Car> cars) {
        Winners winners = new Winners();

        int maxDistance = getMaxDistance(cars);

        for (Car car : cars) {
            winners.addWinner(car, maxDistance);
        }

        return winners;
    }

    private static int getMaxDistance(final List<Car> cars) {
        int maxDistance = 0;

        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }

        return maxDistance;
    }

    private void addWinner(Car car, int maxDistance) {
        if (car.getDistance() == maxDistance) {
            this.cars.add(car);
        }
    }

    public List<String> getWinnersName() {
        List<String> names = new ArrayList<>();

        for (Car car : this.cars) {
            names.add(car.getName());
        }

        return names;
    }
}
