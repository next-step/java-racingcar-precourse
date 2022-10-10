package racingcar.domain.car.carname.validation;

public interface CarNameValidator {

    int CAR_NAME_LENGTH = 5;
    String ERROR_LENGTH_MESSAGE = "[ERROR] 자동차 이름의 길이는 " + CAR_NAME_LENGTH + "자리를 넘을 수 없습니다.";
    String ERROR_DUPLICATE_MESSAGE = "[ERROR] 자동차 이름이 중복되지 않도록 해주세요. *";

    void validate(String carName) throws IllegalArgumentException;
}
