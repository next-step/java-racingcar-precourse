package com.github.momentjin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConditionalMovableObjectTest {

    MockMovable movable = new MockMovable();

    @DisplayName("moveCondition이 true를 반환하면 movableObject는 앞으로 움직인다")
    @Test
    void moveForward() {

        // given
        MoveCondition successCondition = new MockMoveCondition(true);
        ConditionalMovableObject movableObject = new ConditionalMovableObject(
                movable,
                successCondition
        );

        // when
        movableObject.moveForward();

        // then
        assertThat(movable.isMoved).isTrue();
    }

    @DisplayName("moveCondition이 false를 반환하면 movableObject는 움직이지 않는다")
    @Test
    void moveForward2() {

        // given
        MoveCondition failCondition = new MockMoveCondition(false);
        ConditionalMovableObject movableObject = new ConditionalMovableObject(
                movable,
                failCondition
        );

        // when
        movableObject.moveForward();

        // then
        assertThat(movable.isMoved).isFalse();
    }
}

class MockMoveCondition implements MoveCondition {

    private final boolean success;

    public MockMoveCondition(boolean success) {
        this.success = success;
    }

    @Override
    public boolean movableToForward() {
        return success;
    }
}

class MockMovable implements Movable {

    boolean isMoved;

    @Override
    public void moveForward() {
        isMoved = true;
    }

    @Override
    public Location getLocation() {
        return null;
    }
}