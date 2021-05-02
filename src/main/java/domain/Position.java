package domain;

import java.util.Objects;

public class Position {
    private static final int MINIMUM_POSITION = 0;
    private static final int POSITION_INCREASE_COUNT = 1;

    private CarName carName;
    private int position;

    public Position() {
        this(null, MINIMUM_POSITION);
    }

    public Position(int position) {
        this(null, position);
    }

    public Position(CarName carName) {
        this(carName, MINIMUM_POSITION);
    }

    public Position(CarName carName, int position) {
        if(position < MINIMUM_POSITION) {
            throw new IllegalArgumentException("위치는 0 이하가 없습니다.");
        }

        this.carName = carName;
        this.position = position;
    }

    public Position increase() {
        return new Position(carName, position + POSITION_INCREASE_COUNT);
    }

    public CarName getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position && Objects.equals(carName, position1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
