package racingcar.common.type;

import racingcar.common.validate.ValidateUtils;

public class CarName {

    public static final int CAR_NAME_MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        ValidateUtils.maxLength(name, CAR_NAME_MAX_LENGTH);
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
