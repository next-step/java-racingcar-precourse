package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InputMoveCountIllegalArgumentException;

import static racingcar.utils.RacingCarConstants.MAX_INPUT_MOVE_COUNT;
import static racingcar.utils.RacingCarConstants.MIN_INPUT_MOVE_COUNT;
import static racingcar.utils.RacingCarConstants.MSG_MOVE_COUNT_LENGTH_EXCEED_EXCEPTION;
import static racingcar.utils.RacingCarConstants.MSG_MOVE_MIN_VALUE_EXCEPTION;
import static racingcar.utils.RacingCarConstants.MSG_NUMBER_FORMAT_EXCEPTION;

public class InputMoveCount {
    public static int inputMoveCount() {
        System.out.println("시도할 횟수를 입력하세요.");
        String moveCountStr = Console.readLine();
        int moveCount;
        try {
            validateExceedInputNumMaxLength(moveCountStr);
            moveCount = Integer.parseInt(moveCountStr);
            validateMinInputNum(moveCount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(MSG_NUMBER_FORMAT_EXCEPTION);
        }

        return moveCount;
    }

    private static void validateExceedInputNumMaxLength(String moveCountStr) {
        if (moveCountStr.length() > MAX_INPUT_MOVE_COUNT) {
            throw new InputMoveCountIllegalArgumentException(MSG_MOVE_COUNT_LENGTH_EXCEED_EXCEPTION);
        }
    }

    private static void validateMinInputNum(int inputMoveCount) {
        if (inputMoveCount <MIN_INPUT_MOVE_COUNT) {
            throw new InputMoveCountIllegalArgumentException(MSG_MOVE_MIN_VALUE_EXCEPTION);
        }
    }
}
