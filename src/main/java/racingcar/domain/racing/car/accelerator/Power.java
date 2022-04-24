package racingcar.domain.racing.car.accelerator;

import static racingcar.domain.constant.RacingGameConfiguration.MAXIMUM_POWER;
import static racingcar.domain.constant.RacingGameConfiguration.MINIMUM_POWER;
import static racingcar.domain.constant.RacingGameExceptions.MAX_POWER_VALIDATION_ERROR;
import static racingcar.domain.constant.RacingGameExceptions.MIN_POWER_VALIDATION_ERROR;

import racingcar.exception.RacingCarGameException;

public class Power {
    private final int value;

    private Power(int value) {
        validate(value);
        this.value = value;
    }

    public static Power from(int power) {
        return new Power(power);
    }

    boolean isGreaterThanOrEqualTo(int input) {
        return value >= input;
    }

    private void validate(int power) {
        validateMin(power);
        validateMax(power);
    }

    private void validateMin(int power) {
        if (power < MINIMUM_POWER) {
            throw illegalArgumentException(MIN_POWER_VALIDATION_ERROR);
        }
    }

    private void validateMax(int power) {
        if (power > MAXIMUM_POWER) {
            throw illegalArgumentException(MAX_POWER_VALIDATION_ERROR);
        }
    }

    private IllegalArgumentException illegalArgumentException(String errorMessage) {
        return RacingCarGameException.throwIllegalArgumentException(errorMessage);
    }
}
