package racingcar.domain.racing.car.accelerator;

import static racingcar.domain.constant.RacingGameConfiguration.MINIMUM_GO_VALUE;
import static racingcar.domain.constant.RacingGameConfiguration.MOVED_DISTANCE;
import static racingcar.domain.constant.RacingGameExceptions.LOCATION_NULL_ERROR;
import static racingcar.domain.constant.RacingGameExceptions.POWER_NULL_ERROR;

import java.util.Objects;
import racingcar.domain.racing.car.Location;
import racingcar.exception.RacingCarGameException;

public class Accelerator {
    private final Power power;

    private Accelerator(Power power) {
        validate(power);
        this.power = power;
    }

    private Accelerator(int power) {
        this.power = Power.from(power);
    }

    public static Accelerator from(Power power) {
        return new Accelerator(power);
    }

    public static Accelerator from(int power) {
        return new Accelerator(power);
    }

    public Location moveCar(Location currentLocation) {
        if (Objects.isNull(currentLocation)) {
            throw illegalArgumentException(LOCATION_NULL_ERROR);
        }
        return isMovingForward() ? currentLocation.add(MOVED_DISTANCE) : currentLocation;
    }

    private boolean isMovingForward() {
        return power.isGreaterThanOrEqualTo(MINIMUM_GO_VALUE);
    }

    private void validate(Power power) {
        if (Objects.isNull(power)) {
            throw illegalArgumentException(POWER_NULL_ERROR);
        }
    }

    private IllegalArgumentException illegalArgumentException(String errorMessage) {
        return RacingCarGameException.throwIllegalArgumentException(errorMessage);
    }


}
