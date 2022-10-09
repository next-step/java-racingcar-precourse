package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ranking {
    private final Cars cars;

    public Ranking(Cars cars) {
        this.cars = cars;
    }

    public List<Car> getWinnerCars() {
        List<Car> winners = new ArrayList<>();
        Integer maxMovementCount = findMaxMovementCount(this.cars);
        for (Car car : cars.getCars()) {
            addWinnerCar(winners, car, maxMovementCount);
        }
        return winners;
    }

    private Integer findMaxMovementCount(Cars cars) {
        Integer maxMovementCount = 0;
        for (Car car : cars.getCars()) {
            maxMovementCount = compareMovementCount(car, maxMovementCount);
        }
        return maxMovementCount;
    }

    private Integer compareMovementCount(Car car, Integer moveCount) {
        if (car.getMovementCount() > moveCount) {
            return car.getMovementCount();
        }
        return moveCount;
    }

    private void addWinnerCar(List<Car> winners, Car car, Integer maxMovementCount) {
        if (Objects.equals(car.getMovementCount(), maxMovementCount)) {
            winners.add(car);
        }
    }
}
