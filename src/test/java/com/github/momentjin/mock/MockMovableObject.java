package com.github.momentjin.mock;

import com.github.momentjin.Location;
import com.github.momentjin.MovableObject;
import com.github.momentjin.MovableObjectName;

public class MockMovableObject implements MovableObject {

    private boolean isMoved;
    private Location location;

    public MockMovableObject() {
        this.isMoved = false;
    }

    public MockMovableObject(Location location) {
        this();
        this.location = location;
    }

    @Override
    public MovableObjectName getName() {
        return null;
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
