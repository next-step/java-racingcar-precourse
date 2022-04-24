package racingcar.car;

public final class InvalidCarNameException extends IllegalArgumentException {

    InvalidCarNameException(String value) {
        super(String.format("자동차 이름이 올바르지 않습니다. (입력 값: %s, 최대 길이 %d)",
                            value, CarName.MAX_LENGTH));
    }
}
