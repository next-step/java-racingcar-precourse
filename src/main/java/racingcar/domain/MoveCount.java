package racingcar.domain;

public class MoveCount {
    private int moveCount;

    public MoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public void decrease() {
        if (moveCount == 0) {
            throw new IllegalStateException(ExceptionType.NOT_DECREASE_MOVE_COUNT.getMessage());
        }

        this.moveCount--;
    }

    public int getRemainingMoveCount() {
        return moveCount;
    }

    public boolean isMovableCount() {
        return moveCount > 0;
    }
}
