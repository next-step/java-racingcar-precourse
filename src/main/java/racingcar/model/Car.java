package racingcar.model;

import racingcar.Constans;

import java.util.InputMismatchException;

public class Car {
    private String name;
    private int distance = 0;

    public Car(String name) throws IllegalArgumentException {
        setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) throws ArrayIndexOutOfBoundsException {
        if (name.length() > 5) {
            throw new IllegalArgumentException(Constans.ERROR_PREFIX.getMessage()+Constans.ERROR_MAXIMUM_LANGTH.getMessage());
        }
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void go() {
        this.distance++;
    }
}
