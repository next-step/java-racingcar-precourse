package racingcar.domain;

import racingcar.utils.CommonUtils;

import java.util.ArrayList;

import static racingcar.constant.CarConstant.MAX_VALUE;
import static racingcar.constant.CarConstant.MIN_VALUE;

public class RacingGame {
    private final Cars cars;
    private final RacingGameHistory history;

    public RacingGame(String names) {
        this.cars = Cars.createCars(names);
        history = new RacingGameHistory(new ArrayList<>());
    }

    public Cars getResult() {
        return cars;
    }

    public RacingGameHistory getHistory() {
        return history;
    }

    public void play(int number) {
        while (number-- > 0) {
            moveIterator();
            addPlayHistory((Cars) cars.clone());
        }
    }

    private void moveIterator() {
        for (Car car : cars.getCarItems()) {
            move(car);
        }
    }

    private void move(Car car) {
        car.move(CommonUtils.getRandomNumber(MIN_VALUE, MAX_VALUE));
    }

    private void addPlayHistory(Cars cars) {
        history.addCars(cars);
    }
}
