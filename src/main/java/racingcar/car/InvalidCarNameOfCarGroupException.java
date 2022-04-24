package racingcar.car;

public final class InvalidCarNameOfCarGroupException extends IllegalArgumentException {

    InvalidCarNameOfCarGroupException(String value) {
        super(String.format("자동차 이름이 올바르지 않습니다. (입력 값: %s)", value));
    }
}
