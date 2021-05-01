package com.bistros.racing.game;

public class CarPosition implements Comparable<CarPosition> {
    private int position = 0;

    public void increasePosition() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(CarPosition o) {
        return position - o.position;
    }
}
