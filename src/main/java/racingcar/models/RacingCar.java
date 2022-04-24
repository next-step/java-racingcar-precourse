package racingcar.models;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingCar {

    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;
    private static final int MIN_FOR_GO = 4;

    private final Car car;

    public RacingCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return this.car.getName();
    }

    public RaceResult race() {
        if (pickNumberInRange(MIN_RANGE, MAX_RANGE) >= MIN_FOR_GO)
            return RaceResult.GO;
        return RaceResult.STOP;
    }

}
