package com.racingcar.domain;

import java.util.Objects;

public class Winner {

    private final CarName carName;

    private Winner(CarName carName) {
        this.carName = carName;
    }

    public static Winner of(CarName carName) {
        return new Winner(carName);
    }

    @Override
    public String toString() {
        return carName.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winner winner = (Winner) o;
        return Objects.equals(carName, winner.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
