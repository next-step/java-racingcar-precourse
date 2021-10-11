package racinggame;

public class CarMoveCount {
    private int moveCount;

    public CarMoveCount(int moveCount) {
        validatePositiveMoveCount(moveCount);
        this.moveCount = moveCount;
    }

    private void validatePositiveMoveCount(int moveCount) {
        if (moveCount < 0) {
            throw new IllegalArgumentException(ErrorMessage.printNotPositiveMoveCountMessage(moveCount));
        }
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void increaseMoveCount() {
        moveCount++;
    }
}
