package racingcar.domain;

import java.util.Objects;

public class CarPosition {
    private int position;

    public CarPosition() {
        this.position = 0;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(MoveStatus status) {
        if (status != null && status.isMove()) {
            this.position++;
        }
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

    @Override
    public String toString() {
        return "CarPosition{" +
                "position=" + position +
                '}';
    }
}
