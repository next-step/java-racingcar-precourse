package racingcar.domain;

import java.util.Objects;

public class CarPosition implements Comparable<CarPosition> {
    private static final int MINIMUM_CAR_POSITION = 0;
    public static final Character CHAR_HYPHEN = '-';
    private final int position;

    public CarPosition() {
        this(0);
    }

    public CarPosition(int position) {
        validateIfPositionIsNotNegative(position);
        this.position = position;
    }

    private void validateIfPositionIsNotNegative(int position) {
        if (position < MINIMUM_CAR_POSITION) {
            throw new IllegalArgumentException("[ERROR] 자동차의 위치값은 0 이상 이어야 합니다.");
        }
    }

    public CarPosition moveForward() {
        return new CarPosition(this.position + 1);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(CHAR_HYPHEN);
        }
        return sb.toString();
    }

    @Override
    public int compareTo(CarPosition o) {
        return Integer.compare(this.position, o.position);
    }
}
