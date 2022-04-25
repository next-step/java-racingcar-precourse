package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동차 랭킹
 *
 * @author suji
 * @date 2022-04-24
 **/
public class Ranking {

    private static final int FIRST_RANK = 1;
    private static final int INCREASE_RANK = 1;
    private static final int SAME_RANK = 0;

    private final Cars cars;

    public Ranking(Cars cars) {
        this.cars = cars;
    }

    public List<Car> getWinnerCars() {
        List<Car> winners = new ArrayList<>();
        for (Car sourceCar : cars.getCars()) {
            addWinnerCar(winners, sourceCar);
        }
        return winners;
    }

    private void addWinnerCar(List<Car> winners, Car sourceCar) {
        if (getCarRank(sourceCar) == FIRST_RANK) {
            winners.add(sourceCar);
        }
    }

    private int getCarRank(Car sourceCar) {
        int rank = FIRST_RANK;
        for (Car targetCar : cars.getCars()) {
            rank += compareMovementCount(sourceCar, targetCar);
        }
        return rank;
    }

    private int compareMovementCount(Car sourceCar, Car targetCar) {
        if (sourceCar.getMovementCount() < targetCar.getMovementCount()) {
            return INCREASE_RANK;
        }
        return SAME_RANK;
    }
}
