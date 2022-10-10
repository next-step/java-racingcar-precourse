package racingcar.domain.racing.validation;

public interface RacingValidator {

    String ERROR_POSITIVE_NUMBER_MESSAGE = "[ERROR] 시도 횟수는 0보다 큰 값을 입력해주세요.";
    String ERROR_NUMBER_MESSAGE = "[ERROR] 시도할 횟수로 숫자를 입력해주세요.";

    void validate(String tryNo) throws IllegalArgumentException;
}
