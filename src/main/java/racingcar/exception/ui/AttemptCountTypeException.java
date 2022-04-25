package racingcar.exception.ui;

import racingcar.exception.CommonException;

public class AttemptCountTypeException extends CommonException {

    private static final String ATTEMPT_COUNT_VALIDATION_MESSAGE = "시도 횟수는 숫자여야합니다.";

    public AttemptCountTypeException(){
        super(ATTEMPT_COUNT_VALIDATION_MESSAGE);
    }
}
