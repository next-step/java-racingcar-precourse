package racingcar.model;

import racingcar.ExceptionMessageUtils;

public final class Car {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private final MovePolicy movePolicy;
    private final MoveCondition moveCondition;
    private Distance distance;

    public Car(final String name, final MovePolicy movePolicy, final MoveCondition moveCondition) {
        validateName(name);
        validateMovePolicy(movePolicy);
        validateMoveCondition(moveCondition);
        this.name = name;
        this.movePolicy = movePolicy;
        this.moveCondition = moveCondition;
        this.distance = Distance.ZERO;
    }

    private static void validateMoveCondition(final MoveCondition moveCondition) {
        if (moveCondition == null) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createExceptionMessage(
                    "MoveCondition cannot be null"));
        }
    }

    private static void validateMovePolicy(final MovePolicy movePolicy) {
        if (movePolicy == null) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createExceptionMessage(
                    "MovePolicy cannot be null"));
        }
    }

    private static void validateName(final String name) {
        if (name == null) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createExceptionMessage("car name cannot be null"));
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createExceptionMessage("car name cannot be empty"));
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createExceptionMessage("car name is too long"));
        }
    }

    public void move() {
        if (!moveCondition.isMovable()) {
            return;
        }
        distance = distance.plus(movePolicy.getSteps());
    }

    public boolean isFartherMovedThan(final Car other) {
        return distance.isGreaterThan(other.getDistance());
    }

    public boolean isLessMovedThan(final Car other) {
        return distance.isLessThan(other.getDistance());
    }

    public boolean isSamelyMovedWith(final Car other) {
        return distance.equals(other.getDistance());
    }

    public String getName() {
        return name;
    }

    public Distance getDistance() {
        return distance;
    }
}

