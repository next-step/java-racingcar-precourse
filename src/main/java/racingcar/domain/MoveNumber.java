package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.ErrorMessage;

public class MoveNumber {
    private static final int MOVE_NUMBER_MIN = 0;
    private static final int MOVE_NUMBER_MAX = 9;

    private MoveNumber() {
    }

    public static int getRandomNumber() {
        int moveNumber = Randoms.pickNumberInRange(MOVE_NUMBER_MIN, MOVE_NUMBER_MAX);
        validate(moveNumber);
        return moveNumber;
    }

    private static void validate(Integer moveNumber) {
        if (moveNumber < MOVE_NUMBER_MIN || moveNumber > MOVE_NUMBER_MAX) {
            throw new IllegalStateException(ErrorMessage.ERROR_MOVE_NUMBER_RANGE);
        }
    }
}
