package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    private static final int INIT_POSITION_COUNT = 0;
    private static final int INIT_CARS_INDEX = 0;

    private List<Car> winnerCarList;
    private Cars cars;

    public Referee(Cars cars) {
        winnerCarList = new ArrayList<>();
        this.cars = cars;
    }

    public Cars getWinners() {
        int maxMoveCount = getMaxMoveCount(cars);
        compare(cars, maxMoveCount);

        return new Cars(winnerCarList);
    }

    private int getMaxMoveCount(Cars cars) {
        int winnerMoveCount = INIT_POSITION_COUNT;
        for (int index = INIT_CARS_INDEX; index < cars.getSize(); index++) {
            Car car = cars.getCar(index);
            winnerMoveCount = Math.max(winnerMoveCount, car.getPosition());
        }
        return winnerMoveCount;
    }

    private void compare(Cars cars, int maxMoveCount) {
        for (int index = INIT_CARS_INDEX; index < cars.getSize(); index++) {
            Car car = cars.getCar(index);
            compareMaxPosition(car, maxMoveCount);
        }
    }

    private void compareMaxPosition(Car car, int maxMoveCount) {
        if (car.getPosition() == maxMoveCount) {
            winnerCarList.add(car);
        }
    }

}
