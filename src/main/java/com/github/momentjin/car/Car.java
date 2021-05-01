package com.github.momentjin.car;

import com.github.momentjin.Location;
import com.github.momentjin.MovableObject;

public class Car implements MovableObject {

    private Location location;
    private final CarName name;

    Car(String name) {
        this.name = new CarName(name);
        this.location = CarLocation.ZERO;
    }

    Car(String name, Location location) {
        this.name = new CarName(name);
        this.location = location;
    }

    @Override
    public void moveForward() {
        location = location.increaseOne();
    }

    public CarName getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }
}


