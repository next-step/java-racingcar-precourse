package racinggame;

import nextstep.utils.Randoms;

import java.util.List;

public class RacingGame {
    private static final int MIN_GAS_POINT_RANGE = 0;
    private static final int MAX_GAS_POINT_RANGE = 9;
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public GameResult run(int runCount) {
        GameResult gameResult = new GameResult();

        for (int i = 0; i < runCount; i++) {
            moveAllCars();
        }
        return gameResult;
    }

    private void moveAllCars() {
        for (Car car : cars) {
            car.move(generateGasPoint());
        }
    }

    private int generateGasPoint() {
        return Randoms.pickNumberInRange(MIN_GAS_POINT_RANGE, MAX_GAS_POINT_RANGE);
    }
}
