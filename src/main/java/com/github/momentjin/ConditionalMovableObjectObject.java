package com.github.momentjin;

public final class ConditionalMovableObjectObject implements MovableObject {

    private final MovableObject movableObject;
    private final MoveCondition moveCondition;

    public ConditionalMovableObjectObject(MovableObject movableObject, MoveCondition moveCondition) {
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

