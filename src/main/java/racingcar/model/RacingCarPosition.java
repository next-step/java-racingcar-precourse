package racingcar.model;


import java.util.Objects;

import static racingcar.constant.RacingCarGameErrorMessage.ERROR_RACING_CAR_POSITION_NOT_NEGATIVE;

public class RacingCarPosition {

    private static final int ZERO = 0;

    private int position;

    public RacingCarPosition(int position) {
        validateRacingCarPositionPositive(position);
        this.position = position;
    }

    public void moveForward() {
        this.position++;
    }

    public int get() {
        return this.position;
    }

    private static void validateRacingCarPositionPositive(int position) {
        if (position < ZERO) throw new IllegalArgumentException(ERROR_RACING_CAR_POSITION_NOT_NEGATIVE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCarPosition that = (RacingCarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
