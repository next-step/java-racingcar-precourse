package com.bistros.racing.domain;

/**
 * 테스트를 위한 엔진. 100% 전진 할 수 있다
 */
public class TestEngine extends Engine {
    @Override
    public boolean canMove() {
        return canMove(1);
    }
}
