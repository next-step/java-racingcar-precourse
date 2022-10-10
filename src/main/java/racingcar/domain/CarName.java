package racingcar.domain;

import java.util.Objects;

public class CarName {

    private static final Threshold VALID_LENGTH_THRESHOLD = new Threshold(5);
    private final String carName;

    public CarName(String carName) {
        this.carName = carName;
        validateCarNameLength(carName);
    }

    private void validateCarNameLength(String carName) {
        if (VALID_LENGTH_THRESHOLD.isAbove(carName.length())) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CarName carName1 = (CarName) o;

        return carName.equals(carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

    @Override
    public String toString() {
        return carName;
    }
}
