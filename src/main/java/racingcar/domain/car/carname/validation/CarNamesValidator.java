package racingcar.domain.car.carname.validation;

public interface CarNamesValidator {

    String ERROR_EMPTY_MESSAGE = "[ERROR] 공백은 입력할 수 없습니다.";
    String ERROR_FIRST_COMMA_MESSAGE = "[ERROR] 쉼표(,)를 맨 앞에 입력할 수 없습니다.";

    void validate(String carNames) throws IllegalArgumentException;
}
