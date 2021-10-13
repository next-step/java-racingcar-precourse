package racinggame.model;

import racinggame.constants.Messages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racinggame.constants.Messages.ERROR_MESSAGE;
import static racinggame.constants.RacingCarConstants.*;

public class CarPosition {
    private int moveCount;

    public CarPosition() {
        this.moveCount = 0;
    }

    public int moveRacingCarCondition(int moveConditionNum) {
        validateMoveConditionNumber(moveConditionNum);
        if (moveConditionNum >= CAR_MOVE_FORWARD) {
            this.moveCount++;
        }
        return moveCount;
    }

    private void validateMoveConditionNumber(int moveConditionNum) {
        if (moveConditionNum < 0 || moveConditionNum > 9) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getMessage() + Messages.MOVE_CONDITION_NUM_INVALID.getMessage());
        }
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    @Override
    public String toString() {
        return Integer.toString(this.moveCount);
    }
}
