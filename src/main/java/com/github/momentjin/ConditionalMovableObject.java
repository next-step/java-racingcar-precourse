package com.github.momentjin;

public final class ConditionalMovableObject implements MovableObject {

    private final MovableObject movableObject;
    private final MoveCondition moveCondition;

    public ConditionalMovableObject(MovableObject movableObject, MoveCondition moveCondition) {
        this.movableObject = movableObject;
        this.moveCondition = moveCondition;
    }

    @Override
    public MovableObjectName getName() {
        return this.movableObject.getName();
    }

    final public void moveForward() {
        if (this.moveCondition.movableToForward()) {
            this.movableObject.moveForward();
        }
    }

    @Override
    public Location getLocation() {
        return this.movableObject.getLocation();
    }
}

