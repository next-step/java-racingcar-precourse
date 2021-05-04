package com.racingcar.domain;

import java.util.Objects;

public class CarPosition implements Comparable<CarPosition> {

    private Integer carPosition;

    private CarPosition(Integer carPosition) {
        this.carPosition = carPosition;
    }

    public void addCarPosition(Integer carPosition) {
        this.carPosition += carPosition;
    }

    public String makeCarPosition(String carShape) {
        StringBuilder result = new StringBuilder();
        for (int i = 0 ; i < carPosition ; i++) {
            result.append(carShape);
        }

        return result.toString();
    }

    public static CarPosition of(Integer carPosition) {
        return new CarPosition(carPosition);
    }

    @Override
    public int compareTo(CarPosition o) {
        return this.carPosition.compareTo(o.carPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return Objects.equals(carPosition, that.carPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carPosition);
    }
}
