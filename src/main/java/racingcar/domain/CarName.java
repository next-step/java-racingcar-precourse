package racingcar.domain;

import static racingcar.constant.ErrorStatus.CAR_NAME_OVER_MAXIMUM_LENGTH;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_OVER_MAXIMUM_LENGTH.getMessage());
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
