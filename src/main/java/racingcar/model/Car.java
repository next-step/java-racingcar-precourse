package racingcar.model;

import racingcar.constants.ErrorMessage;
import racingcar.enums.MoveStatus;
import racingcar.utils.ValidationUtils;

import java.util.concurrent.atomic.AtomicInteger;

public class Car {

    private static final String DASH = "-";
    private static final int ZERO = 0;

    private final CarDistance distance;
    private final CarName name;

    public Car(CarName name) {
        this.distance = new CarDistance(ZERO);
        this.name = name;
    }

    public String carName() {
        ValidationUtils.validObjectThrowIfNull(name, ErrorMessage.NAME_IS_REQUIRED);
        return name.getName();
    }

    public void actByMoveStatus(MoveStatus moveStatus) {
        if (MoveStatus.MOVE.equals(moveStatus)) {
            distance.increaseDistance();
        }
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public String getDistanceDash() {
        final StringBuilder builder = new StringBuilder();
        final int distanceCount = this.distance.getDistance();

        for (AtomicInteger repeat = new AtomicInteger(); repeat.get() < distanceCount; repeat.getAndIncrement()) {
            builder.append(DASH);
        }

        return builder.toString();
    }

}
