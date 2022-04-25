package racingcar.rule;

public class MoveCount {
    private final int value;

    private MoveCount(int value) {
        validateMin(value);
        validateMax(value);
        this.value = value;
    }

    private void validateMin(int moveCount) {
        final int MIN_MOVE_COUNT = 1;
        if (moveCount < MIN_MOVE_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 한다.");
        }
    }

    private void validateMax(int moveCount) {
        final int MAX_MOVE_COUNT = 100;
        if (moveCount > MAX_MOVE_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 100 이하여야 한다.");
        }
    }

    public static MoveCount fromString(String input) {
        final int count = Integer.parseInt(input);
        return new MoveCount(count);
    }

    public int get() {
        return value;
    }
}
