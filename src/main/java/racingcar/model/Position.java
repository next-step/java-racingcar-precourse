package racingcar.model;

import static racingcar.configuration.ErrorMessage.ERR_CAR_POSITION_LIMIT_MSG;

import racingcar.util.ValidationUtils;

public class Position {
    public static final int MOVE_FORWARD_LOWER_BOUND = 4;
    private final int value;

    public Position(int position) {
        if (!ValidationUtils.validCarPosition(position)) {
            throw new IllegalArgumentException(ERR_CAR_POSITION_LIMIT_MSG);
        }
        this.value = position;
    }

    public boolean isMoveForwardPosition() {
        return this.value >= MOVE_FORWARD_LOWER_BOUND;
    }
}
