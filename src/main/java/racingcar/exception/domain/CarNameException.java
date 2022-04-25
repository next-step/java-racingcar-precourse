package racingcar.exception.domain;

import racingcar.exception.CommonException;

public class CarNameException extends CommonException {

    private static final String ERROR_NAME_LENGTH_MESSAGE = "이름은 1자 이상 5자 미만이여야 합니다.";

    public CarNameException(){
        super(ERROR_NAME_LENGTH_MESSAGE);
    }

}
