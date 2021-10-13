package racinggame.domain;

import nextstep.utils.Randoms;

import java.util.List;

public class Cars {
    private static final int MIN_GAS_POINT_RANGE = 0;
    private static final int MAX_GAS_POINT_RANGE = 9;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public LapResult move() {
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
