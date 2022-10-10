package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Ranking {

    private final Cars cars;

    public Ranking(Cars cars) {
        this.cars = cars;
    }

    public List<Car> getFirstRankers() {
        List<Car> rankers = new ArrayList<>();
        for (Car car: cars.getCars()) {
            addRanker(rankers, car);
        }
        return rankers;
    }

    private void addRanker(List<Car> rankers, Car car) {
        if (getRank(car) == 1) {
            rankers.add(car);
        }
    }

    private int getRank(Car car) {
        int rank = 1;
        for (Car comparedCar: cars.getCars()) {
            rank += calculate(car.getPosition(), comparedCar.getPosition());
        }
        return rank;
    }

    private int calculate(int carPosition, int comparedPosition) {
        if (carPosition < comparedPosition) {
            return 1;
        }
        return 0;
    }
}
