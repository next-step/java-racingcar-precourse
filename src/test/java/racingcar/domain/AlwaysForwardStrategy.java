package racingcar.domain;

import racingcar.domain.car.CarMovingStrategy;
import racingcar.domain.car.Distance;

public class AlwaysForwardStrategy implements CarMovingStrategy {
    private final Distance distanceAtOnce;

    public AlwaysForwardStrategy(Distance distanceAtOnce) {
        this.distanceAtOnce = distanceAtOnce;
    }

    public AlwaysForwardStrategy(int distanceAtOne) {
        this(new Distance(distanceAtOne));
    }

    @Override
    public Distance move() {
        return distanceAtOnce;
    }
}
