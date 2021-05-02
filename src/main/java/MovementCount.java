public class MovementCount {
    private static final String NOTIFY_INVALID_MOVE_COUNT_EXCEPTION_MSG = "시도 횟수는 숫자이어야 합니다.";
    private static final String NOTIFY_INVALID_MOVE_COUNT_CONSOLE_MSG = NOTIFY_INVALID_MOVE_COUNT_EXCEPTION_MSG + "(입력값: %s)";
    private static final int INVALID_MOVE_COUNT = -1;

    private int moveCount;

    public MovementCount(String moveCountString) {
        try {
            this.moveCount = Integer.parseInt(moveCountString);
        } catch (NumberFormatException e) {
            this.moveCount = INVALID_MOVE_COUNT;

            System.out.println(String.format(NOTIFY_INVALID_MOVE_COUNT_CONSOLE_MSG, moveCountString));
            throw e;
        }
    }

    public int getMoveCount() {
        if (this.moveCount == INVALID_MOVE_COUNT) {
            throw new NumberFormatException(NOTIFY_INVALID_MOVE_COUNT_EXCEPTION_MSG);
        }

        return this.moveCount;
    }
}