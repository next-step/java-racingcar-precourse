package racingcar.model;

import java.util.Objects;

public class CarPosition {
    public static final int START_POSITION = 0;
    public static final String HYPHEN = "-";

    private int position;

    public CarPosition() {
        this.position = START_POSITION;
    }

    public CarPosition(int position) {
        this.position = position;
    }

    public void moveForward() {
        this.position++;
    }

    public String convertHyphen() {
        StringBuilder moveCount = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            moveCount.append(HYPHEN);
        }
        return moveCount.toString();
    }

    public boolean isMaxPosition(CarPosition maxPosition) {
        return this.equals(maxPosition);
    }

    public CarPosition comparePosition(CarPosition comparePosition) {
        if (this.position > comparePosition.getPosition()) {
            return this;
        }
        return comparePosition;
    }

    public int getPosition() {
        return position;
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
