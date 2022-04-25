package racingcar.model.record;

import racingcar.model.car.name.CarName;
import racingcar.model.car.distance.ForwardDistance;

public class Record {
    private static final String COLON = " : ";
    private final CarName carName;
    private final ForwardDistance distance;

    public Record(CarName carName, ForwardDistance distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public String report() {
        return carName() + COLON + distance();
    }

    public String carName() {
        return carName.name();
    }

    public String distance() {
        return distance.distance();
    }

    public boolean isHigherThan(Record target) {
        return this.distance.isLongerThan(target.distance);
    }

    public boolean isSameWith(Record target) {
        return this.distance.isSameDistanceWith(target.distance);
    }
}
