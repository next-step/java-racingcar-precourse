package racingcar.domain;

import static racingcar.exception.ErrorMessage.EMPTY_CARNAME;
import static racingcar.exception.ErrorMessage.INVALID_CARNAME;

public class CarName {
    private String value;

    public CarName(String value) {
        validateName(value);
        this.value = value;
    }

    public String getCarName() {
        return this.value;
    }

    private void validateName(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CARNAME);
        }

        if (value.length() > 5) {
            throw new IllegalArgumentException(INVALID_CARNAME);
        }
    }
}
