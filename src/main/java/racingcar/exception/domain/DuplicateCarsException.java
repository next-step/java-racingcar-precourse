package racingcar.exception.domain;

public class DuplicateCarsException extends CarsException{

    private static final String DUPLICATE_ERROR_MESSAGE = "자동차 이름은 중복될 수 없습니다.";

    public DuplicateCarsException(){
        super(DUPLICATE_ERROR_MESSAGE);
    }

}
