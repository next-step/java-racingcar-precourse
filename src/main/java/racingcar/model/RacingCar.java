package racingcar.model;


import racingcar.common.strategy.NumberStrategy;
import racingcar.model.dto.RacingResult;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private final List<Car> cars;

    public RacingCar(List<Car> cars) {
        this.cars = cars;
    }

    public void start(NumberStrategy strategy) {
        for (Car car : cars) {
            car.race(strategy.generate());
        }
    }

    public List<RacingResult> getResult() {
        List<RacingResult> result = new ArrayList<>();
        int maxMove = getMaxMove(cars);

        for (Car car : cars) {
            result.add(new RacingResult(car.getName(), car.getMove(), isWinner(maxMove, car.move())));
        }

        return result;
    }

    private boolean isWinner(int maxMove, CarMove move) {
        return maxMove == move.getMove();
    }

    private int getMaxMove(List<Car> cars) {
        int maxMove = 0;

        for (Car car : cars) {
            maxMove = changeMaxMove(maxMove, car);
        }

        return maxMove;
    }

    private int changeMaxMove(int maxMove, Car car) {
        if (car.move().isMaxMove(maxMove)) {
            return car.getMove();
        }

        return maxMove;
    }

    public List<Car> getCars() {
        return cars;
    }
}
