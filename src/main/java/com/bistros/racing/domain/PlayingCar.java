package com.bistros.racing.domain;

import java.util.Arrays;

public class PlayingCar extends Car implements Comparable<PlayingCar> {

    private final PlayingCarPosition position;

    public PlayingCar(Car car) {
        super(car.getName(), car.getEngine());
        this.position = new PlayingCarPosition();
    }

    public void tryMove() {
        if (canToMove()) {
            position.increasePosition();
        }
    }

    public PositionLead lead(PlayingCar other) {
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

        System.out.printf("%s : %s%n", this.getName(), new String(chars));
    }

    public void play() {
        tryMove();
        printLocation();
    }


    @Override
    public int compareTo(PlayingCar o) {
        return position.compareTo(o.position);
    }

}
