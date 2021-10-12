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

    public GameResult run(int lapCount) {
        GameResult gameResult = new GameResult();
        for (int i = 0; i < lapCount; i++) {
            gameResult.add(moveAllCars());
        }
        return gameResult;
    }

    private LapResult moveAllCars() {
        LapResult lapResult = new LapResult();
        for (Car car : cars) {
            int gasPoint = generateGasPoint();
            lapResult.add(car.move(gasPoint));
        }
        return lapResult;
    }

    private int generateGasPoint() {
        return Randoms.pickNumberInRange(MIN_GAS_POINT_RANGE, MAX_GAS_POINT_RANGE);
    }
}
