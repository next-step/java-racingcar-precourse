package racingcar.car.domain.models;

import java.util.Objects;
import racingcar.car.domain.errors.CarErrors;
import racingcar.util.StringUtils;

public class CarName {

    public static final int MAX_CAR_NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || StringUtils.removeSpace(name).isEmpty()) {
            throw new IllegalStateException(CarErrors.CAR_NAME_EMPTY_ERROR);
        }

        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalStateException(CarErrors.CAR_NAME_GREATER_THAN_NAME_RULE_ERROR + MAX_CAR_NAME_LENGTH);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
