package racingcar.domain;

import racingcar.view.ErrorMessage;

public class CarPosition implements Comparable<CarPosition> {
    private static final int MIN_POSITION = 0;

    private int position;

    public CarPosition() {
        this.position = MIN_POSITION;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        if (position < MIN_POSITION) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_CARPOSITION.getMessage());
        }
        this.position = position;
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
        return position;
    }

    @Override
    public int compareTo(CarPosition carPosition) {
        return Integer.compare(getPosition(), carPosition.getPosition());
    }
}
