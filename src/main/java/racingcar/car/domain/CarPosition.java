package racingcar.car.domain;

import java.util.Objects;

public class CarPosition implements Comparable<CarPosition> {

    private static final String CAR_POSITIVE_POSITION_ERROR_MESSAGE = "[ERROR] 자동차의 위치는 음수일 수 없습니다.";
    public static final int DEFAULT_POSITION = 0;
    public static final int MOVE_POSITION = 1;

    private final int position;

    public CarPosition() {
        this.position = DEFAULT_POSITION;
    }

    public CarPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(CAR_POSITIVE_POSITION_ERROR_MESSAGE);
        }
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return this.position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.position);
    }

    public CarPosition move() {
        return new CarPosition(this.position + MOVE_POSITION);
    }

    @Override
    public int compareTo(CarPosition carPosition) {
        return Integer.compare(this.position, carPosition.position);
    }

    public int position() {
        return position;
    }
}

