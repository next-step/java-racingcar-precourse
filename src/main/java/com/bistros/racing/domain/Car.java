package com.bistros.racing.domain;


import com.bistros.racing.exception.NotAllowCarNamePolicyException;

import java.util.Objects;

public class Car {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String name;
    private final Engine engine;

    public Car(String name) {
        if (name == null || "".equals(name.trim()) || MAX_CAR_NAME_LENGTH < name.trim().length()) {
            throw new NotAllowCarNamePolicyException();
        }
        this.name = name;
        this.engine = new Engine();
    }

    public String getName() {
        return name;
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
}
