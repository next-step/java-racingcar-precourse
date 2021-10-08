package racinggame.model;

import racinggame.model.enums.Error;
import racinggame.model.enums.MoveAction;

public class MoveCondition {
    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final int BOUNDARY = 4;

    private final int value;

    public MoveCondition(int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException(Error.INVALID_MOVE_CONDITION_RANGE.message());
        }
    }

    public MoveAction judge() {
        if (value < BOUNDARY) {
            return MoveAction.STOP;
        }

        return MoveAction.GO;
    }
}
