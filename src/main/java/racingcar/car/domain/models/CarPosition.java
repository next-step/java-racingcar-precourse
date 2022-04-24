package racingcar.car.domain.models;

import java.util.Objects;
import racingcar.car.domain.errors.CarErrors;
import racingcar.util.StringUtils;

public class CarPosition {

    private static final int MINIMUM_CAR_POSITION = 0;

    private final int position;

    public CarPosition(int position) {
        validate(position);
        this.position = position;
    }

    public static CarPosition initByZero() {
        return new CarPosition(MINIMUM_CAR_POSITION);
    }

    public CarPosition getGreaterCarPosition(CarPosition anotherPosition) {
        validate(anotherPosition);

        if (hasGreaterPositionThan(anotherPosition)) {
            return new CarPosition(position);
        }
        return new CarPosition(anotherPosition.position);
    }

    private void validate(int position) {
        if (position < MINIMUM_CAR_POSITION) {
            throw new IllegalStateException(CarErrors.CAR_POSITION_LESS_THAN_ZERO_ERROR);
        }
    }

    private void validate(CarPosition carPosition) {
        if (carPosition == null) {
            throw new IllegalStateException(CarErrors.CAR_POSITION_EMPTY_ERROR);
        }
    }

    private boolean hasGreaterPositionThan(CarPosition anotherPosition) {
        return this.position > anotherPosition.position;
    }

    public CarPosition moveForward() {
        return new CarPosition(position + 1);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int iterator = 0 ; iterator < position ; iterator++) {
            builder.append(StringUtils.DASH);
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
