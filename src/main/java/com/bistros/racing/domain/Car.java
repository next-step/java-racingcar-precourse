package com.bistros.racing.domain;


import com.bistros.racing.exception.NotAllowCarNamePolicyException;

import java.util.Objects;

public class Car {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String name;
    private final Engine engine;

    public Car(String name) {
        this(name, new Engine());
    }

    public Car(String name, Engine engine) {
        if (name == null || "".equals(name.trim()) || MAX_CAR_NAME_LENGTH < name.trim().length()) {
            throw new NotAllowCarNamePolicyException();
        }
        this.name = name;
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    protected Engine getEngine() {
        return engine;
    }

    public boolean canToMove() {
        return engine.canMove();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
