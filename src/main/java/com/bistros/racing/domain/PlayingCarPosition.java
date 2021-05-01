package com.bistros.racing.domain;

public class PlayingCarPosition implements Comparable<PlayingCarPosition> {
    private int position = 0;

    public void increasePosition() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(PlayingCarPosition o) {
        return position - o.position;
    }
}
