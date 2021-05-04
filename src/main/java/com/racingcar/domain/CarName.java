package com.racingcar.domain;

import com.racingcar.exception.RacingCarGameException;
import com.racingcar.exception.RacingCarGameExceptionMessage;

import java.util.Objects;

public class CarName {

    private final String carName;

    private CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        if (carName == null || !isValidLength(carName)) {
            throw new RacingCarGameException(RacingCarGameExceptionMessage.INVALID_CAR_NAME);
        }
    }

    private Boolean isValidLength(String carName) {
        return carName.length() > 0 && carName.length() <= 5;
    }

    public static CarName of(String carName) {
        return new CarName(carName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName1 = (CarName) o;
        return Objects.equals(carName, carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

    @Override
    public String toString() {
        return carName;
    }
}
