package racingcar.domain;

import racingcar.constants.MessageConstants;
import racingcar.constants.OptionConstants;

public class CarName {
    private final String name;

    public CarName(String name) {
        validateCarName(name);
        this.name = name.trim();
    }

    private void validateCarName(String name) {
        validateNullOrEmpty(name);
        validateLength(name);
    }

    private void validateNullOrEmpty(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(MessageConstants.ERROR_MESSAGE_NAME_NULL_EMPTY);
        }
    }

    private void validateLength(String name) {
        if (name.trim().length() > OptionConstants.CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(String.format(MessageConstants.ERROR_MESSAGE_NAME_OVER_LIMIT,
                    OptionConstants.CAR_NAME_LENGTH_LIMIT));
        }
    }

    public String getName() {
        return name;
    }
}
