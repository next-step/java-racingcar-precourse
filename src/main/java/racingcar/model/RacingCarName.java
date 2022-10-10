package racingcar.model;

import java.util.Objects;

import static racingcar.constant.RacingCarGameErrorMessage.*;

public class RacingCarName {

    private static final int MAX_CAR_NAME_INPUT = 5;
    private static final int MIN_CAR_NAME_INPUT = 1;
    private static final String CAR_NAME_BLANK = " ";

    private final String carName;

    public RacingCarName(String carName) {
        validateRacingCarNameNullOrEmpty(carName);
        validateRacingCarNameLengthFive(carName);
        validateRacingCarNameBlank(carName);
        this.carName = carName;
    }

    public String getName() {
        return this.carName;
    }

    private static void validateRacingCarNameNullOrEmpty(String carName) {
        if (carName.isEmpty())
            throw new IllegalArgumentException(ERROR_RACING_CAR_NAME_NOT_NULL_OR_EMPTY);
    }

    private static void validateRacingCarNameLengthFive(String carName) {
        if (carName.length() < MIN_CAR_NAME_INPUT || carName.length() > MAX_CAR_NAME_INPUT) {
            throw new IllegalArgumentException(ERROR_RACING_CAR_NAME_LENGTH_LESS_FIVE);
        }
    }

    private static void validateRacingCarNameBlank(String carName) {
        if (carName.contains(CAR_NAME_BLANK)) throw new IllegalArgumentException(ERROR_RACING_CAR_NAME_NOT_BLANK);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCarName that = (RacingCarName) o;
        return Objects.equals(carName, that.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
