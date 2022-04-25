package racingcar.exception.domain;

import racingcar.exception.CommonException;

public class CarsException extends CommonException {

    private static final String MIN_CAR_COUNT_ERROR_MESSAGE = "자동차는 두 대 이상 존재해야 합니다.";


    public CarsException(){
        super(MIN_CAR_COUNT_ERROR_MESSAGE);
    }

    public CarsException(String message){
        super(message);
    }


}
