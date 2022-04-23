package racingcar.nextstep.domain.racing.service;

public interface RacingValidator {
    void isNumber(String stringNumber);

    void isCarNameNotExceedingFive(String[] splitCarNames);

    void isCarNameNotBlank(String[] splitCarNames);
}
