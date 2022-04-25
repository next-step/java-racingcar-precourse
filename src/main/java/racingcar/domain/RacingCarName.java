package racingcar.domain;

import racingcar.common.Messages;

public class RacingCarName {
    private static final int MAX_LENGTH = 5;

    private final String name;

    public RacingCarName(String carName) {
        validationCarNameNotNull(carName);
        validationCarNameNotEmpty(carName);
        validationCarNameLength(carName);

        this.name = carName.trim();
    }

    private void validationCarNameNotNull(String carName) {
        if (carName == null) {
            throw new NullPointerException(Messages.CAR_NAME_NOT_NULL);
        }
    }

    private void validationCarNameNotEmpty(String carName) {
        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException(Messages.CAR_NAME_NOT_EMPTY);
        }
    }

    private void validationCarNameLength(String carName) {
        if (carName.trim().length() > MAX_LENGTH) {
            throw new IllegalArgumentException(Messages.EXCEED_CAR_NAME_MAX_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
