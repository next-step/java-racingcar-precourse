package racingcar.domain;

import racingcar.constant.ConstantNumber;

import java.util.Objects;

public class CarPosition {

    private final int position;

    public CarPosition() {
        this(ConstantNumber.ZERO_POSITION);
    }

    public CarPosition(int position) {
        this.position = position;
    }

    public CarPosition move() {
        return new CarPosition(position + ConstantNumber.MOVE_ONCE);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public boolean isEqual(int maxPostition) {
        return this.position == maxPostition;
    }
}
