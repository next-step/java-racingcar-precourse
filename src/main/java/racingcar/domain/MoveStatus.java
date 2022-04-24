package racingcar.domain;

public enum MoveStatus {
    MOVE, STOP;

    private static final int MOVE_COMMAND_RANGE = 4;
    public static final int COMMAND_RANGE_MIN = 0;
    public static final int COMMAND_RANGE_MAX = 9;

    public static MoveStatus getStatus(int command) {
        if (command < COMMAND_RANGE_MIN || command > COMMAND_RANGE_MAX) {
            throw new IllegalArgumentException("command 값은 0 ~ 9 사이여야 합니다");
        }
        return command < MOVE_COMMAND_RANGE ? MoveStatus.STOP : MoveStatus.MOVE;
    }
}
