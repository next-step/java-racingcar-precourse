package racingcar.domain.model;

import racingcar.core.common.error.CarErrorCode;
import racingcar.core.common.error.CommonErrorCode;

import java.util.Objects;

public class CarName {

    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public CarName(final String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(final String name) {
        validateNull(name);
        validateEmpty(name);
        validateLength(name);
    }

    private void validateNull(final String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException(CommonErrorCode.NOT_ALLOW_NULL.getErrorMessage());
        }
    }

    private void validateEmpty(final String name) {
        String trimName = name.trim();

        if (trimName.isEmpty()) {
            throw new IllegalArgumentException(CommonErrorCode.NOT_ALLOW_EMPTY.getErrorMessage());
        }
    }

    private void validateLength(final String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CarErrorCode.CAR_NAME_OVER_MAX_LENGTH.getErrorMessage());
        }
    }
}