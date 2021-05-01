package com.github.momentjin;

import com.github.momentjin.car.CarName;

public final class ConditionalMovableObject implements Movable {

    private final Movable movable;
    private final MoveCondition moveCondition;

    public ConditionalMovableObject(Movable movable, MoveCondition moveCondition) {
        this.movable = movable;
        this.moveCondition = moveCondition;
    }

    @Override
    public CarName getName() {
        return this.movable.getName();
    }

    final public void moveForward() {
        if (this.moveCondition.movableToForward()) {
            this.movable.moveForward();
        }
    }

    @Override
    public Location getLocation() {
        return this.movable.getLocation();
    }
}

