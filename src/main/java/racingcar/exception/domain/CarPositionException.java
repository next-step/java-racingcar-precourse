package racingcar.exception.domain;

import racingcar.exception.CommonException;

public class CarPositionException extends CommonException {
    private static final String MIN_POSITION_ERROR_MESSAGE = "자동차는 후진할 수 없습니다.";

    public CarPositionException(){
        super(MIN_POSITION_ERROR_MESSAGE);
    }
}
