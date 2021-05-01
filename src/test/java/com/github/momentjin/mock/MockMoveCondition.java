package com.github.momentjin.mock;

import com.github.momentjin.MoveCondition;

public class MockMoveCondition implements MoveCondition {

    private final boolean success;

    public MockMoveCondition(boolean success) {
        this.success = success;
    }

    @Override
    public boolean movableToForward() {
        return success;
    }
}
