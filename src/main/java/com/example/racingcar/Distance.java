package com.example.racingcar;

public class Distance {
    private static final char DISTANCE_CHARACTER = '-';
    private int distance;

    public Distance() {

    }

    public void go() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }

    public String getCurrentDistanceString() {
        StringBuilder currentDistanceStringBuilder = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            currentDistanceStringBuilder.append(DISTANCE_CHARACTER);
        }

        return currentDistanceStringBuilder.toString();
    }
}
