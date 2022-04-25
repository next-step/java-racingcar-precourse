package racingcar.exception.ui;

import racingcar.exception.CommonException;

public class AttemptCountEmptyException extends CommonException {
    private static final String ATTEMPT_COUNT_VALIDATION_EMPTY_MESSAGE = "시도 횟수를 숫자로 입력해주세요.";

    public AttemptCountEmptyException(){
        super(ATTEMPT_COUNT_VALIDATION_EMPTY_MESSAGE);
    }
}
