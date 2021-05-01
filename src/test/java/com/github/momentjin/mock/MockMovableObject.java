package com.github.momentjin.mock;

import com.github.momentjin.core.model.Location;
import com.github.momentjin.core.model.MovableObject;
import com.github.momentjin.core.model.MovableObjectName;

public class MockMovableObject implements MovableObject {

    private boolean isMoved;
    private MovableObjectName name;
    private Location location;

    public MockMovableObject() {
        this.isMoved = false;
    }

    public MockMovableObject(Location location) {
        this();
        this.location = location;
    }

    public MockMovableObject(MovableObjectName name, Location location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public MovableObjectName getName() {
        return name;
    }

    @Override
    public void moveForward() {
        isMoved = true;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    public boolean isMoved() {
        return isMoved;
    }
}
