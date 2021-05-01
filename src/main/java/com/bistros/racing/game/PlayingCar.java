package com.bistros.racing.game;

import com.bistros.racing.domain.Car;

import java.util.Arrays;

public class PlayingCar {
    private final Car car;
    private final CarPosition position;

    public PlayingCar(Car car) {
        this.car = car;
        this.position = new CarPosition();
    }

    public void tryMove() {
        if (car.canToMove()) {
            position.increasePosition();
        }
    }

    public PositionLead status(PlayingCar other) {
        if (position.compareTo(other.position) == 0) {
            return PositionLead.TIE;
        }
        if (position.compareTo(other.position) < 0) {
            return PositionLead.BEHIND;
        }
        return PositionLead.LEAD;
    }

    public void printing() {
        char[] chars = new char[position.getPosition()];
        Arrays.fill(chars, '-');

        System.out.printf("%s : %s%n", this.car.getName(), new String(chars));
    }
}
