package racingcar.model;

public class TestMoveStrategy implements MoveStrategy {
    private final boolean canMove;

    public TestMoveStrategy(boolean canMove) {
        this.canMove = canMove;
    }

    @Override
    public boolean canMove() {
        return canMove;
    }
}
