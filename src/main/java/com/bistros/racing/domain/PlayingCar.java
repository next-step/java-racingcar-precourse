package com.bistros.racing.domain;

import java.util.Arrays;

public class PlayingCar implements Comparable<PlayingCar> {
    private final Car car;
    private final PlayingCarPosition position;

    public PlayingCar(Car car) {
        this.car = car;
        this.position = new PlayingCarPosition();
    }

    public Car getCar() {
        return car;
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

    public void printLocation() {
        char[] chars = new char[position.getPosition()];
        Arrays.fill(chars, '-');

        System.out.printf("%s : %s%n", this.car.getName(), new String(chars));
    }

    public void play() {
        tryMove();
        printLocation();
    }


    @Override
    public int compareTo(PlayingCar o) {
        return position.getPosition() - o.position.getPosition();
    }

    @Override
    public String toString() {
        return car.getName();
    }
}
