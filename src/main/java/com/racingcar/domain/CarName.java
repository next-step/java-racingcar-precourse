package com.racingcar.domain;

import com.racingcar.exception.RacingCarGameException;

import java.util.Objects;

public class CarName {

    private final String carName;

    private CarName(String carName) {
        this.carName = carName;
    }

    public static CarName of(String carName) {
        validateCarName(carName);
        return new CarName(carName);
    }

    private static void validateCarName(String carName) {
        if (carName == null || !isValidLength(carName)) {
            throw new RacingCarGameException("자동차 이름의 길이가 유효하지 않습니다.");
        }
    }

    private static Boolean isValidLength(String carName) {
        return carName.length() > 0 && carName.length() <= 5;
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
}
