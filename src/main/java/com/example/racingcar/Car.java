package com.example.racingcar;

public class Car {
    private final Name name;
    private final Distance distance;

    public Car(Name name) {
        if (name == null) {
            throw new IllegalArgumentException("이름이 null입니다.");
        }
        this.name = name;
        this.distance = new Distance();
    }

    public void goOrNot(boolean isGo) {
        if (isGo) {
            distance.go();
        }
    }

    public Name getName() {
        return name;
    }

    public Distance getDistance() {
        return distance;
    }

    public String getCurrentState() {
        return name.getName() + " : " + distance.getCurrentDistanceString();
    }
}
