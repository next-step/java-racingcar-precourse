package com.github.momentjin.car;

import com.github.momentjin.Location;

public class CarLocation implements Location, Comparable<CarLocation> {

    private final int position;
    public static final CarLocation ZERO = new CarLocation(0);

    CarLocation(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarLocation carLocation = (CarLocation) o;
        return position == carLocation.position;
    }

    @Override
    public int hashCode() {
        return position;
    }

    @Override
    public int compareTo(CarLocation other) {
        return Integer.compare(position, other.position);
    }

    @Override
    public CarLocation increaseOne() {
        return new CarLocation(this.position + 1);
    }

    @Override
    public int getPosition() {
        return this.position;
    }
}
