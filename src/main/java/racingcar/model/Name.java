package racingcar.model;

import static racingcar.configuration.ErrorMessage.ERR_CAR_NAME_LENGTH_LIMIT_MSG;

import racingcar.util.ValidationUtils;

public class Name {
    private final String value;

    public Name(String name) {
        if (!ValidationUtils.validCarName(name)) {
            throw new IllegalArgumentException(ERR_CAR_NAME_LENGTH_LIMIT_MSG);
        }
        this.value = name;
    }

    public String getName() {
        return this.value;
    }
}
